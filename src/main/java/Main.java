import org.apache.log4j.Logger;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {
    final static Logger log = Logger.getLogger(Main.class);
    final static String direccion = "C:\\Users\\Nicolas\\IdeaProjects\\ConversorDeNotas\\logs";

    public static void main(String[] args) {

        int paisSeleccionado, paisOrigen, repetirConversion = 0;

        Scanner teclado = new Scanner(System.in);
        Menu menuPrincipal = new Menu();

        do{
            log.debug("Programa Iniciado");
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
                deleteLog();

            }catch (InputMismatchException in) {
                log.error("ERROR | No puede ingresar letras o caracteres!!!");
                System.out.println("ERROR | No puede ingresar letras o caracteres!!!\n");
                teclado.next();
            }catch (IOException e) {
                log.error("ERROR AL ELIMINAR LOG");
                System.out.println("ERROR AL ELIMINAR LOG");
            }
        }while(repetirConversion < 2);

        log.info("Programa Terminado");

    }

    public static void deleteLog() throws IOException{
        AtomicInteger count = new AtomicInteger();
        try (Stream<Path> paths = Files.walk(Paths.get(direccion))){
            Files.walk(Paths.get(direccion)).forEach(ruta -> {
                if(Files.isRegularFile(ruta)) {
                    if(count.get() == 0) {
                        File file = new File(ruta.toString());
                        if(file.delete()) {
                            System.out.println("Log Eliminado");
                        }else{
                            System.out.println("Log no eliminado");
                        }
                        count.getAndIncrement();
                    }
                }
            });
        }
    }

}
