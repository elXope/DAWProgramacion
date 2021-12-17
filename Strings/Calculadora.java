package Strings;

import java.util.Scanner;

public class Calculadora {
    String input;
    char tipoOperacio;
    String[] numeros;
    double ans;
    Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        while(true){
            calc.lligEntrada();
            if(calc.input.equalsIgnoreCase("fin")) break;
            calc.extrauInfo();
            if(!calc.validar()) {
                System.out.println("Operació no vàlida.");
                continue;
            }
            calc.fesOperacio();
        }
        calc.lector.close();
    }

    private void lligEntrada() {
        System.out.println("Introduix la operació:");
        this.input = lector.nextLine();
        this.input = this.input.replace(" ","");
    }

    private void extrauInfo() {
        if(this.input.contains("+")){
            this.numeros = this.input.split("\\+");
            this.tipoOperacio = '+';
        }else if(this.input.contains("-")){
            this.numeros = this.input.split("-");
            this.tipoOperacio = '-';
        }else if(this.input.contains("x")){
            this.numeros = this.input.split("x");
            this.tipoOperacio = '*';
        }else if(this.input.contains("X")){
            this.numeros = this.input.split("X");
            this.tipoOperacio = '*';
        }else if(this.input.contains("/")){
            this.numeros = this.input.split("\\/");
            this.tipoOperacio = '/';
        }
    }

    private boolean validar() {
        if (this.tipoOperacio != '+' && this.tipoOperacio != '-' && this.tipoOperacio != '*' && this.tipoOperacio != '/') return false;

        if (!validarNumero(this.numeros[0])) return false;
        if (!validarNumero(this.numeros[1])) return false;

        return true;
    }

    private boolean validarNumero(String numero) {
        for (int i = 0; i < numero.length(); i++) {
            if (numero.charAt(i) != 46){
                if (numero.charAt(i) < 48 || numero.charAt(i) > 57) {
                    return false;
                }
            }
        }
        return true;
    }

    private void fesOperacio() {
        if(this.tipoOperacio == '+'){
            this.ans = Double.parseDouble(this.numeros[0]) + Double.parseDouble(this.numeros[1]);
        }else if(this.tipoOperacio == '-'){
            this.ans = Double.parseDouble(this.numeros[0]) - Double.parseDouble(this.numeros[1]);
        }else if(this.tipoOperacio == '*'){
            this.ans = Double.parseDouble(this.numeros[0]) * Double.parseDouble(this.numeros[1]);
        }else if(this.tipoOperacio == '/'){
            this.ans = Double.parseDouble(this.numeros[0]) / Double.parseDouble(this.numeros[1]);
        }
        System.out.println("= " + this.ans);
    }
}