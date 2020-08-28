package com.example.project1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.MessageFormat;
import java.util.Objects;

import android.os.Bundle;

public class profile extends AppCompatActivity {
    private AppCompatEditText etName, etEmail, etMobile, etAddress, etCity;
    SharedPreferences sharedPreferences;
    String userId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        userId = sharedPreferences.getString("UserId", "0");

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etAddress = findViewById(R.id.etAddress);
        etCity = findViewById(R.id.etCity);
        etMobile = findViewById(R.id.etMobile);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Users").document(userId)
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        etName.setText(Objects.requireNonNull(Objects.requireNonNull(documentSnapshot.getData()).get("name")).toString());
                        etEmail.setText(Objects.requireNonNull(Objects.requireNonNull(documentSnapshot.getData()).get("email")).toString());
                        etAddress.setText(Objects.requireNonNull(Objects.requireNonNull(documentSnapshot.getData()).get("address")).toString());
                        etCity.setText(Objects.requireNonNull(Objects.requireNonNull(documentSnapshot.getData()).get("city")).toString());
                        etMobile.setText(Objects.requireNonNull(Objects.requireNonNull(documentSnapshot.getData()).get("mobile")).toString());



                    }
                });

    }
}




