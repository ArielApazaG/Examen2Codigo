package examenprog2;
public class Main {
    public static void main(String[] args) {      
        MiTeleferico teleferico = new MiTeleferico("La Paz", 1000000.0f);
        Linea lAmarilla = teleferico.getLinea("Amarillo");
        Linea lRoja = teleferico.getLinea("Rojo");
        Linea lVerde = teleferico.getLinea("Verde");
        Cabina cA1 = new Cabina(1); // 2 Preferencial (1.5) + 1 Regular (3.0) -> 6.0
        cA1.agregarPersona(new Persona("Ana", "123", 70.0f, 20)); // P
        cA1.agregarPersona(new Persona("Bernardo", "456", 80.0f, 30)); // R
        cA1.agregarPersona(new Persona("Carlos", "789", 100.0f, 25)); // P
        lAmarilla.agregarCabina(cA1);
        
        Cabina cR1 = new Cabina(10); // 3 Regular (3.0) -> 9.0
        cR1.agregarPersona(new Persona("Diana", "111", 75.0f, 40)); // R
        cR1.agregarPersona(new Persona("Elena", "222", 65.0f, 35)); // R
        cR1.agregarPersona(new Persona("Felipe", "333", 85.0f, 32)); // R
        lRoja.agregarCabina(cR1);

        Cabina cV1 = new Cabina(20); // 1 Regular (3.0) + 4 Preferencial (1.5) -> 3.0 + 6.0 = 9.0
        cV1.agregarPersona(new Persona("Gaby", "444", 60.0f, 22)); // P
        cV1.agregarPersona(new Persona("Hugo", "555", 60.0f, 21)); // P
        cV1.agregarPersona(new Persona("Irene", "666", 60.0f, 23)); // P
        cV1.agregarPersona(new Persona("Juan", "777", 80.0f, 50)); // R
        cV1.agregarPersona(new Persona("Katy", "888", 60.0f, 18)); // P
        lVerde.agregarCabina(cV1);

        System.out.println("----------------------------------------------------");
        System.out.println("--- Prueba de Ingresos Regulares (Inciso d) ---");
        
        // --- Lógica del Inciso d: Mostrar la Línea con más ingreso solo con tarifa regular ---
        
        Linea lineaMayorIngresoRegular = null;
        float maxIngresoRegular = -1.0f;

        // Iteramos sobre las líneas del teleférico (Amarillo, Rojo, Verde)
        for (Linea l : teleferico.getLineas()) {
            float ingresoRegularActual = l.calcularIngresoSoloRegular();
            
            System.out.println("Ingreso Regular de Línea " + l.getColor() + ": " + ingresoRegularActual + " Bs");

            if (ingresoRegularActual > maxIngresoRegular) {
                maxIngresoRegular = ingresoRegularActual;
                lineaMayorIngresoRegular = l;
            }
        }
        
        System.out.println("\n----------------------------------------------------");
        if (lineaMayorIngresoRegular != null) {
            System.out.println("🏆 La Línea con el mayor ingreso solo por Tarifa Regular (Bs 3.0) es:");
            System.out.println("   -> Línea **" + lineaMayorIngresoRegular.getColor() + "** con **" + maxIngresoRegular + " Bs**.");
        } else {
            System.out.println("No se encontraron líneas con ingresos.");
        }
        
        // Datos de prueba: 
        // Amarillo (cA1): 1 R * 3.0 = 3.0 Bs
        // Rojo (cR1): 3 R * 3.0 = 9.0 Bs
        // Verde (cV1): 1 R * 3.0 = 3.0 Bs
        // Resultado esperado: Línea Roja con 9.0 Bs.
    }
}