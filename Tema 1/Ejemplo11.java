import java.util.Scanner;
import java.util.Arrays;

public class Ejemplo11 {
    public static void main(String[] args) {        
        Scanner llig = new Scanner(System.in);
        System.out.println("Introduix quants numeros vols ordenar: ");
        float[] nums = new float[llig.nextInt()];
        
        for(byte i = 0; i < nums.length; i++){
            System.out.println("Introduix el numero: ");
            nums[i] = llig.nextFloat();
            System.out.println("(" + (i + 1) + "/" + nums.length + ")\n");
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++){
            System.out.print(nums[i] + ", ");
        }
        System.out.print(nums[nums.length - 1] + ".\n");

    }
}
