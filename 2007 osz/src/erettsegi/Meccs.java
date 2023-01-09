package erettsegi;

public class Meccs {
	//adatok
	public int fordulo;
	public int hv;
	public int vv;
	public int hf;
	public int vf;
	public String hazai;
	public String vendeg;
	int meg_fordult;
	public String gyoztes;
	public String stat_eredmeny;
		
	//konstruktor
	public Meccs(String s) {
		String[] st = s.split(" ");
		fordulo = Integer.parseInt(st[0]);
		hv = Integer.parseInt(st[1]);
		vv = Integer.parseInt(st[2]);
		hf = Integer.parseInt(st[3]);
		vf= Integer.parseInt(st[4]);
		hazai = st[5];
		vendeg = st[6];
		meg_fordult = (hv-vv)*(hf-vf);
		if(hv>vv)
			gyoztes = hazai;
		else if(hv < vv)
			gyoztes = vendeg;
		else 
			gyoztes = "dontetlen";
		if(hv>vv) {
			stat_eredmeny = ""+hv+"-"+vv;
		}else {
			stat_eredmeny = ""+vv+"-"+hv;
		}
	}
	
	//metodusok
	public void kiir() {
		System.out.println(hazai+"-"+vendeg +": "+hv+"-"+vv+" ("+hf+"-"+vf+")");
	}

}
