package com.conversor.dev;

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

/**
 * Clase donde se ejcuta el programa
 * @author Nicolas Pereira
 * @version 3.0
 * @since 2021-07-23
 */
public class Main {
    final static Logger log = Logger.getLogger(Main.class);
    final static String direccion = "C:\\Users\\Nicolas\\IdeaProjects\\ConversorDeNotas\\logs";

    /**
     * Metodo principal de la clase Main
     * @param args String[] argumentos del main
     * @see Scanner para interactuar con el usuario
     * @see Menu para instanciar un objeto de tipo menu
     * @see Menu#seleccionPais() selecciona el pais de la lista de paises
     * @see Menu#setPaisOrigen(int) seteamos el pais de origen con la eleccion del usuario
     * @see Menu#ingresarNota() ingresamos la nota del usuario
     * @see Menu#setPaisElegido(int) seteamos el pais elegido con la eleccion del usuario
     * @see Menu#mostrarResultado() mostrar el resultado de la conversion
     */
    public static void main(String[] args) {

        int paisSeleccionado, paisOrigen, repetirConversion = 0;

        Scanner teclado = new Scanner(System.in);
        Menu menuPrincipal = new Menu();

        do{
            log.debug("Programa Iniciado");
            try {
                System.out.println("-- CONVERSOR DE NOTAS 1.1 --");
                System.out.println("Ingrese com.conversor.dev.Pais de origen: ");
                menuPrincipal.seleccionPais();
                paisOrigen = teclado.nextInt();
                menuPrincipal.setPaisOrigen(paisOrigen);

                menuPrincipal.ingresarNota();

                System.out.println("Ingrese com.conversor.dev.Pais al que dease convertir la nota: ");
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

    /**
     * Funcion para eliminar logs antiguos
     * @throws IOException caso de que exista error al encontrar el path
     */
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
