public class EsTriangulo {
    public static boolean esTriangulo(int a, int b, int c){
        return (a + b > c) && (a + c > b) && (c + b > a);
    }
}
