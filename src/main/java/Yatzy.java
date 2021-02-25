import java.util.List;

import static java.util.Comparator.naturalOrder;

public class Yatzy {

    public static int chance(DiceRoll roll) {
        return roll.sum();
    }

    public static int yatzy(DiceRoll roll) {
        if (roll.isYatzy()) {
            return 50;
        }
        return 0;
    }

    public static int ones(DiceRoll roll) {
        return roll.countDice(1);
    }

    public static int twos(DiceRoll roll) {
        return roll.countDice(2) * 2;
    }

    public static int threes(DiceRoll roll) {
        return roll.countDice(3) * 3;
    }

    public static int fours(DiceRoll roll) {
        return roll.countDice(4) * 4;
    }

    public static int fives(DiceRoll roll) {
        return roll.countDice(5) * 5;
    }

    public static int sixes(DiceRoll roll) {
        return roll.countDice(6) * 6;
    }

    public static int pair(DiceRoll roll) {
        return roll.findPairs()
                .stream()
                .max(naturalOrder())
                .map(dice -> dice * 2)
                .orElse(0);
    }

    public static int twoPairs(DiceRoll roll) {
        List<Integer> pairs = roll.findPairs();
        if (pairs.size() >= 2) {
            return pairs.stream()
                    .mapToInt(pair -> pair * 2)
                    .sum();
        }
        return 0;
    }

    public static int threeOfAKind(DiceRoll roll) {
        return roll.getDiceWithCountGreaterThan(3) * 3;
    }

    public static int fourOfAKind(DiceRoll roll) {
        return roll.getDiceWithCountGreaterThan(4) * 4;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(DiceRoll roll) {
        boolean hasThreeOfAKind = roll.getDiceWithCountGreaterThan(3) != 0;
        boolean hasPair = !roll.findPairs().isEmpty();
        boolean isYatzy = roll.isYatzy();
        if (hasThreeOfAKind && hasPair && !isYatzy) {
            return roll.sum();
        }
        return 0;
    }
}


