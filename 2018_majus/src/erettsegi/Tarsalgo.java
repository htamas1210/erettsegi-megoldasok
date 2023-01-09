package erettsegi;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Tarsalgo {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("ajto.txt");
			Scanner reader = new Scanner(fr);
			
			Ajto[] ajto = new Ajto[1000];
			int ajto_i = -1;
			
			while(reader.hasNextLine()) {
				ajto_i++;
				ajto[ajto_i] = new Ajto(reader.nextLine());
			}
			fr.close();
			reader.close();
			
			//2.feladat
			System.out.println("2.feladat");
			int u_index = -1;
						
			for (int i = 0; i < ajto_i; i++) {
				if(ajto[i].ajto_irany.equals("ki")) {
					u_index = i;
				}
			}
			
			System.out.println("Elsonek lepett be: " + ajto[0].azon);
			System.out.println("Utoljara lepett ki: " + ajto[u_index].azon);
			
			//3.feladat
			int max_azon = 0;		
			
			for (int i = 0; i <= ajto_i; i++) {
				if(max_azon < ajto[i].azon) {
					max_azon = ajto[i].azon;
				}
			}
			
			int[][] atjarasok = new int [max_azon][2];
			
			for (int i = 0; i < max_azon; i++) {
					atjarasok[i][0] = i+1;
			}
			
			for (int i = 0; i <= ajto_i; i++) {
				atjarasok[ajto[i].azon-1][1]++;
			}
			
			FileWriter writer = new FileWriter("athaladas.txt");
			
			for (int i = 0; i < max_azon; i++) {
				writer.write(atjarasok[i][0] +" "+atjarasok[i][1]+System.lineSeparator());
			}
			writer.close();
			
			//4.feladat
			System.out.println("4.feladat");
			boolean bent_van = false;
			System.out.print("A vegen a tarsalgoban voltak: ");
			for (int i = 0; i < max_azon; i++) {
				for (int j = 0; j <= ajto_i; j++) {
					if(i == ajto[j].azon-1) {
						if(ajto[j].ajto_irany.equals("be")) {
							bent_van = true;
						}else {
							bent_van = false;
						}
						
					}
				}
				if(bent_van) 
					System.out.print((i+1) + " ");
			}
			System.out.println();
			
			//5.feladat
			System.out.println("5.feladat");
			
			int max_bent = 0;
			int akt_bent = 0;
			int index = 0;
			
			for (int i = 0; i <= ajto_i; i++) {
				if(ajto[i].ajto_irany.equals("be")) 
					akt_bent++;
				else 
					akt_bent--;
				
				if(akt_bent > max_bent) {
					max_bent = akt_bent;
					index = i;
				}				
			}
			
			System.out.println(ajto[index].ora+":"+ajto[index].perc+"-kor voltak bent a legtobben");
			
			//6.feladat
			System.out.println("6.feladat");			
			System.out.print("Kerek egy azonositot ");
			Scanner sc = new Scanner(System.in);
			int user_azon = Integer.parseInt(sc.nextLine());
			sc.close();
			
			//7.feladat
			System.out.println("7.feladat");
			
			String be_ido = "";
			String ki_ido = "";
			
			for (int i = 0; i <= ajto_i; i++) {
				if(ajto[i].azon == user_azon) {
					if(ajto[i].ajto_irany.equals("be")) {
						be_ido = ""+ajto[i].ora+":"+ajto[i].perc;
						System.out.print(be_ido+"-");
					}
					if(ajto[i].ajto_irany.equals("ki")) {
						ki_ido = ""+ajto[i].ora+":"+ajto[i].perc;			
						System.out.println(ki_ido);
					}	
				}
			}
			System.out.println();
			
			//8.feladat
			System.out.println("8.feladat");
			
			int bent_ido = 0;
			int ido = 0;
			bent_van = false;
			
			for (int i = 0; i <= ajto_i; i++) {
				if(ajto[i].azon == user_azon) {
					if(ajto[i].ajto_irany.equals("be")) {
						ido = ajto[i].ido_percbe;
						bent_van = true;
					}
					if(ajto[i].ajto_irany.equals("ki")) {
						bent_ido += ajto[i].ido_percbe-ido;	
						bent_van = false;
					}
				}
			}
			
			if(bent_van)
				System.out.println("A(z) "+user_azon+". személy összesen "+bent_ido+" percet volt bent, a megfigyelésvégén a társalgóban volt.");
			else {
				System.out.println("A(z) "+user_azon+". személy összesen "+bent_ido+" percet volt bent, a megfigyelésvégén nem volt a tarsalgoban.");
			}
									
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}
