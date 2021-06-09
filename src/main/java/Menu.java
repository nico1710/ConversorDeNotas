import java.util.Scanner;

public class Menu {
    private double nota;
    private Pais paisElejido;
    private Formula calculoNota;

    public Menu() {}

    public void ingresarNota() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("-- CONVERSOR DE NOTAS 1.1 --");
        System.out.println("Ingrese Nota: ");
        this.nota = teclado.nextDouble();
    }
    public void seleccionPais() {
        int contador = 0;
        for(Pais pais : Pais.values()) {
            System.out.println((contador + 1) + ". " + pais.getNombrePais());
            contador++;
        }
    }

    public void setPaisElejido(int opcion) {
        switch (opcion) {
            case 1:
                paisElejido = Pais.ARGENTINA;
                break;
            case 2:
                paisElejido = Pais.PERU;
                break;
            case 3:
                paisElejido = Pais.BRASIL;
                break;
            case 4:
                paisElejido = Pais.ECUADOR;
                break;
        }
    }

    public void mostrarResultado() {
        calculoNota = new Formula(nota, paisElejido);
        calculoNota.crearFormula();
        System.out.println(calculoNota.getResultado());
    }

    public double getNota() {
        return nota;
    }
}
