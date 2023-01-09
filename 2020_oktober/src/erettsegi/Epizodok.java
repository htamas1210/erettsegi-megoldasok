package erettsegi;

public class Epizodok {
	public String datum;
	public String cim;
	public String epizod;
	public int hossz;
	public int megnezett;
	
	public Epizodok(String s) {
		String[] st = s.split("@");
		datum = st[0];
		cim = st[1];
		epizod = st[2];
		hossz = Integer.parseInt(st[3]);
		megnezett = Integer.parseInt(st[4]);
	}

}
