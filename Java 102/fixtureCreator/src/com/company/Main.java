package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Galatasaray");
        list.add("Bursaspor");
        list.add("Fenerbahce");
        list.add("Besiktas");
        list.add("Basaksehir");
        list.add("Trabzonspor");
        Fixture fixtureCreator = new Fixture();
        List<List<Match>> all = fixtureCreator.getFixtures(list);
        fixtureCreator.print(all);
    }
}
