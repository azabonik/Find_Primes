
import java.util.HashMap;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anthony
 */
public class PrimesHelper 
{
    static public LinkedList<Integer> generate(int begin, int end)
    {
        // Check the range of the numbers
        if(begin < 2 || end < 2)
            return new LinkedList<>();
        
        // Swap begin and end if begin > end
        if(begin > end)
        {
            int temp = end;
            end = begin;
            begin = temp;
        }
        
        // A linked list of Integers to return that are prime between begin and end
        LinkedList<Integer> primes = new LinkedList<>();
        // A HashMap representing the "sieve numbers" for the sieve of Eratosthenes
        HashMap<Integer, Boolean> sieveNums = new HashMap<>();
        
        // Initially all numbers in the sieve are considered prime
        for(int i = 2; i <= end; i++)
            sieveNums.put(i, Boolean.TRUE);
        
        // For each number in the sieve that is marked as prime
        // use it to check if numbers "further down the line" are prime
        for(int curNum = 2; curNum <= end; curNum++)
            // If the current number is still considered prime
            if(sieveNums.get(curNum))
                // Go through the rest of the numbers and divide
                for(int checkNum = 2; checkNum <= end; checkNum++)
                    // If the checkNum is still considered prime
                    if(sieveNums.get(checkNum) && curNum != checkNum)
                        // See if the checkNum is evenly divisible by the curNum
                        if(checkNum % curNum == 0)
                            sieveNums.put(checkNum, Boolean.FALSE);
        
        // Now that we have calculate the primes up to end we have to find
        // the ones in the range that was specified
        for(int i = begin; i <= end; i++)
            if(sieveNums.get(i))
                primes.add(i);
        
        return primes;
    }
    
    public static boolean isPrime(int inVal)
    {
        return generate(2, inVal).contains(inVal);
    }
}
