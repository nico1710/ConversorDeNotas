package com.conversor.dev;

import org.apache.log4j.Logger;

import java.util.Scanner;

/** Representa el menu con las opciones para el usuario
 * @author Nicolas Pereira
 * @version 3.0
 * @since 2021-07-23
 */

public class Menu {
    public static Logger log = Logger.getLogger(Menu.class);
    private double nota;
    private Pais paisElegido;
    private Pais paisOrigen;
    private Formula calculoNota;
    /**
     * Construcor vacio del Menu
     */
    public Menu() {}

    /**
     * Ingresa la nota del usuario
     */
    public void ingresarNota() {
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Ingresa Nota de " + paisOrigen.getNombrePais() + ": ");
            this.nota = teclado.nextDouble();
        }while(nota < paisOrigen.getNotaMinima() || nota > paisOrigen.getNotaMaxima());
    }

    /**
     * Muestra el nombre del pais con los valores del enum Pais
     * @see Pais#values() para obtener cada pais del enum
     * @see Pais#getNombrePais() para mostrar al usuario el nombre del pais
     */
    public void seleccionPais() {
        int contador = 0;
        for(Pais pais : Pais.values()) {
            System.out.println((contador + 1) + ". " + pais.getNombrePais());
            contador++;
        }
    }

    /**
     * Setea el pais de origen
     * @param opcion int con la opcion ingresada por el usuario
     * @see Pais#values() para obtener cada pais del enum
     */
    public void setPaisOrigen(int opcion) {
        int contador = 1;
        for(Pais pais : Pais.values()) {
            if(opcion == contador) {
                paisOrigen = pais;
                break;
            }
            contador++;
        }
        log.info("com.conversor.dev.Pais Origen: " + paisOrigen);
    }

    /**
     * Setea el pais de destino
     * @param opcion int con la opcion ingresada por el usuario
     * @see Pais#values() para obtener cada pais del enum
     */
    public void setPaisElegido(int opcion) {
        int contador = 1;
        for(Pais pais : Pais.values()) {
            if(opcion == contador) {
                paisElegido = pais;
                break;
            }
        }
        log.info("com.conversor.dev.Pais Destino: " + paisElegido);
    }

    /**
     * Muestra el resultado de la conversion
     */
    public void mostrarResultado() {
        if(paisOrigen == paisElegido) {
            System.out.println("La nota es la Misma..!!!");
        }else {
            if(paisOrigen != Pais.CHILE && paisElegido != Pais.CHILE) {
                System.out.println("formula completa");
                calculoNota = new Formula(nota, paisOrigen, paisElegido);
                calculoNota.crearFormulaCompleta();
                System.out.println(calculoNota.getResultado());
            }else if(paisOrigen == Pais.CHILE) {
                calculoNota = new Formula(nota, paisElegido);
                calculoNota.crearFormula();
                System.out.println(calculoNota.getResultado());
            }else {
                calculoNota = new Formula(nota, paisOrigen);
                calculoNota.crearFormulaPaisOrigenAChilena();
                System.out.println(calculoNota.getResultado());
            }
        }
    }

    /**
     * Retorna el pais elegido por el usuario
     * @return Pais elegido
     */
    public Pais getPaisElegido() {
        return paisElegido;
    }
}
