import com.conversor.dev.Formula;
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
public class Formula_test {
    public static Logger log = Logger.getLogger(Formula_test.class);
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
    public static void afterAll() {
        log.info("TEST Terminados");
    }

    @BeforeEach
    public void nuevoTest() { log.info("Nuevo Test"); }

    //test para obtener el primer parametro del enum de un com.conversor.dev.Pais
    @Test
    public void objeto_formula_test() throws Exception{
        double nota = 3.5;
        Pais paisElejido = Pais.ARGENTINA;
        int control = 6;
        Formula formulaArgentina = new Formula(nota, paisElejido);
        int obtenido = formulaArgentina.getNum();

        Assertions.assertEquals(control, obtenido);
    }

    //test que convierte nota de cualquier pais a nota CHILENA
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

    //test para covertir nota chilena a cualquier pais
    @Test
    public void convertir_notaChilena_otro_pais() {
        double notaChilena = 7.0, control, obtenido;
        Pais paisElegido = Pais.BRASIL;
        Formula formula = new Formula(notaChilena, paisElegido);
        formula.crearFormula();

        control = 10;
        obtenido = formula.getResultado();

        Assertions.assertEquals(control, obtenido);
    }

    @Test
    public void convertir_notaChilena_otro_pais2() {
        double notaChilena = 7.0, control, obtenido;
        Pais paisElegido = Pais.PERU;
        Formula formula = new Formula(notaChilena, paisElegido);
        formula.crearFormula();

        control = 20;
        obtenido = formula.getResultado();

        Assertions.assertEquals(control, obtenido);
    }

    //test para convertir nota a cualquier pais, en este caso nota PERUANA A BOLIVIANA
    @Test
    public void convertir_nota_cualquierPais() {
        double notaPeruana = 20, control, obtenido;
        Pais paisOrigen = Pais.PERU;
        Pais paisElegido = Pais.BOLIVIA;

        Formula formula = new Formula(notaPeruana, paisOrigen, paisElegido);
        formula.crearFormulaCompleta();

        control = 100; //nota boliviana
        obtenido = formula.getResultado();

        Assertions.assertEquals(control, obtenido);

    }

    @Test
    public void convertir_nota_cualquierPais2() {
        double notaPeruana = 10, control, obtenido;
        Pais paisOrigen = Pais.ARGENTINA;
        Pais paisElegido = Pais.BRASIL;

        Formula formula = new Formula(notaPeruana, paisOrigen, paisElegido);
        formula.crearFormulaCompleta();

        control = 10; //nota boliviana
        obtenido = formula.getResultado();

        Assertions.assertEquals(control, obtenido);

    }

}
