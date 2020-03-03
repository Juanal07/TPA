
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

	public static boolean sonIgualesDyV4(int[][] m1, int[][] m2, int inix, int finx, int iniy, int finy) {

		if (inix == finx) {
			return m1[inix][iniy] == m2[inix][iniy];

		} else {
			return sonIgualesDyV4(m1, m2, inix, (finx + inix) / 2, iniy, (finy + iniy) / 2)
					&& sonIgualesDyV4(m1, m2, inix, (finx + inix) / 2, (finy + iniy) / 2 + 1, finy)
					&& sonIgualesDyV4(m1, m2, (finx + inix) / 2 + 1, finx, iniy, (finy + iniy) / 2)
					&& sonIgualesDyV4(m1, m2, (finx + inix) / 2 + 1, finx, (finy + iniy) / 2 + 1, finy);

		}
	}

	public static boolean sonIgualesDyV2(int[][] m1, int[][] m2, int iniy, int finy) {

		boolean valor = true;
		if (iniy == finy) {
			int i = 0;
			while (i < m1.length ) {
				if (m1[i][iniy] != m2[i][iniy]) {
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
		// TODO Auto-generated method stub
		int[][] m1 = { { 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8 },
				{ 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8 },
				{ 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8 } };
		int[][] m2 = { { 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8 },
				{ 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8 },
				{ 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8 } };

//		int[][] m1 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 } };
//		int[][] m2 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 } };

		System.out.println("Comparacion iterativa: " + sonIguales(m1, m2));
		System.out.println("Comparacion DyV entre 4: " + sonIgualesDyV4(m1, m2, 0, 7, 0, 7));
		System.out.println("Comparacion DyV entre 2: " + sonIgualesDyV2(m1, m2, 0, 7));

	}

}
