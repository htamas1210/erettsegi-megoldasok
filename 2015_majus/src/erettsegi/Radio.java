package erettsegi;

public class Radio {
	public int nap_i;
	public int vevo_i;
	public String uzenet;	
	
	public Radio(String nap_vevo, String uzenet) {
		String[] st = nap_vevo.split(" ");
		nap_i = Integer.parseInt(st[0]);
		vevo_i = Integer.parseInt(st[1]);
		this.uzenet = uzenet;
	}

	public void kiir() {
		System.out.println(nap_i + " " + vevo_i + " " + uzenet);
	}
	
}
