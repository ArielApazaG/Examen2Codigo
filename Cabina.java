package examenprog2;
import java.util.ArrayList;
import java.util.List;
class Cabina {
    private int nroCabina;
    private List<Persona> personas; 
    public static final float PESO_MAXIMO = 650.0f; 
    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personas = new ArrayList<>();
    }
    public boolean agregarPersona(Persona p) {
        if (personas.size() >= 10) {
            return false;
        }
        float pesoActual = calcularPesoTotal();
        if (pesoActual + p.getPesoPersonal() > PESO_MAXIMO) {
            return false;
        }
        personas.add(p);
        return true;
    }
    public float calcularPesoTotal() {
        float pesoTotal = 0;
        for (Persona p : personas) {
            pesoTotal += p.getPesoPersonal();
        }
        return pesoTotal;
    }
    public boolean cumpleRegla() {
        return personas.size() <= 10 && calcularPesoTotal() <= PESO_MAXIMO;
    }
    public int contarPersonasMenoresOIguales25() {
        int contador = 0;
        for (Persona p : personas) {
            if (p.getEdad() <= 25) {
                contador++;
            }
        }
        return contador;
    }
    public int contarPersonasMayores25() {
        int contador = 0;
        for (Persona p : personas) {
            if (p.getEdad() > 25) {
                contador++;
            }
        }
        return contador;
    }
    public int getCantidadPersonas() {
        return personas.size();
    }
}