import com.conversor.dev.Menu;
import com.conversor.dev.Pais;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@ExtendWith(MyTestWatcher.class)
public class Menu_test {
    private Menu menu = new Menu();
    public static Logger log = Logger.getLogger(Menu_test.class);
    final static String direccion = "C:\\Users\\Nicolas\\IdeaProjects\\ConversorDeNotas\\logs";

    @BeforeAll
    public static void init() throws IOException {
        AtomicInteger count = new AtomicInteger();
        try (Stream<Path> paths = Files.walk(Paths.get(direccion))){
            Files.walk(Paths.get(direccion)).forEach(ruta -> {
                if(Files.isRegularFile(ruta)) {
                    if(count.get() == 0) {
                        File file = new File(ruta.toString());
                        if(file.delete()) {
                            System.out.println("Log Eliminado");
                        }else{
                            System.out.println("Log no eliminado");
                        }
                        count.getAndIncrement();
                    }
                }
            });
        }

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
