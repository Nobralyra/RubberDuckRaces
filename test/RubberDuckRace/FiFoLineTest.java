package RubberDuckRace;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class FiFoLineTest
{

    static FiFoRubberDuckRace fiFoRubberDuckRace;

    @BeforeAll
    public static void setUp()
    {
        fiFoRubberDuckRace = new FiFoRubberDuckRace();
    }


    @Test
    public void tooManyElementsTest()
    {
        ArrayList<Integer> rubberDuck = new ArrayList<>(101);
        //assertAll(fiFoRubberDuckRace.GetResult(rubberDuck, 0));
    }



}