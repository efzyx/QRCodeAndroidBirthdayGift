package com.bacokod.fauzi.bacokod;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    private Button baco;
    private Button buek;
    private TextView isi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baco = (Button) findViewById(R.id.baco_btn);
        final Activity activity =this;
        baco.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(activity);
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                intentIntegrator.setPrompt("Baburu Kode");
                intentIntegrator.setCameraId(0);
                intentIntegrator.setBeepEnabled(false);
                intentIntegrator.setBarcodeImageEnabled(false);
                intentIntegrator.initiateScan();
            }
        });
        buek =(Button) findViewById(R.id.buek_button);
        buek.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(activity, Main2Activity.class);
                finish();
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        isi=(TextView) findViewById(R.id.isi_view);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if(intentResult.getContents() == null){
                Toast.makeText(this, "Dak jadi do", Toast.LENGTH_SHORT).show();
                isi.setText("");
            }
            else{
                isi.setText(intentResult.getContents());
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
        }
}
