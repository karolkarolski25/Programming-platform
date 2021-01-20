using System;
using System.Diagnostics;
using System.Numerics;

namespace lab10
{
    public static class Factorial
    {
        public static void Start(int n)
        {
            Stopwatch stopwatch = new Stopwatch();

            stopwatch.Start();

            Console.WriteLine($"Factorial result: {CalculateFactorial(n).ToString("E")}");

            stopwatch.Stop();

            TimeSpan ts = stopwatch.Elapsed;

            string elapsedTime = string.Format("{0:00}:{1:00}:{2:00}.{3:00}",
            ts.Hours, ts.Minutes, ts.Seconds, ts.Milliseconds / 10);

            Console.WriteLine($"RunTime {elapsedTime} ms\n");
        }

        private static BigInteger CalculateFactorial(int n)
        {
            BigInteger sum = 1;

            while (n > 1)
            {
                sum = BigInteger.Multiply(n--, sum);
            }

            return sum;
        }
    }
}
