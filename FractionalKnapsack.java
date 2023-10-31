import java.util.ArrayList;
import java.util.Scanner;

class KnapsackItem implements Comparable<KnapsackItem> {
    private int p;
    private int w;

    public KnapsackItem(int p, int w) {
        this.p = p;
        this.w = w;
    }

    public int getP() {
        return p;
    }

    public int getW() {
        return w;
    }

    @Override
    public int compareTo(KnapsackItem ki) {
        float odnos1 = (float) p / w;
        float odnos2 = (float) ki.getP() / ki.getW();
        return Float.compare(odnos1,odnos2);
    }
}

public class FractionalKnapsack {

    public static float maxProfit(int C, ArrayList<KnapsackItem> items) {
        items.sort((a,b) -> b.compareTo(a)); // opagjachki redosled

        float profit = 0;

        for(int i=0;i<items.size();i++) {
            if(C - items.get(i).getW() >= 0) {
                profit += items.get(i).getP();
                C-=items.get(i).getW();
            } else {
                profit += ((float) C / items.get(i).getW()) * items.get(i).getP();
                break;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();

        int n = sc.nextInt();

        ArrayList<KnapsackItem> items = new ArrayList<>();

        for(int i=0;i<n;i++) {
            items.add(new KnapsackItem(sc.nextInt(), sc.nextInt()));
        }

        System.out.println(maxProfit(C, items));

    }
}
