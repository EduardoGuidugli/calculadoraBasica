package com.example.calculadorabasica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivityCalculadora extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete,
            numeroOito, numeroNove, virgula, limparButton, conversorButton2, conversorButton;
    private TextView txtExpressao, resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculadora);
        iniciarComponentes();
        criarListeners();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        virgula.setOnClickListener(this);
    }

    private void iniciarComponentes(){
        numeroZero = findViewById(R.id.numeroZero);
        numeroUm = findViewById(R.id.numeroUm);
        numeroDois = findViewById(R.id.numeroDois);
        numeroTres = findViewById(R.id.numeroTres);
        numeroQuatro = findViewById(R.id.numeroQuatro);
        numeroCinco = findViewById(R.id.numeroCinco);
        numeroSeis = findViewById(R.id.numeroSeis);
        numeroSete = findViewById(R.id.numeroSete);
        numeroOito = findViewById(R.id.numeroOito);
        numeroNove = findViewById(R.id.numeroNove);
        virgula = findViewById(R.id.virgula);
        limparButton = findViewById(R.id.limparButton);
        resultadoTextView = findViewById(R.id.resultadoTextView);
        txtExpressao = findViewById(R.id.txtExpressao);
        conversorButton = findViewById(R.id.conversorButton);
        conversorButton2 = findViewById(R.id.conversorButton2);
        limparButton =  findViewById(R.id.limparButton);

    }

    public void AcrescentarUmaExpressao (String string, boolean limpar_dados){

        if (resultadoTextView.getText().equals("")){
            txtExpressao.setText("");
        }

        if (limpar_dados){
            resultadoTextView.setText("");
            txtExpressao.append(string);
        }else {
            txtExpressao.append(resultadoTextView.getText());
            txtExpressao.append(string);
            resultadoTextView.setText("");
        }

    }

    private void criarListeners() {
        conversorButton.setOnClickListener(evt -> conversor());
        conversorButton2.setOnClickListener(evt -> conversor2());
        limparButton.setOnClickListener(evt -> limpar());
    }

    private void limpar() {
        resultadoTextView.setText("");
        txtExpressao.setText("");
    }

    private void conversor() {
        String numero1String = txtExpressao.getText().toString();


        double numero1 = Double.parseDouble(numero1String);
        double numero2 = Double.parseDouble(String.valueOf("4.98"));
        double resultado = numero1 * numero2 ;
        DecimalFormat resultado2  = new DecimalFormat("0.00");
        String resultadoFinal = resultado2.format(resultado);

        resultadoTextView.setText(String.valueOf(resultadoFinal) + " R$");
    }

    private void conversor2() {
        String numero1String = txtExpressao.getText().toString();

        double numero1 = Double.parseDouble(numero1String);
        double numero2 = Double.parseDouble(String.valueOf("4.98"));
        double resultado = numero1 / numero2 ;
        DecimalFormat resultado2  = new DecimalFormat("0.00");
        String resultadoFinal = resultado2.format(resultado);

        resultadoTextView.setText(String.valueOf(resultadoFinal) + " $");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.numeroZero:
                AcrescentarUmaExpressao("0", true);
                break;
            case R.id.numeroUm:
                AcrescentarUmaExpressao("1", true);
                break;
            case R.id.numeroDois:
                AcrescentarUmaExpressao("2", true);
                break;
            case R.id.numeroTres:
                AcrescentarUmaExpressao("3", true);
                break;
            case R.id.numeroQuatro:
                AcrescentarUmaExpressao("4", true);
                break;
            case R.id.numeroCinco:
                AcrescentarUmaExpressao("5", true);
                break;
            case R.id.numeroSeis:
                AcrescentarUmaExpressao("6", true);
                break;
            case R.id.numeroSete:
                AcrescentarUmaExpressao("7", true);
                break;
            case R.id.numeroOito:
                AcrescentarUmaExpressao("8", true);
                break;
            case R.id.numeroNove:
                AcrescentarUmaExpressao("9", true);
                break;
            case R.id.virgula:
                AcrescentarUmaExpressao(".", true);
                break;
        }
    }
}
