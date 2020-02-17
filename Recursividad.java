public class Recursividad {
	
	public static int buscar (int[] array, int dato){
		int i=0;
		System.out.print("* ");
		while (i<array.length && dato!=array[i]){
			System.out.print("* ");
			i++;						
		}	
		if (i==array.length) {
			i=-1;
		}
		return i;		
	}
	
	public static int buscarREC (int[] array, int dato, int i){	
		System.out.print("* ");
		if (i==array.length) { //Caso llega al final sin encontrar
			return -1;
		}else if (dato==array[i]) { //Caso encontrado
			return i;						
		}else {	//Caso recursivo	
			return buscarREC(array, dato, i+1);
		}
			
	}

	public static void main(String[] args) {
		
		int [] lista = {1,2,3,4,5,6,7,8,9,10};
		System.out.println("Iterativa: " + buscar(lista,0));
		System.out.println("Recursiva: " + buscarREC(lista,0,0));

	}

}
