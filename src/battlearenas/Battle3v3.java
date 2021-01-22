package battlearenas;

import droid.*;

import java.util.Scanner;
import java.util.Random;

public class Battle3v3 {
    private static Droid droidA1;
    private static Droid droidA2;
    private static Droid droidA3;
    private static Droid droidB1;
    private static Droid droidB2;
    private static Droid droidB3;

    private static Droid attacker;
    private static Droid reciever;
    private static Droid ally1;
    private static Droid ally2;


    public static void setAttacker(Droid attacker) { Battle3v3.attacker = attacker; }

    public static void setReciever(Droid reciever) {
        Battle3v3.reciever = reciever;
    }

    public static void setAlly1(Droid ally1) {
        Battle3v3.ally1 = ally1;
    }

    public static void setAlly2(Droid ally2) {
        Battle3v3.ally2 = ally2;
    }


    public static void start(Scanner read) {
        droidA1 = createDroid('A', 1, read);
        read.nextLine();
        droidA2 = createDroid('A', 2, read);
        read.nextLine();
        droidA3 = createDroid('A', 3, read);
        read.nextLine();
        droidB1 = createDroid('B', 1, read);
        read.nextLine();
        droidB2 = createDroid('B', 2, read);
        read.nextLine();
        droidB3 = createDroid('B', 3, read);
        read.nextLine();

        startBattle(read);
    }

    public static void startBattle(Scanner read) {
        Random rand = new Random();
        System.out.println("Randomly choosing who is going to make their move first...");
        if (rand.nextInt(100) < 50) {
            System.out.println("Team A makes the first move!");
            while (true) {
                playerMove('A', droidA1, droidA2, droidA3, read);
                if(droidB1.isDead() && droidB2.isDead() && droidB3.isDead()) {
                    System.out.println("Player A wins!");
                    return;
                }

                playerMove('B', droidB1, droidB2, droidB3, read);
                if(droidA1.isDead() && droidA2.isDead() && droidA3.isDead()) {
                    System.out.println("Player B wins!");
                    return;
                }
            }
        }
        else {
            System.out.println("Team B makes the first move!");
            while (true) {
                playerMove('B', droidB1, droidB2, droidB3, read);
                if(droidA1.isDead() && droidA2.isDead() && droidA3.isDead()) {
                    System.out.println("Player B wins!");
                    return;
                }

                playerMove('A', droidA1, droidA2, droidA3, read);
                if(droidB1.isDead() && droidB2.isDead() && droidB3.isDead()) {
                    System.out.println("Player A wins!");
                    return;
                }
            }
        }
    }




    public static void playerMove(char player, Droid droid1, Droid droid2, Droid droid3, Scanner read) {

        System.out.println("\nPlayer " + player + " move!\n");

        System.out.println("Choose a droid you want to make a move:\n" +            //вибираємо атакуючого дроїда
                "1 - " + droid1.getType() + " " + droid1.getName() + " with " + droid1.getHp() + " HP left\n" +
                "2 - " + droid2.getType() + " " + droid2.getName() + " with " + droid2.getHp() + " HP left\n" +
                "3 - " + droid3.getType() + " " + droid3.getName() + " with " + droid3.getHp() + " HP left\n" +
                "->");
        int option = read.nextInt();
        switch (option) {
            case 1:
                if (droid1.isDead()) {
                    System.out.println("This droid is dead! Please choose another droid.");
                    playerMove(player, droid1, droid2, droid3, read);
                    return;
                }
                else {
                    setAttacker(droid1);
                    setAlly1(droid2);
                    setAlly2(droid3);
                }
                break;
            case 2:
                if(droid2.isDead()) {
                    System.out.println("This droid is dead! Please choose another droid.");
                    playerMove(player, droid1, droid2, droid3, read);
                    return;
                }
                else {
                    setAttacker(droid2);
                    setAlly1(droid1);
                    setAlly2(droid3);
                }
                break;
            case 3:
                if(droid3.isDead()) {
                    System.out.println("This droid is dead! Please choose another droid.");
                    playerMove(player, droid1, droid2, droid3, read);
                    return;
                }
                else {
                    setAttacker(droid3);
                    setAlly1(droid1);
                    setAlly2(droid2);
                }
                break;
            default:
                System.out.println("Error: wrong option. Please redo your move...\n");
                playerMove(player, droid1, droid2, droid3, read);
        }

        if(attacker.getType().equals("Healer")) {           // якщо дроїд - хіллер
            if (attacker.isUltimate()) {                     // якщо дроїд хіллер і в нього є ульт.
                moveHealerUltimate(player, read);
            }
            else {                                          // якщо дроїд хіллер і в нього немає ульт.
                moveHealer(player, read);
            }
        }

        else {                                              // якщо дроїд не хіллер
            if (attacker.isUltimate()) {                     // якщо дроїд хіллер і в нього є ульт.
                moveDroidUltimate(player, read);
            }
            else {                                          // якщо дроїд хіллер і в нього немає ульт.
                moveDroid(player, read);
            }
        }

    }

