package com.example.ap3_dadm_diego_de_souza;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();
        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Resultado");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();

        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);

        mbmi=Float.toString(intbmi);

        if(intbmi<18.5)
        {
            mbmicategory.setText("Abaixo do peso");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.errado);
        }
        else if(intbmi<=24.9 && intbmi>=18.5)
        {
            mbmicategory.setText("Peso ideal");
            mimageview.setImageResource(R.drawable.correto);
        }
        else if(intbmi<=29.9 && intbmi>=25)
        {
            mbmicategory.setText("Sobrepeso");
            mimageview.setImageResource(R.drawable.atencao);
        }
        else if(intbmi<=34.9 && intbmi>=30)
        {
            mbmicategory.setText("Obesidade grau I");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.errado);
        }
        else if(intbmi<=39.9 && intbmi>=35)
        {
            mbmicategory.setText("Obesidade grau II (Severa)");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.errado);
        }
        else
        {
            mbmicategory.setText("Obesidade grau III (Mórbida)");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.errado);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}