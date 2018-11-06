
import java.util.Scanner;

/**
 *
 * @author Carlos Contreras
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Lista<Monomio> primerPolinomio = new Lista();
        Lista<Monomio> segundoPolinomio = new Lista();

        System.out.println("Capurando el primer polinomnio\r");
        capturarPolinomio(primerPolinomio);
        System.out.println("Capurando el segundo polinomnio\r");
        capturarPolinomio(segundoPolinomio);

        System.out.print("Primer polinomio: ");
        imprimirPolinomio(primerPolinomio);
        System.out.print("Segundo polinomio: ");
        imprimirPolinomio(segundoPolinomio);
        System.out.print("Suma: ");
        Lista<Monomio> sumaPolinomio = sumarPolinomios(primerPolinomio, segundoPolinomio);
        imprimirPolinomio(sumaPolinomio);

    }

    public static void capturarPolinomio(Lista<Monomio> polinomio) {
        while (true) {
            System.out.println("Capture el coeficiente: (Teclee 0 si desea terminar)\r");
            int coeficiente = scanner.nextInt();
            if (coeficiente == 0) {
                return;
            }
            System.out.println("Capture la variable: \r");
            String variable = scanner.next().toUpperCase();
            System.out.println("Capture el exponente: \r");
            int exponente = scanner.nextInt();

            sumarEquivalente(polinomio, new Monomio(coeficiente, variable, exponente));
        }
    }

    public static void imprimirPolinomio(Lista<Monomio> polinomio) {
        Nodo<Monomio> aux = polinomio.getFrente();
        while (aux != null) {
            System.out.print(aux.Info.coeficiente + aux.Info.base + aux.Info.exponente + " ");
            aux = aux.getSig();
        }
        System.out.println("");
    }

    public static Lista<Monomio> sumarPolinomios(Lista<Monomio> primerPolinomio, Lista<Monomio> segundoPolinomio) {
        Lista<Monomio> sumaPolinomio = new Lista();

        // Rellenar la lista de la suma con datos del primer polinomio
        Nodo<Monomio> aux = primerPolinomio.getFrente();
        while (aux != null) {
            sumaPolinomio.InsertaFin(aux.Info);
            aux = aux.getSig();
        }
        
        // Sumar la lista de suma con el segundo polinomio
        aux = segundoPolinomio.getFrente();
        while (aux != null) {
            sumarEquivalente(sumaPolinomio, aux.Info);
            aux = aux.getSig();
        }
        return sumaPolinomio;
    }
    
    public static void sumarEquivalente(Lista<Monomio> polinomio, Monomio monomio) {
        String idNuevo = monomio.toString();
        Nodo<Monomio> aux = polinomio.getFrente();
        
        while (aux != null) {
            if (aux.Info.toString().compareTo(idNuevo) == 0) {
                aux.Info.coeficiente += monomio.coeficiente;
                return;
            }
            aux = aux.getSig();
        }
        polinomio.InsertaOrdenado(monomio);
    }
}
