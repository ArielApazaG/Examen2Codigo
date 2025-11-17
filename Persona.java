package examenprog2;
class Persona {
    private String nombre;
    private float pesoPersonal;
    private int edad;
    public Persona(String nombre, float pesoPersonal, int edad) {
        this.nombre = nombre;
        this.pesoPersonal = pesoPersonal;
        this.edad = edad;
    }
    public float getPesoPersonal() {
        return pesoPersonal;
    }
    public int getEdad() {
        return edad;
    }
}