    public static void moveHealerUltimate(char player, Scanner read) {
        int option;
        System.out.println("Player " + player + ", choose an option:\n" +
                "1 - attack an opponent\n" +
                "2 - heal an ally\n" +
                "3 - use ultimate ability\n" +
                "->");
        option = read.nextInt();
        switch(option) {
            case 1:
                if(player == 'A') {
                    chooseAttackTarget(droidB1, droidB2, droidB3, read);
                }
                else {
                    chooseAttackTarget(droidA1, droidA2, droidA3, read);
                }
                attacker.damages(reciever);
                break;

            case 2:
                if(player == 'A') {
                    chooseHealTarget(droidA1, droidA2, droidA3, read);
                }
                else {
                    chooseHealTarget(droidB1, droidB2, droidB3, read);
                }
                reciever.setHp(reciever.getHp() + 30);
                break;

            case 3:
                if(player == 'A') {
                    chooseHealTarget(droidA1, droidA2, droidA3, read);
                }
                else {
                    chooseHealTarget(droidB1, droidB2, droidB3, read);
                }
                attacker.ultimateAbility3v3(ally1, ally2, ally1, reciever);
                break;
            default:
                System.out.println("Wrong option. Please try again.");
                moveHealerUltimate(player, read);
        }
    }

    public static void moveHealer(char player, Scanner read) {
        int option;
        System.out.println("Player " + player + ", choose an option:\n" +
                "1 - attack an opponent\n" +
                "2 - heal an ally\n" +
                "->");
        option = read.nextInt();
        switch(option) {
            case 1:
                if (player == 'A') {
                    chooseAttackTarget(droidB1, droidB2, droidB3, read);
                } else {
                    chooseAttackTarget(droidA1, droidA2, droidA3, read);
                }
                attacker.damages(reciever);
                break;

            case 2:
                if (player == 'A') {
                    chooseHealTarget(droidA1, droidA2, droidA3, read);
                } else {
                    chooseHealTarget(droidB1, droidB2, droidB3, read);
                }
                reciever.setHp(reciever.getHp() + 30);
                break;
            default:
                System.out.println("Wrong option. Please try again.");
                moveHealer(player, read);
        }
    }

    public static void moveDroidUltimate(char player, Scanner read) {
        int option;
        System.out.println("Player " + player + ", choose an option:\n" +
                "1 - attack an opponent\n" +
                "2 - use ultimate ability\n" +
                "->");
        option = read.nextInt();
        switch(option) {
            case 1:
                if(player == 'A') {
                    chooseAttackTarget(droidB1, droidB2, droidB3, read);
                }
                else {
                    chooseAttackTarget(droidA1, droidA2, droidA3, read);
                }
                attacker.damages(reciever);
                break;

            case 2:
                if(player == 'A') {
                    if(attacker.getType().equals("Sniper")) {
                        chooseAttackTarget(droidB1, droidB2, droidB3, read);
                    }
                    if(reciever.isDead()) {
                        System.out.println("This droid is dead already! Choose another one.");
                        moveDroidUltimate(player, read);
                        return;
                    }
                    attacker.ultimateAbility3v3(ally1, ally2, reciever, ally1);
                }
                else {
                    if (attacker.getType().equals("Sniper")) {
                        chooseAttackTarget(droidA1, droidA2, droidA3, read);
                    }
                    if (reciever.isDead()) {
                        System.out.println("This droid is dead already! Choose another one.");
                        moveDroidUltimate(player, read);
                        return;
                    }
                    attacker.ultimateAbility3v3(ally1, ally2, reciever, ally1);
                }
                break;

            default:
                System.out.println("Wrong option. Please try again.");
                moveDroidUltimate(player, read);
        }
    }

