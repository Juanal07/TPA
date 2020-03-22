
public class AlgoritmosOrdenacion {

	public static void mergesort(int[] lista, int inicio, int fin) {
		if (inicio < fin) {
			int med = (inicio + fin) / 2;
//			int[] lizq = {};
//			int[] lder = {};
//
//			for (int i = 0; i < med; i++) {
//				lizq[i] = lista[i];
//			}
//			for (int i = med + 1; med + 1 < fin; i++) {
//				lder[i] = lista[i];
//			}
			mergesort(lista, inicio, med);
			mergesort(lista, med + 1, fin);
//			merge();
		}

	}

	public static void merge(int[] lista, int inicio, int fin) {

	}

	public static void quicksort(int[] lista, int inicio, int fin) {

		if (inicio < fin) {

			int posPivote = pivotar(lista, inicio, fin);

			quicksort(lista, inicio, posPivote - 1);
			quicksort(lista, posPivote + 1, fin);
		}

	}

	public static int pivotar(int[] lista, int inicio, int fin) { // coge el 1er elemento del array y lo ubica en su
																	// posicion final, devuelve su posicion

		int i = inicio;
		int p = lista[inicio];

		for (int j = inicio + 1; j <= fin; j++) {
			if (lista[j] <= p) {
				i++;
				if (i != j) {
					int aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}

		}
		int aux = lista[inicio];
		lista[inicio] = lista[i];
		lista[i] = aux;

		return i;
	}

	public static int seleccion(int[] lista, int k) { // localiza el elemento i-esimo
		int ini = 0;
		int fin = lista.length - 1;
		int x = pivotar(lista, ini, fin);
		while (k != x) {
			if (x > k) {
				fin = x - 1;
			} else {
				ini = x + 1;
			}
			x = pivotar(lista, ini, fin);
		}
		return lista[x];
	}

	public static void main(String[] args) {
		int[] lista = { 4, 3, 1, 7, 2 };
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + ", ");
		}
		System.out.println();
		System.out.println("**********************************");
		quicksort(lista, 0, lista.length - 1);
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + ", ");
		}
		System.out.println();
		System.out.println("**********************************");
		System.out.println("El elemento de la lista situado en la posicion dada es el: " + seleccion(lista, 0));

	}

}
