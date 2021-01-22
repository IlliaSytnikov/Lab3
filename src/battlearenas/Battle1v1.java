package battlearenas;

import droid.*;

import java.util.Scanner;
import java.util.Random;

public class Battle1v1 {

    private static Droid droidA;
    private static Droid droidB;

    public static void start(Scanner read) {
        droidA = createDroid('A', read);
        read.nextLine();
        droidB = createDroid('B', read);
        read.nextLine();

        startBattle(read);
    }

    public static Droid createDroid(char player, Scanner read) {
        Droid droid;

        System.out.println("Player " + player + ", choose a name for your droid: ");
        String name = read.nextLine();

        while(true) {
            System.out.println("Player " + player + ", choose the type of your droid:\n" +
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
                    System.out.println(Stats_info.stats1v1());
                    break;
                default:
                    System.out.println("Error: wrong option. Please try again...");
            }
        }
    }

    public static void startBattle(Scanner read) {

        Random rand = new Random();
        System.out.println("Randomly choosing who is going to make their move first...");
        if (rand.nextInt(100) < 50) {
            System.out.println("Team A makes the first move!");
            while (true) {
                playerMove('A', droidA, droidB, read);
                if (droidB.isDead()) {
                    System.out.println("Player A wins!");
                    return;
                }

                playerMove('B', droidB, droidA, read);
                if (droidA.isDead()) {
                    System.out.println("Player B wins!");
                    return;
                }
            }
        }

        else {
            System.out.println("Team B makes the first move!");
            while (true) {
                playerMove('B', droidB, droidA, read);
                if (droidA.isDead()) {
                    System.out.println("Player B wins!");
                    return;
                }

                playerMove('A', droidA, droidB, read);
                if (droidB.isDead()) {
                    System.out.println("Player A wins!");
                    return;
                }
            }
        }

    }

    public static void playerMove(char player, Droid droid1, Droid droid2, Scanner read) {
        int option;
        if(droid1.getType().equals("Healer")) {           // якщо дроїд - хіллер
            if(droid1.isUltimate()) {                     // якщо дроїд хіллер і в нього є ульт.
                System.out.println("Player " + player + ", choose an option:\n" +
                        "1 - attack an opponent\n" +
                        "2 - heal yourself\n" +
                        "3 - use ultimate ability\n" +
                        "->");
                option = read.nextInt();
                switch (option) {
                    case 1:
                        droid1.damages(droid2);
                        break;
                    case 2:
                        droid1.healing(droid1);
                        break;
                    case 3:
                        droid1.ultimateAbility1v1(droid1);
                        break;
                    default:
                        System.out.println("Wrong option! Try again.");
                        playerMove(player, droid1, droid2, read);
                }
            }
            else {                                    // якщо дроїд - хіллер, але в нього немає ульт.
                System.out.println("Player " + player + ", choose an option:\n" +
                        "1 - attack an opponent\n" +
                        "2 - heal yourself\n" +
                        "->");
                option = read.nextInt();
                switch (option) {
                    case 1:
                        droid1.damages(droid2);
                        break;
                    case 2:
                        droid1.healing(droid1);
                        break;
                    default:
                        System.out.println("Wrong option! Try again.");
                        playerMove(player, droid1, droid2, read);
                }
            }

        }
        else {                                // якщо дроїд - не хіллер
            if(droid1.isUltimate()) {         // якщо дроїд не хіллер і в нього є ульт.
                System.out.println("Player " + player + ", choose an option:\n" +
                        "1 - attack an opponent\n" +
                        "2 - use ultimate ability\n" +
                        "->");
                option = read.nextInt();
                switch (option) {
                    case 1:
                        droid1.damages(droid2);
                        break;
                    case 2:
                        droid1.ultimateAbility1v1(droid2);
                        break;
                    default:
                        System.out.println("Wrong option! Try again.");
                        playerMove(player, droid1, droid2, read);
                }
            }
            else {              // якщо дроїд не хіллер і в нього немає ульт.
                System.out.println("Player " + player + "'s " + droid1.getType() + " " + droid1.getName() +
                        " has nothing to do but to attack!");
                droid1.damages(droid2);
            }
        }
    }
}
