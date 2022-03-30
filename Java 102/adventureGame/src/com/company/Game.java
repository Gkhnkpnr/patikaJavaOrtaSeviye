package com.company;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome to Game");
        System.out.print("Please Enter your Name : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Welcome " + player.getName());
        System.out.println("Please Choose Your Character");
        player.selectChar();
        Location location = null;
        while(true){
            player.printInfo();
            Location[] locationList ={new SafeHouse(player),new Merchant(player),new Cave(player),new Forest(player),new River(player)};
            System.out.println("Locations");
            System.out.println("---------------------------------");
            for (Location locations :
                    locationList) {
                System.out.println(locations.getId() + " "+ locations.getName());
            }
            System.out.println("0- Quit Game");
            System.out.println("---------------------------------");
            System.out.print("Please Enter Location Id to Go : ");
            int selectLocation = input.nextInt();
            switch (selectLocation){
                case 0:
                    location =null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Merchant(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location =  new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    System.out.println("As a Default Place you are in Safe House");
            }
            if (location == null){
                System.out.println("Game Over.");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
        }
    }
}
