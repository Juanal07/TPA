
public class EjemplosArbol {

//	public static void preorden(Arbol arbol){
//		if (! arbol.esVacio()){
//		visitar(arbol.raiz());
//		preorden(arbol.hijoIzquierdo());
//		preorden(arbol.hijoDerecho());
//		}
//		}

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
	
	//hacer una funcion que cuente cuantos datos son pares
	
	public static <T> int contarPares(ArbolBin<T> arbol) {

		if (!arbol.esVacio()) {
			return 1 + contarPares(arbol.hijoIzquierdo()) + contarPares(arbol.hijoDerecho());
		} else {
			return 0;
		}
	}
	
	//cuantos numeros primos hay en el arbol
	
	// de la hoja de ejercicios 5(cuantos nodos hoja hay) y 7 (2 arboles a y b y decir si son iguales)
	

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

	}

}
