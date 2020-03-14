package RubberDuckRace;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        FiFoRubberDuckRace fiFoRubberDuckRace = new FiFoRubberDuckRace();

        ArrayList<Integer> rubberDuck = new ArrayList<>();
        for (int i = 1; i <= 20; i++)
        {
            rubberDuck.add(i);
        }

        System.out.println(fiFoRubberDuckRace.GetResult(rubberDuck, 4));


    }
}
