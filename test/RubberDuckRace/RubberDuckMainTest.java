package RubberDuckRace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Er det her korrekt?
 */
class RubberDuckMainTest
{
    static ArrayList<Integer> rubberDuck;

    @BeforeEach
    void mainSetup()
    {
        rubberDuck = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
        {
            rubberDuck.add(i);
        }
    }

    @Test
    void notNullTest()
    {
        assertNotNull(rubberDuck);
    }

    @Test
    void correctNumberTest()
    {
        assertEquals( 100, rubberDuck.size());
    }

}