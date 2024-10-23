package com.encurtador.url.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

    public static String criaIdCorrespondente(){
        String[] numeroLetras = new String[]{"A","B","C","D","E","F","G","H","I",
                "J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z","W","0","1","2"
                ,"3","4","5","6","7","8","9"};
        int tamanho = new Random().nextInt(5,10);
        List<String> idCorrepondente = new ArrayList<>(tamanho);
        for(int i =0; i < tamanho; i++){
            idCorrepondente.add(i,numeroLetras[new Random().nextInt(numeroLetras.length)]);
        }
        return String.join("", idCorrepondente);
    }

}
