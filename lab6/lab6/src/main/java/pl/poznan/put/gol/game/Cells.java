package pl.poznan.put.gol.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Cells implements Iterable<Cell> {

	protected HashSet<Cell> cells;

	public Cells(Cell... cells) {
		this.cells = new HashSet<>(Arrays.asList(cells));
	}

	public Cells() {
		this.cells = new HashSet<>();
	}

	public Cells getNeighbors() {
            Cells neighboors = new Cells();
                        
            cells.forEach(x -> neighboors.addAll(x.neighbors()));
            
            return neighboors;
	}

	public boolean isEmpty() {
		return cells.isEmpty();
	}

	public int size() {
		return cells.size();
	}

	public void add(Cell cell) {
		if (cells.contains(cell)) {
			return;
		}
		cells.add(cell);
	}

	public void addAll(Iterable<? extends Cell> cells) {
		cells.forEach((cell) -> {
			add(cell);
		});
	}

	@Override
	public Iterator<Cell> iterator() {
		return cells.iterator();
	}

	public boolean contains(Cell cell) {
		return cells.contains(cell);
	}

	public void remove(Cell cell) {
		cells.remove(cell);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cells)) {
			return false;
		}
		Cells other = (Cells) obj;
		if (!cells.stream().noneMatch((cell) -> (!other.contains(cell)))) {
			return false;
		}
		if (!other.cells.stream().noneMatch((cell) -> (!contains(cell)))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return cells.toString();
	}

}
