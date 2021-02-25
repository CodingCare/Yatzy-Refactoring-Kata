package yatzy;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;

public class YatzyCollectors {

    /**
     * Same as {@link Collectors#counting()} but returns an Integer instead of a Long.
     */
    public static final Collector<Integer, ?, Integer> countingInt = reducing(0, e -> 1, Integer::sum);

    private YatzyCollectors() {
        throw new UnsupportedOperationException();
    }
}
