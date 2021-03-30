package com.example.geraldmobileproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnsave, btndel;
    EditText etPW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave = findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });

        btndel = findViewById(R.id.btndel);
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                //Membuat Title
                alertDialogBuilder.setTitle("Peringatan..!!");
                //Membuat Pesan
                alertDialogBuilder.setMessage("Apakah Anda Yakin Menghapus Data..?")
                        .setIcon(R.drawable.logo)
                        .setCancelable(false)
                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               Toast.makeText(getApplicationContext(),"Data Terhapus", Toast.LENGTH_SHORT).show();
                           }
                       }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                 //MembuatDialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                //untuk menampilkan
                alertDialog.show();
            }
        });
        etPW = findViewById(R.id.etPW);
        etPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPW.getText().toString().length()==0) {
                    etPW.setError("Password Tidak Boleh Kosong"); }
                else {Toast.makeText(MainActivity.this, "Password Berhasil", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}