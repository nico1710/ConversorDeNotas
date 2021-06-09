public enum Pais {
    ARGENTINA("Argentina", 6, 4),
    PERU("Peru", 11, 9),
    BRASIL("Brasil", 5, 5),
    ECUADOR("Ecuador", 3, 5);

    private String nombrePais;
    private int numeroFormula;
    private int dividendo;

    Pais(String nombrePais, int numeroFormula, int dividendo) {
        this.nombrePais = nombrePais;
        this.numeroFormula = numeroFormula;
        this.dividendo = dividendo;
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
}