    public static void moveDroid(char player, Scanner read) {
        System.out.println("Player " + player + "'s " + attacker.getType() + " " + attacker.getName() +
                " has nothing to do but to attack!");
        if(player == 'A') {
            chooseAttackTarget(droidB1, droidB2, droidB3, read);
        }
        else {
            chooseAttackTarget(droidA1, droidA2, droidA3, read);
        }
        attacker.damages(reciever);
    }

    public static void chooseAttackTarget(Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        int option;

        int temp = 1;
        while(temp == 1) {
            System.out.println("Who do you want to attack?\n" +
                    "1 - " + droid1.getType() + " " + droid1.getName() + " with " + droid1.getHp() + " HP left\n" +
                    "2 - " + droid2.getType() + " " + droid2.getName() + " with " + droid2.getHp() + " HP left\n" +
                    "3 - " + droid3.getType() + " " + droid3.getName() + " with " + droid3.getHp() + " HP left\n" +
                    "->");

            option = read.nextInt();

            switch (option) {
                case 1:
                    if (droid1.isDead()) {
                        System.out.println("Droid is dead already! Please choose another target.");
                    } else {
                        setReciever(droid1);
                        temp = 0;
                    }
                    break;

                case 2:
                    if (droid2.isDead()) {
                        System.out.println("Droid is dead already! Please choose another target.");
                    } else {
                        setReciever(droid2);
                        temp = 0;
                    }
                    break;

                case 3:
                    if (droid3.isDead()) {
                        System.out.println("Droid is dead already! Please choose another target.");
                    } else {
                        setReciever(droid3);
                        temp = 0;
                    }
                    break;
                default:
                    System.out.println("Error: wrong option. Please choose the target...\n");
            }
        }
    }

    public static void chooseHealTarget(Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        int option;

        int temp = 1;
        while(temp == 1) {
            System.out.println("Who do you want to heal?\n" +
                    "1 - " + droid1.getType() + " " + droid1.getName() + " with " + droid1.getHp() + " HP left\n" +
                    "2 - " + droid2.getType() + " " + droid2.getName() + " with " + droid2.getHp() + " HP left\n" +
                    "3 - " + droid3.getType() + " " + droid3.getName() + " with " + droid3.getHp() + " HP left\n" +
                    "->");

            option = read.nextInt();

            switch (option) {
                case 1:
                    setReciever(droid1);
                    temp = 0;
                    break;

                case 2:
                    setReciever(droid2);
                    temp = 0;
                    break;

                case 3:
                    setReciever(droid3);
                    temp = 0;
                    break;
                default:
                    System.out.println("Error: wrong option. Please choose the target...\n");
            }
        }
    }

    public static Droid createDroid(char player, int number, Scanner read) {
        Droid droid;

        System.out.println("Player " + player + ", choose a name for your " + number + " droid: ");
        String name = read.nextLine();

        while(true) {
            System.out.println("Player " + player + ", choose the type of your " + number + " droid:\n" +
                    "1 - soldier\n" +
                    "2 - tank\n" +
                    "3 - sniper\n" +
                    "4 - healer\n" +
                    "5 - read stats and ultimate abilities of each type \n" +
                    "->");
            int option = read.nextInt();
            switch (option) {
                case 1:
                    droid = new Soldier(name);
                    return droid;
                case 2:
                    droid = new Tank(name);
                    return droid;
                case 3:
                    droid = new Sniper(name);
                    return droid;
                case 4:
                    droid = new Healer(name);
                    return droid;
                case 5:
                    System.out.println(Stats_info.stats3v3());
                    break;
                default:
                    System.out.println("Error: wrong option. Please try again...");
            }
        }
    }
}
