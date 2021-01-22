package droid;

public class Stats_info {
    public static String stats1v1() {
        return "Stats:\n" +
                "Droid type:\t|HP:\t|Damage:\t|Accuracy:\t|Crit chance:\t|Crit damage:\t|Heal:\n" +
                "Soldier\t\t|100\t|30\t\t\t|70\t\t\t|20%\t\t\t|45\t\t\t\t|-\n" +
                "Tank\t\t|200\t|10\t\t\t|80\t\t\t|30%\t\t\t|30\t\t\t\t|-\n" +
                "Sniper\t\t|70\t\t|45\t\t\t|90\t\t\t|35%\t\t\t|60\t\t\t\t|-\n" +
                "Healer\t\t|60\t\t|10\t\t\t|70\t\t\t|25%\t\t\t|30\t\t\t\t|30\n\n" +
                "1v1 Ultimate abilities:\n" +
                "Soldier: Increases accuracy to 100 and crit chance to 50% and decreases opponent's accuracy to 50\n" +
                "Tank: Increases HP to 150% of current HP(can go over 200)\n" +
                "Sniper: Deals 30 damage to opponent and heals for 30 HP\n" +
                "Healer: Heals to max HP\n";
    }

    public static String stats3v3() {
        return "Stats:\n" +
                "Droid type:\t|HP:\t|Damage:\t|Accuracy:\t|Crit chance:\t|Crit damage:\t|Heal:\n" +
                "Soldier\t\t|100\t|30\t\t\t|70\t\t\t|20%\t\t\t|45\t\t\t\t|-\n" +
                "Tank\t\t|200\t|10\t\t\t|80\t\t\t|30%\t\t\t|30\t\t\t\t|-\n" +
                "Sniper\t\t|70\t\t|45\t\t\t|90\t\t\t|35%\t\t\t|60\t\t\t\t|-\n" +
                "Healer\t\t|60\t\t|10\t\t\t|70\t\t\t|25%\t\t\t|30\t\t\t\t|30\n\n" +
                "3v3 Ultimate abilities:\n" +
                "Soldier: Increases accuracy to 100% and doubles the crit chance to itself and all allies\n" +
                "Tank: Increases HP to 150% of current HP to itself and all allies\n" +
                "Sniper: Deals 100 damage to the chosen opponent\n" +
                "Healer: Heals chosen ally for 100 HP (can revive dead allies)\n";
    }
}
