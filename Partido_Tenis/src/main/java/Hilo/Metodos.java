
package Hilo;

import clases.Tenista;
import clases.Torneo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Metodos {
    
            public static List<Tenista> cargarLista(Tenista t1,Tenista t2){
        
            
            //Dejamos acomodado al primer jugador en la primera posicion
            
            List<Tenista> tenistas=new ArrayList<>();
            if (t1.getPosibilidad()>t2.getPosibilidad()) {
                    tenistas.add(t1);
                    tenistas.add(t2);
                    
                }
            
            else{
            
                    tenistas.add(t2);
                    tenistas.add(t1);
            
            }
           
            return tenistas;
            
            
            
            
            
        
        
        }
 
            //Menu de opcion printeo
             public static  void menu(){
    
        System.out.println("----------------------------------------");
        System.out.println("TORNEO DE TENIS");
        System.out.println("OPCION (1) PARA CARGAR JUGADORES  Y TORNEO");
        System.out.println("OPCION (2) PARA SALIR");
        System.out.println("----------------------------------------");
    
    }
             
             //Cargas completas
            
       public static int cargarNumero(String texto){
    
        int retorno=-20;
        
        
        boolean aux=true;
        while(aux){
        
            try {
            Scanner sn=new Scanner(System.in);
            System.out.println(texto);
            retorno=sn.nextInt();
            aux=false;
            
          } catch (Exception e) {
              
                System.out.println("Error en la carga");
              
            }
        
        }
        
        
        return retorno;
    
    }
    
    public static String cargarString(String texto){
    
        Scanner sn=new Scanner(System.in);
        System.out.println(texto);
        return sn.nextLine();
        
    
    }
    
    public static void cargarTenista(Tenista tenis){
        
        String nombre=cargarString("Ingrese nombre de  tenista:");
        int probabilidad=0;
        boolean aux=true;
        while(aux){
            probabilidad=cargarNumero("Ingrese un numero entre 1 y 100 para la probabilidad de victoria del tenista");
            if (probabilidad<100 && probabilidad>1) {
                aux=false;
            }
        }
        
        tenis.setNombre(nombre);
        tenis.setPosibilidad(probabilidad);
    
        
    
    }
    
        public static void cargarTorneo(Torneo t){
        
        String nombre=cargarString("Ingrese nombre del torneo:");
        int set=0;
        boolean aux=true;
        while(aux){
            set=cargarNumero("Ingrese un numero un 3 o un 5:");
            if (set==5 || set==3) {
                aux=false;
            }
        }
        
        t.setNombre(nombre);
        t.setSet(set);
    
        
    
    }
            
        
        public static int jugar_revancha(){
        
        
        System.out.println("-----------------------------");
        System.out.println("Quiere jugar la revancha?");
        System.out.println("Ingrese (1) para SI o (2) para NO");
        System.out.println("-----------------------------");
        int retorno;
        do {            
            retorno=cargarNumero("Ingrese su opcion");
        } while (retorno>3 && retorno<1);
        
        return retorno;
        
    }    
     public static int iniciar_set(int[][] matriz,int posicion,List<Tenista> tenista){
    
        Random random=new Random();
        int a,b;
        boolean aux=true;
        int contA=0;
        int contB=0;
        
        while(aux){
        
            a=random.nextInt(1,20);
            b=random.nextInt(1,20);
            
            if (a>b) {
                
                contA++;
                System.out.println("-------------------");
                System.out.println("!Gana el punto el jugador:"+tenista.get(0).getNombre());
                System.out.println("-------------------");
                
            }else{
            
                contB++;System.out.println("-------------------");
                System.out.println("!Gana el punto el jugador:"+tenista.get(1).getNombre());
                System.out.println("-------------------");
                
            }
            
            if (contA>=contB+2 && contA>=6) {
                
                System.out.println("Gano jugador Uno");
                aux=false;
                
            }else if(contB>=contA+2 && contB>=6){
            
                System.out.println("Gano jugador Dos");
                aux=false;
            }
 
        }
        
        matriz[0][posicion]=contA;
        matriz[1][posicion]=contB;
        
         if (contA>contB) {
             return 0;
             
         }else{
         
             return  1;
         }
        
    
    };
    
     //Finalizacion de las cargas
     
     
     //Partido completo utiliza la muestra de una matris y cada set
     //Se verifica las condiciones para que los  sets esten bien contabilizados 
   
    public static void  jugar(int[][] matriz,List<Tenista> tenistas,Torneo torneo){
        
        int contA=0;
        int contB=0;
        int opcionR;
        
        System.out.println("-----------------------------------------");
        System.out.println("Inicia el:"+torneo.getNombre());
        System.out.println("-----------------------------------------\n");
        
        do{
        
            for (int i = 0; i < torneo.getSet(); i++) {
            
            System.out.println("Set:("+(i+1)+")");
            int ganador=iniciar_set(matriz,i,tenistas);
            
            if (ganador==0) {
                
                contA++;
                
            }else if(ganador==1){
                
                contB++;
            }
            
            if (torneo.getSet()==3) {
                
                if (contA==2) {
                    System.out.println("-------------------");
                    System.out.println("Gano el jugador:"+tenistas.get(0).getNombre()+"\n");
                    System.out.println("-------------------");
                    mostrar_matriz(matriz,tenistas);
                    System.out.println("-------------------");
                    break;
                }
                else if(contB==2){
                    
                    System.out.println("-------------------");
                    System.out.println("Gano el jugador:"+tenistas.get(1).getNombre()+"\n");
                    System.out.println("-------------------");
                    mostrar_matriz(matriz,tenistas);
                    System.out.println("-------------------");
                    break;
                }
                
            }
            else if(torneo.getSet()==5){
            if (contA==3) {
                    System.out.println("-------------------");
                    System.out.println("Gano el jugador:"+tenistas.get(0).getNombre()+"\n");
                    System.out.println("-------------------");
                    mostrar_matriz(matriz,tenistas);
                    System.out.println("-------------------");
                    break;
                }
                else if(contB==3){
                    
                    System.out.println("-------------------");
                    System.out.println("Gano el jugador:"+tenistas.get(1).getNombre()+"\n");
                    System.out.println("-------------------");
                    mostrar_matriz(matriz,tenistas);
                    System.out.println("-------------------");
                    break;
                }}
                
            
            
        }
            
            opcionR=jugar_revancha();
            contA=0;
            contB=0;
            
            
        }while(opcionR==1);
        
        System.out.println("Gracias por jugar el partido");
    }
    

    
         public static void mostrar_matriz(int[][] matriz,List<Tenista> tenistas){
         
         for (int i = 0; i < matriz.length; i++) {
             if (i==0) {
                 
                 System.out.print(tenistas.get(0).getNombre()+" ");
                 
             }else if(i==1){
             
                 System.out.print(tenistas.get(1).getNombre()+"   ");
                 
             }
             for (int j = 0; j < matriz[i].length; j++) {
                 System.out.print(matriz[i][j]+" ");
                 
             }
             System.out.println("\n");
             
         }
     
     }
     

    
    
}
