package erettsegi;

public class Musor {
	public int ado;
	public int perc;
	public int mp;
	public int szam_hossz;
	public String azonosito;
	public String eloado;
	public String zene;
		
	public Musor(String s) {
		String[] st = s.split(" ");
		ado = Integer.parseInt(st[0]);
		perc = Integer.parseInt(st[1]);
		mp = Integer.parseInt(st[2]);
		szam_hossz = perc * 60 + mp;
		String a = "";
		for (int i = 3; i < st.length; i++) {
			a += st[i];
			if(i < st.length-1)
				a += " ";
		}
		//a = a.substring(0, a.length()-1);
		azonosito = a;
		String[] sg = azonosito.split(":");	
		eloado = sg[0];
		zene = sg[1];
	}
}
