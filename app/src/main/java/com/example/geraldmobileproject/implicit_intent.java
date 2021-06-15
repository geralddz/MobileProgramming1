package com.example.geraldmobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.EditText;

public class implicit_intent extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_intent_activity);

        final EditText et = findViewById(R.id.etNo);

        findViewById(R.id.btncam).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(MediaStore.ACTION_VIDEO_CAPTURE);

            startActivity(i);
        });

        findViewById(R.id.btngal).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("content://media/internal/images/media"));
            startActivity(i);
        });

        findViewById(R.id.btnbrow).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://www.google.com/"));
            startActivity(Intent.createChooser(i, "Title"));
        });

        findViewById(R.id.btncon).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("content://contacts/people/"));
            startActivity(i);
        });

        findViewById(R.id.btndial).setOnClickListener(v -> {

            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+et.getText()));
            startActivity(i);

            Intent intent = new Intent(Intent.ACTION_DIAL, Uri
                    .parse("tel:"+et.getText()));
            startActivity(i);

            startActivity(new Intent(Intent.ACTION_DIAL, Uri
                    .parse("tel:"+et.getText())));

        });
    }
}