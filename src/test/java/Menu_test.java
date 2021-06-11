import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Menu_test {
    private Menu menu = new Menu();

    //test que verifica que la opcion que seleccione el usuario corresponda
    @Test
    public void verificar_pais_elegido_test(){
        int opcion = 2;
        menu.setPaisElegido(opcion);
        Assertions.assertSame(Pais.ARGENTINA, menu.getPaisElegido());
    }

    //test que verifica que la nota ingresada este entre el rango de un pais
    @Test
    public void ingresar_nota_test() {
        Pais paisElegido = Pais.CHILE;
        // nota ingresada por teclado
        double notaChilena = 7.0;
        Assertions.assertTrue(notaChilena >= paisElegido.getNotaMinima() && notaChilena <= paisElegido.getNotaMaxima());
    }

    @Test
    public void ingresar_nota_test2() {
        Pais paisElegido = Pais.ARGENTINA;
        double notaArgentina = 10;
        Assertions.assertTrue(notaArgentina >= paisElegido.getNotaMinima() && notaArgentina <= paisElegido.getNotaMaxima());
    }

}
