package com.conversor.dev;

/** Representa los paises disponibles para elegir
 * @author Nicolas Pereira
 * @version 3.0
 * @since 2021-07-14
 */

public enum Pais {
    CHILE("Chile", 0, 0, 1, 7),
    ARGENTINA("Argentina", 6, 4,1, 10),
    PERU("Peru", 11, 9, 1, 20),
    BRASIL("Brasil", 5, 5, 1, 10),
    ECUADOR("Ecuador", 3, 5, 1, 10),
    BOLIVIA("Bolivia", 50, 50,1, 100);

    private String nombrePais;
    private int numeroFormula;
    private int dividendo;
    private int notaMinima;
    private int notaMaxima;

    Pais(String nombrePais, int numeroFormula, int dividendo, int notaMinima, int notaMaxima) {
        this.nombrePais = nombrePais;
        this.numeroFormula = numeroFormula;
        this.dividendo = dividendo;
        this.notaMinima = notaMinima;
        this.notaMaxima = notaMaxima;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public int getNumeroFormula() {
        return numeroFormula;
    }

    public int getDividendo() {
        return dividendo;
    }

    public int getNotaMinima() { return notaMinima; }

    public int getNotaMaxima() { return notaMaxima; }
}
