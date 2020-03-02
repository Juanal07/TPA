
public class Matrices {

	public static boolean sonIguales(int[][] m1, int[][] m2) {
		int i = 0;
		while (i < m1.length) {
			int j = 0;
			while (j < m1.length) {
				if (m1[i][j] != m2[i][j]) {
					return false;
				}
				j++;
			}
			i++;
		}
		return true;
	}
	
	public static boolean sonIgualesDyV(int[][] m1, int[][] m2, int inii, int fini, int inij, int finj) {
		int mitadi=(inii+fini)/2;
		int mitadj=(inij+finj)/2;
		
		if (mitadi==1) {
			if (m1[0][0]==m2[0][0]) {
				return true;
			}else {
				return false;
			}
		}else {
			return sonIgualesDyV(m1, m2, inii, fini, inij, finj) &&
					sonIgualesDyV(m1, m2, inii, fini, inij, finj) &&
					sonIgualesDyV(m1, m2, inii, fini, inij, finj) &&
					sonIgualesDyV(m1, m2, inii, fini, inij, finj);
					
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m1 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 } };
		int[][] m2 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 } };
		
		System.out.println("¿Son iguales?: "+sonIguales(m1,m2));

	}

}
