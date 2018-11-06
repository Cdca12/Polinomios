/**
 *
 * @author Carlos Contreras
 */
public class Rutinas {

    static public String PonBlancos(String texto, int tamaño) {
        while (texto.length() < tamaño) 
            texto += " ";
        return texto;
    }

    static public String PonCeros(int numero, int tamaño) {
        String texto = numero + "";

        while (texto.length() < tamaño)
            texto = "0" + texto;
        return texto;
    }
}
