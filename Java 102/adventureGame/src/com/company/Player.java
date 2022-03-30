package com.company;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orginalHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        Job[] charList = {new Samurai(), new Ranger(), new Knight()};
        System.out.println("Characters");
        System.out.println("---------------------------------");
        for (Job gameChar : charList) {
            System.out.println(gameChar.getId() + "-" + gameChar.getJobName() + ": Damage: " + gameChar.getDamage() + " Health: " + gameChar.getHealth() + " Money: " + gameChar.getMoney());
        }
        System.out.println("---------------------------------");
        System.out.print("Please Enter You Character Id for Choose : ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                createChar(new Samurai());
                break;
            case 2:
                createChar(new Ranger());
                break;
            case 3:
                createChar(new Knight());
                break;
            default:
                System.out.println("Invalid Id Your Hero Created As a Samurai by Default");
                createChar(new Samurai());
        }
        System.out.println("Your Stats:");
        System.out.println("Job: " + this.getCharName() + " Damage: " + this.getDamage() + " Health : " + this.getHealth() + " Money: " + this.getMoney());
    }

    public void createChar(Job job) {
        this.setCharName(job.getJobName());
        this.setDamage(job.getDamage());
        this.setHealth(job.getHealth());
        this.setOrginalHealth(job.getHealth());
        this.setMoney(job.getMoney());
    }

    public void printInfo() {
        System.out.println("Your Current Armor : " + this.getInventory().getArmor().getName() +
                " Your Current Weapon : " + this.getInventory().getWeapon().getName() +
                " Damage Reduction : " + getInventory().getArmor().getDamageReduction() +
                " Damage : " + this.getTotalDamage() +
                " Health : " + this.getHealth() +
                " Money : " + this.getMoney());
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrginalHealth() {
        return orginalHealth;
    }

    public void setOrginalHealth(int orginalHealth) {
        this.orginalHealth = orginalHealth;
    }
}
