package com.company;

public class Armor {
    private int id;
    private String name;
    private int damageReduction;
    private int price;

    public Armor(int id, String name, int damageReduction, int price) {
        this.id = id;
        this.name = name;
        this.damageReduction = damageReduction;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1,"Light",1,15);
        armorList[1] = new Armor(2,"Half Plate",3,25);
        armorList[2] = new Armor(3,"Heavy",5,40);
        return armorList;
    }

    public static Armor getArmorObjectById(int id){
        for (Armor a : Armor.armors()){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
