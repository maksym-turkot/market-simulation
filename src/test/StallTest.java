import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Customer;
import main.Market;
import main.Stall;

import java.util.ArrayList;

/**
 * The test class StallTest.
 *
 * @author  Maksym Turkot
 * @version 03/28/2021
 */
public class StallTest
{
    ArrayList<Integer> list;
    Market market;
    Stall stall;
    Customer cust1, cust2, cust3;
    /**
     * Default constructor for test class StallTest
     */
    public StallTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        list = new ArrayList<Integer>();
        market = new Market(list, list, 1);
        stall = new Stall(1, 5, market);
        cust1 = new Customer(market);
        cust2 = new Customer(market);
        cust3 = new Customer(market);
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
    }
    
    /**
     * Test if addToQueue works correctly.
     */
    @Test
    public void addToQueueTest() {
        System.out.println("============================");
        System.out.println("StallTest.addToQueueTest:");
        System.out.println("----------------------------");
        
        stall.addToQueue(cust1);
        stall.addToQueue(cust2);
        stall.addToQueue(cust3);
        System.out.println(stall.getQueue().toString());
    }
    
    /**
     * Test if remove from queue works correctly.
     */
    @Test
    public void removeFromQueueTest() {
        System.out.println("============================");
        System.out.println("StallTest.removeFromQueueTest:");
        System.out.println("----------------------------");
        
        stall.removeFromQueue();
        stall.removeFromQueue();
        stall.removeFromQueue();
        
        System.out.println(stall.getQueue().toString());
    }
}
