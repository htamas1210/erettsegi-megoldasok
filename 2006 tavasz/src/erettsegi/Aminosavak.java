package erettsegi;

public class Aminosavak {
	//adatok
	public String rovnev;
	public char jel;
	public int c;
	public int h;
	public int o;
	public int n;
	public int s;
	public int relmoltomeg;
	
	//konstruktor
	public Aminosavak(String rn, char j, int c, int h, int o, int n, int s) {
		rovnev = rn;
		jel = j;
		this.c = c;
		this.h = h;
		this.o = o;
		this.n = n;
		this.s = s;	
		relmoltomeg = c*12+h+o*16+n*14+s*32;
	}
	
	///metodusok
	public void kiir() {
		System.out.println(rovnev+" " +jel+" "+c+" "+h+" "+o +" "+n+" "+s+" "+relmoltomeg);;
	}
	
}
