
public class Ejercicio2 {

	public static int BusquedaOrdenadaBinariaDyV(int[] lista, int inicio, int fin, int x) {
		if (inicio > fin) {
			return -1;
		} else {
			int mitad = (inicio + fin) / 2;
			if (x == lista[mitad]) {
				return mitad;
			} else {
				if (x < lista[mitad]) {
					System.out.println("camino de la izq.");
					return BusquedaOrdenadaBinariaDyV(lista, inicio, mitad - 1, x);
				} else {
					System.out.println("camino de la dch.");
					return BusquedaOrdenadaBinariaDyV(lista, mitad + 1, fin, x);
				}
			}
		}
	}

	public static int BusquedaOrdenadaCuaternariaDyV(int[] lista, int inicio, int fin, int x) {
		// Caso base
		if (inicio > fin) {
			return -1;
		} else {
			// Divisiones
			int q2 = inicio + ((fin - inicio) / 2);
			int q1 = inicio + ((q2 - inicio) / 2);
			int q3 = inicio + (fin - q1);
			// Recursividad
			if (x == lista[q2]) {
				return q2;
			} else {
				if (x < lista[q2]) {
					if (x == lista[q1]) {
						return q1;
					} else {
						if (x < lista[q1]) {
							System.out.println("me voy por el 1er cuarto");
							return BusquedaOrdenadaCuaternariaDyV(lista, inicio, q1 - 1, x);
						} else {
							System.out.println("me voy por el 2º cuarto");
							return BusquedaOrdenadaCuaternariaDyV(lista, q1 + 1, q2 - 1, x);

						}
					}

				} else {
					if (x == lista[q3]) {
						return q3;
					} else {
						if (x < lista[q3]) {
							System.out.println("me voy por el 3er cuarto");
							return BusquedaOrdenadaCuaternariaDyV(lista, q2 + 1, q3 - 1, x);
						} else {
							System.out.println("me voy por el 4º cuarto");
							return BusquedaOrdenadaCuaternariaDyV(lista, q3 + 1, fin, x);

						}

					}

				}
			}
		}
	}

	public static void main(String[] args) {

//		int[] lista = { 0, 1, 2, 3, 4, 5, 6, 7,7,7,7,7,7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
//		for (int i = 0; i < lista.length; i++) {
//			int elemento = i;
//			System.out.println("Binaria->Tu elemento esta en la posicion: "
//					+ BusquedaOrdenadaBinariaDyV(lista, 0, lista.length - 1, elemento));
//			System.out.println("Cuaternaria->Tu elemento "+elemento+" esta en la posicion: "
//					+ BusquedaOrdenadaCuaternariaDyV(lista, 0, lista.length - 1, elemento));
//
//		}

		int[] lista = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
				26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 };
		int elemento = 14;
		System.out.println("Binaria->Tu elemento esta en la posicion: "
				+ BusquedaOrdenadaBinariaDyV(lista, 0, lista.length - 1, elemento));
		System.out.println("Cuaternaria->Tu elemento esta en la posicion: "
				+ BusquedaOrdenadaCuaternariaDyV(lista, 0, lista.length - 1, elemento));

	}
}
