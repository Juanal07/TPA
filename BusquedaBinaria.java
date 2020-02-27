public class BusquedaBinaria {
//repasar metodo
	public static int BusquedaDyV(int[] lista, int inicio, int fin, int x) {
		if (inicio > fin) {
			return -1;
		} else {
			int mitad = (inicio + fin) / 2;
			if (x == lista[mitad]) {
				return mitad;
			} else {
				if (x < lista[mitad]) {
					return BusquedaDyV(lista, inicio, mitad - 1, x);
				} else {
					return BusquedaDyV(lista, mitad, fin-1, x);
				}
			}
		}
	}
	//hacer este metodo y calcular eficiencia
	public static int SumaDyV (int[]lista, int inicio, int fin) {
		
		int suma=0;
		return suma;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lista = { 1};
		System.out.println(BusquedaDyV(lista, 0, lista.length, 2));

	}

}
