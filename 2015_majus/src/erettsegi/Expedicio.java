package erettsegi;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Expedicio {

	public static void main(String[] args) {
		try {
			//1.feladat
			FileReader fr = new FileReader("veetel.txt");
			Scanner reader = new Scanner(fr);
			
			//LinkedList<Radio> radio = new LinkedList<>();
			Radio[] radio3 = new Radio[220];
			int radio3_i = -1;
			String nap_vevo = "", uzenet = "";
			
			while(reader.hasNextLine()) {
				nap_vevo = reader.nextLine(); uzenet = reader.nextLine();
				//radio.add(new Radio(nap_vevo, uzenet));
				radio3[++radio3_i] = new Radio(nap_vevo, uzenet);
			}
			
			//2.feladat
			System.out.println("2.feladat");
			/*System.out.println("Elso uzenet rogzitoje: " + radio.getFirst().vevo_i);
			System.out.println("Utolso uzenet rogzitoje: " + radio.getLast().vevo_i);*/
			System.out.println("Elso uzenet rogzitoje: " + radio3[0].vevo_i);
			System.out.println("Utolso uzenet rogzitoje: " + radio3[radio3_i].vevo_i);
			
			
			//3.feladat
			System.out.println("3.feladat");
			
			/*for (Radio radio2 : radio) {
				if(radio2.uzenet.contains("farkas"))
					System.out.println(radio2.nap_i + " " + radio2.vevo_i);
			}*/
			for (int i = 0; i < radio3_i; i++) {
				if(radio3[i].uzenet.contains("farkas"))
					System.out.println(radio3[i].nap_i + " " + radio3[i].vevo_i);
			}
			
			//4.feladat
			System.out.println("4.feladat");			
			int[][] nap_stat = new int[11][2];
			
			for (int i = 0; i < 11; i++) {
				nap_stat[i][0] = i+1;
				nap_stat[i][1] = 0;
			}
			
			/*for (Radio radio2 : radio) {
				nap_stat[radio2.nap_i-1][1]++;
			}*/
			for (int i = 0; i < radio3_i; i++) {
				nap_stat[radio3[i].nap_i-1][1]++;
			}
					 
			for (int i = 0; i < 11; i++) {
				System.out.println(nap_stat[i][0]+". nap: "+nap_stat[i][1]+" radioamator");
			}	
					
			//5.feladat
			System.out.println("5.feladat");
			FileWriter writer = new FileWriter("adaas.txt");
			
			Radio csere;
			//sorba rendezes
			for (int i = 0; i < radio3_i-1; i++) {
				for (int j = i+1; j < radio3_i; j++) {
					if(radio3[i].nap_i > radio3[j].nap_i) {
						csere = radio3[i];
						radio3[i] = radio3[j];
						radio3[j] = csere;
					}
				}
			}
			
			/*
			 * csinalni egy stringet es egyesevel feltolteni a karaktereket
			 */
			String egybeFuzott = "";
			//boolean menetKozben = false;
			int char_i = 0, nap = 1;
			for (int i = 0; i < radio3_i; i++) {				
				if(radio3[i].nap_i >= 2)break;
				
				for (int j = 0; j < radio3_i; j++) {
					if(nap == radio3[j].nap_i) {
						for (int k = 0; k < radio3[i].uzenet.length(); k++) {
							if(radio3[i].uzenet.charAt(char_i) != '#') {
								egybeFuzott += radio3[i].uzenet.charAt(char_i); 
							}
							char_i++;
						}
					}
					char_i = 0;
				}			
			}
			System.out.println(egybeFuzott);
			
				
			/*for (int i = 0; i < radio3_i; i++) {
				writer.write(radio3[i].nap_i+ " "+radio3[i].vevo_i+" "+radio3[i].uzenet+System.lineSeparator());
			}
			writer.close();*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
