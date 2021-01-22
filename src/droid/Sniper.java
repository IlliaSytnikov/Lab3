package droid;

public class Sniper extends Droid {

    public Sniper(String name) {
        setName(name);
        setDamage(45);
        setHp(70);
        setMaxhp(70);
        setAccuracy(90);
        setCrit(35);
        setCritdamage(60);
        setType("Sniper");
        setAttacks(0);
    }

    @Override
    public void ultimateAbility3v3(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {
        damageReciever.setHp(damageReciever.getHp() - 100);
        this.setAttacks(0);
        System.out.println(this.getType() + " " + this.getName() + " used his Ultimate Ability! " +
                "Now HP of his target " + damageReciever.getType() + " " + damageReciever.getName() + " is " + damageReciever.getHp());
    }

    @Override
    public void ultimateAbility1v1(Droid reciever) {
        this.setHp(getHp() + 30);
        if(this.getHp() > this.getMaxhp())
            this.setHp(this.getMaxhp());
        reciever.setHp(reciever.getHp() - 30);
        this.setAttacks(0);
        System.out.println(this.getType() + " " + this.getName() + " used his Ultimate Ability! " +
                "Now his HP is " + this.getHp() + " and his opponent's HP is " + reciever.getHp());
    }
}
