package erettsegi;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Feherje {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("aminosav.txt");
			Scanner reader = new Scanner(fr);
			
			Aminosavak[] as = new Aminosavak[20];
			String rovnev = "";
			char jel = ' ';
			int c;
			int h;
			int o;
			int n;
			int s;
			
			for (int i = 0; i < as.length; i++) {
				rovnev = reader.nextLine();
				jel = reader.nextLine().charAt(0);
				c = Integer.parseInt(reader.nextLine());
				h = Integer.parseInt(reader.nextLine());
				o = Integer.parseInt(reader.nextLine());
				n = Integer.parseInt(reader.nextLine());
				s = Integer.parseInt(reader.nextLine());
				as[i] = new Aminosavak(rovnev, jel, c, h, o, n, s);
			}			
			reader.close();
			
			for (int i = 0; i < as.length; i++) {
				as[i].kiir();
			}
			
		} catch (IOException e) {
			System.err.println(e);
		}catch(NumberFormatException e) {
			System.err.println(e);
		}
	}

}
