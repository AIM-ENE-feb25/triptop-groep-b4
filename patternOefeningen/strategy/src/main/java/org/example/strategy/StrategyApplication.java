package org.example.strategy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StrategyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrategyApplication.class, args);
        Woordenlijst woordenlijst = new Woordenlijst();
        woordenlijst.setSorteerStrategie(new BubbleSort()); //Change for different sorting method
        System.out.println("Before: ");
        woordenlijst.print();
        woordenlijst.sorteer();
        System.out.println("After: ");
        woordenlijst.print();
    }

}
