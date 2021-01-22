package droid;

public class Soldier extends Droid {

    public Soldier(String name) {
        setName(name);
        setDamage(30);
        setHp(100);
        setMaxhp(100);
        setAccuracy(70);
        setCrit(20);
        setCritdamage(45);
        setType("Soldier");
        setAttacks(0);
    }

    @Override
    public void ultimateAbility3v3(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {
        this.setAccuracy(100);
        ally1.setAccuracy(100);
        ally2.setAccuracy(100);
        this.setCrit(40);
        ally1.setCrit(ally1.getCrit() * 2);
        ally2.setCrit(ally2.getCrit() * 2);
        this.setAttacks(0);
        System.out.println(this.getType() + " " + this.getName() + " used his Ultimate Ability!" +
                " Now all of his team's accuracy is 100, and crit chance is doubled!");
    }

    @Override
    public void ultimateAbility1v1(Droid reciever) {
        this.setAccuracy(100);
        this.setCrit(50);
        reciever.setAccuracy(50);
        this.setAttacks(0);
        System.out.println(this.getType() + " " + this.getName() + " used his Ultimate Ability!" +
                " Now his accuracy is 100, his crit chance is 50% and his opponent's accuracy is 50!");
    }
}
