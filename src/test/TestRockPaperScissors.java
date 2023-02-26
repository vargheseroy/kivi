package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.RockPaperScissors;

public class TestRockPaperScissors extends RockPaperScissors {
    @Test
    public void testCheckValidity() {
        assertEquals(checkValidity("rock"), true);
        assertEquals(checkValidity("paper"), true);
        assertEquals(checkValidity("scissors"), true);

        assertEquals(checkValidity("scisor"), false);
    }

    @Test
    public void testcheckResult() {
        assertEquals(checkResult("rock", "rock"), 0);
        assertEquals(checkResult("scissors", "scissors"), 0);
        assertEquals(checkResult("paper", "paper"), 0);

        assertEquals(checkResult("rock", "paper"), 2);
        assertEquals(checkResult("paper", "scissors"), 2);
        assertEquals(checkResult("scissors", "rock"), 2);

        assertEquals(checkResult("rock", "scissors"), 1);
        assertEquals(checkResult("paper", "rock"), 1);
        assertEquals(checkResult("scissors", "paper"), 1);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            checkResult("scis", "rock");
        });

        String expectedMessage = "Invalid move from either user or opponent or both";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        exception = assertThrows(RuntimeException.class, () -> {
            checkResult("rock", "pap");
        });

        actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
