public class Formula {

    private double nota;
    private int num1;
    private double denominador;
    private double convercionChilena;
    private double resultado;

    public Formula(){}

    public Formula(double nota, int num1, double denominador){
        this.nota = nota;
        this.num1 = num1;
        this.denominador = denominador;
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
