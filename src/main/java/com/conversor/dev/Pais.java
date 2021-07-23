package com.conversor.dev;

/** Representa los paises disponibles para elegir
 * @author Nicolas Pereira
 * @version 3.0
 * @since 2021-07-14
 * {@link #CHILE}
 * {@link #ARGENTINA}
 * {@link #PERU}
 * {@link #BRASIL}
 * {@link #ECUADOR}
 * {@link #BOLIVIA}
 */

public enum Pais {
    /**
     * Chile pais
    */
    CHILE("Chile", 0, 0, 1, 7),
    /**
     * Argentina pais
     */
    ARGENTINA("Argentina", 6, 4,1, 10),
    /**
     * Peru pais
     */
    PERU("Peru", 11, 9, 1, 20),
    /**
     * Brasil pais
     */
    BRASIL("Brasil", 5, 5, 1, 10),
    /**
     * Ecuador pais
     */
    ECUADOR("Ecuador", 3, 5, 1, 10),
    /**
     * Bolivia pais
     */
    BOLIVIA("Bolivia", 50, 50,1, 100);

    private String nombrePais;
    private int numeroFormula;
    private int dividendo;
    private int notaMinima;
    private int notaMaxima;

    /**
     * Construcor del Enum Pais
     * @param nombrePais nombre del pais
     * @param numeroFormula es la primer constante dentro de la formula
     * @param dividendo es el denominador constante dentro de la formula
     * @param notaMinima es la nota minima del pais
     * @param notaMaxima es la nota maxima del pais
     */
    Pais(String nombrePais, int numeroFormula, int dividendo, int notaMinima, int notaMaxima) {
        this.nombrePais = nombrePais;
        this.numeroFormula = numeroFormula;
        this.dividendo = dividendo;
        this.notaMinima = notaMinima;
        this.notaMaxima = notaMaxima;
    }

    /**
     * Obtener el nombre del pais
     * @return String con el nombre del pais
     */
    public String getNombrePais() {
        return nombrePais;
    }

    /**
     * Obtener la primer constante del pais
     * @return int con el numero de la primer constante que se implementa en la formula.
     */
    public int getNumeroFormula() {
        return numeroFormula;
    }

    /**
     * Obtener el denominador del pais
     * @return int con el denominador que se implementa en la formula.
     */
    public int getDividendo() {
        return dividendo;
    }

    /**
     * Obtener la nota minima del pais
     * @return int con la nota minima del pais
     */
    public int getNotaMinima() { return notaMinima; }

    /**
     * Obtener la nota maxsima del pais
     * @return int con la nota maxima del pais
     */
    public int getNotaMaxima() { return notaMaxima; }
}
