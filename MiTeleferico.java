package examenprog2;
import java.util.ArrayList;
import java.util.List;
class MiTeleferico {
    private String direccion;
    private float caudalFinanciero;
    private List<Linea> lineas;
    public MiTeleferico(String direccion, float caudalFinanciero) {
        this.direccion = direccion;
        this.caudalFinanciero = caudalFinanciero;
        this.lineas = new ArrayList<>();
        this.lineas.add(new Linea("Amarillo"));
        this.lineas.add(new Linea("Rojo"));
        this.lineas.add(new Linea("Verde"));
    }
    public Linea getLinea(String color) {
        for (Linea l : lineas) {
            if (l.getColor().equalsIgnoreCase(color)) {
                return l;
            }
        }
        return null;
    }
    public List<Linea> getLineas() {
        return lineas;
    }
}