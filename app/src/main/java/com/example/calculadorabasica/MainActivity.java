package com.example.calculadorabasica;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText numero1EditText;
    Button conversorButton;
    Button conversorButton2;
    Button limpar;
    Button buttonAlternar;
    TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vincularComponentes();
        criarListeners();
    }
    private void vincularComponentes() {
        numero1EditText = findViewById(R.id.numero1EditText);
        conversorButton = findViewById(R.id.conversorButton);
        conversorButton2 = findViewById(R.id.conversorButton2);
        limpar =  findViewById(R.id.limparButton);
        resultadoTextView = findViewById(R.id.resultadoTextView);
    }
    private void criarListeners() {
        conversorButton.setOnClickListener(evt -> conversor());
        conversorButton2.setOnClickListener(evt -> conversor2());
        limpar.setOnClickListener(evt -> limpar());
    }

    private void limpar() {
        resultadoTextView.setText("");
        numero1EditText.setText("");
    }

    private void conversor() {
        String numero1String = numero1EditText.getText().toString();


        double numero1 = Double.parseDouble(numero1String);
        double numero2 = Double.parseDouble(String.valueOf("4.98"));
        double resultado = numero1 * numero2 ;
        DecimalFormat resultado2  = new DecimalFormat("0.00");
        String resultadoFinal = resultado2.format(resultado);

        resultadoTextView.setText(String.valueOf(resultadoFinal) + " R$");
    }

    private void conversor2() {
        String numero1String = numero1EditText.getText().toString();

        double numero1 = Double.parseDouble(numero1String);
        double numero2 = Double.parseDouble(String.valueOf("4.98"));
        double resultado = numero1 / numero2 ;
        DecimalFormat resultado2  = new DecimalFormat("0.00");
        String resultadoFinal = resultado2.format(resultado);

        resultadoTextView.setText(String.valueOf(resultadoFinal) + " $");
    }

    public void proximaTela(View view){

        Intent intent = new Intent(this, MainActivityCalculadora.class);
        startActivity(intent);
    }

}


