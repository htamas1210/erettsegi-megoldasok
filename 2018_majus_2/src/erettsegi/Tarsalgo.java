package erettsegi;

import java.io.FileReader;
import java.util.Scanner;

public class Tarsalgo {

	public static void main(String[] args) {
		try {		
			//1.feladat
			FileReader fr = new FileReader("ajto.txt");
			Scanner reader = new Scanner(fr);
			
			Ajto[] ajto = new Ajto[1000];
			int ajto_i = -1;
			
			while(reader.hasNextLine()) {
				ajto_i++;
				ajto[ajto_i] = new Ajto(reader.nextLine());
			}
			
			/*for (int i = 0; i <= ajto_i; i++) {
				ajto[i].kiir();
			}*/
			
			fr.close();
			reader.close();
			
			//2.feladat
			System.out.println("2.feladat");
			
			System.out.println("Elsonek ment be: "+ajto[0].azon);
			
			for (int i = ajto_i; i > -1; i--) {
				if(ajto[i].ajto_irany.equals("ki")) {
					System.out.println("utolsonak ment ki: "+ajto[i].azon);
					break;
				}
			}
			
			//3.feladat
			System.out.println("3.feladat");
			
			int max_azon = 0;
			
			for(int i = 0; i <= ajto_i; i++) {
				if(max_azon < ajto[i].azon) {
					max_azon = ajto[i].azon;
				}
			}
			
			int[] atjarasok = new int[max_azon+1];
			
			for (int i = 0; i <= max_azon; i++) atjarasok[i] = 0;
			
			for (int i = 0; i <= ajto_i; i++) {
				atjarasok[ajto[i].azon]++;
			}
			
			for (int i = 0; i <= max_azon; i++) {
				if(atjarasok[i] != 0) {
					System.out.println((i+1)+" "+atjarasok[i]);
				}
			}
			
			//4.feladat
			System.out.println("4.feladat");
			
			boolean bent_van = false;
			System.out.println("A vegen a tarsalgoban maradtak: ");

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
				if(bent_van) {
					System.out.print((i+1)+" ");
				}
			}
			/*
			 * 
			 * 
			System.out.println("max azon: "+max_azon);
			boolean[] bent = new boolean[max_azon+1];
			
			for (int i = 0; i <= max_azon; i++) bent[i] = false;
			
			for (int i = 0; i <= ajto_i; i++) {
				if(ajto[i].ajto_irany.equals("be"))
					bent[ajto[i].azon] = true;
				else
					bent[ajto[i].azon] = false;
			}
			System.out.println("A vegen a tarsalgoban maradtak: ");
			for (int i = 0; i < bent.length; i++) {
				if(bent[i])
					System.out.print(i+" ");
			}
			*/
			System.out.println();
			//5.feladat
			System.out.println("5.feladat");
			
			int max_bent = 0, akt_bent = 0, index = 0;
			
			for (int i = 0; i <= ajto_i; i++) {
				if(ajto[i].ajto_irany.equals("be")) {
					akt_bent++;
				}else {
					akt_bent--;
				}
				if(akt_bent > max_bent) {
					max_bent = akt_bent;
					index = i;
				}
			}
			
			System.out.println(ajto[index].ora+":"+ajto[index].perc);
			
			//6.feladat
			System.out.println("6.feladat");
			
			Scanner sc = new Scanner(System.in);
			int user_azon = Integer.parseInt(sc.nextLine());
			
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
					else {
						ki_ido = ""+ajto[i].ora+":"+ajto[i].perc;
						System.out.println(ki_ido);
					}
				}
			}
			
			System.out.println();
			//8.feladat
			System.out.println("8.feladat");
			
			int be_i = 0, ki_i = 0, sum = 0, sum2 = 0;
			boolean van_par = false;
			
			for (int i = 0; i <= ajto_i; i++) {
				if(ajto[i].azon == user_azon) {
					if(ajto[i].ajto_irany.equals("be")) {
						be_i = ajto[i].ora*60+ajto[i].perc;
						van_par = false;
					}
					else {
						ki_i = ajto[i].ora*60+ajto[i].perc;
						van_par = true;
						if(van_par) {					
							System.out.println(sum2 = (ki_i-be_i));
							sum += sum2;
						}
					}
					if(van_par == false) {
						System.out.println(sum2 = (15*60-be_i));
						sum += sum2;
					}
				}
				
			}
			
			System.out.print(sum+" idot toltott bent és ");
			if(!van_par)
				System.out.println("bent maradt");
			else
				System.out.println("nem maradt bent");
			
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}

	}

}
