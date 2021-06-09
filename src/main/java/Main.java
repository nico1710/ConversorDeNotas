import java.util.*;

public class Main {


    public static void main(String[] args){
        int paisSeleccionado, repetirConversion = 0;

        Scanner teclado = new Scanner(System.in);
        Menu menuPrincipal = new Menu();

        do{
            System.out.println("Seleccione Pais de Origen");
            menuPrincipal.seleccionPais();

            menuPrincipal.ingresarNota();
            menuPrincipal.seleccionPais();

            paisSeleccionado = teclado.nextInt();
            menuPrincipal.setPaisElejido(paisSeleccionado);
            menuPrincipal.mostrarResultado();

            System.out.println("Desea calcular otra nota: ");
            System.out.println("1. Convertir otra nota");
            System.out.println("2. Salir");
            repetirConversion = teclado.nextInt();

        }while(repetirConversion < 2);
    }

}
