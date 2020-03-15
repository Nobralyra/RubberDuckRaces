package RubberDuckRace;

import java.util.ArrayList;
import java.util.Collections;

public class RubberDuckMain
{
    public static void main(String[] args)
    {
        FiFoRubberDuckRace fiFoRubberDuckRace = new FiFoRubberDuckRace();

        ArrayList<Integer> rubberDuck = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
        {
            rubberDuck.add(i);
            /**
             * Randomize the numbers to give an equal chance for all numbers to win
             */
            Collections.shuffle(rubberDuck);
        }

        System.out.println(fiFoRubberDuckRace.GetResult(rubberDuck, 10));
    }

}
