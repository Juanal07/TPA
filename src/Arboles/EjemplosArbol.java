package Arboles;

public class EjemplosArbol {

//	public static void preorden(Arbol arbol){
//		if (! arbol.esVacio()){
//		visitar(arbol.raiz());
//		preorden(arbol.hijoIzquierdo());
//		preorden(arbol.hijoDerecho());
//		}
//		}

	public static boolean esPrimo(int numero) {
		if (numero < 2)
			return false;
		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador != numero)) {
			if (numero % contador == 0)
				primo = false;
			contador++;
		}
		return primo;
	}

	public static <T> int contarNodos(ArbolBin<T> arbol) {

		if (!arbol.esVacio()) {
			return 1 + contarNodos(arbol.hijoIzquierdo()) + contarNodos(arbol.hijoDerecho());
		} else {
			return 0;
		}
	}

	public static int sumarNodos(ArbolBin<Integer> arbol) {

		if (!arbol.esVacio()) {
			return arbol.raiz() + sumarNodos(arbol.hijoIzquierdo()) + sumarNodos(arbol.hijoDerecho());
		} else {
			return 0;
		}
	}

	public static int contarPares(ArbolBin<Integer> arbol) {

		if (!arbol.esVacio()) {
			return (arbol.raiz() % 2 == 0) ? 1 + contarPares(arbol.hijoIzquierdo()) + contarPares(arbol.hijoDerecho())
					: contarPares(arbol.hijoIzquierdo()) + contarPares(arbol.hijoDerecho());
		} else {
			return 0;
		}
	}// hacer una funcion que cuente cuantos datos son pares

	public static int contarNodosPrimos(ArbolBin<Integer> arbol) {

		if (!arbol.esVacio()) {
			return (esPrimo(arbol.raiz()))
					? 1 + contarNodosPrimos(arbol.hijoIzquierdo()) + contarNodosPrimos(arbol.hijoDerecho())
					: contarNodosPrimos(arbol.hijoIzquierdo()) + contarNodosPrimos(arbol.hijoDerecho());
		} else {
			return 0;
		}
	}// cuantos numeros primos hay en el arbol

	public static int nodosHoja(ArbolBin<Integer> arbol) {

		if (!arbol.esVacio()) {
			return (arbol.hijoIzquierdo().esVacio() && arbol.hijoDerecho().esVacio())
					? 1 + nodosHoja(arbol.hijoIzquierdo()) + nodosHoja(arbol.hijoDerecho())
					: nodosHoja(arbol.hijoIzquierdo()) + nodosHoja(arbol.hijoDerecho());

		} else {
			return 0;
		}
	}// cuantos nodos hoja hay

	public static boolean arbolesIguales(ArbolBin<Integer> a1, ArbolBin<Integer> a2) {

		// si los dos son vacios
		if (a1.esVacio() && a2.esVacio())
			return true;
		// si uno es vacio y el espejo no
		else {
			if (a1.esVacio() || a2.esVacio())
				return false;
			else
				return (a1.raiz().equals(a2.raiz())) ? arbolesIguales(a1.hijoIzquierdo(), a2.hijoIzquierdo())
						&& arbolesIguales(a1.hijoDerecho(), a2.hijoDerecho()) : false;

		}

	}// decir si son iguales

	public static void nodosConHijos(ArbolBin<Integer> arbol) {

		if (!arbol.esVacio()) {
			if (!arbol.hijoIzquierdo().esVacio()) {
				if (!arbol.hijoDerecho().esVacio()) {
					System.out.print(arbol.raiz() + ", ");
					nodosConHijos(arbol.hijoIzquierdo());
					nodosConHijos(arbol.hijoDerecho());
				} else {
					nodosConHijos(arbol.hijoIzquierdo());
				}
			} else if (!arbol.hijoDerecho().esVacio()) {
				nodosConHijos(arbol.hijoDerecho());
			}

		}
	}// mostrar nodos que tengan hijo izq y derch

	public static int profundidad(ArbolBin<Integer> arbol) {

		if (!arbol.esVacio()) {
			return 1 + Math.max(profundidad(arbol.hijoIzquierdo()), profundidad(arbol.hijoDerecho()));

		} else {
			return 0;
		}
	}// profundidad

	public static boolean arbolLleno(ArbolBin<Integer> arbol, int profundidad) {

		if (!arbol.esVacio()) {
			if (!arbol.hijoIzquierdo().esVacio() && !arbol.hijoDerecho().esVacio()) {
				if (profundidad == 2) {
					return true;
				} else {
					return arbolLleno(arbol.hijoIzquierdo(), profundidad - 1)
							&& arbolLleno(arbol.hijoDerecho(), profundidad - 1);
				}
			} else {
				return false;
			}

		} else {
			return false;
		}

	}// decir si el arbol estaba "lleno", si tiene todos los nodos dado un nivel de
		// profundidad

	public static boolean buscarElemABB(ArbolBin<Integer> arbol, int x) {

		if (!arbol.esVacio()) {
			if (arbol.raiz() == x) {
				return true;
			} else if (arbol.raiz() > x) {
				return buscarElemABB(arbol.hijoIzquierdo(), x);
			} else {
				return buscarElemABB(arbol.hijoDerecho(), x);
			}
		} else {
			return false;
		}
	}// buscar elemento en ABB

	public static void main(String[] args) {
		ArbolBin<Integer> g = new ArbolBin<Integer>(new ArbolBin<Integer>(), 9, new ArbolBin<Integer>());
		ArbolBin<Integer> f = new ArbolBin<Integer>(new ArbolBin<Integer>(), 7, new ArbolBin<Integer>());
		ArbolBin<Integer> e = new ArbolBin<Integer>(new ArbolBin<Integer>(), 4, new ArbolBin<Integer>());
		ArbolBin<Integer> d = new ArbolBin<Integer>(new ArbolBin<Integer>(), 1, new ArbolBin<Integer>());

		ArbolBin<Integer> c = new ArbolBin<Integer>(f, 8, g);
		ArbolBin<Integer> b = new ArbolBin<Integer>(d, 3, e);

		ArbolBin<Integer> a = new ArbolBin<Integer>(b, 5, c);

		a.dibujar(1);

		System.out.println("*** FIN ***");
//		System.out.println("Este arbol tiene: " + contarNodos(a) + " nodos");
//		System.out.println("La suma de los valores es: " + sumarNodos(a));
//		System.out.println("Hay: " + contarPares(a) + " nodos pares");
//		System.out.println("Hay: " + contarNodosPrimos(a) + " n�meros primos");
//		System.out.println("Hay: " + nodosHoja(a) + " nodos hoja");
//		System.out.println("�Estos arboles son iguales? " + arbolesIguales(a, b));
//		System.out.print("Los nodos que tienen ambos hijos son: ");
//		nodosConHijos(a);
//		System.out.println();
//		System.out.println("La profundidad del arbol es: " + profundidad(a));
//		System.out.println("Es arbol lleno: " + arbolLleno(a, 3));
		System.out.println("Esta el elemento en el arbol?: "+buscarElemABB(a, 4));

	}

}//
