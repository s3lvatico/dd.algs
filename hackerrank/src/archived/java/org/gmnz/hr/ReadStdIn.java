package org.gmnz.hr;


import java.util.Scanner;


/**
 * ReadStdIn
 */
public class ReadStdIn {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        String line = s.nextLine();

        System.out.println("line read : <" + line + ">");

        s.close();
    }
}