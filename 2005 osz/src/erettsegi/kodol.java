package erettsegi;

import java.util.Scanner;

public class kodol {

	public static void main(String[] args) {
		//1.feladat
		System.out.println("1.feladat");
		Scanner sc = new Scanner(System.in);
		System.out.println("Kerek egy szoveget ami rovidebb 255 karakternel es nem ures.");
		String ny_szoveg = sc.nextLine();
		//ny_szoveg.length() > 255 || 
		while(ny_szoveg.equals("")) {
			System.out.println("A szoveg nem felel meg az eloirasnak");
			ny_szoveg = sc.nextLine();
		}

		//2.feladat
		System.out.println("2.feladat");
		String[] st = ny_szoveg.split("");
		//switchel is meg  lehet csinalni
		for (int i = 0; i < st.length; i++) {
			if(st[i].equals("á"))
				st[i] = "a";
			else if(st[i].equals("é"))
				st[i] = "e";
			else if(st[i].equals("í"))
				st[i] = "i";
			else if(st[i].equals("ó") || st[i].equals("ö") || st[i].equals("ő"))
				st[i] = "o";
			else if(st[i].equals("ü") || st[i].equals("ú") || st[i].equals("ű"))
				st[i] = "u";
		}
		ny_szoveg = "";
		for (int i = 0; i < st.length; i++) {
			ny_szoveg += st[i].toUpperCase();
		}
		ny_szoveg =  ny_szoveg.replaceAll("\\s","");
		ny_szoveg =  ny_szoveg.replaceAll("['-,;.?!]","");
		
		//3.feladat
		System.out.println("3.feladat");
		System.out.println(ny_szoveg);	
	}
}
