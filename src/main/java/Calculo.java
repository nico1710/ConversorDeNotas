public class Calculo {

    private double resultado;
    private final double nota;
    private Formula formula;

    public Calculo(double nota){
        this.nota = nota;
    }

    public void calculoArgentino() {
        formula = new Formula(nota, 6, 4);
        formula.crearFormula();
        resultado = formula.getResultado();
    }

    public void calculoPeruano() {
        formula = new Formula(nota, 11, 9);
        formula.crearFormula();
        resultado = formula.getResultado();
    }

    public void calculoBoliviano() {
        formula = new Formula(nota, 50, 50);
        formula.crearFormula();
        resultado = formula.getResultado();
    }

    public double getResultado() {
        return resultado;
    }
}
