package RubberDuckRace;

import java.util.*;

/**
 * Skal jeg også have en equals i den her klasse?
 */

/**
 * Jeg løb ind i at jeg ikke kunne få mit gamle program til at virke, da jeg prøvede at lave remove metoden,
 * derfor valgte jeg at starte forfra, og kigge på hvad jeg havde haft af andre tanker til, hvordan man kunne lave systemet.
 *
 * Jeg har dog mange problemer med test klasserne, og jeg kan ikke få det til at virke
 */
public class FiFoRubberDuckRace
{
    /**
     * Declaration group as  List Integer Array (group)
     * and
     * result as Arraylist integer
     */
    private ArrayList<Integer>[] group;
    private ArrayList<Integer> result;

    public FiFoRubberDuckRace()
    {}

    public FiFoRubberDuckRace(ArrayList<Integer>[] group, ArrayList<Integer> result)
    {
        this.group = group;
        this.result = result;
    }

    /**
     * Skal jeg bruge dem her?
     * @return String
     */
    @Override
    public String toString()
    {
        return "FiFoRubberDuckRace{" +
                "group=" + Arrays.toString(group) +
                ", result=" + result +
                '}';
    }

    /**
     * Skal jeg bruge dem her?
     * @return int
     */
    @Override
    public int hashCode()
    {
        int result1 = Objects.hash(result);
        result1 = 31 * result1 + Arrays.hashCode(group);
        return result1;
    }

    /**
     * Recusive method that return the winner number
     * @param input
     * @param queues
     * @return int
     */
    public int GetResult(ArrayList<Integer> input, int queues)
    {
        makeArrayLists(queues);

        putNumberInTheCreatedArrayLists(input, queues);

        RemoveRubberDucks(input, queues);

        JoinAllArraysToArrayList(queues);

        /**
         * If statement der retunere hvis ArrayList kun har et nummer tilbage
         */
        if (result.size() == 1)
        {
            Winner();
            return result.get(0);
        }

        /**
         * Call on the method we are in - 1 to queues, so the room for rubber ducks get smaller and smaller
         */
        return GetResult(result, queues - 1);
    }

    /**
     * Opret antallet af ArrayLister der er angivet i queues + 1 (ellers java.lang.ArrayIndexOutOfBoundsException)
     * @return ArrayList<Integer>[]
     */
    public ArrayList<Integer>[] makeArrayLists(int queues)
    {
        /**
         * Initialize group with Arraylist and queues
         * Allocating memory to arrays
         */
        group = new ArrayList[queues+1];

        for (int countArrayGroup = 0; countArrayGroup <= queues; countArrayGroup++)
        {
            group[countArrayGroup] = new ArrayList<>();
        }
        return group;
    }

    /**
     * Fordel antallet af inputs i input.size af ArrayList
     * Brug for loop
     * @return int
     */
    public int putNumberInTheCreatedArrayLists(ArrayList<Integer> input, int queues)
    {
        int howManyRoundsOfQueues = 0;

        /**
         * Equally distributes howManyRoundsOfQueues in the queues
         */
        for (int inputNumber : input)
        {
            group[howManyRoundsOfQueues].add(inputNumber);
            System.out.println("Equally distributes numbers: " + group[howManyRoundsOfQueues]);

            /**
             * Equally distributes howManyRoundsOfQueues in the queues
             */
            howManyRoundsOfQueues++;
            if (howManyRoundsOfQueues == queues)
            {
                howManyRoundsOfQueues = 0;
            }
        }
        return howManyRoundsOfQueues;
    }

    /**
     * For loop der fjerner det sidste tal i hvert Array med input.size() - ((queues - 1)*(queues - 1))
     * Antallet af tal der skal fjernes
     * @param input
     * @param queues
     * @return int
     */
    public int RemoveRubberDucks(ArrayList<Integer> input, int queues)
    {
        int howManyRoundsOfQueues = 0;

        int remove = input.size() - ((queues - 1)*(queues - 1));

        /**
         * Take the arraylist with the first array and remove the last number and so on
         */
        for (int i = 0; i < remove; i++)
        {
            System.out.println("Numbers in ArrayList: " + group[howManyRoundsOfQueues]);

            int notMakingItRubberDucks = group[howManyRoundsOfQueues].remove(group[howManyRoundsOfQueues].size() - 1);

            System.out.println("Gets removed: " + notMakingItRubberDucks);

            howManyRoundsOfQueues++;
            if  (howManyRoundsOfQueues == queues)
            {
                howManyRoundsOfQueues = 0;
            }
        }
        return howManyRoundsOfQueues;
    }

    /**
     * Join alle arrayList op igen i en for loop
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> JoinAllArraysToArrayList(int queues)
    {
        result = new ArrayList<>();
        for (int i = 0; i < queues; i++)
        {
            result.addAll(group[i]);
        }

        /**
         * Randomize de joinede arrayList
         */
        Collections.shuffle(result);
        System.out.println("Shuffle joined ArrayList: " + result);

        return result;
    }

    /**
     * Calculate the procentage for a number to win
     * Because the numbers starts on a random place, they all have an equal chance to win
     * In the first round the first 81 out of 100 goes to the next round and so on.
     */
    public void Winner()
    {
        double percentage = ((81.0/(10*10))*(64.0/(9*9))*(49.0/(8*8))*(36.0/(7*7))*(25.0/(6*6))*(16.0/(5*5))*(9.0/(4*4))*(4.0/(3*3))*(1.0/(2*2))*(1.0/(1))/100)*100;
        System.out.println("What was the probability for the number to win? " + percentage + "%");
        System.out.println("Winner!");
    }

}
