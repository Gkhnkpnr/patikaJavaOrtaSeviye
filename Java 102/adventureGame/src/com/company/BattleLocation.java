package com.company;

import java.util.Random;

public abstract class BattleLocation extends Location {
    private Enemy enemy;
    private String reward;
    private int maxEnemy;

    public BattleLocation(int id, Player player, String name, Enemy enemy, String reward, int maxEnemy) {
        super(id, player, name);
        this.enemy = enemy;
        this.reward = reward;
        this.maxEnemy = maxEnemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Override
    public boolean onLocation() {
        int enemyNumber = this.randomEnemyNumber();
        System.out.println("You are here right now : " + this.getName());
        System.out.println("Be careful there are " + enemyNumber + " " + this.getEnemy().getName() + " Live here!!");
        System.out.println("Do You want to <F>ight or <R>un");
        String selectAction = input.nextLine();
        selectAction = selectAction.toUpperCase();
        if (selectAction.equals("F")) {
            if (combat(enemyNumber)){
                System.out.println(this.getName() + " defeat all enemies.");
                return true;
            }
        }

        if (this.getPlayer().getHealth() <= 0){
            System.out.println("You Died");
            return false;
        }

        return true;
    }

    public boolean combat(int enemyNumber) {
        for (int i = 1; i <= enemyNumber; i++) {
            this.getEnemy().setHealth(this.getEnemy().getOrginalHealth());
            playerStats();
            enemyStats();
            while(this.getPlayer().getHealth() > 0 && this.getEnemy().getHealth() > 0){
                System.out.println("<F>ight or <R>un");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("F")){
                    System.out.println("You Hit to Enemy");
                    this.getEnemy().setHealth(this.getEnemy().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getEnemy().getHealth() > 0){
                        System.out.println();
                        System.out.println("Monster Hit You !");
                        int enemyDamage = this.getEnemy().getDamage() - this.getPlayer().getInventory().getArmor().getDamageReduction();
                        if (enemyDamage < 0){
                            enemyDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - enemyDamage);
                        afterHit();
                    }
                }else{
                    return false;
                }
            }

            if (this.getEnemy().getHealth() < this.getPlayer().getHealth()){
                System.out.println("You Win");
                System.out.println(this.getEnemy().getReward() + " para kazandiniz.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getEnemy().getReward());
                System.out.println("Current Money : " + this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Health : "+ this.getPlayer().getHealth());
        System.out.println(this.getEnemy().getName() + " Health : " + this.getEnemy().getHealth());
        System.out.println();
    }

    public void playerStats(){
        System.out.println("Player stats");
        System.out.println("------------------------");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Weapon : "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Armor : "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Armor Value : " + this.getPlayer().getInventory().getArmor().getDamageReduction());
        System.out.println("Money : " + this.getPlayer().getMoney());
    }

    public void enemyStats(){
        System.out.println(this.getEnemy().getName() + " Stats");
        System.out.println("------------------------");
        System.out.println("Health : " + this.getEnemy().getHealth());
        System.out.println("Damage : " + this.getEnemy().getDamage());
        System.out.println("Reward : " + this.getEnemy().getReward());
    }

    public int randomEnemyNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxEnemy()) + 1;
    }

    public int getMaxEnemy() {
        return maxEnemy;
    }

    public void setMaxEnemy(int maxEnemy) {
        this.maxEnemy = maxEnemy;
    }
}
