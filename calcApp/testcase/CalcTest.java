package com.peerislands.assessment.calcApp.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.peerislands.assessment.calcApp.Calculate;

class CalcTest {
	
	@BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }  
	
    @Before  
    public void setUp() throws Exception {  
        System.out.println("before");  
    }  
    
    @Test  
    public void testGetPositiveCases() throws Exception{  
        System.out.println("Test positive case");  
        assertEquals(0,Calculate.performOperation("1 plus 3 minus 4"));  
        assertEquals(13,Calculate.performOperation("1 plus (3 into 4)"));  
    } 
    
    @Test  
    public void testGetNegativeCases() throws Exception{  
        System.out.println("Test negative case");  
        assertEquals(5,Calculate.performOperation("5 plus 3 mod 4"));  
        assertEquals(10,Calculate.performOperation("10 ^ (1 into 4)"));  
    } 
        
    @After  
    public void tearDown() throws Exception {  
        System.out.println("after");  
    }  
  
    @AfterClass  
    public static void tearDownAfterClass() throws Exception {  
        System.out.println("after class");  
    }  
	
}
