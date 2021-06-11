import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private double nota;
    private Pais paisElejido;
    private Pais paisOrigen;
    private Formula calculoNota;

    public Menu() {}

    public void ingresarNota() {
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Ingrese Nota de " + paisOrigen.getNombrePais() + ": ");
            this.nota = teclado.nextDouble();
        }while(nota < paisOrigen.getNotaMinima() || nota > paisOrigen.getNotaMaxima());
    }
    public void seleccionPais() {
        int contador = 0;
        for(Pais pais : Pais.values()) {
            System.out.println((contador + 1) + ". " + pais.getNombrePais());
            contador++;
        }
    }
    public void setPaisOrigen(int opcion) {
        switch (opcion) {
            case 1:
                paisOrigen = Pais.CHILE;
                break;
            case 2:
                paisOrigen = Pais.ARGENTINA;
                break;
            case 3:
                paisOrigen = Pais.PERU;
                break;
            case 4:
                paisOrigen = Pais.BRASIL;
                break;
            case 5:
                paisOrigen = Pais.ECUADOR;
                break;
            case 6:
                paisOrigen = Pais.BOLIVIA;
                break;
        }
    }

    public void setPaisElegido(int opcion) {
        switch (opcion) {
            case 1:
                paisElejido = Pais.CHILE;
                break;
            case 2:
                paisElejido = Pais.ARGENTINA;
                break;
            case 3:
                paisElejido = Pais.PERU;
                break;
            case 4:
                paisElejido = Pais.BRASIL;
                break;
            case 5:
                paisElejido = Pais.ECUADOR;
                break;
            case 6:
                paisElejido = Pais.BOLIVIA;
                break;
        }
    }

    public void mostrarResultado() {
        if(paisOrigen == paisElejido) {
            System.out.println("La nota es la Misma..!!!");
        }else {
            if(paisOrigen != Pais.CHILE) {
                calculoNota = new Formula(nota, paisOrigen);
                calculoNota.crearFormulaPaisOrigenAChilena();
            }else {
                calculoNota = new Formula(nota, paisElejido);
                calculoNota.crearFormula();
            }
        }
        System.out.println(calculoNota.getResultado());
    }

    public double getNota() {
        return nota;
    }

    public Pais getPaisElejido() {
        return paisElejido;
    }
}
