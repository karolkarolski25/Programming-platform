package com.company;

public class Main
{
    public static void main(String[] args)
    {
        Company firma = new Company();

        System.out.println("\nZadanie 1: \n\n");
        System.out.println(new Person("Jan", "Kowalski").toString());

        System.out.println("\nZadanie 2: \n\n");
        System.out.println(new Worker("Jan", "Kowalski", Position.CEO, 8500));

        System.out.println("Zadamoe 3: \n");
        System.out.println(Position.CEO.toString());
        System.out.println(Position.CTO.toString());
        System.out.println(Position.Manager.toString());
        System.out.println(Position.Accountant.toString());
        System.out.println(Position.Worker.toString());

        System.out.println("\n\nZadanie 4: \n");

        firma.AddWorker(new Worker("Jan", "Kowalski", Position.CEO, 8000));
        firma.AddWorker(new Worker("Serafina", "Wysocka", Position.CTO, 5000));
        firma.AddWorker(new Worker("Fryderyk", "Jaworski", Position.CTO, 5000));
        firma.AddWorker(new Worker("Julita", "Czerwinska", Position.Manager, 3750));
        firma.AddWorker(new Worker("Damian", "Rosiak", Position.Accountant, 4000));
        firma.AddWorker(new Worker("Grzegorz", "Matczak", Position.Manager, 5500));
        firma.AddWorker(new Worker("Wojciech", "Mazurowski", Position.Worker, 2684));
        firma.AddWorker(new Worker("Karol", "Zarębski", Position.CEO, 8500));
        firma.AddWorker(new Worker("Patryk", "Cieślak", Position.CTO, 7465));

        System.out.println("\nLiczba pracownikow: " + firma.WorkersCount() + "\n");

        firma.ShowWorkers();

        System.out.println("Zadanie 5 (Wszyscy pracownicy (własny iterator)): \n\n");

        for (Worker p : firma)
        {
            System.out.println(p.toString());
        }

        System.out.println("Zadanie 6 (Tylko CEO): \n\n");

        firma.iterator(Position.CEO).forEachRemaining(System.out::println);

        System.out.println("Zadanie 7: \n\n");
        System.out.println("Średnia całkowita: " + firma.AverageSalary() + " zł\n");
        System.out.println("Średnia dla CEO " + firma.AverageSalary(Position.CEO) + " zł\n");
    }
}

