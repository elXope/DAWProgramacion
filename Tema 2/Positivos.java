public class Positivos {
    public static int positivos(double[] arr){
        int nPositivos = 0;
        for(double i : arr){
            if (i >= 0) {
                nPositivos++;
            }
        }
        return nPositivos;
    }
}
