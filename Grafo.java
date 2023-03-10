import java.util.ArrayList;

public abstract class Grafo 
{       
    public abstract int getNumVertices();
    public abstract int getNumAristas();    
    public abstract boolean existeArista(int origen, int destino);
    public abstract double getPesoArista(int i, int j);
    public abstract void insertarArista(int i, int j);
    public abstract void insertarArista(int i, int j, double peso);
    public abstract ArrayList<Integer> getAdyacentes(int vertice);/// valor de retorno puede ser diferente
    public abstract void dibujarGrafo();
    public abstract boolean quitarArista(int origen, int destino);
    public abstract boolean esCompleto();
    public abstract boolean esGrafoCiclo();
    public abstract boolean esGrafoRueda();
    public abstract boolean existeBucle();
}