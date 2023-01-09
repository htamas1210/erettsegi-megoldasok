public class Haz {
    private final int adoszam;
    private final String utca;
    private final String hazszam;
    private final String adosav;
    private final int negyzetmeter;

    public Haz(int adoszam, String utca, String hazszam, String adosav, int negyzetmeter){
        this.adoszam = adoszam;
        this.utca = utca;
        this.hazszam = hazszam;
        this.adosav = adosav;
        this.negyzetmeter = negyzetmeter;
    }

    public void kiir(){
        System.out.println("Adoszam: " + adoszam + " Utca: " + utca + " Hazszam: " + hazszam + " Adosav: " + adosav + " Negyzetmeter: " + negyzetmeter);
    }

    public int getAdoszam(){
        return adoszam;
    }

    public String getAdosav(){
        return adosav;
    }

    public int getNegyzetmeter(){
        return negyzetmeter;
    }
}
