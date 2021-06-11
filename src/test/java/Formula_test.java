import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Formula_test {

    @Test
    public void objeto_formula_test() {
        double nota = 3.5;
        Pais paisElejido = Pais.ARGENTINA;
        int control = 6;
        Formula formulaArgentina = new Formula(nota, paisElejido);
        int obtenido = formulaArgentina.getNum();

        Assertions.assertEquals(control, obtenido);
    }

    @Test
    public void obtener_notaChilena() {
        double notaArgentina = 10;
        Pais paisOrigen = Pais.ARGENTINA;
        Formula formulaChilena = new Formula(notaArgentina, paisOrigen);
        formulaChilena.crearFormulaPaisOrigenAChilena();

        double control = 7.0;
        double obtenido = formulaChilena.getResultado();

        Assertions.assertEquals(control, obtenido);
    }

}
