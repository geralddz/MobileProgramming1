package com.example.geraldmobileproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.geraldmobileproject.ui.Activity_Form;

public class MainActivity extends AppCompatActivity {
    Button btnsave, btndel;
    EditText etNim, etPW, etNama, etHP, etEmail;
    RadioButton rblk, rbpr;
    CheckBox amcc, hmssi, koma;
    Spinner spiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inisiasi
        btnsave = (Button) findViewById(R.id.btnsave);
        btndel = (Button) findViewById(R.id.btndel);
        etNama = (EditText) findViewById(R.id.etNama);
        etNim = (EditText) findViewById(R.id.etNim);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etHP = (EditText) findViewById(R.id.etHP);
        etPW = (EditText) findViewById(R.id.etPW);
        rblk = (RadioButton) findViewById(R.id.rblk);
        rbpr = (RadioButton) findViewById(R.id.rbpr);
        spiner = (Spinner) findViewById(R.id.spiner);
        amcc = (CheckBox) findViewById(R.id.amcc);
        hmssi = (CheckBox) findViewById(R.id.himssi);
        koma = (CheckBox) findViewById(R.id.koma);

        btnsave.setOnClickListener((View.OnClickListener) v -> {
            String inputnama = String.valueOf(etNama.getText().toString());
            String inputnim = String.valueOf(etNim.getText().toString());
            String inputemail = String.valueOf(etEmail.getText().toString());
            String inputhp = String.valueOf(etHP.getText().toString());
            String inputprodi = String.valueOf(spiner.getSelectedItem().toString());
            String jk;
            if (rblk.isChecked())
            {
                jk = "Laki-Laki";
            }
            else
            {
                jk = "Perempuan";
            }
            String UKM = " ";
            if (amcc.isChecked())
            {
                UKM += "\nAMCC";
            }
            if (hmssi.isChecked())
            {
                UKM += "\nHMSSI";
            }
            if (koma.isChecked())
            {
                UKM += "\nKOMA";
            }

            Intent myIntent = new Intent(MainActivity.this, Activity_Form.class);
            Bundle paket = new Bundle();
            paket.putString("Nama", inputnama);
            paket.putString("NIM", inputnim);
            paket.putString("Email", inputemail);
            paket.putString("No. HP", inputhp);
            paket.putString("Prodi", inputprodi);
            paket.putString("Jenis Kelamin", jk);
            paket.putString("UKM",UKM);
            myIntent.putExtras(paket);
            startActivity(myIntent);
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