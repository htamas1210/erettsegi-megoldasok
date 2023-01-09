package erettsegi;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Foci {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("meccs.txt");
			Scanner reader = new Scanner(fr);
			
			int fsz = Integer.parseInt(reader.nextLine());			
			Meccs[] m = new Meccs[fsz];
			
			for (int i = 0; i < fsz; i++) {
				m[i] = new Meccs(reader.nextLine());
			}
			
			//2.feladat
			System.out.println("2.feladat");
			
			int max_ford = 0;
			
			for (int i = 0; i < fsz; i++) 
				if(max_ford < m[i].fordulo)
					max_ford = m[i].fordulo;
			
			Scanner user_in = new Scanner(System.in);
			int user_ford = 0;
			
			do {
				System.out.println("Kerek egy forduloszamot");
				user_ford = Integer.parseInt(user_in.nextLine());
			}while(user_ford <= 0 || user_ford > 20);
				
			for (int i = 0; i < fsz; i++) 
				if(m[i].fordulo == user_ford)
					m[i].kiir();
			
			//3.feladat
			System.out.println("3.feladat");

			for (int i = 0; i < fsz; i++) 
				if(m[i].meg_fordult < 0)
					System.out.println(m[i].fordulo + " " + m[i].gyoztes);
			

				
		} catch (IOException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
