import java.util.Scanner;

public class ChessBruteForce {

    public static int func(int n) {
        int res = 0;
        for(int x1=0;x1<n;x1++) {
            for(int y1=0;y1<n;y1++) {
                for(int x2=0;x2<n;x2++) {
                    for(int y2=0;y2<n;y2++) {
                        if(x1!=x2 && y1!=y2 && Math.abs(x1 - x2) != Math.abs(y1 - y2)) {
                            res++;
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println(func(n));
    }
}
