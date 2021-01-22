package droid;

public class Healer extends Droid {

    public Healer(String name) {
        setName(name);
        setDamage(10);
        setHp(60);
        setMaxhp(100);
        setAccuracy(70);
        setCrit(25);
        setCritdamage(30);
        setType("Healer");
        setAttacks(0);
    }

    @Override
    public void healing(Droid reciever) {
        reciever.setHp(reciever.getHp() + 30);
        if (reciever.getHp() > reciever.getMaxhp())
            reciever.setHp(reciever.getMaxhp());
        this.setAttacks(getAttacks() + 1);
        System.out.println(reciever.getType() + " " + reciever.getName() + " was healed! Now his HP is " + reciever.getHp());
    }

    @Override
    public void ultimateAbility3v3(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {
        healReciever.setHp(healReciever.getHp() + 100);
        if(healReciever.getHp() > healReciever.getMaxhp()) {
            healReciever.setHp(healReciever.getMaxhp());
        }
        this.setAttacks(0);
        System.out.println(this.getType() + " " + this.getName() + " used his Ultimate Ability! " +
                "Now " + healReciever.getType() + " " + healReciever.getName() + "'s" + " HP is " + healReciever.getHp());
    }

    @Override
    public void ultimateAbility1v1(Droid reciever) {
        this.setHp(this.getMaxhp());
        this.setAttacks(0);
        System.out.println(this.getType() + " " + this.getName() + " used his Ultimate Ability! " +
                "Now his HP is " + this.getHp());
    }
}
