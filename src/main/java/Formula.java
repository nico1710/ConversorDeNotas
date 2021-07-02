import org.apache.log4j.Logger;

public class Formula {
    public static Logger log = Logger.getLogger(Formula.class);
    private double nota;
    private int num1;
    private double denominador;
    private int numPaisDestino;
    private int denominadorPaisDestino;
    private double resultado;
    private Pais pais;

    public Formula(double nota, Pais pais){
        this.nota = nota;
        this.num1 = pais.getNumeroFormula();
        this.denominador = pais.getDividendo();
    }

    public Formula(double nota, Pais paisOrigen, Pais paisDestino) {
        this.nota = nota;
        this.num1 = paisOrigen.getNumeroFormula();
        this.denominador = paisOrigen.getDividendo();
        this.numPaisDestino = paisDestino.getNumeroFormula();
        this.denominadorPaisDestino = paisDestino.getDividendo();
    }

    //obtener la nota que se ingresa por consola
    public double getNota() {
        return nota;
    }

    public int getNum() { return num1; }

    //se crea la formula de nota CHilena a otro Pais
    public void crearFormula() {
        log.info("Formula Creada");
        log.info("(" + denominador + " * (" + nota + " - 4) / 3)" + " + " + num1);
        resultado = ((denominador * (nota - 4)) / 3) + num1 ;
    }

    //se crea la formula de nota Pais origen a Chilena
    public void crearFormulaPaisOrigenAChilena() {
        log.info("Formula Creada");
        log.info("(((" + nota + " - " + num1 + ") * 3) / " + denominador + ") + 4)");
        resultado = (((nota - num1) * 3) / denominador) + 4;
    }

    //se crear la formula a partir del PaisOrigen a nota Chilena y la nota chilena la usamos para el pais de Destin
    public void crearFormulaCompleta() {
        log.info("Formula Creada");
        double notaChilena = (((nota - num1) * 3) / denominador) + 4;
        log.info("((" + denominadorPaisDestino + " * (" + nota + " - 4) / 3)" + " + " + num1);
        resultado =  ((denominadorPaisDestino * (notaChilena - 4)) / 3) + numPaisDestino ;
    }

    public double getResultado() {
        return resultado;
    }


}
