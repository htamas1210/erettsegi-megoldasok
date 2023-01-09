package erettsegi;

import java.io.FileReader;
import java.util.Scanner;

public class Robot {

	public static double tav(int x, int y) {
		double tav = Math.sqrt(x * x + y * y);
		return Math.round(tav * 1000.0) / 1000.0;
	}

	public static void main(String[] args) {
		try {
			// 1.feladat
			FileReader fr = new FileReader("program.txt");
			Scanner reader = new Scanner(fr);

			int db = Integer.parseInt(reader.nextLine());
			String[] progs = new String[db];

			for (int i = 0; i < db; i++) {
				progs[i] = reader.nextLine();
			}

			reader.close();

			// 2.feladat
			System.out.println("2.feladat");
			// a
			// ED, DE, KN, NK
			Scanner sc = new Scanner(System.in);
			int utasitas = Integer.parseInt(sc.nextLine()) - 1;

			if (progs[utasitas].contains("ED") || progs[utasitas].contains("DE") || progs[utasitas].contains("KN")
					|| progs[utasitas].contains("NK")) {
				System.out.println("A program egyszerusitheto");
			} else {
				System.out.println("A program nem egyszerusitheto");
			}

			// b
			int x = 0;
			int y = 0;

			for (int j = 0; j < progs[utasitas].length(); j++) {
				switch (progs[utasitas].charAt(j)) {
					case 'E':
						y++;
						break;
					case 'D':
						y--;
						break;
					case 'N':
						x--;
						break;
					case 'K':
						x++;
						break;
				}
			}
			System.out.println(y + " lepest kell tenni az ED, " + x + " lépést a KN tengelymentén.");

			// c
			// atfogo kiszamitasa

			System.out.println("Legvonalban a tavolsag: " + tav(x, y));

			// 3.feladat
			System.out.println("3.feladat");
			

		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
