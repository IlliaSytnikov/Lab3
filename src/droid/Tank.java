package droid;

public class Tank extends Droid {

    public Tank(String name) {
        setName(name);
        setDamage(10);
        setHp(200);
        setMaxhp(300);
        setAccuracy(80);
        setCrit(30);
        setCritdamage(30);
        setType("Tank");
        setAttacks(0);
    }

    @Override
    public void ultimateAbility3v3(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {
        this.setHp(this.getHp() + (this.getHp() / 2));
        if(this.getHp() > this.getMaxhp())
            this.setHp(this.getMaxhp());
        ally1.setHp(ally1.getHp() + (ally1.getHp() / 2));
        if(ally1.getHp() > ally1.getMaxhp())
            ally1.setHp(ally1.getMaxhp());
        ally2.setHp(ally2.getHp() + (ally2.getHp() / 2));
        if(ally2.getHp() > ally2.getMaxhp())
            ally2.setHp(ally2.getMaxhp());
        this.setAttacks(0);
        System.out.println(this.getType() + " " + this.getName() + " used his Ultimate Ability! " +
                "Now his HP is " + this.getHp() + ", " +
                ally1.getType() + " " + ally1.getName() + "'s HP is " + ally1.getHp() + ", " +
                ally2.getType() + " " + ally2.getName() + "'s HP is " + ally2.getHp() + ".");
    }

    @Override
    public void ultimateAbility1v1(Droid reciever) {
        this.setHp(this.getHp() + (this.getHp() / 2));
        if(this.getHp() > this.getMaxhp())
            this.setHp(this.getMaxhp());
        this.setAttacks(0);
        System.out.println(this.getType() + " " + this.getName() + " used his Ultimate Ability!" +
                " Now his HP is " + this.getHp());
    }
}
