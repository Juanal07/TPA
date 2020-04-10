public class Traspuesta {

	public static boolean esTraspuesta_v1 (int[][] a, int[][] b) {
		boolean traspuesta = true;
		
		for (int fila = 0; fila < a.length; fila++) {
			for (int col = 0; col < a[fila].length; col++) {
				if (a[fila][col] != b[col][fila])
					traspuesta = false;
			}
		}
		return traspuesta;
	}
	
	public static boolean esTraspuesta_v2 (int[][] a, int[][] b) {
		boolean traspuesta = true;
		int fila = 0;
		while (fila < a.length && traspuesta) {
			int col=0;			
			while (col < a[fila].length && traspuesta) {
				if (a[fila][col] != b[col][fila])
					traspuesta = false;
				col++;
			}
			fila++;
		}
		return traspuesta;
	}
	
	public static boolean esTraspuesta_DyV (int[][] a, int[][] b) {		
		
		return sonIgualesDyV2(a,b,0,a.length-1);
				
	}

	
	public static boolean sonIgualesDyV2(int[][] m1, int[][] m2, int iniy, int finy) {

		boolean valor = true;
		if (iniy == finy) {
			int i = 0;
			while (i < m1.length && valor) {
				if (m1[i][iniy] != m2[iniy][i]) {
					valor = false;
				}
				i++;
			}
		} else {
			return sonIgualesDyV2(m1, m2, iniy, (finy + iniy) / 2)
					&& sonIgualesDyV2(m1, m2, (finy + iniy) / 2 + 1, finy);
		}
		return valor;
	}
	
	public static void main(String[] args) {
		
		int[][] m1 = {	{1,2,3,4},
						{5,6,7,8},
						{1,2,3,4},
						{5,6,7,8}};

		int[][] m2 = {	{1,5,1,5},
						{2,6,2,6},
						{3,7,3,7},
						{4,8,4,8}};	
		
		int[][] m3 = {	{0,5,1,5},
						{2,6,2,6},
						{3,7,3,7},
						{4,8,4,8}};	
	
		System.out.println("PRUEBA 1:");
		System.out.println(" * esTraspuesta_v1 (m1, m2): " + esTraspuesta_v1(m1,m2));
		System.out.println(" * esTraspuesta_v1 (m1, m3): " + esTraspuesta_v1(m1,m3));
		
		System.out.println("\nPRUEBA 2:");
		System.out.println(" * esTraspuesta_v2 (m1, m2): " + esTraspuesta_v2(m1,m2));
		System.out.println(" * esTraspuesta_v2 (m1, m3): " + esTraspuesta_v2(m1,m3));
		
		System.out.println("\nPRUEBA 3:");
		System.out.println(" * esTraspuesta_DyV (m1, m2): " + esTraspuesta_DyV(m1,m2));
		System.out.println(" * esTraspuesta_DyV (m1, m3): " + esTraspuesta_DyV(m1,m3));
		
		System.out.println("\n*** FIN ***");
	
	}//main

}//class