import java.io.BufferedReader;

import java.io.File;

import java.io.IOException;

import java.io.InputStreamReader;

public class Ejemplos {

    public static void main (String[] args) throws IOException {

        //System.out.println("Introduce un directorio:");

        //String ent = new BufferedReader(new InputStreamReader(System.in)).readLine();

        File f = File.listRoots()[0];

        System.out.println("Lista de ficheros y directorios del directorio root: ");

        System.out.println("---------------------------------------------------");

        for (String e : f.list()) {

            System.out.println(e);

        }
    }
}

