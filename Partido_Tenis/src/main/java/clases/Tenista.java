
package clases;


public class Tenista {
    
    private  String nombre;
    private int posibilidad;

    public Tenista(String nombre, int posibilidad) {
        this.nombre = nombre;
        this.posibilidad = posibilidad;
    }

    public Tenista() {
    }

    
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosibilidad() {
        return posibilidad;
    }

    public void setPosibilidad(int posibilidad) {
        this.posibilidad = posibilidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tenista{");
        sb.append("nombre=").append(nombre);
        sb.append(", posibilidad=").append(posibilidad);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
    
    
}
