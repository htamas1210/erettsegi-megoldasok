package erettsegi;

public class Adatok {
	public int honap;
	public int nap;
	public String nev;
	public String hianyzas;
	
	
	public Adatok(String s1,String s2) {	
		String[] st = s1.split(" ");
		honap = Integer.parseInt(st[1]);
		nap = Integer.parseInt(st[2]);
		String[] st2 = s2.split(" ");
		nev = ""+st2[0]+" "+st2[1];
		hianyzas = st2[2];
	}
	
	public void kiir() {
		System.out.println(honap + " " + nap +" "+nev+" "+hianyzas);
	}

}
