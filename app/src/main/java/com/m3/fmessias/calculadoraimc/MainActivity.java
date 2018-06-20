//grupobsb.android@gmail.com

package com.m3.fmessias.calculadoraimc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    //Declarações
    EditText txtPeso;
    EditText txtAltura;
    TextView txtResult;
    TextView txtValorImc;
    Button btnCalcular;
    Button btnReferencias;
    ImageView imgResultado;
    Intent intent;
    Validator validator = new Validator();

    //OnCreate & OnClick
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPeso = findViewById(R.id.editTxtPeso);
        txtAltura = findViewById(R.id.editTxtAltura);
        txtResult = findViewById(R.id.txtResult);
        txtValorImc = findViewById(R.id.txtValorImc);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnReferencias = findViewById(R.id.btnValoresReferencia);
        imgResultado = findViewById(R.id.imgResultado);

        btnCalcular.setOnClickListener(this);
        btnReferencias.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnCalcular:
                String peso = txtPeso.getText().toString();
                String altura = txtAltura.getText().toString();

                Double imc;

                if(!validator.isCampoPesoValido(peso)) {
                    Toast.makeText(this, "Campo PESO inválido!", Toast.LENGTH_LONG).show();
                    txtPeso.requestFocus();
                }else{
                    if(!validator.isCampoAlturaValido(altura)){
                        Toast.makeText(this, "Campo ALTURA inválido!", Toast.LENGTH_LONG).show();
                        txtAltura.requestFocus();
                    }else{
                        Double dPeso = Double.parseDouble(peso);
                        Double dAltura = Double.parseDouble(altura);
                        imc = calculaImc(dPeso, dAltura);

                        if (imc < 17) {
                            txtResult.setText(R.string.txtMuitoAbaixoPeso);
                            txtValorImc.setText(String.valueOf(imc));
                            imgResultado.setImageResource(R.drawable.muitomagro);
                        } else if (imc < 18.5) {
                            txtResult.setText(R.string.txtAbaixoPeso);
                            txtValorImc.setText(String.valueOf(imc));
                            imgResultado.setImageResource(R.drawable.magro);
                        } else if (imc < 25) {
                            txtResult.setText(R.string.txtPesoNormal);
                            txtValorImc.setText(String.valueOf(imc));
                            imgResultado.setImageResource(R.drawable.normal);

                        } else if (imc < 30) {
                            txtResult.setText(R.string.txtAcimaPeso);
                            txtValorImc.setText(String.valueOf(imc));
                            imgResultado.setImageResource(R.drawable.acimapeso);
                        } else if(imc < 35) {
                            txtResult.setText(R.string.txtObesidadeI);
                            txtValorImc.setText(String.valueOf(imc));
                            imgResultado.setImageResource(R.drawable.obesidade1);
                        } else if (imc < 40) {
                            txtResult.setText(R.string.txtObesidadeII);
                            txtValorImc.setText(String.valueOf(imc));
                            imgResultado.setImageResource(R.drawable.obesidade2);
                        } else {
                            txtResult.setText(R.string.txtObesidadeIII);
                            txtValorImc.setText(String.valueOf(imc));
                            imgResultado.setImageResource(R.drawable.obesidade3);
                        }
                    }
                }

                break;

            case R.id.btnValoresReferencia:
                intent = new Intent(this, ListaDeReferenciaActivity.class);
                startActivity(intent);
                break;
        }
    }

    //Métodos
    private double calculaImc (double peso, double altura){
        return peso / (altura*altura);
    }


}
