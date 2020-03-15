package RubberDuckRace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Er det her korrekt?
 */
class FiFoLineTest
{

    static FiFoRubberDuckRace fiFoRubberDuckRace;
    static ArrayList[] group;
    static ArrayList<Integer> result = new ArrayList<>();
    static ArrayList<Integer> rubberDuck = new ArrayList<>();
    static int queues = 10;

    @BeforeEach
    void mainSetup()
    {
        for (int i = 1; i <= 100; i++)
        {
            rubberDuck.add(i);
        }
    }

    @Test
    public void putNumberInTheCreatedArrayListsTest()
    {
        group = new ArrayList[10];

        assertEquals(10, group.length);
    }

    /**
     * Do not work!
     * How can I test that the right amount of numbers are removed?
     */
    @Test
    public void TestRemoveRubberDucks()
    {
        fiFoRubberDuckRace.makeArrayLists(10);
        fiFoRubberDuckRace.putNumberInTheCreatedArrayLists(rubberDuck, 10);


        int rubberDuckThatContinous = 0;

        for (int i = 0; i < fiFoRubberDuckRace.RemoveRubberDucks(rubberDuck, 10); i++)
        {
            if(fiFoRubberDuckRace.RemoveRubberDucks(rubberDuck, 10) == 19)
            {
                rubberDuckThatContinous++;
            }
        }
        assertEquals(81, rubberDuckThatContinous);
    }

    /**
     * Do not work!
     * How can I test that the arrays gets in again in the ArrayList?
     */
    @Test
    public void TestJoinAllArraysToArrayList()
    {
        group = new ArrayList[10];
        for (int i = 0; i < queues; i++)
        {
            result.addAll(group[i]);
        }

        assertFalse(result.isEmpty());
    }
}