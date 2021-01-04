package com.company;

public enum Position
{
    CEO("CEO", 1, "Executive activity"),
    CTO("CTO", 2, "Technical activity"),
    Manager("Manager", 3, "Management activity"),
    Accountant("Accountant", 4, "Accountant activity"),
    Worker("Worker", 5, "Physical activity");

    private final String _positionName;
    private final int _hierarchyLevel;
    private final String _description;

    Position(String positionName, int hierarchyLevel, String description)
    {
        _positionName = positionName;
        _hierarchyLevel = hierarchyLevel;
        _description = description;
    }


    @Override
    public String toString()
    {
        return String.format("\n\tPosition name: %s \n\tHierarchy level: %s \n\tDescription: %s"
                , _positionName, _hierarchyLevel, _description);
    }
}
