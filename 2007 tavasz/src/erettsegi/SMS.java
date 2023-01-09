package erettsegi;

import java.io.FileReader;
import java.util.Scanner;

public class SMS {
	
	public static int billentyu(char c) {
		int billentyu = 0;
		
		switch(Character.toLowerCase(c)) {
		case 'a': 
		case 'b': 
		case 'c': billentyu = 2; break;
		
		case 'd': 
		case 'e': 
		case 'f': billentyu = 3; break;
		
		case 'g': 
		case 'h': 
		case 'i': billentyu = 4; break;
		
		case 'j': 
		case 'k': 
		case 'l': billentyu = 5; break;

		case 'm': 
		case 'n': 
		case 'o': billentyu = 6; break;
		
		case 'p': 
		case 'q': 
		case 'r':
		case 's': billentyu = 7; break;
		
		case 't': 
		case 'u': 
		case 'v': billentyu = 8; break;
		
		case 'w': 
		case 'x': 
		case 'y': 
		case 'z': billentyu = 9; break;
		
		default: billentyu = 1;
	}		
		return billentyu;
	}

	public static void main(String[] args) {
		//1.feladat
		System.out.println("1.feladat");
		System.out.println("Kerek egy betut.");
		Scanner sc = new Scanner(System.in);
		char betu = sc.nextLine().charAt(0);

		if(billentyu(betu) == 1) {
			System.out.println("Nincs ilyen billentyu");
		}else {
			System.out.println("Megnyomtad a "+billentyu(betu)+"-t");
		}
		
		//2.feladat
		System.out.println("2.feladat");
		
		String kert_szo = sc.nextLine();
		
		for (int i = 0; i < kert_szo.length(); i++) {
			System.out.print(billentyu(kert_szo.charAt(i)) + ", ");
		}
		System.out.println(" billentyukbol lehet beirni");
		
		//3.feladat
		System.out.println("3.feladat");
		
		String[] szavak = new String[600];
		int szavak_i = -1;
		
		try {
			FileReader fr = new FileReader("szavak.txt");
			Scanner reader = new Scanner(fr);			
			
			while(reader.hasNextLine()) {
				szavak_i++;
				szavak[szavak_i] = reader.nextLine();
			}			
			
		} catch (Exception e) {
			System.err.println(e);
		}	
	}
}
