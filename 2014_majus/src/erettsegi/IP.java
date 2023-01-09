package erettsegi;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class IP {

	public static void main(String[] args) {
		try {
			//1.feladat
			FileReader fr = new FileReader("ip2.txt");
			Scanner reader = new Scanner(fr);
			
			int ip_db = -1;
			String[] ip_adress = new String[100000000];
			
			while(reader.hasNextLine()) {
				ip_db++;
				ip_adress[ip_db] = reader.nextLine();
			}
			reader.close();
			//2.feladat
			System.out.println("2.feladat");			
			System.out.println("Az allomanyban "+(ip_db+1)+" db adatsor van");
			
			//3.feladat
			System.out.println("3.feladat");
			
			int min = Integer.MAX_VALUE;
			int min_hely = 0;
			int min_sum = 0;
			
			for (int i = 0; i < ip_db; i++) {
				min_sum = 0;
				for (int j = 0; j < ip_adress[i].length(); j++) {
					min_sum += ip_adress[i].charAt(j);
				}
				if(min > min_sum) {
					min = min_sum;
					min_hely = i;
				}
			}
			
			System.out.println("A legalacsonyabb tarolt IP-cim:"+System.lineSeparator()+ip_adress[min_hely]);
			
			//4.feladat
			System.out.println("4.feladat");
			
			int doc = 0, glb = 0, lcl = 0, egyeb = 0;
			
			for (int i = 0; i < ip_db; i++) {
				if(ip_adress[i].substring(0,9).equals("2001:0db8")) {
					doc++;
				}else if(ip_adress[i].substring(0,7).equals("2001:0e")) {
					glb++;
				}else if(ip_adress[i].substring(0,2).equals("fc") || ip_adress[i].substring(0,2).equals("fd")) {
					lcl++;
				}else{
					egyeb++;
				}
			}
			
			System.out.println("Dokumenatcios cim: "+ doc + " darab");
			System.out.println("Globalis egyedi cim: "+glb+" darab");
			System.out.println("Helyi egyedi cim: "+lcl+" darab");
			System.out.println("Egyeb: " + egyeb + " darab");
			//System.out.println(ip_db);
			
			//5.feladat
			//System.out.println("5.feladat");
			
			int zero_db = 0;
			FileWriter writer = new FileWriter("sok.txt");
			
			for (int i = 0; i < ip_db; i++) {
				zero_db = 0;
				for (int j = 0; j < ip_adress[i].length(); j++) {
					if(ip_adress[i].charAt(j) == '0')
						zero_db++;
				}
				if(zero_db > 18)
					writer.write(""+(i+1)+" "+ip_adress[i]+System.lineSeparator());
			}
			
			writer.close();
			
			//6.feladat
			/*System.out.println("6.feladat");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("K�rek egy sorszamot: ");
			int sorszam = Integer.parseInt(sc.nextLine());
			sc.close();
			String s = "";
			
				String[] split = ip_adress[sorszam-1].split(":");
				for (int j = 0; j < split.length; j++) {
					if(split[j].equals("0000")) {
						split[j] = "0";
					}
				}
				for (int j = 0; j < split.length; j++) {
					s += split[j] + ":";
				}
				s = s.substring(0, s.length()-1);
				
			System.out.println(ip_adress[sorszam-1]);
			System.out.println(s);
			
			//7.feladat
			System.out.println("7.feladat");
			
			int n_db = 0;
			int n_index = 0;
			int n_max = 0;
			
			split = s.split(":");
			
			for (int i = 0; i < split.length; i++) {
				if(split[i].equals("0"))
					n_db++;
				else {
					n_db = 0;
				}
			}
			*/
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
