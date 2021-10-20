public class T1Ex1 {
    int a;
    char b;

    public static void main(String[] args) {
        T1Ex1 prova = new T1Ex1();
        prova.display();        
    }

    public void display(){
        System.out.println(this.a);
        System.out.println(this.b);
    }
}
