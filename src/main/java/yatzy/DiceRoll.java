package yatzy;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class DiceRoll {

    private final List<Integer> dice;

    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.dice = asList(d1, d2, d3, d4, d5);
    }

    public Map<Integer, Integer> counts() {
        return dice.stream().collect(groupingBy(identity(), YatzyCollectors.countingInt));
    }

    public int countDice(int dice) {
        return counts().getOrDefault(dice, 0);
    }

    public int sum() {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }

    public boolean isYatzy() {
        return counts()
                .values()
                .stream()
                .anyMatch(count -> count == 5);
    }

    private Stream<Integer> filterNumberOfDiceGreaterThan(int n) {
        return counts().entrySet().stream()
                .filter(entry -> entry.getValue() >= n)
                .map(Entry::getKey);
    }

    public List<Integer> findPairs() {
        return filterNumberOfDiceGreaterThan(2)
                .sorted(reverseOrder())
                .collect(toList());
    }

    public int getDiceWithCountGreaterThan(int n) {
        return filterNumberOfDiceGreaterThan(n)
                .findFirst()
                .orElse(0);
    }

    private List<Integer> sort() {
        return dice.stream().sorted().collect(toList());
    }

    public boolean isSmallStraight() {
        return sort().equals(asList(1, 2, 3, 4, 5));
    }

    public boolean isLargeStraight() {
        return sort().equals(asList(2, 3, 4, 5, 6));
    }

    public boolean isFullHouse() {
        boolean hasThreeOfAKind = getDiceWithCountGreaterThan(3) != 0;
        boolean hasPair = !findPairs().isEmpty();
        boolean isYatzy = isYatzy();
        return hasThreeOfAKind && hasPair && !isYatzy;
    }
}
