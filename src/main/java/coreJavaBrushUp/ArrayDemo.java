package coreJavaBrushUp;

public class ArrayDemo {

	public static void main(String[] args) {

		int aa[] = new int[4];

		// This is called Array Literal
		int a[] = { 1, 2, 3, 4, 5 };

		System.out.println(a.length);
		String b[] = { "Mrinmoy", "Biswas" };
		String bb[] = new String[4];
		bb[3] = "KUMAR";

		System.out.println(b.length);
		System.out.println(bb[3]);

		int d[][] = new int[3][3];

		int aaa[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 3, 4, 5 } };
		System.out.println(aaa.length);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(aaa[i][j]);
			}
			System.out.println("");
		}

	}

}
