package yatzy;

import java.util.List;

/* package */ class YatzyScores {

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
        List<Integer> pairs = roll.findPairs();
        if (pairs.isEmpty()) {
            return 0;
        }  else {
            return pairs.get(0) * 2;
        }
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

    public static int smallStraight(DiceRoll roll) {
        if (roll.isSmallStraight()) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(DiceRoll roll) {
        if (roll.isLargeStraight()) {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(DiceRoll roll) {
        if (roll.isFullHouse()) {
            return roll.sum();
        }
        return 0;
    }
}


