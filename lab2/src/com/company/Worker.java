package com.company;

public class Worker extends Person
{
    private Position _position;
    private double _salary;

    public Worker(String firstName, String lastName, Position position, double salary)
    {
        super(firstName, lastName);

        _position = position;
        _salary = salary;
    }

    public double GetSalary()
    {
        return _salary;
    }

    public Position GetPosition()
    {
        return _position;
    }

    @Override
    public String toString()
    {
        return String.format("%sPosition: %s\nSalary: %s zł\n\n", super.toString(), _position, _salary);
    }
}
