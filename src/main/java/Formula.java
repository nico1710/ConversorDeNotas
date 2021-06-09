public class Formula {

    private double nota;
    private int num1;
    private double denominador;
    private double resultado;
    private Pais pais;

    public Formula(){}

    public Formula(double nota, Pais pais){
        this.nota = nota;
        this.num1 = pais.getNumeroFormula();
        this.denominador = pais.getDividendo();
    }
    //obtener la nota que se ingresa por consola
    public double getNota() {
        return nota;
    }
    //se crea la formula
    public void crearFormula(){
        resultado = ((nota - num1) * (3 / denominador)) + 4;
    }

    public double getResultado() {
        return resultado;
    }


}
