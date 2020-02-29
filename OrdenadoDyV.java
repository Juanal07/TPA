public class OrdenadoDyV {

	public static int BusquedaOrdenadaDyV(int[] lista, int inicio, int fin, int x) {
		if (inicio > fin) {
			return -1;
		} else {
			int mitad = (inicio + fin) / 2;
			if (x == lista[mitad]) {
				return mitad;
			} else {
				if (x < lista[mitad]) {
					System.out.println("camino de la izq.");
					return BusquedaOrdenadaDyV(lista, inicio, mitad - 1, x);
				} else {
					System.out.println("camino de la dch.");
					return BusquedaOrdenadaDyV(lista, mitad + 1, fin, x);
				}
			}
		}
	}

	public static int SumaOrdenadaDyV(int[] lista, int inicio, int fin, int suma) {
		if (inicio > fin) {
			return 0;

		} else {
			int mitad = (inicio + fin) / 2;
			suma = suma + lista[mitad] + SumaOrdenadaDyV(lista, inicio, mitad - 1, suma)
					+ SumaOrdenadaDyV(lista, mitad + 1, fin, suma);
		}
		return suma;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lista = { 2, 55 };
//		System.out.println(BusquedaOrdenadaDyV(lista, 0, lista.length - 1, 2));
		System.out.println(SumaOrdenadaDyV(lista, 0, lista.length - 1, 0));

	}

}
