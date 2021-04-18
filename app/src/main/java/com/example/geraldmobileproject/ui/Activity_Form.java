package com.example.geraldmobileproject.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.geraldmobileproject.R;

import java.security.Key;

public class Activity_Form extends AppCompatActivity {
    TextView Nama, Nim, Hp, Email, Jkl, Prodi, Ukm;
    String getnama, getnim, getemail, gethp, getprodi, getjkl, getukm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__form);

        Nama = findViewById(R.id.FmNama);
        Nim = findViewById(R.id.FmNim);
        Hp = findViewById(R.id.FmHP);
        Email = findViewById(R.id.FmEmail);
        Jkl = findViewById(R.id.FmJkel);
        Prodi = findViewById(R.id.Fmprodi);
        Ukm = findViewById(R.id.FmUKM);

        Bundle bundle = getIntent().getExtras();
        getnama = bundle.getString("Nama");
        getnim = bundle.getString("NIM");
        getemail = bundle.getString("Email");
        gethp = bundle.getString("No. HP");
        getprodi = bundle.getString("Prodi");



        Nama.setText("Nama : "+getnama);
        Nim.setText("NIM : "+getnim);
        Email.setText("Email : "+getemail);
        Hp.setText("No. HP : "+gethp);
        Prodi.setText("Prodi : "+getprodi);

        Intent tampilkanIntent = getIntent();
        Bundle bukapaket = tampilkanIntent.getExtras();
        String jk = bukapaket.getString("Jenis Kelamin");
        String UKM = bukapaket.getString("UKM");
        Jkl.setText("Jenis Kelamin : "+jk);
        Ukm.setText("UKM : "+UKM);
    }
}