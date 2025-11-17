package examenprog2;
public class Main {
    public static void main(String[] args) {
        MiTeleferico teleferico = new MiTeleferico("La Paz", 1000000.0f);
        Linea lAmarilla = teleferico.getLinea("Amarillo");
        Linea lRoja = teleferico.getLinea("Rojo");
        Linea lVerde = teleferico.getLinea("Verde");
        Cabina cA1 = new Cabina(1);
        cA1.agregarPersona(new Persona("Ana", 70.0f, 20));
        cA1.agregarPersona(new Persona("Bernardo", 80.0f, 30));
        cA1.agregarPersona(new Persona("Carlos", 100.0f, 25));
        lAmarilla.agregarCabina(cA1);
        Cabina cR1 = new Cabina(10);
        cR1.agregarPersona(new Persona("Diana", 75.0f, 40));
        cR1.agregarPersona(new Persona("Elena", 65.0f, 35));
        cR1.agregarPersona(new Persona("Felipe", 85.0f, 32));
        lRoja.agregarCabina(cR1);
        Cabina cV1 = new Cabina(20);
        cV1.agregarPersona(new Persona("Gaby", 60.0f, 22));
        cV1.agregarPersona(new Persona("Hugo", 60.0f, 21));
        cV1.agregarPersona(new Persona("Irene", 60.0f, 23));
        cV1.agregarPersona(new Persona("Juan", 80.0f, 50));
        cV1.agregarPersona(new Persona("Katy", 60.0f, 18));
        lVerde.agregarCabina(cV1);
        System.out.println("--- PRUEBA INCISO a ---");
        System.out.println("Personas en Cabina A1: " + cA1.getCantidadPersonas());
        System.out.println("--- PRUEBA INCISO b ---");
        boolean cumplen = lAmarilla.verificarTodasCabinasCumplenReglas();
        System.out.println("Todas las cabinas de la Linea Amarilla cumplen reglas: " + cumplen);
        System.out.println("--- PRUEBA INCISO c ---");
        float ingresoTotalAmarilla = lAmarilla.calcularIngresoTotal();
        System.out.println("Ingreso total de Linea Amarilla: " + ingresoTotalAmarilla + " Bs");
        System.out.println("--- PRUEBA INCISO d ---");      
        Linea lineaMayorIngresoRegular = null;
        float maxIngresoRegular = -1.0f;
        for (Linea l : teleferico.getLineas()) {
            float ingresoRegularActual = l.calcularIngresoSoloRegular();            
            if (ingresoRegularActual > maxIngresoRegular) {
                maxIngresoRegular = ingresoRegularActual;
                lineaMayorIngresoRegular = l;
            }
        }        
        if (lineaMayorIngresoRegular != null) {
            System.out.println("La Linea con el mayor ingreso solo por Tarifa Regular es: Linea " + lineaMayorIngresoRegular.getColor() + " con " + maxIngresoRegular + " Bs.");
        }
    }
}s
