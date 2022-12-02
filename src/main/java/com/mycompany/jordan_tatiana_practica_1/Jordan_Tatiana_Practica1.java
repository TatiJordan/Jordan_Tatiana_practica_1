package com.mycompany.jordan_tatiana_practica_1;

public class Jordan_Tatiana_Practica1 {
    public static void main(String[] args) {
        
        //creacion del mensaje
        int[] msj = {1, 1, 1, 1, 1, 1, 1, 1};
        int bParidad = 0;
        
        //saber los bits de paridad.
        for (int i = 0; Math.pow(2, i) < msj.length + bParidad + 1; i++) {
            bParidad++;
        }//for
    }//main
}//Practica 1
