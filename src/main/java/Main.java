import java.util.*;

public class Main {


    public static void main(String[] args){
        double nota;
        int opcion, repetir = 0;

        Scanner teclado = new Scanner(System.in);

        do{
            System.out.println("Selecione pais");
            System.out.println("1.- Argentina");
            System.out.println("2.- Peru");
            System.out.println("3.- Bolivia");

            opcion = teclado.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Ingrese nota ");
                    nota = teclado.nextDouble();
                    Calculo calculo = new Calculo(nota);
                    calculo.calculoArgentino();
                    System.out.println(calculo.getResultado());
                    break;

                case 2:
                    System.out.println("Ingrese nota ");
                    nota = teclado.nextDouble();
                    Calculo calculo2 = new Calculo(nota);
                    calculo2.calculoPeruano();
                    System.out.println(calculo2.getResultado());
                    break;

                case 3:
                    System.out.println("Ingrese nota ");
                    nota = teclado.nextDouble();
                    Calculo calculo3 = new Calculo(nota);
                    calculo3.calculoPeruano();
                    System.out.println(calculo3.getResultado());
                    break;
            }
            System.out.println("");
            System.out.println("1. DESAS VOLVER A CONVERTIR...");
            System.out.println("2. SALIR");
            repetir = teclado.nextInt();

        }while(repetir < 2);
    }

}
