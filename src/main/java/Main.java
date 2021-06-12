import java.util.*;

public class Main {
    public static void main(String[] args){
        int paisSeleccionado, paisOrigen, repetirConversion = 0;

        Scanner teclado = new Scanner(System.in);
        Menu menuPrincipal = new Menu();

        do{
            try {
                System.out.println("-- CONVERSOR DE NOTAS 1.1 --");
                System.out.println("Ingrese Pais de origen: ");
                menuPrincipal.seleccionPais();
                paisOrigen = teclado.nextInt();
                menuPrincipal.setPaisOrigen(paisOrigen);

                menuPrincipal.ingresarNota();

                System.out.println("Ingrese Pais al que dease convertir la nota: ");
                menuPrincipal.seleccionPais();
                paisSeleccionado = teclado.nextInt();
                menuPrincipal.setPaisElegido(paisSeleccionado);

                menuPrincipal.mostrarResultado();

                System.out.println("Desea calcular otra nota: ");
                System.out.println("1. Convertir otra nota");
                System.out.println("2. Salir");
                repetirConversion = teclado.nextInt();

            }catch (InputMismatchException in) {
                System.out.println("ERROR | No puede ingresar letras o caracteres!!!\n");
                teclado.next();
            }
        }while(repetirConversion < 2);
    }

}
