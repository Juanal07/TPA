
public class AlgoritmosOrdenacion {

	public static void quicksort(int[] lista, int inicio, int fin) {

		if (inicio < fin) {

			int posPivote = pivotar(lista, inicio, fin);

			quicksort(lista, inicio, posPivote - 1);
			quicksort(lista, posPivote + 1, fin);
		}

	}

	public static int pivotar(int[] lista, int inicio, int fin) {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lista = { 3, 3, 2, 2 };
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + ", ");
		}
		System.out.println();
		System.out.println("**********************************");
		quicksort(lista, 0, lista.length-1);
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + ", ");
		}

	}

}
