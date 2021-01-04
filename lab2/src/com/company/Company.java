package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Company implements Iterable<Worker>
{
    private final ArrayList<Worker> workers = new ArrayList<>();

    public void AddWorker(Worker p)
    {
        workers.add(p);
    }

    public int WorkersCount()
    {
        return workers.size();
    }

    public void ShowWorkers()
    {
        workers.forEach(System.out::println);
    }

    public double AverageSalary()
    {
        var sum = new AtomicReference<>(0d);

        workers.forEach(p -> sum.updateAndGet(z -> z + p.GetSalary()));

        return  Math.round((sum.get() / workers.size()) * 100.0) / 100.0;
    }

    public double AverageSalary(Position s)
    {
        AtomicReference<Double> sum = new AtomicReference<>(0d);
        AtomicInteger count = new AtomicInteger();

        this.iterator(s).forEachRemaining(p -> {
            sum.updateAndGet(v -> v + p.GetSalary());
            count.getAndIncrement();
        });

        return Math.round((sum.get() / count.get()) * 100.0) / 100.0;
    }

    public Iterator<Worker> iterator(Position position)
    {
        return new Iterator<>()
        {
            final Iterator<Worker> worker = workers
                    .stream()
                    .filter(x -> x.GetPosition() == position)
                    .iterator();

            @Override
            public boolean hasNext()
            {
                return worker.hasNext();
            }

            @Override
            public Worker next()
            {
                return worker.next();
            }
        };
    }

    @Override
    public Iterator<Worker> iterator()
    {
        return new Iterator<>()
        {
            final Iterator<Worker> worker = workers.iterator();

            @Override
            public boolean hasNext()
            {
                return worker.hasNext();
            }

            @Override
            public Worker next()
            {
                return worker.next();
            }
        };
    }
}
