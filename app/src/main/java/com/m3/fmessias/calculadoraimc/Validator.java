package com.m3.fmessias.calculadoraimc;

import android.text.TextUtils;

public class Validator {

    public boolean isCampoPesoValido(String peso){
        if((peso.isEmpty() || Double.parseDouble(peso) < 3 || Double.parseDouble(peso) > 600))
            return false;
        else
            return true;
    }

    public boolean isCampoAlturaValido(String altura){
        if((altura.isEmpty() || Double.parseDouble(altura) < 0.30 || Double.parseDouble(altura) > 2.30))
            return false;
        else
            return true;
    }

}
