
public class EjemplosArbol {

//	public static void preorden(Arbol arbol){
//		if (! arbol.esVacio()){
//		visitar(arbol.raiz());
//		preorden(arbol.hijoIzquierdo());
//		preorden(arbol.hijoDerecho());
//		}
//		}

	public static boolean esPrimo(int numero) {
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
		if (a1.esVacio() && a2.esVacio()) {
			return true;
		} else {
			return (a1.raiz() == a2.raiz()) ? arbolesIguales(a1.hijoIzquierdo(), a2.hijoIzquierdo())
					&& arbolesIguales(a1.hijoDerecho(), a2.hijoDerecho()) : false;

		}

	}// decir si son iguales

	public static void main(String[] args) {
//		ArbolBin<Integer> d = new ArbolBin<Integer>(new ArbolBin<Integer>(),4,new ArbolBin<Integer>());
		ArbolBin<Integer> f = new ArbolBin<Integer>(new ArbolBin<Integer>(), 6, new ArbolBin<Integer>());
		ArbolBin<Integer> e = new ArbolBin<Integer>(new ArbolBin<Integer>(), 5, f);
		ArbolBin<Integer> b = new ArbolBin<Integer>(new ArbolBin<Integer>(), 2, new ArbolBin<Integer>());
		ArbolBin<Integer> c = new ArbolBin<Integer>(e, 3, new ArbolBin<Integer>());

		ArbolBin<Integer> a = new ArbolBin<Integer>(b, 1, c);

		a.dibujar(1);

		System.out.println("*** FIN ***");
		System.out.println("Este arbol tiene: " + contarNodos(a) + " nodos");
		System.out.println("La suma de los valores es: " + sumarNodos(a));
		System.out.println("Hay: " + contarPares(a) + " nodos pares");
//		System.out.println("Hay: " + contarNodosPrimos(a) + " números primos");
		System.out.println("Hay: " + nodosHoja(a) + " nodos hoja");
		System.out.println("¿El arbol a y el b son iguales? " + arbolesIguales(a, b));

	}

}
