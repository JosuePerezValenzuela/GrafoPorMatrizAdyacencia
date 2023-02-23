import java.util.ArrayList;
import java.util.Arrays;

public class Matriz_Adyacencia extends Grafo{
    private double [][] grafo;
    public Matriz_Adyacencia(double [][] grafo){
        this.grafo = grafo;
    }
    
    public Matriz_Adyacencia(int cantDeVertices){
      grafo = new double [cantDeVertices][cantDeVertices];
    }

    public int getNumVertices(){
      return this.grafo.length;
    }
    public int getNumAristas(){
      int cantDeVertices = 0;
      for(int i = 0; i < grafo.length; i++){
         for(int j = 0; j < grafo.length; j++){
            if(grafo[i][j] != 0.0){
              cantDeVertices++;
            }
            }
        }
      return cantDeVertices/2;
    }    
    public boolean existeArista(int origen, int destino){
      return this.grafo[origen][destino] != 0.0;
    }
    public double getPesoArista(int i, int j){
      return this.grafo[i][j];
    }
    public void insertarArista(int i, int j){
      this.grafo [i][j] = 1.0;
      this.grafo[j][i] = 1.0;
    }
    public void insertarArista(int i, int j, double peso){
      this.grafo [i][j] = peso;
      this.grafo[j][i] = peso;    
    }
    public ArrayList<Integer> getAdyacentes(int vertice){
      ArrayList <Integer> adyacentes = new ArrayList <>();
      for(int i = 0; i < this.grafo.length; i++){
        if (this.grafo [vertice][i] != 0.0){
           adyacentes.add(i);
        }
        }
      return adyacentes;
    }
    public void dibujarGrafo(){
      for(double graf[]: this.grafo){
        System.out.println(Arrays.toString(graf));
        }  
    }
    public boolean quitarArista(int origen, int destino){
        if(this.grafo [origen][destino] != 0){
          this.grafo [origen][destino] = 0;
          this.grafo [destino][origen] = 0;
          return true;
        }
        return false;
    }
    public boolean esCompleto(){
      for(int i = 0; i < grafo.length; i++){
        for(int j = 0; j < grafo.length; j++){
          if(grafo[i][j] == 0.0 && i != j){
            return false;
            }
        }
        }
      return true;
    }
    public boolean esGrafoCiclo(){
      if(getNumVertices() != getNumAristas()){
         return false;
        }else{
         // todos deben tener solo 2 uno
         return true;
        } 
    }
    
    //debe haber un vertice que se conecte a todos los demas
    public boolean esGrafoRueda(){
      boolean resp = true;
      boolean aux = true;
      for(int i = 0; i < grafo.length; i++){
        for(int j = 0; j < grafo.length; j++){
          if(grafo [i][j] == 0){
            aux = false;
            }  
        }
        if (aux == true){
          return true;
        }
        aux = true;
        }
      return resp;
    }
    public boolean existeBucle(){
      for(int i = 0; i < this.grafo.length; i++){
        if(grafo[i][i] != 0){
          return true;
        } 
        }
      return false;
    }
    public double [][] getGrafo(){
      return this.grafo;
    }
}
