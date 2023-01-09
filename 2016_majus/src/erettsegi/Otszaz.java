package erettsegi;

import java.io.FileReader;
import java.util.Scanner;

public class Otszaz {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("penztar.txt");
			Scanner reader = new Scanner(fr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
