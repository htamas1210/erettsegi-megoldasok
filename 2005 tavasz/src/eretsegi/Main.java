package eretsegi;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader lotto_num = new FileReader("lottosz.dat");
            Scanner sc = new Scanner(lotto_num);
            Scanner szam_user = new Scanner(System.in);

            int[][] lotto_file = new int[51][5];
            int[] lotto = new int[255];
            int h = 0;

            // adatok tombbe beolvasasa
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] split = line.split(" ");
                int k = 0;
                while (k < 5 && h < 255) {
                    lotto[h] = Integer.parseInt(split[k]);
                    h++;
                    k++;
                }
            }

            int m = 0;

            for (int l = 0; l < 51; l++) {
                for (int n = 0; n < 5; n++) {
                    lotto_file[l][n] = lotto[m];
                    m++;
                }

            }

            // 1.feladat
            System.out.println("1.feladat");

            int[] lotto_szamok = new int[5];

            for (int i = 0; i < lotto_szamok.length; i++) {
                System.out.println("Adja meg a kovetkezo szamot");
                int num = szam_user.nextInt();

                if (num > 99 || num < 1) {
                    System.out.println("Tul nagy vagy tul kicsi a szam!");
                    num = szam_user.nextInt();
                    lotto_szamok[i] = num;
                } else
                    lotto_szamok[i] = num;
            }
            System.out.println();

            // 2.feladat
            System.out.println("2.feladat");

            for (int i = 0; i < lotto_szamok.length; i++) {
                for (int j = i + 1; j < lotto_szamok.length; j++) {
                    if (lotto_szamok[i] > lotto_szamok[j]) {
                        int csere = lotto_szamok[i];
                        lotto_szamok[i] = lotto_szamok[j];
                        lotto_szamok[j] = csere;
                    }

                }
            }

            for (int i = 0; i < lotto_szamok.length; i++) {
                System.out.print(lotto_szamok[i] + " ");
            }
            System.out.println();
            System.out.println();

            // 3.feladat
            System.out.println("3.feladat");
            System.out.println("Adjon meg egy szamot");
            int keres = szam_user.nextInt();
            System.out.println();

        } catch (IOException e) {
            System.err.println("Valami hiba tortent!");
        }

    }
}
