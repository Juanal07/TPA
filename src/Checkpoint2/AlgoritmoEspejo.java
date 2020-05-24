package Checkpoint2;

/**
 * 
 * @author Nombre y apellidos
 * @expediente 12345678
 * @fecha dd-mm-aaaa
 *
 */

public class AlgoritmoEspejo <Info> {

	public static <Info> ArbolBin<Info> algoritmoEspejoPractica (ArbolBin<Info> arbol){
		return null; // para que compile, eliminar.
		// incluye aqu� tu c�digo
	}

	
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
		a1.dibujar(1);
		// declaro un �rbol espejo, que modificar� con la funci�n para 
		ArbolBin<Integer> espejoChar;
		// invoco a la funci�n para calcular el espejo
		espejoChar=algoritmoEspejoPractica(a);
		// dibujo el espejo
		espejoChar.dibujar(1);
		

		/* ****** DATOS PERSONALES ****** */
		
		String miNombre = "indica aqui tu nombre";
		String misApellidos = "indica aqui tus apellidos";
		String miExpediente = "indica aqui tu expediente";
		
		System.out.println("\nESTUDIANTE:");
		System.out.println(" * Apellidos:\t" + misApellidos);
		System.out.println(" * Nombre:\t" + miNombre);
		System.out.println(" * Expediente:\t" + miExpediente);
		
		System.out.println("\n*** FIN ***");
	
	

	}

}
