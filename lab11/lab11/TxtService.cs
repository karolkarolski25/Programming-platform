using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace lab11
{
    public static class TxtService
    {
        private static Dictionary<string, int> words = new Dictionary<string, int>();

        private static void ReadData(string path)
        {
            using (FileStream fs = File.Open(path, FileMode.Open, FileAccess.Read, FileShare.ReadWrite))
            {
                using (BufferedStream bs = new BufferedStream(fs))
                {
                    using (StreamReader sr = new StreamReader(bs))
                    {
                        string line;

                        while ((line = sr.ReadLine()) != null)
                        {
                            foreach (var word in line
                                .Where(s => !char.IsPunctuation(s))
                                .Aggregate("", (s, c) => s + c)
                                .Split(' ')
                                .Where(w => w.Length > 2)
                                .Select(w => w.ToLower()))
                            {
                                if (words.ContainsKey(word))
                                {
                                    words[word]++;
                                }
                                else
                                {
                                    words[word] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        public static void MostFrequent(string path)
        {
            if (File.Exists(path))
            {
                ReadData(path);

                foreach (var word in words.OrderByDescending(d => d.Value).Take(20))
                {
                    Console.WriteLine($"{word.Key} - {word.Value}");
                }

                Console.WriteLine();
            }
            else
            {
                Console.WriteLine("Cannot find file");
            }

        }
    }
}
