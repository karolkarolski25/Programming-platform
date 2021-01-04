package com.company;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Zadanie2
{
    public void CalculateFactorial(int n)
    {
        long startTime = System.nanoTime();

        BigInteger factorialResult = BigInteger.ONE;

        for (int i = 1; i <= n; i++)
        {
            factorialResult = factorialResult.multiply(BigInteger.valueOf(i));
        }

        long stopTime = System.nanoTime() - startTime;

        NumberFormat formatter = new DecimalFormat("0.######E0", DecimalFormatSymbols.getInstance(Locale.ROOT));
        String scientificNotation = formatter.format(factorialResult);

        System.out.println("Factorial result: " + scientificNotation);

        System.out.println("Time for calculating factorial: " + stopTime);
    }
}
