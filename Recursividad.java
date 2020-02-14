public class Recursividad {
	
	public static int buscar (int[] array, int dato){
		int i=0;
		while (i<array.length && dato!=array[i]){
			System.out.print("* ");
			i++;						
		}	
		if (i==array.length){
			i=-1;
		}
		return i;		
	}
	
	public static int buscarREC (int[] array, int dato, int i){	
		System.out.print("* ");
		int pos = 0;
		if (i==array.length) { //Caso llega al final sin encontrar
			pos=-1;
		}else if (dato==array[i]) { //Caso encontrado
			pos=i;						
		}else {	//Caso recursivo		
			i++;
			pos=buscarREC(array, dato, i);
		}
		
		return pos;		
	}

	public static void main(String[] args) {
		
		int [] lista = {1,2,3,4,5,6,7,8,9,10};	
		System.out.println("Iterativa: " + buscar(lista,8));
		System.out.println("Recursiva: " + buscarREC(lista,8,0));

	}

}
