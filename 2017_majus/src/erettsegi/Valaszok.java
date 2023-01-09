package erettsegi;

public class Valaszok {
	public String azon;
	public String valasz;	
	
	public Valaszok(String s) {
		String[] st = s.split(" ");
		azon = st[0];
		valasz = st[1];
	}

}
