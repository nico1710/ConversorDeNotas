import java.util.*;

public class Main {


    public static void main(String[] args){
        double nota;
        int opcion;
        Formula formula = new Formula();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Selecione pais");
        System.out.println("1.- Argentina");
        System.out.println("2.- Peru");
        System.out.println("3.- Bolivia");

        opcion = teclado.nextInt();

        switch(opcion){
            case 1:
                System.out.println("Ingrese nota ");
                nota = teclado.nextDouble();

                System.out.println(formula.formulaArgentina(nota));
                break;

            case 2:
                System.out.println("Ingrese nota ");
                nota = teclado.nextDouble();

                System.out.println(formula.formulaPeruana(nota));
                break;

            case 3:
                System.out.println("Ingrese nota ");
                nota = teclado.nextDouble();

                System.out.println(formula.formulaBoliviana(nota));
                break;
        }

    }

}
