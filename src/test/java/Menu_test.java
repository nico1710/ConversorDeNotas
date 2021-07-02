import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyTestWatcher.class)
public class Menu_test {
    private Menu menu = new Menu();
    public static Logger log = Logger.getLogger(Menu_test.class);

    @BeforeAll
    public static void init() {
        log.info("TEST Iniciados");
    }

    @AfterAll
    public static void afterAll() { log.info("TEST Terminados"); }

    @BeforeEach
    public void nuevoTest() { log.info("Nuevo Test"); }

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
