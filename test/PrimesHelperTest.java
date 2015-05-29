/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Anthony
 */
public class PrimesHelperTest 
{
    int end;
    int begin;  
    LinkedList<Integer> expectedVals;
    LinkedList<Integer> returnedVals;
    
    public PrimesHelperTest() 
    {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
    }
    
    @Before
    public void setUp() 
    {
        end = 0;
        begin = 0;
        expectedVals = new LinkedList<>();
        returnedVals = new LinkedList<>();
    }
    
    @After
    public void tearDown() 
    {
    }

    
    @Test
    public void SanityTest()
    {
        // These are the values given in the challenge desription that must work
        begin = 7900;
        end = 7920;
        expectedVals.clear();
        expectedVals.add(7901);
        expectedVals.add(7907);
        expectedVals.add(7919);
        
        // Call our primes function
        returnedVals = PrimesHelper.generate(begin, end);
        
        // Make sure that it returns the expected numbers and only those
        Assert.assertTrue(expectedVals.size() == returnedVals.size());
        for(int i = 0; i < expectedVals.size(); i++)
            Assert.assertEquals(expectedVals.get(i), returnedVals.get(i));
    }
    
    @Test
    public void SwapValTest()
    {
        // These are the values given in the challenge desription that must work
        begin = 7900;
        end = 7920;
        expectedVals.clear();
        expectedVals.add(7901);
        expectedVals.add(7907);
        expectedVals.add(7919);
        
        // Call our primes function SWAPPED!
        returnedVals = PrimesHelper.generate(end, begin);
        
        // Make sure that it returns the expected numbers and only those
        Assert.assertTrue(expectedVals.size() == returnedVals.size());
        for(int i = 0; i < expectedVals.size(); i++)
            Assert.assertEquals(expectedVals.get(i), returnedVals.get(i));
    }
    
    @Test
    public void SingleValTest()
    {
        // These are the values given in the challenge desription that must work
        begin = 7901;
        end = 7901;
        expectedVals.clear();
        expectedVals.add(7901);
        
        // Call our primes function
        returnedVals = PrimesHelper.generate(begin, end);
        
        // Make sure that it returns the expected numbers and only those
        Assert.assertTrue(expectedVals.size() == returnedVals.size());
        for(int i = 0; i < expectedVals.size(); i++)
            Assert.assertEquals(expectedVals.get(i), returnedVals.get(i));
    }
    
    
    @Test
    public void NegativeValTest()
    {
        // These are the values given in the challenge desription that must work
        begin = 0;
        end = -1;
        expectedVals.clear();
        
        // Call our primes function
        returnedVals = PrimesHelper.generate(begin , end);
        
        // Make sure that it returns the expected numbers and only those
        Assert.assertTrue(expectedVals.size() == returnedVals.size());
    }
}
