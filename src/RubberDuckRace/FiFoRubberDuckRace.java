package RubberDuckRace;

import java.util.*;


public class FiFoRubberDuckRace
{

    public int GetResult(ArrayList<Integer> input, int count)
    {
        /**
         * Opret antallet af ArrayLister der er angivet i count + 1 (ellers java.lang.ArrayIndexOutOfBoundsException)
         */
        int j = 0;
        ArrayList<Integer> group[] = new ArrayList[count+1];
        for (int countArrayGroup = 0; countArrayGroup <= count; countArrayGroup++)
        {
            group[countArrayGroup] = new ArrayList<>();
            //System.out.println(group[countArrayGroup]);
        }

        /**
         * Fordel antallet af input i input.size af ArrayList
         * Brug for loop
         */
        for (int i = 0; i < input.size(); i++)
        {
            group[j].add(input.get(i));
            System.out.println("Fordel antallet: " + group[j]);
            j++;
            if  (j == count)
            {
                j = 0;
            }
            /**
             * Randomize de joinede arrayList
             */
            Collections.shuffle(group[j]);
        }


        System.out.println("Shuffle: " + group[j]);




        /**
         * For loop der fjerner input.size() - (count-count)
         * Antallet af tal der skal fjernes
         */
        int remove = input.size() - (count*count);

        for (int i = 0; i < remove; i++)
        {
            System.out.println("Gets removed: " + group[j].get(group[j].size() - 1));
            group[j].remove(group[j].size() - 1);

            j++;
            if  (j == count)
            {
                j = 0;
            }
            System.out.println("What is left: " + group[j]);
        }


        /**
         * Joine alle arrayList op igen i en for loop
         */
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < count; i++)
        {
            result.addAll(group[i]);

            j++;
            if  (j == count)
            {
                j = 0;
            }
        }
        System.out.println("Joined ArrayLists: " + result);



        /**
         * If statement der retunere hvis der kun er en tilbage
         */
        if (result.size() == 1)
        {

            double resultNumber = result.get(0);
            double percentage = (float) ((resultNumber/100)*100.0);
            /**
             * Not right!
             */
            System.out.println("What was the probability for the number to win? " + percentage + "%");
            System.out.println("Winner!");
            return result.get(0);
        }
        /**
         * Call on the method we are in - 1
         */
        return GetResult(result, count - 1);
    }
}
