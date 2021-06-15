package com.example.geraldmobileproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.provider.AlarmClock;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class activity_implicit extends AppCompatActivity {

    Button BtnShare, BtnAlarm, BtnFoto;
    EditText etJam, etMenit, etDesc;
    ImageView imageView;

    final int REQUEST_CODE = 111;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        BtnShare = findViewById(R.id.btnshare);
        BtnFoto = findViewById(R.id.btnfoto);
        imageView = findViewById(R.id.hslfoto);

        BtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, "Praktikum Mobile Implicit Intent");
                startActivity(i.createChooser(i, "Share"));
            }
        });


        etJam = findViewById(R.id.jam);
        etMenit = findViewById(R.id.mnt);
        etDesc = findViewById(R.id.desk);

        BtnAlarm = findViewById(R.id.btnalarm);
        BtnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int jam = Integer.parseInt(etJam.getText().toString());
                int menit = Integer.parseInt(etMenit.getText().toString());
                String desc = String.valueOf(etDesc.getText());

                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_HOUR, jam);
                i.putExtra(AlarmClock.EXTRA_MINUTES, menit);
                i.putExtra(AlarmClock.EXTRA_MESSAGE, desc);

                if (jam <= 24 && menit <= 60)
                {
                    startActivity(i);
                } else
                    Toast.makeText(getApplicationContext(), "Waktu Salah", Toast.LENGTH_SHORT).show();

            }
        });

        BtnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK);
            {
                imageUri = data.getData();
                imageView.setImageURI(imageUri);
            }

        }
    }
