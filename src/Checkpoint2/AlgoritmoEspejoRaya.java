package Checkpoint2;

/**
 * 
 * @author Juan Alberto Raya
 * @expediente 21948149
 * @fecha 25-05-2020
 *
 */

public class AlgoritmoEspejoRaya<Info> {

	public static <Info> ArbolBin<Info> algoritmoEspejoPractica (ArbolBin<Info> arbol){
		
		if (arbol.esVacio()) {//caso base
			return new ArbolBin<Info>();
		}else{//caso recursivo
			return new ArbolBin<Info>(algoritmoEspejoPractica(arbol.hijoDerecho()), arbol.raiz(), algoritmoEspejoPractica(arbol.hijoIzquierdo()));
			//la raiz se queda fija y de hijo izq le asigno el espejo del hijo derecho y al hijo derecho le asigno el espejo del hijo izquierdo
		}
	}//AlgoritmoEspejo

	
	public static void main(String[] args) {

		// declaro e inicializo un �rbol de enteros
		ArbolBin<Integer> d = new ArbolBin<Integer>(new ArbolBin<Integer>(),4,new ArbolBin<Integer>());
		ArbolBin<Integer> f = new ArbolBin<Integer>(new ArbolBin<Integer>(),6,new ArbolBin<Integer>());
		ArbolBin<Integer> e = new ArbolBin<Integer>(new ArbolBin<Integer>(),5,f);
		ArbolBin<Integer> b = new ArbolBin<Integer>(d,2,new ArbolBin<Integer>());
		ArbolBin<Integer> c = new ArbolBin<Integer>(e,3,new ArbolBin<Integer>());
		ArbolBin<Integer> a = new ArbolBin<Integer>(b,1,c);
		// lo dibujo
		a.dibujar(1);
		// declaro un �rbol espejo, que modificar� con la funci�n para 
		ArbolBin<Integer> espejo;
		// invoco a la funci�n para calcular el espejo
		espejo=algoritmoEspejoPractica(a);
		// dibujo el espejo
		espejo.dibujar(1);
	
		// declaro e inicializo un �rbol de caracteres
		ArbolBin<Character> a1 = new ArbolBin<Character>(new ArbolBin<Character>(), 'A', new ArbolBin<Character>());
		ArbolBin<Character> a2 = new ArbolBin<Character>(null, 'B', null);
		ArbolBin<Character> a3 = new ArbolBin<Character>(a1,'C',new ArbolBin<Character>());
		ArbolBin<Character> a4 = new ArbolBin<Character>(a3,'D', a2);
		
		// lo dibujo
		a4.dibujar(1);
		// declaro un �rbol espejo, que modificar� con la funci�n para 
		ArbolBin<Character> espejoChar;
		// invoco a la funci�n para calcular el espejo
		espejoChar=algoritmoEspejoPractica(a4);
		// dibujo el espejo
		espejoChar.dibujar(1);
		

		/* ****** DATOS PERSONALES ****** */
		
		String miNombre = "Juan Alberto";
		String misApellidos = "Raya Rodríguez";
		String miExpediente = "21948149";
		
		System.out.println("\nESTUDIANTE:");
		System.out.println(" * Apellidos:\t" + misApellidos);
		System.out.println(" * Nombre:\t" + miNombre);
		System.out.println(" * Expediente:\t" + miExpediente);
		
		System.out.println("\n*** FIN ***");
	
	

	}

}
