package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Zadanie1 {

    private int _n;

    public Zadanie1(int n)
    {
        _n = n;
    }

    private static void ArrayTime(int n)
    {
        long startTime = System.nanoTime();

        int array[] = new int[n];

        for (int i = 0; i < n; i++)
        {
            array[i] = i;
        }

        long stopTime = System.nanoTime() - startTime;

        System.out.println("Array time: " + stopTime);
    }

    private static void ArrayListTime(int n)
    {
        long startTime = System.nanoTime();

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < n; i++)
        {
            arrayList.add(i);
        }

        long stopTime = System.nanoTime() - startTime;

        System.out.println("ArrayList time: " + stopTime);
    }

    private static void ArrayListWithGivenSize(int n)
    {
        long startTime = System.nanoTime();

        ArrayList<Integer> arrayListWithGivenSize = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++)
        {
            arrayListWithGivenSize.add(i);
        }

        long stopTime = System.nanoTime() - startTime;

        System.out.println("ArrayListWithGivenSize time: " + stopTime);
    }

    private static void LinkedListTime(int n)
    {
        long startTime = System.nanoTime();

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < n; i++)
        {
            linkedList.add(i);
        }

        long stopTime = System.nanoTime() - startTime;

        System.out.println("LinkedList time: " + stopTime);
    }

    public void ShowTimesForEx1()
    {
        ArrayTime(_n);
        ArrayListTime(_n);
        ArrayListWithGivenSize(_n);
        LinkedListTime(_n);
    }
}
