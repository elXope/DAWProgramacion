package AceptaElReto;

import java.util.Scanner;

public class P614 {
    public static void main(String[] args) {
        Scanner lec = new Scanner(System.in);
        final int T = lec.nextInt();
        final int E = lec.nextInt();
        int[] pos = new int[E];
        for (int i = 0; i < E; i++) {
            pos[i] = lec.nextInt();
        }
        long sum = 0;
        if(T%2 == 0 && E%2 != 0) {
            int ct = E/2 - T/2;
            int ft = E/2 + T/2;
            if (pos[ct] > pos[ft]) ft--;
            else ct++;
            sum = calcula(ct, ft, pos);
        } else if(E%2 == 0 && T%2 != 0) {
            int ct = E/2 - (T/2 + 1);
            int ft = E/2 + T/2;
            if (pos[ct] > pos[ft]) ft--;
            else ct++;
            sum = calcula(ct, ft, pos);
        } else {
            int ct = E/2 - T/2;
            int ft = E/2 + T/2;
            sum = calcula(ct, ft, pos);
        }
        System.out.println(sum);
    }

    public static long calcula(int ct, int ft, int[] pos){
        long sum = 0;
        for(int i = 0; i < ct; i++){
            sum += pos[i] * (ct - i);
        }
        for(int i = ft + 1; i < pos.length; i++){
            sum += pos[i] * (i - ft);
        }
        return sum;
    }    
}
