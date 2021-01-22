package droid;

import java.sql.SQLOutput;
import java.util.Random;

public class Droid {
    private String name;
    private int hp;
    private int damage;
    private boolean ultimate;
    private int accuracy;
    private int crit;
    private int critdamage;
    private String type;
    private int attacks;
    private int maxhp;
    private boolean dead;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isUltimate() {
        if(this.attacks >= 2)
            return true;
        else
            return false;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getCritdamage() {
        return critdamage;
    }

    public void setCritdamage(int critdamage) {
        this.critdamage = critdamage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttacks() {
        return attacks;
    }

    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }

    public boolean isDead() {
        if (this.getHp() < 1)
            return true;
        else
            return false;
    }

    public void damages (Droid reciever) {
        Random rand = new Random();
        if (rand.nextInt(100) < getAccuracy()) {
            if (rand.nextInt(100) < getCrit()) {
                reciever.setHp(reciever.getHp() - getCritdamage());
                setAttacks(getAttacks() + 1);
                System.out.println("Critical hit! "
                        + this.getName() + " damaged " + reciever.getName() + " for " + this.getCritdamage() + "HP!"
                        + reciever.getName() + "'s remaining HP is " + reciever.getHp() + "\n");
            }
            else {
                reciever.setHp(reciever.getHp() - getDamage());
                this.setAttacks(getAttacks() + 1);
                System.out.println("Hit! "
                        + this.getName() + " damaged " + reciever.getName() + " for " + this.getDamage() + "HP! "
                        + reciever.getName() + "'s remaining HP is " + reciever.getHp() + "\n");
            }
        }
        else {
            System.out.println("Miss! " + this.name + " didn't land a hit on his target! "
            + reciever.name + "'s remaining HP is " + reciever.getHp() + "\n");
        }
    }

    public void healing(Droid reciever) {

    }

    public void ultimateAbility1v1(Droid reciever) {

    }

    public void ultimateAbility3v3(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {

    }

}
