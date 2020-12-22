package com.example.differentciphers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private Button mPlayFairbutton;
    protected EditText mKeyText;
    protected EditText mEncryptPlaintext;
    protected EditText mDecryptPliantext;
    protected EditText mMatrix;
    protected EditText M1;
    protected EditText M2;
    protected EditText M3;
    protected EditText M4;
    protected EditText M5;
    final PlayFairCipher pc=new PlayFairCipher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mEncryptPlaintext=findViewById(R.id.editText);
        mDecryptPliantext=findViewById(R.id.editText2);
        mMatrix=findViewById(R.id.editText3);
        mKeyText=findViewById(R.id.editTextKey);
        mPlayFairbutton=findViewById(R.id.button3);
        M1=findViewById(R.id.textViewM1);
        M2=findViewById(R.id.textViewM2);
        M3=findViewById(R.id.textViewM3);
        M4=findViewById(R.id.textViewM4);
        M5=findViewById(R.id.textViewM5);
        mPlayFairbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vkey=mKeyText.getText().toString();
                String vtext = pc.encrypt(vkey,mEncryptPlaintext.getText().toString());
                mDecryptPliantext.setText(vtext);
                char aa[][]=pc.getMatrix2D();
                ArrayList<String> matrixres = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    StringBuilder ss=new StringBuilder();
                    for (int j = 0; j < 5; j++) {
                        char b=aa[i][j];
                        ss.append(b);
                    }
                    String Pair=ss.toString();
                    matrixres.add(Pair);
                }
                M1.setText(matrixres.get(0));
                M2.setText(matrixres.get(1));
                M3.setText(matrixres.get(2));
                M4.setText(matrixres.get(3));
                M5.setText(matrixres.get(4));


            }
        });

    }
}
