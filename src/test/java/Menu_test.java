import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Menu_test {
    @Test
    public void verificar_pais_elegido(){
        Menu menu = new Menu();
        int opcion = 2;
        menu.setPaisElegido(opcion);

        Assertions.assertSame(Pais.ARGENTINA, menu.getPaisElejido());
    }
}
