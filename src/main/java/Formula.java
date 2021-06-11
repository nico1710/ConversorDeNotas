public class Formula {

    private double nota;
    private int num1;
    private double denominador;
    private double resultado;
    private Pais pais;

    public Formula(double nota, Pais pais){
        this.nota = nota;
        this.num1 = pais.getNumeroFormula();
        this.denominador = pais.getDividendo();
    }

    //obtener la nota que se ingresa por consola
    public double getNota() {
        return nota;
    }

    public int getNum() { return num1; }

    //se crea la formula de nota CHilena a otro Pais
    public void crearFormula() {
        resultado = ((denominador * (nota - 4)) / 3) + num1 ;
    }

    //se crea la formula de nota Pais origen a Chilena
    public void crearFormulaPaisOrigenAChilena() {
        resultado = (((nota - num1) * 3) / denominador) + 4;
    }

    public double getResultado() {
        return resultado;
    }


}
