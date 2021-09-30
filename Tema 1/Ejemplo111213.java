import java.util.Scanner;
import java.util.Arrays;

public class Ejemplo111213 {
    public static void main(String[] args) {        
        Scanner llig = new Scanner(System.in);
        System.out.println("Introduix la quantitat de números amb els que vols treballar: ");
        float[] nums = new float[llig.nextInt()];
        
        for(byte i = 0; i < nums.length; i++){
            System.out.println("Introduix un numero: ");
            nums[i] = llig.nextFloat();
            System.out.println("(" + (i + 1) + "/" + nums.length + ")\n");
        }
        Arrays.sort(nums);

        boolean seguir = true;
        while(seguir){

            System.out.println("Què vols fer amb els números?\n1 --> Ordenar de forma ascendent.\n2 --> Ordenar de forma descendent.\n3 --> Mostrar valor més gran.\n4 --> Mostrar valor més xicotet.\n5 --> Finalitzar programa.");

            switch(llig.nextInt()){
                case 1:
                    for(int i = 0; i < nums.length - 1; i++){
                        System.out.print(nums[i] + ", ");
                    }
                    System.out.print(nums[nums.length - 1] + ".\n\n");
                    break;

                case 2:
                    for(int i = nums.length - 1; i > 0; i--){
                        System.out.print(nums[i] + ", ");
                    }
                    System.out.print(nums[0] + ".\n\n");
                    break;

                case 3:
                    System.out.print(nums[nums.length - 1] + ".\n\n");
                    break;

                case 4:
                    System.out.print(nums[0] + ".\n\n");
                    break;
                    
                case 5:
                    seguir = false;
                    break;

                default:
                    System.out.println("El número introduït no és vàlid.\n");
                    break;
            }
        }
        System.out.println("Programa finalitzat.");

    }
}
