package erettsegi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zene {
	public static void main(String[] args) {	
		try {
			//1.feladat
			System.out.println("1.feladat");			
			FileReader fr = new FileReader("musor.txt");
			Scanner reader = new Scanner(fr);
			
			int adas_db = Integer.parseInt(reader.nextLine());
			Musor[] m = new Musor[adas_db];
			
			for (int i = 0; i < adas_db; i++) {
				m[i] = new Musor(reader.nextLine());
			}	
			reader.close();
			
			//2.feladat
			System.out.println("2.feladat");
			
			int ado1 = 0, ado2 = 0, ado3 = 0;
			
			for (int i = 0; i < adas_db; i++) {
				if(m[i].ado == 1)
					ado1++;
				else if(m[i].ado == 2)
					ado2++;
				else
					ado3++;
			}
			
			System.out.println("Az egyes adon "+ado1+" db szam ment le.");
			System.out.println("Az kettes adon "+ado2+" db szam ment le.");
			System.out.println("Az harmas adon "+ado3+" db szam ment le.");
			
			//3.feladat
			System.out.println("3.feladat");
			
			int ec1 = 0, ec2 = 0;
			
			for (int i = 0; i < adas_db; i++) {
				if(m[i].ado == 1)
					if(m[i].eloado.equals("Eric Clapton")) {
						ec1 = i;
						break;
					}
			}
			
			for(int i = adas_db-1; i>-1;i--) {
				if(m[i].ado == 1)
					if(m[i].eloado.equals("Eric Clapton")) {
						ec2 = i;
						break;
					}
			}
			
			//System.out.println(ec1 + " " + ec2);
			int ido = 0;
			for (int i = ec1; i <= ec2; i++) {
				if(m[i].ado == 1)
					ido += m[i].szam_hossz;
			}
			//System.out.println(ido);
			
			int ora = 0, perc = 0, mp = 0, maradek = 0;
			
			ora = ido / 3600;
			maradek = ido % 3600;
			perc = maradek / 60;
			mp = maradek%60;
			
			System.out.println("Eltelt ido: "+ora+":"+perc+":"+mp);			
			
		} catch (FileNotFoundException e) {
			System.err.println("A fajl nem talalhato!");
		}catch(IOException e) {
			System.err.println("Hiba!");
		}
	}
}
