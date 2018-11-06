/**
 *
 * @author Carlos Contreras
 */
public class Monomio {
    public int coeficiente;
    public String base;
    public int exponente;
    
    public Monomio(int coeficiente, String variable, int exponente) {
        this.coeficiente = coeficiente;
        this.base = variable;
        this.exponente = exponente;
    }
    
    public String toString() {
        return Rutinas.PonBlancos(base, 1) + Rutinas.PonCeros(exponente, 5);
    }
}
