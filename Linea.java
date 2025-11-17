package examenprog2;
import java.util.ArrayList;
import java.util.List;
class Linea {
    private String color;
    private List<Cabina> cabinas; 
    public static final float TARIFA_PREFERENCIAL = 1.5f; 
    public static final float TARIFA_REGULAR = 3.0f;     
    public Linea(String color) {
        this.color = color;
        this.cabinas = new ArrayList<>();
    }
    public void agregarCabina(Cabina c) {
        cabinas.add(c);
    }
    public boolean verificarTodasCabinasCumplenReglas() {
        for (Cabina c : cabinas) {
            if (!c.cumpleRegla()) {
                return false; 
            }
        }
        return true; 
    }
    public float calcularIngresoTotal() {
        float ingresoTotal = 0.0f;  
        for (Cabina c : cabinas) {
            int menoresIguales25 = c.contarPersonasMenoresOIguales25();
            int mayores25 = c.contarPersonasMayores25();
            
            ingresoTotal += (menoresIguales25 * TARIFA_PREFERENCIAL);
            ingresoTotal += (mayores25 * TARIFA_REGULAR);
        }
        return ingresoTotal;
    }
    public float calcularIngresoSoloRegular() {
        float ingresoRegular = 0.0f;
        for (Cabina c : cabinas) {
            int mayores25 = c.contarPersonasMayores25();
            ingresoRegular += (mayores25 * TARIFA_REGULAR);
        }
        return ingresoRegular;
    }
    public String getColor() {
        return color;
    }
}