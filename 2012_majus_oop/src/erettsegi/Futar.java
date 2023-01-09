package erettsegi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Futar {

	public static void main(String[] args) {
		try {
			//1.feladat
			FileReader fr = new FileReader("tavok.txt");
			Scanner reader = new Scanner(fr);
			int nap = 0, fuvar_szam = 0, tav = 0;
			int sor = 0;
			Szallitas[] szlts = new Szallitas[61];
			
			while(reader.hasNextLine()) {
				String[] split = reader.nextLine().split(" ");
				nap = Integer.parseInt(split[0]);
				fuvar_szam = Integer.parseInt(split[1]);
				tav = Integer.parseInt(split[2]);
				
				szlts[sor] = new Szallitas(nap,fuvar_szam,tav);
				sor++;				
			}
			reader.close();
			
			//2.feladat
			System.out.println("2.feladat");	
			int ef_nap = szlts[60].nap;
			int ef_fuvarsz = szlts[60].fuvar_szam;
			int ef_tav = 0;
			
			for (int i = szlts.length-1; i >= 0; i--) {
				if(ef_nap > szlts[i].nap || ef_fuvarsz > szlts[i].fuvar_szam) {
					ef_nap = szlts[i].nap;
					ef_fuvarsz = szlts[i].fuvar_szam;
					ef_tav = szlts[i].tav;
				}
			}

			System.out.println("A het legelso utjanak tavolsaga: "+ef_tav);
			
			//3.feladat
			System.out.println("3.feladat");
			int uf_nap = szlts[0].nap;
			int uf_fuvarsz = szlts[0].fuvar_szam;
			int uf_tav = 0;
			
			for (int i = 0; i < szlts.length; i++) {
				for (int j = 0; j < szlts.length; j++) {
					if(uf_nap < szlts[j].nap) {
						uf_nap = szlts[j].nap;					
					}
				}
				for (int j = 0; j < szlts.length; j++) {
					if(uf_nap <= szlts[j].nap && uf_fuvarsz < szlts[j].fuvar_szam) {
						uf_nap = szlts[j].nap;
						uf_fuvarsz = szlts[j].fuvar_szam;
						uf_tav = szlts[j].tav;
					}
				}
			}

			System.out.println("A het legelso utjanak tavolsaga: "+uf_tav);			
			
			//4.feladat
			System.out.println("4.feladat");
			int[] szabad_nap = new int[7];
			
			for (int i = 1; i <= 7; i++) {
				for (int j = 0; j < szlts.length; j++) {
					if(szlts[j].nap == i) {
						szabad_nap[i-1]++;
					}
				}
			}			
			for (int i = 0; i < 7; i++) {
				if(szabad_nap[i] == 0) {
					System.out.println(i+1+". napon nem dolgozott a futar");
				}
			}
			
			//5.feladat
			System.out.println("5.feladat");
			int lt_fuvar_nap = 1;
			int lt_fuvar = 0;
			
			for (int i = 0; i < szlts.length; i++) {
				if(szlts[i].fuvar_szam > lt_fuvar) {
					lt_fuvar_nap = szlts[i].nap;
					lt_fuvar = szlts[i].fuvar_szam;
				}
			}
			
			System.out.println(lt_fuvar_nap+".napon volt a legtobb fuvar");
			
			//6.feladat
			System.out.println("6.feladat");		
			int[] nap_tav = new int[7];			
			
			for (int i = 0; i < szlts.length; i++) {
				for (int j = 1; j < 8; j++) {
					if(szlts[i].nap == j) {
						nap_tav[j-1] += szlts[i].tav;
					}
				}
			}		
			for (int i = 0; i < nap_tav.length; i++) {
				System.out.println(i+1+". napon "+ nap_tav[i] +" km-t tett meg a futar");
			}
			
			//7.feladat
			System.out.println("7.feladat");			
			Scanner user_in = new Scanner(System.in);
			String user_tav = user_in.nextLine();
			int fizetes = 0;
			
			if(Integer.parseInt(user_tav)>= 1 && Integer.parseInt(user_tav) <= 2) {
				fizetes = 500;
			}
			else if(Integer.parseInt(user_tav)>= 3 && Integer.parseInt(user_tav) <= 5) {
				fizetes = 700;
			}
			else if(Integer.parseInt(user_tav)>= 6 && Integer.parseInt(user_tav) <= 10) {
				fizetes = 900;
			}
			else if(Integer.parseInt(user_tav)>= 11 && Integer.parseInt(user_tav) <= 20) {
				fizetes = 1400;
			}
			else if(Integer.parseInt(user_tav)>= 21) {
				fizetes = 2000;
			}
			user_in.close();
			System.out.println("Az utert ennyi fizetest kapott: "+fizetes);
			
			//8.feladat
			System.out.println("8.feladat");
			Szallitas csere;
			
			for (int i = 0; i < szlts.length; i++) {
				for (int j = i+1; j < szlts.length; j++) {
					if(szlts[i].nap >= szlts[j].nap) {
						csere = szlts[i];
						szlts[i] = szlts[j];
						szlts[j] = csere;						
					}
				}
			}	
			for (int i = 0; i < szlts.length; i++) {
				for (int j = i+1; j < szlts.length; j++) {
					if(szlts[i].nap >= szlts[j].nap && szlts[i].fuvar_szam > szlts[j].fuvar_szam) {
						csere = szlts[i];
						szlts[i] = szlts[j];
						szlts[j] = csere;						
					}
				}
			}
			
			FileWriter writer = new FileWriter("dijazas.txt");
			
			for (int i = 0; i < szlts.length; i++) {
				writer.write(szlts[i].nap+".nap "+szlts[i].fuvar_szam+".ut: "+szlts[i].fizetes+" Ft"+System.lineSeparator());
			}
			writer.close();
			
			//9.feladat
			System.out.println("9.feladat");
			int heti_fizetes = 0;
			
			for (int i = 0; i < szlts.length; i++) {
				if(szlts[i].tav >= 1 && szlts[i].tav <= 2) {
					heti_fizetes += 500;
				}
				else if(szlts[i].tav >= 3 && szlts[i].tav <= 5) {
					heti_fizetes += 700;
				}
				else if(szlts[i].tav >= 6 && szlts[i].tav <= 10) {
					heti_fizetes += 900;
				}
				else if(szlts[i].tav >= 11 && szlts[i].tav <= 20) {
					heti_fizetes += 1400;
				}
				else if(szlts[i].tav >= 21) {
					heti_fizetes += 2000;
				}
			}
			
			System.out.println("A heti munkajaert ennyi fizetest kap: "+heti_fizetes);
			
		} catch (IOException e) {
			System.err.println(e);
		}catch(NumberFormatException e) {
			System.err.println(e);
		}
	}
}
