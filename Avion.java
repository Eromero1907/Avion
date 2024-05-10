import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Avion
{
    String [][] sillas;
    int numFilas;
    
    public void leerEstructura(String nombreArchivo){
        try{
            Scanner sc = new Scanner(new File(nombreArchivo));
    
            this.numFilas = sc.nextInt();
    
            int numClases = sc.nextInt();
            sillas = new String[numFilas][];
            int fila = 0;
            for(int clase = 0; clase < numClases; clase++){
                int numFilasClase = sc.nextInt();
                int numSillasClase = sc.nextInt();
                for(int i = 0; i < numFilasClase; i++){
                    String [] filaDeSillas = new String[numSillasClase];
                    sillas[fila] = filaDeSillas;
                    fila++;
                }
            }
            System.out.println("Estructura creada, filas: "+fila);
        } catch (FileNotFoundException e){
            System.out.println("Archivo no existe: "+nombreArchivo);
        }
        
    }
    public boolean agregarPasajero(int fila, int columna, String nombre){
        if(fila < 0 || fila >=numFilas){
            System.out.println("Fila inválida");
            return false;
        }
        if(columna < 0 || columna >= sillas[fila].length){
            System.out.println("Columna inválida");
            return false;
        }
        if(sillas[fila][columna] == null){
            sillas[fila][columna] = nombre;
            System.out.println("El pasajero "+nombre+" fue asignado.");
            return true;
        }
        else{
            String nombre1 = sillas[fila][columna];
            System.out.println("La silla está ocupada por "+nombre1);
            return false;
        }
    }
    
    public static void main(String[] args){
        Avion avion = new Avion();
        avion.leerEstructura("Avion.txt");
        avion.agregarPasajero(0, 0, "Maria");
    }
}
