package main;

import battlearenas.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("What mode do you want to play?\n" +
                "1 - 1v1\n" +
                "3 - 3v3\n" +
                "->");
        int option = read.nextInt();
        read.nextLine();
        switch(option) {
            case 1:
                Battle1v1.start(read);
                break;
            case 3:
                Battle3v3.start(read);
                break;
            default:
                System.out.println("Wrong option. Please try again.");
                main(args);
        }

        int check;
        System.out.println("\nDo you want to try again? (1 - try again, 0 - leave)");
        check = read.nextInt();
        read.nextLine();
        if(check == 1) {
            main(args);
        }
    }
}
