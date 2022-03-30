package com.company;

public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(1,player,"Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in Safe House !");
        System.out.println("Your health has replenished !");
        this.getPlayer().setHealth(this.getPlayer().getOrginalHealth());
        return true;

    }
}
