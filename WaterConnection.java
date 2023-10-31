import java.util.ArrayList;
import java.util.Scanner;

public class WaterConnection {

    public static ArrayList<ArrayList<Integer>> waterConnection(int houses[][]) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<houses.length;i++) {
            if(houses[i][0] == 0 && houses[i][1] != -1) {
                int min_d = houses[i][2];
                int curr = i;
                while(houses[curr][1] != -1) {
                    curr = houses[curr][1];
                    if(houses[curr][1] != -1 && houses[curr][2] < min_d) {
                        min_d = houses[curr][2];
                    }
                }
                ArrayList<Integer> pom = new ArrayList<>();
                pom.add(i); //rezervoar
                pom.add(curr); //cheshma
                pom.add(min_d);
                res.add(pom);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int houses[][] = new int[n][3];

        for(int i=0;i<n;i++) {
            houses[i][0] = 0; //dali ima vlezna cevka
            houses[i][1] = -1; //kon koja kukja ima izlezna cevka
            houses[i][2] = 0; //dijametar na izlezna cevka
        }

        for(int i=0;i<p;i++) {
            int pocetnaKukja = sc.nextInt();
            int krajnaKukja = sc.nextInt();
            int dijametar = sc.nextInt();

            houses[pocetnaKukja][1] = krajnaKukja;
            houses[pocetnaKukja][2] = dijametar;
            houses[krajnaKukja][0] = 1;
        }

        ArrayList<ArrayList<Integer>> res = waterConnection(houses);
        for(int i=0;i<res.size();i++) {
            for(int j=0;j<res.get(i).size();j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
