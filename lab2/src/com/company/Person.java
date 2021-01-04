package com.company;

public class Person
{
    private final String _firstName;
    private final String _lastName;

    public Person(String firstName, String lastName)
    {
        _firstName = firstName;
        _lastName = lastName;
    }

    @Override
    public String toString()
    {
        return String.format("First name: %s\nLast name: %s\n", _firstName, _lastName);
    }
}
