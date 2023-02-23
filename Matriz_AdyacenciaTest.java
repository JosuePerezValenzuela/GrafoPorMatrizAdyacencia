
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class Matriz_AdyacenciaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Matriz_AdyacenciaTest
{
    private Matriz_Adyacencia grafo;
    private Matriz_Adyacencia grafo2;
    private Matriz_Adyacencia grafo3;
    /**
     * Default constructor for test class Matriz_AdyacenciaTest
     */
    public Matriz_AdyacenciaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        /* creamos un grafo
        (0)--(1)--(2)
         |   / \   |
         |  /   \  |
         | /     \ |
        (3)-------(4)    */
        double grafo1[][] = {{0.0, 1.0, 0.0, 1.0, 0.0},
                             {1.0, 0.0, 1.0, 1.0, 1.0},
                             {0.0, 1.0, 0.0, 0.0, 1.0},
                             {1.0, 1.0, 0.0, 0.0, 1.0},
                             {0.0, 1.0, 1.0, 1.0, 0.0}};
        this.grafo = new Matriz_Adyacencia(grafo1);
        /* creamos otro grafo
           (0)-------(1)
             \        |
              5 \     | 2
                    \ |
           (3)-------(2)
                 4    |
                      |
                     (4)
         */
        double grafo2[][] = {{0.0, 1.0, 5.0, 0.0, 0.0},
                             {1.0, 0.0, 2.0, 0.0, 0.0},
                             {5.0, 2.0, 0.0, 4.0, 1.0},
                             {0.0, 0.0, 4.0, 0.0, 0.0},
                             {0.0, 0.0, 1.0, 0.0, 0.0}};
        this.grafo2 = new Matriz_Adyacencia(grafo2);
        double grafo3[][] = {{0.0 ,1.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0},
                             {1.0 ,0.0 ,1.0 ,0.0 ,1.0 ,0.0 ,0.0 ,1.0 ,0.0 ,0.0 ,0.0},
                             {1.0 ,1.0 ,0.0 ,1.0 ,0.0 ,0.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0},
                             {0.0 ,0.0 ,1.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0},
                             {0.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,0.0 ,1.0 ,1.0 ,0.0},
                             {0.0 ,0.0 ,0.0 ,1.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,1.0},
                             {0.0 ,0.0 ,1.0 ,1.0 ,1.0 ,0.0 ,0.0 ,1.0 ,0.0 ,0.0 ,0.0},
                             {0.0 ,1.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,0.0 ,1.0 ,1.0},
                             {0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,0.0 ,0.0 ,1.0 ,0.0},
                             {0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,1.0},
                             {1.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0, 0.0 ,1.0 ,0.0 ,1.0, 0.0}};
        this.grafo3 = new Matriz_Adyacencia(grafo3);
    }

    @Test
    public void numVertices(){
        assertEquals(5,grafo.getNumVertices());
        assertEquals(5,grafo2.getNumVertices());
        assertEquals(11,grafo3.getNumVertices());
    }

    @Test
    public void numAristas(){
        assertEquals(7,grafo.getNumAristas());
        assertEquals(5,grafo2.getNumAristas());
        assertEquals(21,grafo3.getNumAristas());
    }

    @Test
    public void existeAristaEntre(){
        //primer grafo
        assertEquals(true,grafo.existeArista(0, 1));
        assertEquals(true,grafo.existeArista(1, 0));
        assertEquals(false,grafo.existeArista(4, 0));
        assertEquals(true,grafo.existeArista(4, 1));
        assertEquals(true,grafo.existeArista(4, 3));
        assertEquals(true,grafo.existeArista(4, 2));
        //segundo grafo
        assertEquals(false,grafo2.existeArista(0, 3));
        assertEquals(true,grafo2.existeArista(0, 1));
        assertEquals(true,grafo2.existeArista(0, 2));
        assertEquals(false,grafo2.existeArista(0, 4));
        //tercer grafo
        assertEquals(true,grafo3.existeArista(0, 1));
        assertEquals(true,grafo3.existeArista(0, 2));
        assertEquals(false,grafo3.existeArista(0, 3));
        assertEquals(false,grafo3.existeArista(0, 4));
        assertEquals(false,grafo3.existeArista(0, 5));
        assertEquals(false,grafo3.existeArista(0, 6));
        assertEquals(false,grafo3.existeArista(0, 7));
        assertEquals(false,grafo3.existeArista(0, 8));
        assertEquals(false,grafo3.existeArista(0, 9));
        assertEquals(true,grafo3.existeArista(0, 10));
    }

    @Test 
    public void PesoDeAristas(){
        assertEquals(5.0,grafo2.getPesoArista(0, 2)); 
        assertEquals(2.0,grafo2.getPesoArista(1, 2));
        assertEquals(4.0,grafo2.getPesoArista(3, 2));
        assertEquals(1.0,grafo2.getPesoArista(0, 1));
        assertEquals(0.0,grafo2.getPesoArista(0, 3));
    }
    
    @Test
    public void insertarAristasSinPeso(){
        //replicaremos el grafo
        /*
         * (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4) 
         */
        Matriz_Adyacencia grafoAConstruir = new Matriz_Adyacencia(5);
        grafoAConstruir.insertarArista(0,1);
        grafoAConstruir.insertarArista(0,3);
        grafoAConstruir.insertarArista(1,2);
        grafoAConstruir.insertarArista(1,4);
        grafoAConstruir.insertarArista(1,3);
        grafoAConstruir.insertarArista(2,4);
        grafoAConstruir.insertarArista(3,4);
        assertArrayEquals(grafo.getGrafo(),grafoAConstruir.getGrafo());
    }
    
    @Test
    public void insertarAristasConPeso(){
        /* recrearemos el grafo 2
           (0)-------(1)
             \        |
              5 \     | 2
                    \ |
           (3)-------(2)
                 4    |
                      |
                     (4)
         */ 
        Matriz_Adyacencia grafoAConstruirConPeso = new Matriz_Adyacencia(5);
        grafoAConstruirConPeso.insertarArista(0, 1, 1.0);
        grafoAConstruirConPeso.insertarArista(0, 2, 5.0);
        grafoAConstruirConPeso.insertarArista(1, 2, 2.0);
        grafoAConstruirConPeso.insertarArista(2, 3, 4.0);
        grafoAConstruirConPeso.insertarArista(2, 4, 1.0);
        assertArrayEquals(grafo2.getGrafo(), grafoAConstruirConPeso.getGrafo());
    }
    
    @Test
    public void conseguirAdyacentes(){
       //para el primer grafo los adyacentes del vertice 0 son
       ArrayList <Integer> respEsperadaV0 = new ArrayList <>();
       respEsperadaV0.add(1);
       respEsperadaV0.add(3);
       assertEquals(respEsperadaV0, grafo.getAdyacentes(0));
       //adyacentes del vertice 1
       ArrayList <Integer> respEsperadaV1 = new ArrayList <>();
       respEsperadaV1.add(0);
       respEsperadaV1.add(2);
       respEsperadaV1.add(3);
       respEsperadaV1.add(4);
       assertEquals(respEsperadaV1, grafo.getAdyacentes(1));
       //adyacentes del vertice 2
       ArrayList <Integer> respEsperadaV2 = new ArrayList <>();
       respEsperadaV2.add(1);
       respEsperadaV2.add(4);
       assertEquals(respEsperadaV2, grafo.getAdyacentes(2));
       //adyacentes del vertice 3
       ArrayList <Integer> respEsperadaV3 = new ArrayList <>();
       respEsperadaV3.add(0);
       respEsperadaV3.add(1);
       respEsperadaV3.add(4);
       assertEquals(respEsperadaV3, grafo.getAdyacentes(3));
       //adyacentes del vertice 4
       ArrayList <Integer> respEsperadaV4 = new ArrayList <>();
       respEsperadaV4.add(1);
       respEsperadaV4.add(2);
       respEsperadaV4.add(3);
       assertEquals(respEsperadaV4, grafo.getAdyacentes(4));
    }
    
    @Test
    public void impresionDelGrafo(){
      grafo.dibujarGrafo();
      grafo2.dibujarGrafo();
      grafo3.dibujarGrafo();
    }
    
    @Test
    public void quitarArista(){
      assertEquals(true,grafo.quitarArista(0, 1));
      assertEquals(true,grafo.quitarArista(0, 3));
      assertEquals(false,grafo.quitarArista(0, 4));
      assertEquals(false,grafo.quitarArista(0, 2));
    }
    
    @Test
    public void esCompleto(){
    
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
