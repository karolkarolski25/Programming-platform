package com.company;

import java.util.Random;

public class Zadanie5
{
    private int _n;

    private int[] _randomArray;
    private int[] _ascArray;
    private int[] _descArray;

    public Zadanie5(int n)
    {
        _n = n;

        _ascArray = GetAscData(_n);
        _descArray = GetDescData(_n);
        _randomArray = GetRandomData(_n);
    }

    private int[] GetAscData(int n)
    {
        int[] array = new int[n];

        for(int i = 0; i < n; i++)
        {
            array[i] = i;
        }

        return array;
    }

    private int[] GetDescData(int n)
    {
        int[] array = new int[n];

        int arrayIndexer = 0;

        for (int i = n - 1; i >= 0; i--)
        {
            array[arrayIndexer++] = i;
        }

        return array;
    }

    private int[] GetRandomData(int n)
    {
        Random random = new Random();

        int[] array = new int[n];

        for (int i  = 0; i < n; i++)
        {
            array[i] = random.nextInt(n);
        }

        return array;
    }

    private long InsertionSort(int[] arr)
    {
        long startTime = System.nanoTime();

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        return System.nanoTime() - startTime;
    }

    private void Merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
        {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; ++j)
        {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }

            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private long MergeSort(int[] arr, int l, int r)
    {
        long startTime = System.nanoTime();

        if (l < r)
        {
            int m = (l + r) / 2;

            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);

            Merge(arr, l, m, r);
        }

        return System.nanoTime() - startTime;
    }

    public void RunSortingAlgorithmsForAllCases()
    {
        System.out.println("Insertion sort");
        System.out.println();
        System.out.println("desc -> asc " + InsertionSort(_descArray));
        System.out.println("asc -> asc " + InsertionSort(_ascArray));
        System.out.println("rand -> asc " + InsertionSort(_randomArray));

        System.out.println();

        System.out.println("Merge sort");
        System.out.println();
        System.out.println("desc -> asc " + MergeSort(_descArray, 0, _descArray.length - 1));
        System.out.println("asc -> asc " + MergeSort(_ascArray, 0,_ascArray.length - 1));
        System.out.println("rand -> asc " + MergeSort(_randomArray, 0, _randomArray.length - 1));
    }
}
