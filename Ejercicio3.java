package Clase3;

import java.util.Scanner;

public class EjerciciosMetodos {

    public static void main(String args[]){
        Scanner input= new Scanner(System.in);

        bienvenida();
        int doble= calcularDoble(6);
        System.out.println("El doble de 6 es " + doble);

        finalizar();
    }


    //Ejercicio 1
    //Escribir un método que reciba un número y retorne su doble
    public static int calcularDoble(int num){
        return  num * 2;
    }
    public static void bienvenida()
    {
        System.out.println("Benvenido al programa!");
    }
    public static void finalizar(){
        System.out.println("El programa ha finalizado");
    }
    

}
