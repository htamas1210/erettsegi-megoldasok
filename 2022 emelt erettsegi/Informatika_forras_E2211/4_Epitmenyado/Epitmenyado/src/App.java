import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
    static short[] ado = new short[3];

    public static int ado(String adosav, int negyzetmeter){
        int penz = 0;
        if(adosav.equals("A") || adosav.equals("a")){
            penz = negyzetmeter * ado[0];
        }else if(adosav.equals("B") || adosav.equals("b")){
            penz = negyzetmeter * ado[1];
        }else if(adosav.equals("C") || adosav.equals("c")){
            penz = negyzetmeter * ado[2];
        }

        if(penz < 10000) penz = 0;

        return penz;
    }

    public static void main(String[] args){
        try {
            FileReader fr = new FileReader("src/utca.txt"); 
            Scanner sc = new Scanner(fr);    

            Haz[] haz = new Haz[1000];
            short index = -1;

            String ado_s = sc.nextLine();         
            String[] sp = ado_s.split(" ");
            ado[0] = Short.parseShort(sp[0]); 
            ado[1] = Short.parseShort(sp[1]);
            ado[2] = Short.parseShort(sp[2]);
            
            while(sc.hasNextLine()){
                String in = sc.nextLine();
                sp = in.split(" ");
                haz[++index] = new Haz(Integer.parseInt(sp[0]), sp[1], sp[2], sp[3], Integer.parseInt(sp[4]));
            }
            sc.close();
            fr.close();
            
            //2.f
            System.out.println("2f:");
            System.out.println((index+1) + " db sor van");

            //3.f
            System.out.println("3.f");
            Scanner sc2 = new Scanner(System.in);
            System.out.print("Adja meg az adoszamot: ");
            int user_in = Integer.parseInt(sc2.nextLine());
            sc2.close();

            for (int i = 0; i < haz.length; i++) {
                if(haz[i].getAdoszam() == user_in){
                    System.out.println();
                    haz[i].kiir();
                    break;
                }
            }          
        } catch (IOException e) {
            System.err.println("A fajl nem talalhato!!");
        }catch (Exception e){
            System.err.println("Hiba!!");
            e.printStackTrace();
        }
        
    }
}
