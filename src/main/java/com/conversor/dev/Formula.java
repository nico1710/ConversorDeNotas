package com.conversor.dev;

import org.apache.log4j.Logger;

/** Representa a la formula que se contruye a partir de la nota y el com.conversor.dev.Pais de origen y/o destino.
 * @author Nicolas Pereira
 * @version 3.0
 * @since 2021-07-14
 */
public class Formula {
    public static Logger log = Logger.getLogger(Formula.class);
    private double nota;
    private int num1;
    private double denominador;
    private int numPaisDestino;
    private int denominadorPaisDestino;
    private double resultado;
    private Pais pais;

    /**
     * Constructor de la clase com.conversor.dev.Formula
     * @param nota la nota para crear la formula
     * @param pais el com.conversor.dev.Pais al que desar convertir la nota
     * @see Pais#getNumeroFormula() para obtener el la primer incgnita de nuestra formula
     */
    public Formula(double nota, Pais pais){
        this.nota = nota;
        this.num1 = pais.getNumeroFormula();
        this.denominador = pais.getDividendo();
    }

    /**
     * Constructor de la clase com.conversor.dev.Formula
     * @param nota la nota para crear la formula
     * @param paisOrigen el com.conversor.dev.Pais de origen del usuario
     * @param paisDestino el com.conversor.dev.Pais al que desea convertir la nota
     */
    public Formula(double nota, Pais paisOrigen, Pais paisDestino) {
        this.nota = nota;
        this.num1 = paisOrigen.getNumeroFormula();
        this.denominador = paisOrigen.getDividendo();
        this.numPaisDestino = paisDestino.getNumeroFormula();
        this.denominadorPaisDestino = paisDestino.getDividendo();
    }

    /**
     * Constructor de la clase com.conversor.dev.Formula
     * @return int nos retorna la nota
     */
    public double getNota() {
        return nota;
    }

    /**
     * Constructor de la clase com.conversor.dev.Formula
     * @return int nos retorna la primer icognita de nuestra formula
     */
    public int getNum() { return num1; }

    /**
     * se crea la formula de nota chilena a otro com.conversor.dev.Pais
     */
    public void crearFormula() {
        log.info("com.conversor.dev.Formula Creada");
        log.info("(" + denominador + " * (" + nota + " - 4) / 3)" + " + " + num1);
        resultado = ((denominador * (nota - 4)) / 3) + num1 ;
    }

    /**
     * se crea la formula de nota com.conversor.dev.Pais origen a Chilena
     */
    public void crearFormulaPaisOrigenAChilena() {
        log.info("com.conversor.dev.Formula Creada");
        log.info("(((" + nota + " - " + num1 + ") * 3) / " + denominador + ") + 4)");
        resultado = (((nota - num1) * 3) / denominador) + 4;
    }

    /**
     * se crear la formula a partir del PaisOrigen a nota Chilena y la nota chilena la usamos para el pais de Destino
     */
    public void crearFormulaCompleta() {
        log.info("com.conversor.dev.Formula Creada");
        double notaChilena = (((nota - num1) * 3) / denominador) + 4;
        log.info("((" + denominadorPaisDestino + " * (" + nota + " - 4) / 3)" + " + " + num1);
        resultado =  ((denominadorPaisDestino * (notaChilena - 4)) / 3) + numPaisDestino ;
    }

    /**
     * obtenemos el resultado al hacer el calculo
     * @return obtenemos el resultado al hacer el calculo
     */
    public double getResultado() {
        return resultado;
    }


}
