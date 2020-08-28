package com.example.project1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.ContentLoadingProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;





public class signup extends AppCompatActivity {
    private AppCompatEditText etName, etEmail, etMobile, etAddress, etCity, etPassword, etConfirm;
    private String name, email, address, city, mobile, password, confirm;
    private int UserCount = 0;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    String TAG = "SignUpActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etAddress = findViewById(R.id.etAddress);
        etCity = findViewById(R.id.etCity);
        etMobile = findViewById(R.id.etMobile);
        etPassword = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirmPassword);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);


        AppCompatButton btnAdd = findViewById(R.id.btnAddUser);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                name = Objects.requireNonNull(etName.getText()).toString();
                email = Objects.requireNonNull(etEmail.getText()).toString();
                mobile = Objects.requireNonNull(etMobile.getText()).toString();
                address = Objects.requireNonNull(etAddress.getText()).toString();
                city = Objects.requireNonNull(etCity.getText()).toString();
                password = Objects.requireNonNull(etPassword.getText()).toString();
                confirm = Objects.requireNonNull(etConfirm.getText()).toString();


                if (TextUtils.isEmpty(name)) {
                    etName.setError("This field is empty!");
                    return;
                }
                // blan space is for error messages
                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("This field is empty!");
                    return;
                }
                if (mobile.length() != 10) {
                    etMobile.setError("the Phone number length should be 10");
                    return;

                }
                if (password.length() < 6) {
                    etPassword.setError("Minimum Length 6");
                    return;
                }
                if (!TextUtils.equals(password, confirm)) {

                    etConfirm.setError("Password does not match !");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser firebaseUser = mAuth.getCurrentUser();

                                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                                    Map<String, Object> user = new HashMap<>();
                                    user.put("id", Objects.requireNonNull(firebaseUser).getUid());
                                    user.put("name", name);
                                    user.put("email", email);
                                    user.put("mobile", mobile);
                                    user.put("address", address);
                                    user.put("city", city);


                                    db.collection("Users").document(Objects.requireNonNull(firebaseUser).getUid())
                                            .set(user)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    progressBar.setVisibility(View.GONE);
                                                    Intent i = new Intent(signup.this, MainActivity.class);
                                                    startActivity(i);
                                                    finish();

                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    progressBar.setVisibility(View.GONE);
                                                    Log.w(TAG, "Error writing document", e);
                                                }
                                            });




                                } else {
                                    // If sign in fails, display a message to the user.
                                    progressBar.setVisibility(View.GONE);
                                }


                            }
                        });


            }
        });
    }


}



