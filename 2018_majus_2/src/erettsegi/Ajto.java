package erettsegi;

public class Ajto {
	public int ora;
	public int perc;
	public int azon;
	public int ido_percbe;
	public String ajto_irany;
		
	public Ajto(String s) {
		String[] st = s.split("\\+");
		ora = Integer.parseInt(st[0]);
		perc = Integer.parseInt(st[1]);
		azon = Integer.parseInt(st[2]);
		ajto_irany = st[3];			
		ido_percbe = ora*60+perc;
	}
	
	public void kiir() {
		System.out.println(ora+" "+perc+" "+azon+" "+ajto_irany);
	}

}
