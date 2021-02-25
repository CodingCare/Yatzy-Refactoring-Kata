import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class DiceRoll {
    /**
     * Same as {@link Collectors#counting()} but returns an Integer instead of a Long.
     */
    // FIXME Rien à faire ici
    private static final Collector<Integer, ?, Integer> countingInt = reducing(0, (previous, current) -> previous + 1);

    private final List<Integer> dice;

    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.dice = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public Map<Integer, Integer> counts() {
        return dice.stream().collect(groupingBy(identity(), countingInt));
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
        return filterNumberOfDiceGreaterThan(2).collect(toList());
    }

    public int getDiceWithCountGreaterThan(int n) {
        return filterNumberOfDiceGreaterThan(n)
                .findFirst()
                .orElse(0);
    }
}
