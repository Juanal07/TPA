package Checkpoint2;

/**
 * @author Juan Alberto Raya Rodriguez
 * @expediente 21948149
 * @fecha 31-05-2020
 */

public class AlgoritmoPrimRaya<Clave, InfoVertice, Coste extends Comparable<Coste>> {

    /**
     * @param g            Grafo.
     * @param a            Clave del vértice de inicio
     * @param listaAristas Listados de pares de vértices (aristas): la solución.
     */
    public void prim(Grafo<Clave, InfoVertice, Coste> g, Clave a, Lista<Par<Clave>> listaAristas) {

        //Inicializo las listas que voy a usar
        Lista<Clave> visitados = new Lista<Clave>();

        visitados.insertar(1, a); // Ej: vistados = {A}
        Lista<Clave> noVisitados = g.listaVertices();
        noVisitados.borrar(g.listaVertices().buscar(a)); // Ej: noVisitados = {B,C,D,E,F,G} = g.listaVertices() - visitados

        while (!noVisitados.esVacia()) {
            //mientras queden vertices por visitar sigo añadiendo a mi lista el valor minimo de los posibles
            Par<Clave> parVistado = minimo(sucesoresPrim(g, visitados, noVisitados), g); //el par me indica el origen y destino del par ideal de mi solución
            listaAristas.insertar(listaAristas.longitud() + 1, parVistado); //añado el par a mi lista solucion
            noVisitados.borrar(noVisitados.buscar(parVistado.getDestino())); //borro el destino visitado de mi lista noVisitados
            visitados.insertar(visitados.longitud() + 1, parVistado.getDestino()); //añado el destino visitado de mi lista visitados
        }
    }//prim

    public Lista<Par<Clave>> sucesoresPrim(Grafo<Clave, InfoVertice, Coste> g, Lista<Clave> visitados, Lista<Clave> noVisitados) {

		/*me devuelve la lista de pares que
		  esten disponibles (que no se hayan visitado y estén al alcance)
		  dado el estado actual del arbol de recubrimiento*/

        Lista<Par<Clave>> sucesoresPrim = new Lista<Par<Clave>>();//inicializo mi lista de pares vacia
        //Ahora itero para encontrar todos los sucesores (no repetidos) de mis nodos visitados
        //En mi ejemplo en la primera iteracion devuelve (A,B),(A,D),(A,C)
        for (int i = 0; i < visitados.longitud(); i++) {//recorro los nodos visitados
            //En la 1ª iteracion solo estaria el "A"
            Lista<Clave> sucesoresAux = g.listaSucesores(visitados.consultar(i + 1));//lista de sucesores de un visitado
            for (int j = 0; j < sucesoresAux.longitud(); j++) { //recorro los nodos sucesores de los visitados
                if (visitados.buscar(sucesoresAux.consultar(j + 1)) == 0) {//si el sucesor no esta ya en visitados
                    sucesoresPrim.insertar(sucesoresPrim.longitud() + 1, new Par<Clave>(visitados.consultar(i + 1), sucesoresAux.consultar(j + 1)));
                    //inserto el par en sucesoresPrim
                }
            }
        }
        return sucesoresPrim;
    }//sucesoresPrim

    private Par<Clave> minimo(Lista<Par<Clave>> sucesoresPrim, Grafo<Clave, InfoVertice, Coste> g) {
        //me devuelve el par que menos valor tenga

        Par<Clave> parMinimo = sucesoresPrim.consultar(1); //inicializo mi par minimo
        Par<Clave> parAux = sucesoresPrim.consultar(1); //inicializo al 1º de succesoresPrim un par auxiliar para iterar
        Coste coste = g.costeArista(parAux.getOrigen(), parAux.getDestino());//inicializo el coste al primer camino que vea
        for (int i = 0; i < sucesoresPrim.longitud(); i++) {//recorro toda la lista en busca del minimo
            parAux = sucesoresPrim.consultar(i + 1);
            if (coste.compareTo(g.costeArista(parAux.getOrigen(), parAux.getDestino())) == 1) {//si es menor me quedo con él
                parMinimo = parAux;
            }
        }
        return parMinimo;
    }//minimo

    public static void main(String[] args) {

        // declara e inicializa un grafo con los datos de los apuntes
        // invoca a la funci�n algoritmoPrimAR, para el grafo anterior, partiendo del v�rtice con clave "A"
        // muestra por pantalla el coste del �rbol de recubrimiento m�nimo generado
        // muestra por pantalla la lista de pares que forman el �rbol

        Grafo<String, String, Integer> g = new Grafo<String, String, Integer>();
        g.insertarVertice("A", "Alemania");
        g.insertarVertice("B", "Belgica");
        g.insertarVertice("C", "Croacia");
        g.insertarVertice("D", "Dinamarca");
        g.insertarVertice("E", "España");
        g.insertarVertice("F", "Francia");
        g.insertarVertice("G", "Grecia");

        g.insertarArista("A", "B", 10);
        g.insertarArista("B", "A", 10);

        g.insertarArista("A", "D", 7);
        g.insertarArista("D", "A", 7);

        g.insertarArista("A", "C", 4);
        g.insertarArista("C", "A", 4);

        g.insertarArista("C", "D", 2);
        g.insertarArista("D", "C", 2);

        g.insertarArista("B", "D", 2);
        g.insertarArista("D", "B", 2);

        g.insertarArista("B", "E", 10);
        g.insertarArista("E", "B", 10);

        g.insertarArista("G", "D", 5);
        g.insertarArista("D", "G", 5);


        g.insertarArista("E", "G", 2);
        g.insertarArista("G", "E", 2);

        g.insertarArista("F", "G", 5);
        g.insertarArista("G", "F", 5);

        g.insertarArista("C", "F", 3);
        g.insertarArista("F", "C", 3);

        String inicio = "A";
        Lista<Par<String>> listaAristas = new Lista<Par<String>>();

        AlgoritmoPrimRaya objeto = new AlgoritmoPrimRaya(); //como nos has dado una cabecera NO static tenemos que instanciar un objeto
        objeto.prim(g, inicio, listaAristas);

        System.out.println("Solucion: ");
        int total = 0; //coste total de la solucion

        for (int i = 0; i < listaAristas.longitud(); i++) {
            System.out.println("Arista: (" + listaAristas.consultar(i + 1).getOrigen() + ", " + listaAristas.consultar(i + 1).getDestino() + ")");
            total += g.costeArista(listaAristas.consultar(i + 1).getOrigen(), listaAristas.consultar(i + 1).getDestino());

        }
        System.out.println("Coste total: " + total);
        System.out.println("=========================================");




        /* ****** DATOS PERSONALES ****** */

        String miNombre = "Juan Alberto";
        String misApellidos = "Raya Rodriguez";
        String miExpediente = "21948149";

        System.out.println("\nESTUDIANTE:");
        System.out.println(" * Apellidos:\t" + misApellidos);
        System.out.println(" * Nombre:\t" + miNombre);
        System.out.println(" * Expediente:\t" + miExpediente);

        System.out.println("\n*** FIN ***");

    }//main


}//Class
