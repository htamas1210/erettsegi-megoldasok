package erettsegi;

import java.io.FileReader;
import java.util.Scanner;

public class Tesztverseny {

	public static void main(String[] args) {
		try {
			//1.feladat
			FileReader fr = new FileReader("valaszok.txt");
			Scanner reader = new Scanner(fr);
			
			int tanulo_i = -1;
			String helyes_valasz = reader.nextLine();
			Valaszok[] valaszok = new Valaszok[500];
			
			while(reader.hasNextLine()) {
				tanulo_i++;
				valaszok[tanulo_i] = new Valaszok(reader.nextLine());
			}
			
			fr.close();
			reader.close();
			
			//2.feladat
			System.out.println("2.feladat");
			
			
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}

	}

}
