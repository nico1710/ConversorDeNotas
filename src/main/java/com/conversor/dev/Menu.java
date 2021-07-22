package com.conversor.dev;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Menu {
    public static Logger log = Logger.getLogger(Menu.class);
    private double nota;
    private Pais paisElegido;
    private Pais paisOrigen;
    private Formula calculoNota;

    public Menu() {}

    public void ingresarNota() {
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Ingresa Nota de " + paisOrigen.getNombrePais() + ": ");
            this.nota = teclado.nextDouble();
        }while(nota < paisOrigen.getNotaMinima() || nota > paisOrigen.getNotaMaxima());
    }

    public void seleccionPais() {
        int contador = 0;
        for(Pais pais : Pais.values()) {
            System.out.println((contador + 1) + ". " + pais.getNombrePais());
            contador++;
        }
    }

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

    public Pais getPaisElegido() {
        return paisElegido;
    }
}
