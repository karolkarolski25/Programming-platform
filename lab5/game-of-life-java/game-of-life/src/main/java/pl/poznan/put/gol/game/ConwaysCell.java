package pl.poznan.put.gol.game;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.util.Objects;

public class ConwaysCell implements Cell {

    protected int i;
    protected int j;

    public ConwaysCell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public Cells neighbors() {
        Cells cells = new Cells();

        cells.add(new ConwaysCell(i - 1, j - 1));
        cells.add(new ConwaysCell(i - 1, j));
        cells.add(new ConwaysCell(i - 1, j + 1));
        cells.add(new ConwaysCell(i, j - 1));
        cells.add(new ConwaysCell(i, j + 1));
        cells.add(new ConwaysCell(i + 1, j - 1));
        cells.add(new ConwaysCell(i + 1, j));
        cells.add(new ConwaysCell(i + 1, j + 1));

        return cells;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        ConwaysCell tempCell = (ConwaysCell) obj;

        return i == tempCell.i && j == tempCell.j;
    }

    @Override
    public String toString() {
        return "c(" + i + ":" + j + ")";
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(i, j);
    }
}
