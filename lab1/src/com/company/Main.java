package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Zadanie 1");
        System.out.print("N: ");
        int n = scan.nextInt();
        Zadanie1 zad1 = new Zadanie1(n);
        zad1.ShowTimesForEx1();


        System.out.println("Zadanie 2");
        System.out.print("N: ");
        n = scan.nextInt();
        Zadanie2 zad2 = new Zadanie2();
        zad2.CalculateFactorial(n);


        System.out.println("Zadanie 3");
        Zadanie3 zad3 = new Zadanie3("src/macbeth.txt");
        System.out.println("Unique words: " + zad3.GetUniqueWordCount());


        System.out.println("Zadanie 4");
        Zadanie4 zad4 = new Zadanie4("src/macbeth.txt");
        zad4.GetMostFrequentWords();


        System.out.println("Zadanie 5");
        System.out.print("N: ");
        n = scan.nextInt();
        Zadanie5 zad5 = new Zadanie5(n);
        zad5.RunSortingAlgorithmsForAllCases();
    }
}
