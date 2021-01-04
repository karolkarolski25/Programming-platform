package pl.poznan.put.gol.game;

public class ConwaysRules implements Rules {

    @Override
    public boolean inNextGeneration(boolean alive, int numberOfNeighbors) {

        if (!alive && numberOfNeighbors == 3) {
            return true;
        }

        if (alive && (numberOfNeighbors == 2 || numberOfNeighbors == 3)) {
            return true;
        }

        return false;
    }

}
