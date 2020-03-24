
public class AlgoritmosOrdenacion {

	 // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    public static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j];   
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    public static void mergesort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            mergesort(arr, l, m); 
            mergesort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 

	public static void quicksort(int[] lista, int inicio, int fin) {

		if (inicio < fin) {

			int posPivote = pivotar(lista, inicio, fin);

			quicksort(lista, inicio, posPivote - 1);
			quicksort(lista, posPivote + 1, fin);
		}

	}

	public static int pivotar(int[] lista, int inicio, int fin) { // coge el 1er elemento del array y lo ubica en su
																	// posicion final, devuelve su posicion

		int i = inicio;
		int p = lista[inicio];

		for (int j = inicio + 1; j <= fin; j++) {
			if (lista[j] <= p) {
				i++;
				if (i != j) {
					int aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}

		}
		int aux = lista[inicio];
		lista[inicio] = lista[i];
		lista[i] = aux;

		return i;
	}

	public static int seleccion(int[] lista, int k) { // localiza el elemento i-esimo
		int ini = 0;
		int fin = lista.length - 1;
		int x = pivotar(lista, ini, fin);
		while (k != x) {
			if (x > k) {
				fin = x - 1;
			} else {
				ini = x + 1;
			}
			x = pivotar(lista, ini, fin);
		}
		return lista[x];
	}

	public static void main(String[] args) {
		int[] lista = { 4, 3, 1, 7, 2 };
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + ", ");
		}
		System.out.println();
		System.out.println("**********************************");
		
		mergesort(lista, 0, lista.length - 1);
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + ", ");
		}
		System.out.println();
		System.out.println("**********************************");		
		
		quicksort(lista, 0, lista.length - 1);
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + ", ");
		}
		System.out.println();
		System.out.println("**********************************");
		System.out.println("El elemento de la lista situado en la posicion dada es el: " + seleccion(lista, 0));

	}

}
