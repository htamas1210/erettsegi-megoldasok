package erettsegi;

import java.io.FileReader;
import java.util.Scanner;

public class Hianyzas {
	
	public static String hetnapja(int honap, int nap) {
		String[] napnev = {"vasarnap","hetfo","kedd","szerda","csutortok","pentek","szombat"};
		int[] napszam = {0,31,59,90,120,151,181,212,243,273,304,335};
		int napsorszam = (napszam[honap-1]+nap) % 7;
		return napnev[napsorszam];
	}

	public static void main(String[] args) {
		try {
			//1.feladat
			FileReader fr = new FileReader("naplo.txt");
			Scanner reader = new Scanner(fr);
			
			Adatok[] adat = new Adatok[600];
			int adat_i = -1;
			String s = "";
			String s1 = "";
			
			while(reader.hasNextLine()){
				s = reader.nextLine();
				if(s.startsWith("#")) {
					s1 = s;
				}else {
					adat[++adat_i] = new Adatok(s1,s);
				}			
			}
			
			//2.feladat
			System.out.println("2.feladat");			
			System.out.println("Ennyi hianyzas volt: "+(adat_i+1));
			
			//3.feladat
			System.out.println("3.feladat");
			
			int igazolt = 0, igazolatlan = 0;
			
			for (int i = 0; i < adat_i; i++) {
				for (int j = 0; j < 7; j++) {
					if(adat[i].hianyzas.charAt(j) == 'X') igazolt++;
					else if(adat[i].hianyzas.charAt(j) == 'I') igazolatlan++;
				}
			}
			
			System.out.println("Igazolt: "+igazolt);
			System.out.println("Igazolatlan: "+igazolatlan);
			
			//4.feladat
			//System.out.println("4.feladat");
			//5.feladat
			System.out.println("5.feladat");
			
			Scanner sc = new Scanner(System.in);
			int honap = Integer.parseInt(sc.nextLine());
			int nap = Integer.parseInt(sc.nextLine());		
			System.out.println(hetnapja(honap,nap));
			
			
			//6.feladat
			System.out.println("6.feladat");
			
			System.out.println("nap: ");
			String napnev = sc.nextLine();
			System.out.println("oraszam:");
			int oraszam = Integer.parseInt(sc.nextLine());
			int hianyzas_db = 0;
			
			for (int i = 0; i < adat_i; i++) {
				if(hetnapja(adat[i].honap,adat[i].nap).equals(napnev)) {
					if(adat[i].hianyzas.charAt(oraszam-1) == 'X' || adat[i].hianyzas.charAt(oraszam-1) == 'I')
						hianyzas_db++;
				}	
			}
			
			System.out.println("Oran hianyzas ossz "+ hianyzas_db);
			
			//7.feladat
			System.out.println("7.feladat");
			
			int max_hianyzas = 0;
			int index = -1;
			int akt_hianyzas = 0;
			
			for (int i = 0; i < adat_i; i++) {
				for (int j = 0; j < 7; j++) {
					if(adat[i].hianyzas.charAt(j) == 'X' || adat[i].hianyzas.charAt(j) == 'I');
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
