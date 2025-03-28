package org.example.strategy;

public class Woordenlijst {
    private String[] woorden = {"hond", "beer", "leeuw", "kat", "aap", "tijger", "olifant"};
    private ISorteerStrategie sorteerStrategie;

    public void print() {
        for (int i = 0; i < woorden.length; i++) {
            System.out.print(woorden[i] + " ");
        }
        System.out.println();
    }

    public void sorteer() {
        if (sorteerStrategie == null){
            throw new UnsupportedOperationException("Geen sorteerstrategie ingesteld");
        }
        sorteerStrategie.sorteer(woorden);
    }

    public void setSorteerStrategie(ISorteerStrategie strategie) {
        this.sorteerStrategie = strategie;
    }
}
