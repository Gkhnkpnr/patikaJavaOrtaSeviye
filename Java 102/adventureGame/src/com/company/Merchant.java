package com.company;

public class Merchant extends NormalLocation {
    public Merchant(Player player) {
        super(2, player, "Merchant");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to Merchant");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Buy Weapons");
            System.out.println("2- Buy Armors");
            System.out.println("3- Quit");
            System.out.print("What do you want to do :");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Invalid Operation Please Enter Valid Option : ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See You Soon !!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("Weapons");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() + " <Price : " + w.getPrice() + " Damage : " + w.getDamage() + " >");
        }
        System.out.println("0-Quit");
    }

    public void buyWeapon() {
        System.out.print("Choose a Weapon : ");
        int selectWeapon = input.nextInt();
        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length) {
            System.out.println("Invalid Operation Please Enter Valid Option : ");
            selectWeapon = input.nextInt();
        }

        if (selectWeapon != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjectById(selectWeapon);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Insufficient Fund");
                } else {
                    System.out.println(selectedWeapon.getName() + " Bought");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your Balance : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }

    }

    public void printArmor() {
        System.out.print("Choose a Armor : ");
        int selectArmor = input.nextInt();
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + "-" + a.getName() + "< Price : " + a.getPrice() + " Armor : " + a.getDamageReduction() + " >");
        }
    }

    public void buyArmor() {
        System.out.print("Choose a Armor : ");
        int selectArmor = input.nextInt();
        while (selectArmor < 0 || selectArmor > Armor.armors().length) {
            System.out.println("Invalid Operation Please Enter Valid Option : ");
            selectArmor = input.nextInt();
        }

        if (selectArmor != 0){
            Armor selectedArmor = Armor.getArmorObjectById(selectArmor);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Insufficient Fund");
                } else {
                    System.out.println(selectedArmor.getName() + " Bought");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your Balance : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }
}
