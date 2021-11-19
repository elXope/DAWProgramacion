package AceptaElReto;

import java.util.ArrayList;
import java.util.Scanner;

public class P614 {
    public static void main(String[] args) {
        Scanner lec = new Scanner(System.in);
        ArrayList<Integer> output = new ArrayList<>();
        int T, E, ct, ft;
        int[] pos;
        while(true){
            T = lec.nextInt();
            E = lec.nextInt();
            if (T == 0 && E == 0) break;
            pos = new int[E];
            for (int i = 0; i < E; i++) {
                pos[i] = lec.nextInt();
            }
            ct = E/2 - T/2;
            ft = E/2 + T/2;
            if(E%2 == 0 && T%2 == 0) ft --;
            if(E%2 != 0 || T%2 != 0){
                if(T%2 != 0){
                    ct--;
                }
                if (pos[ct] > pos[ft]) ft--;
                else ct++;
            }
            output.add(calcula(ct, ft, pos));
        }
        lec.close();

        for(int i = 0; i < output.size(); i++){
            System.out.println(output.get(i));
        }
    }

    public static int calcula(int ct, int ft, int[] pos){
        int sum = 0;
        for(int i = 0; i < ct; i++){
            sum += pos[i] * (ct - i);
        }
        for(int i = ft + 1; i < pos.length; i++){
            sum += pos[i] * (i - ft);
        }
        return sum;
    }
}