package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private EditText editValor;
    private SeekBar seekBarGorjeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textGorjeta = findViewById(R.id.textGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textTotal = findViewById(R.id.textTotal);
        editValor = findViewById(R.id.editValor);
        seekBarGorjeta =findViewById(R.id.seekBar2);

        //adicionar listener
        seekBarGorjeta.setOnSeekBarChangeListener((new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
               porcentagem = progress;
               textPorcentagem.setText( Math.round( porcentagem) + "%");
               calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        }));

    }

    public void calcular(){
        String valorRecuperado = editValor.getText().toString();
        if( valorRecuperado == null || valorRecuperado.equals("")){

            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_LONG
            ).show();
        }else {
//Conveter string para double
            double valorDigitado = Double.parseDouble(( valorRecuperado));

            //calcular gorjeta
            double gorjeta = valorDigitado * (porcentagem/100);
            double Total = gorjeta + valorDigitado;

            //exibir gorjeta
            textGorjeta.setText("R$" + Math.round((gorjeta)));
            textTotal.setText("R$" + Total);
        }

    }

}