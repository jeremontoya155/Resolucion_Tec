
package Hilo;

import clases.Tenista;
import clases.Torneo;
import java.util.List;
import static Hilo.Metodos.menu;
import static Hilo.Metodos.cargarNumero;
import static Hilo.Metodos.cargarTenista;
import static Hilo.Metodos.cargarTorneo;
import static Hilo.Metodos.cargarLista;
import static Hilo.Metodos.jugar;

public class Acciones extends Thread{

    private Tenista t1,t2;
    private Torneo t;

    
    
    
    @Override
    public void run() {
        
        this.t1=new Tenista();
        this.t2=new Tenista();
        this.t=new Torneo();
        boolean aux=true;
        List<Tenista> jugadores_torneo;
        int opcion;
        int[][] matriz;
        
        
        while(aux){
            menu();
            opcion=cargarNumero("Ingrese su opcion:");
            
        switch (opcion) {
            
            case 1 -> {
                System.out.println("Ingrese la carga de los jugadores");
                System.out.println("Ingrese los datos del jugador uno");
                cargarTenista(this.t1);
                System.out.println("Ingrese los datos del jugador dos");
                cargarTenista(this.t2);
                cargarTorneo(this.t);
                jugadores_torneo=cargarLista(this.t1,this.t2);
                matriz=new int[2][t.getSet()];
                jugar(matriz,jugadores_torneo,this.t);
                
                
            }
            case 2 ->{ System.out.println("------------------------------");
            System.out.println("GRACIAS POR  USAR EL PROGRAMA");
            System.out.println("------------------------------");
                aux=false;
            }
            default -> System.out.println("Ingreso una opcion incorrecta");
        }}
        
        
        
    }
    
    
   
      
}
