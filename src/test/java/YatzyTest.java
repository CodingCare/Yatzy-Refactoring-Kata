import org.junit.jupiter.api.Test;
import yatzy.DiceRoll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static yatzy.Category.*;

public class YatzyTest {

    @Test
    public void chance() {
        assertEquals(15, Chance.score(new DiceRoll(2, 3, 4, 5, 1)));
        assertEquals(16, Chance.score(new DiceRoll(3, 3, 4, 5, 1)));
        assertEquals(14, Chance.score(new DiceRoll(1, 1, 3, 3, 6)));
        assertEquals(21, Chance.score(new DiceRoll(4, 5, 5, 6, 1)));
    }

    @Test
    public void yatzy() {
        assertEquals(50, Yatzy.score(new DiceRoll(4, 4, 4, 4, 4)));
        assertEquals(50, Yatzy.score(new DiceRoll(6, 6, 6, 6, 6)));
        assertEquals(0, Yatzy.score(new DiceRoll(6, 6, 6, 6, 3)));
        assertEquals(50, Yatzy.score(new DiceRoll(1, 1, 1, 1, 1)));
        assertEquals(0, Yatzy.score(new DiceRoll(1, 1, 1, 2, 1)));
    }

    @Test
    public void ones() {
        assertEquals(1, Ones.score(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(2, Ones.score(new DiceRoll(1, 2, 1, 4, 5)));
        assertEquals(0, Ones.score(new DiceRoll(6, 2, 2, 4, 5)));
        assertEquals(4, Ones.score(new DiceRoll(1, 2, 1, 1, 1)));
        assertEquals(0, Ones.score(new DiceRoll(3, 3, 3, 4, 5)));
    }

    @Test
    public void twos() {
        assertEquals(4, Twos.score(new DiceRoll(1, 2, 3, 2, 6)));
        assertEquals(10,Twos.score(new DiceRoll(2, 2, 2, 2, 2)));
        assertEquals(4, Twos.score(new DiceRoll(2, 3, 2, 5, 1)));
    }

    @Test
    public void threes() {
        assertEquals(6, Threes.score(new DiceRoll(1, 2, 3, 2, 3)));
        assertEquals(12, Threes.score(new DiceRoll(2, 3, 3, 3, 3)));
    }

    @Test
    public void fours() {
        assertEquals(12, Fours.score(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(8, Fours.score(new DiceRoll(4, 4, 5, 5, 5)));
        assertEquals(4, Fours.score(new DiceRoll(4, 5, 5, 5, 5)));
        assertEquals(8, Fours.score(new DiceRoll(1, 1, 2, 4, 4)));
    }

    @Test
    public void fives() {
        assertEquals(10, Fives.score(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(15, Fives.score(new DiceRoll(4, 4, 5, 5, 5)));
        assertEquals(20, Fives.score(new DiceRoll(4, 5, 5, 5, 5)));
    }

    @Test
    public void sixes() {
        assertEquals(0, Sixes.score(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(6, Sixes.score(new DiceRoll(4, 4, 6, 5, 5)));
        assertEquals(18, Sixes.score(new DiceRoll(6, 5, 6, 6, 5)));
    }

    @Test
    public void pair() {
        assertEquals(6, Pair.score(new DiceRoll(3, 4, 3, 5, 6)));
        assertEquals(10, Pair.score(new DiceRoll(5, 3, 3, 3, 5)));
        assertEquals(12, Pair.score(new DiceRoll(5, 3, 6, 6, 5)));
        assertEquals(8, Pair.score(new DiceRoll(3, 3, 3, 4, 4)));
        assertEquals(12, Pair.score(new DiceRoll(1, 1, 6, 2, 6)));
        assertEquals(6, Pair.score(new DiceRoll(3, 3, 3, 4, 1)));
        assertEquals(6, Pair.score(new DiceRoll(3, 3, 3, 3, 1)));
        assertEquals(0, Pair.score(new DiceRoll(1, 2, 3, 4, 5)));
    }

    @Test
    public void twoPairs() {
        assertEquals(16, TwoPairs.score(new DiceRoll(3, 3, 5, 4, 5)));
        assertEquals(16, TwoPairs.score(new DiceRoll(3, 3, 5, 5, 5)));
        assertEquals(8, TwoPairs.score(new DiceRoll(1, 1, 2, 3, 3)));
        assertEquals(0, TwoPairs.score(new DiceRoll(1, 1, 2, 3, 4)));
        assertEquals(6, TwoPairs.score(new DiceRoll(1, 1, 2, 2, 2)));
        // TODO ask to users if a fourOfAKind counts as a twoPairs ?
        assertEquals(0, TwoPairs.score(new DiceRoll(1, 1, 1, 1, 2)));
    }

    @Test
    public void ThreeOfAKind() {
        assertEquals(9, ThreeOfAKind.score(new DiceRoll(3, 3, 3, 4, 5)));
        assertEquals(15, ThreeOfAKind.score(new DiceRoll(5, 3, 5, 4, 5)));
        assertEquals(9, ThreeOfAKind.score(new DiceRoll(3, 3, 3, 3, 5)));
        assertEquals(9, ThreeOfAKind.score(new DiceRoll(3, 3, 3, 3, 3)));
        assertEquals(0, ThreeOfAKind.score(new DiceRoll(3, 3, 4, 5, 6)));
        assertEquals(9, ThreeOfAKind.score(new DiceRoll(3, 3, 3, 3, 1)));
    }

    @Test
    public void fourOfAKind() {
        assertEquals(12, FourOfAKind.score(new DiceRoll(3, 3, 3, 3, 5)));
        assertEquals(20, FourOfAKind.score(new DiceRoll(5, 5, 5, 4, 5)));
        assertEquals(8, FourOfAKind.score(new DiceRoll(2, 2, 2, 2, 5)));
        assertEquals(0, FourOfAKind.score(new DiceRoll(2, 2, 2, 5, 5)));
        assertEquals(8, FourOfAKind.score(new DiceRoll(2, 2, 2, 2, 2)));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, SmallStraight.score(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(15, SmallStraight.score(new DiceRoll(2, 3, 4, 5, 1)));
        assertEquals(0, SmallStraight.score(new DiceRoll(1, 2, 2, 4, 5)));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, LargeStraight.score(new DiceRoll(6, 2, 3, 4, 5)));
        assertEquals(20, LargeStraight.score(new DiceRoll(2, 3, 4, 5, 6)));
        assertEquals(0, LargeStraight.score(new DiceRoll(1, 2, 2, 4, 5)));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, FullHouse.score(new DiceRoll(6, 2, 2, 2, 6)));
        assertEquals(0, FullHouse.score(new DiceRoll(2, 3, 4, 5, 6)));
        assertEquals(8, FullHouse.score(new DiceRoll(1, 1, 2, 2, 2)));
        assertEquals(0, FullHouse.score(new DiceRoll(2, 2, 3, 3, 4)));
        assertEquals(0, FullHouse.score(new DiceRoll(4, 4, 4, 4, 4)));
    }
}