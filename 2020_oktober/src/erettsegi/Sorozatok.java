package erettsegi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Sorozatok {

	public static void main(String[] args) {
		try {
			//1.feladat
			FileReader fr = new FileReader("lista.txt");
			Scanner reader = new Scanner(fr);
			Epizodok[] eps = new Epizodok[400];
			int n = 0;
			String adatok = "";
			
			while(reader.hasNextLine()) {
				adatok += reader.nextLine() + "@" + reader.nextLine() + "@" + reader.nextLine() + "@" + reader.nextLine() + "@" + reader.nextLine();
				eps[n] = new Epizodok(adatok);
				adatok = "";
				n++;
			}	
			
			reader.close();
			
			//2.feladat
			System.out.println("2.feladat");
			
			int ismert = 0;
			int ismeretlen = 0;
			
			for (int i = 0; i < n; i++) {
				if(!eps[i].datum.equals("NI")) {
					ismert++;
				}
			}
			
			System.out.println("A listában "+ ismert +" db vetítési dátummal rendelkező epizód van.");
			
			//3.feladat
			System.out.println("3.feladat");
			
			int latta_db = 0;
			
			for (int i = 0; i < n; i++) {
				if(eps[i].megnezett == 1) {
					latta_db++;
				}
			}
			
			double szazalek = ((double)latta_db * 100)/n;
			szazalek = szazalek *100;
			szazalek = Math.round(szazalek);
			szazalek = szazalek /100;
			
			System.out.println("A listában lévő epizódok "+ szazalek +"%-át látta.");
			
			//4.feladat
			System.out.println("4.feladat");
			
			int nezett_ido = 0;
			int nap = 0, ora = 0, perc = 0;
			
			for (int i = 0; i < n; i++) 
				if(eps[i].megnezett == 1)
					nezett_ido += eps[i].hossz;
			
			nap = nezett_ido / 1440;
			ora = (nezett_ido % 1440) / 60;
			perc = nezett_ido % 60;
			
			System.out.println("Sorozatnézéssel "+nap+" napot "+ora+" órát és "+perc+" percet töltött.");

			//5.feladat
			System.out.println("5.feladat");

			for (int i = 0; i < n; i++) {
				
			}
			

			
			
			
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}catch(IOException e) {
			System.err.println(e);
		}

	}

}
