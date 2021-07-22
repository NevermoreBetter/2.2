package com.company;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.io.IOException;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {
        String regular = "(//)+[a-z]*[F-K]+";
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\file.txt"))) {
            String line = br.readLine();
            while (line != null) {
                if (Pattern.matches(regular, line)) {
                    System.out.println(line);
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Input string: ");
        Automat automat = new Automat(in.nextLine());
        automat.scanner();
        switch (automat.getState()) {
            case Error:
                System.out.println("Result: false");
                break;
            case Success:
                System.out.println("Result: true");
                break;
            default:
                break;
        }
    }
}

