package com.bacokod.fauzi.bacokod;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button buek = (Button) findViewById(R.id.button);
        Button ulang = (Button) findViewById(R.id.button2);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final ImageView iv = (ImageView) findViewById(R.id.imageView);

            buek.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String str2qr = editText.getText().toString();
                    if(str2qr.length()>=1){
                    MultiFormatWriter mfw = new MultiFormatWriter();
                    try {
                        BitMatrix bm = mfw.encode(str2qr, BarcodeFormat.QR_CODE, 500, 500);
                        BarcodeEncoder be = new BarcodeEncoder();
                        Bitmap bitmap = be.createBitmap(bm);
                        editText.setVisibility(View.GONE);
                        iv.setImageBitmap(bitmap);
                    } catch (WriterException e) {

                    }
                    }
                    else{
                        Toast.makeText(Main2Activity.this, "Isi lah dulu", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        ulang.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                iv.setImageBitmap(null);
                editText.setText(null);
                editText.setVisibility(View.VISIBLE);
            }
        });

    }

}
