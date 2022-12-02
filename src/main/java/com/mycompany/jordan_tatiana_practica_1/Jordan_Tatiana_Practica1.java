package com.mycompany.jordan_tatiana_practica_1;

public class Jordan_Tatiana_Practica1 {
    public static boolean potenciaDeDos(int posicion, int[] codigo){
        //para encontrar la posicion del array.
        boolean potencia = false;
        for (int i = 0; i < codigo.length; i++){
            if (Math.pow(2, i) == posicion){
                potencia = true;
            }//if
        }//for
        
        return potencia;
        
    }//Potencias de dos
    
    private static boolean bitDependiente (int bitRed, int bitMsj, int[] codigo ){
        
        boolean bitDepende = false;
        if((potenciaDeDos(bitMsj, codigo) == false) && ((bitMsj & bitRed) == bitRed) && ( bitRed != bitMsj)) 
            bitDepende = true;
        return bitDepende;
    }//Bit dependiente.
    
    public static void main(String[] args) {
        
        //creacion del mensaje
        int[] msj = {1, 1, 1, 1, 1, 1, 1, 1};
        int bParidad = 0;
        
        //saber los bits de paridad.
        for (int i = 0; Math.pow(2, i) < msj.length + bParidad + 1; i++) {
            bParidad++;
        }//for
        
        //Array con el mensaje mas los bits paridad y el global.
        int[] codigo = new int[msj.length + bParidad + 1];
        int i2 = 0;
        
        //Meter el mensaje en el hueco indicado.
        for (int i = 1; i < codigo.length; i++) {
            if (potenciaDeDos(i, codigo) == false) {
                codigo[i] = msj[i2];
                i2++;
            }//if
        }//for
        
        int contador = 0;
        int bitRed = 1;
        int bitMsj = 1;
        
        //rellenar los bits de redundancia:
        while(bitRed < codigo.length){ //Este recorre los bits de redundancia
            if (potenciaDeDos(bitRed, codigo) == true) {
                while(bitMsj < codigo.length){//Este recorre los bits de mensaje
                    if (bitDependiente(bitRed, bitMsj, codigo) == true) {
                        if (codigo[bitMsj] == 1) {
                            contador++;
                        }//if
                    }//if
                   bitMsj++;
                }//while
                codigo[bitRed] = contador % 2;
                contador = 0; 
                 bitMsj = 1;
            }//if
            bitRed++;
        }//while
        
        //Rellenar bit global:
        int contador2 = 0;
        for(int i = 1; i < codigo.length;i++){
            if(codigo[i] == 1)
                contador2++;
        }//for
        codigo[0] = contador2 % 2;
        
    }//main
}//Practica 1
