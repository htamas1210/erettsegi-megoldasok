package erettsegi;

public class Szallitas {
	public int nap;
	public int fuvar_szam;
	public int tav;
	public int fizetes;
	
	
	public Szallitas(int nap, int fuvar_szam, int tav) {
		this.nap = nap;
		this.fuvar_szam = fuvar_szam;
		this.tav = tav;
		if(tav>= 1 && tav<= 2) {
			fizetes = 500;
		}
		else if(tav>= 3 && tav<= 5) {
			fizetes = 700;
		}
		else if(tav>= 6 && tav<= 10) {
			fizetes = 900;
		}
		else if(tav>= 11 && tav<= 20) {
			fizetes = 1400;
		}
		else if(tav>= 21) {
			fizetes = 2000;
		}
	}
	
	public void kiir() {
		System.out.println(nap + " " + fuvar_szam + " " + tav + " " + fizetes);
	}

}
