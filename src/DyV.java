
public class DyV {

	public static int maximo(int[] lista, int inicio, int fin) {
		int sol;
		if (inicio == fin) {
			sol = lista[inicio];
		} else {
			int mitad = (inicio + fin) / 2;
			int maxI = maximo(lista, inicio, mitad);
			int maxD = maximo(lista, mitad + 1, fin);
			sol = Integer.max(maxI, maxD);
		}
		return sol;
	}

	public static void main(String[] args) {
		int[] lista = { -1, 4, -44, 55 };
		System.out.println(maximo(lista, 0, lista.length - 1));
	}

}
