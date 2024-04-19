import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random r = new Random();
        for (int i=0; i<1000; i++) {
            int zufall = r.nextInt(100) + 1;
            System.out.println(zufall);
        }


        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine(); // verarbeitet das Enterzeichen aus nextInt()
        String zeichen = sc.nextLine();

        System.out.println(x + " " + zeichen);

        int[][] arzttermine = new int[366][10];
        int[] tageMonat = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] monat = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        int countMonat = 0;
        int tageGesamt = 31;
        int tageproMonat = 0;

        for (int zeile = 0; zeile <= 365; zeile++){
            //System.out.println("MONAT: " + countMonat + " Zeile: " + zeile + "TageGesamt: " +tageGesamt);
            for (int spalte = 0; spalte <= 9; spalte++){
                if(zeile == 0 || zeile < tageGesamt) {
                    if(spalte==0){
                        arzttermine[zeile][spalte] = monat[countMonat];
                    }
                    else if(spalte == 1){
                        arzttermine[zeile][spalte] = tageproMonat = tageproMonat+1;
                    }
                    else{
                        Random random = new Random();
                        int zufall = random.nextInt(2);
                        arzttermine[zeile][spalte] = zufall;
                    }
                }
                else{
                    if(countMonat <= 10){
                       // System.out.println("ELSE");
                        tageproMonat=0;
                        tageGesamt += tageMonat[countMonat];
                        countMonat++;
                    }
                }
            }
        }


       /* for (int i = 0; i < arzttermine.length; i++) {
            for(int j = 0; j < arzttermine[i].length; j++) {
                System.out.print(arzttermine[i][j] + " ") ;
            }
            System.out.println("");
        }*/
    }
}