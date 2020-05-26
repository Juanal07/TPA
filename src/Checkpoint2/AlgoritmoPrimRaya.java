package Checkpoint2;

/**
 *
 * @author Nombre y apellidos
 * @expediente 12345678
 * @fecha dd-mm-aaaa
 *
 */

public class AlgoritmoPrimRaya<Clave, InfoVertice, Coste extends Comparable<Coste>> {


	/**
	 * @param g Grafo.
	 * @param a Clave del vértice de inicio
	 * @param listaAristas Listados de pares de vértices (aristas): la solución.
	 */
	public void prim (Grafo<Clave, InfoVertice, Coste> g, Clave a, Lista <Par<Clave>> listaAristas){


	}//prim


	public static void main(String[] args) {

		// declara e inicializa un grafo con los datos de los apuntes
		// invoca a la funci�n algoritmoPrimAR, para el grafo anterior, partiendo del v�rtice con clave "A"
		// muestra por pantalla el coste del �rbol de recubrimiento m�nimo generado
		// muestra por pantalla la lista de pares que forman el �rbol


		/* ****** DATOS PERSONALES ****** */

		String miNombre = "Nombre";
		String misApellidos = "Apellido1 Apellido2";
		String miExpediente = "12345678";

		System.out.println("\nESTUDIANTE:");
		System.out.println(" * Apellidos:\t" + misApellidos);
		System.out.println(" * Nombre:\t" + miNombre);
		System.out.println(" * Expediente:\t" + miExpediente);

		System.out.println("\n*** FIN ***");

	}//main

}//Class
