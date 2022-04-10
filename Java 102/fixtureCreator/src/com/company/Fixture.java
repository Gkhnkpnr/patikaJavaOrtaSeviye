package com.company;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fixture {
    public List<List<Match>> getFixtures(List<String> teams) {
        int teamNumber = teams.size();
        if (teamNumber % 2 != 0) {
            teamNumber++;
            teams.add("Bay");
        }

        Collections.shuffle(teams);

        int totalRounds = teamNumber - 1;
        int matchesPerRound = teamNumber / 2;
        List<List<Match>> rounds = new LinkedList<>();
        for (int round = 0; round < totalRounds; round++) {
            List<Match> matches = new LinkedList<>();
            for (int match = 0; match < matchesPerRound; match++) {
                int home = (round + match) % (teamNumber - 1);
                int away = (teamNumber - 1 - match + round) % (teamNumber - 1);
                if (match == 0) {
                    away = teamNumber - 1;
                }
                matches.add(new Match(teams.get(home), teams.get(away)));
            }
            rounds.add(matches);
        }

        for (int roundNumber = 0; roundNumber < rounds.size(); roundNumber++) {
            if (roundNumber % 2 == 1) {
                Match match = rounds.get(roundNumber).get(0);
                rounds.get(roundNumber).set(0, new Match(match.getAwayTeam(), match.getHomeTeam()));
            }
        }

        List<List<Match>> reverseFixtures = new LinkedList<>();
        for (List<Match> round : rounds) {
            List<Match> reverseRound = new LinkedList<>();
            for (Match match : round) {
                reverseRound.add(new Match(match.getAwayTeam(), match.getHomeTeam()));
            }
            reverseFixtures.add(reverseRound);
        }
        rounds.addAll(reverseFixtures);
        return rounds;
    }

    public void print(List<List<Match>> all) {
        int count = 1;
        for (List<Match> round : all) {
            System.out.println("----" + count + ". Round ----");
            count++;
            for (Match match : round) {
                System.out.println(match.getHomeTeam() + " - " + match.getAwayTeam());
            }
        }
    }
}
