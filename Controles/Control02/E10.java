package Control02;

public class E10 {
    public static void main(String[] args) {
        double To = 6 + 273.15; //K
        System.out.println("Para una temperatura inicial de " + (To - 273.15) + "ºC tarda " + huevoALaCopa(To) + "segundos");
    }

    private static double huevoALaCopa(double To){
        final double M = 67; //g
        final double ro = 1.038; //gcm⁻³
        final double c = 3.7; //Jg⁻¹K⁻¹
        final double K = 5.4e-3; //Wcm⁻¹K⁻¹
        final double Tw = 373.15; //K
        final double Ty = 65 + 273.15; //K

        return (Math.pow(M,(double)2/3)*c*Math.pow(ro,(double)1/3))/(K*Math.pow(Math.PI,2)*Math.pow((4*Math.PI/3),(double)2/3))*Math.log(0.76*(To - Tw)/(Ty - Tw));
    }
}