
package clases;


public class Torneo {
    
    private String nombre;
    private int set;

   

    public Torneo() {
    }

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Torneo{");
        sb.append("nombre=").append(nombre);
        sb.append(", set=").append(set);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
