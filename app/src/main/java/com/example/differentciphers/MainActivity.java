package com.example.differentciphers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mRadioCipherGroup;
    protected Button mEncryptButton;
    protected Button mDecryptButton;
    protected Button mplayfair;
    protected EditText mKeyText;
    protected EditText mEncryptPlaintext;
    protected EditText mDecryptPliantext;
    protected EditText mEncryptCipertext;
    protected EditText mDecryptCiphertext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEncryptButton=findViewById(R.id.button1);
        mDecryptButton=findViewById(R.id.button2);
        mplayfair=findViewById(R.id.button3);
        mKeyText=findViewById(R.id.editTextKey);
        mEncryptPlaintext=findViewById(R.id.editText);
        mDecryptPliantext=findViewById(R.id.editText2);
        mEncryptCipertext=findViewById(R.id.editText3);
        mDecryptCiphertext=findViewById(R.id.editText4);
        final ShiftCipher sc= new ShiftCipher();
        final VigenereCipher vc=new VigenereCipher();

        mEncryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //int selectedId=mRadioCipherGroup.getCheckedRadioButtonId();
                //mRadioCipherButton.findViewById(selectedId);
                mRadioCipherGroup =findViewById(R.id.radioGroup);
                switch (mRadioCipherGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton:
                        //mRadioCipherButton = findViewById(selectedId);
                        int key = Integer.parseInt(mKeyText.getText().toString());
                        String text = sc.encrypt(key, mEncryptPlaintext.getText().toString());
                        mDecryptPliantext.setText(text);
                    break;
                    case R.id.radioButton2:
                        String vkey=mKeyText.getText().toString();
                        String vtext = vc.encrypt(vkey,mEncryptPlaintext.getText().toString());
                        mDecryptPliantext.setText(vtext);
                    break;
                }
            }
        });
        mDecryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRadioCipherGroup =findViewById(R.id.radioGroup);
                switch (mRadioCipherGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton:
                        //mRadioCipherButton = findViewById(selectedId);
                        int key= Integer.parseInt(mKeyText.getText().toString());
                        String text2=sc.decrypt(key,mEncryptCipertext.getText().toString());
                        mDecryptCiphertext.setText(text2);
                        break;
                    case R.id.radioButton2:
                        String vkey=mKeyText.getText().toString();
                        String vtext = vc.decrypt(vkey,mEncryptCipertext.getText().toString());
                        mDecryptCiphertext.setText(vtext);
                        break;
                }

            }
        });
        mplayfair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

    }
    public void openActivity2(){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}

