import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Customer;
import main.Market;
import main.Queue;
import main.Stall;

import java.util.ArrayList;

/**
 * The test class QueueTest.
 *
 * @author  Maksym Turkot
 * @version 03/26/2021
 */
public class QueueTest
{
    ArrayList<Integer> list;
    Market market;
    Stall stall;
    Customer cust1, cust2, cust3;
    Queue queue;
    Queue queue2;

    
    /**
     * Default constructor for test class QueueTest
     */
    public QueueTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        queue = new Queue();
        queue2 = new Queue();
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
        queue = null;
        queue2 = null;
    }

    /**
     * Tests if add correctly adds new customer to a queue
     */
    @Test
    public void addTest() {
        System.out.println("============================");
        System.out.println("Queue.queueAddTest:");
        System.out.println("----------------------------");
        
        Customer customer = new Customer(market);
        queue.add(customer);
        assertEquals(customer.getId(), queue.peek().getId());
        System.out.println(queue.toString());
    }

    /**
     * Tests if add correctly adds new customer to a queue
     */
    @Test
    public void peekTest() {
        System.out.println("============================");
        System.out.println("Queue.queuePeekTest:");
        System.out.println("----------------------------");

        Customer newCustomer = new Customer(market);
        queue.add(newCustomer);
        System.out.println(queue.peek().getId());
    }
    
    /**
     * Tests if add correctly adds new customer to a queue
     */
    @Test
    public void removeTest() {
        System.out.println("============================");
        System.out.println("queueRemoveTest:");
        System.out.println("----------------------------");

        // Generate 20 customers
        for (int i = 0 ; i < 20; i++) {
            Customer newCustomer = new Customer(market);
            queue.add(newCustomer);
        }
        
        // Remove 20 customers
        for (int i = 0 ; i < 20; i++) {
            queue.remove();
            System.out.println(queue.toString());
        }
    }
    
    @Test
    public void sizeTest() {
        // Generate 20 customers
        for (int i = 0 ; i < 20; i++) {
            Customer newCustomer = new Customer(market);
            queue.add(newCustomer);
        }
        assertEquals(20, queue.size());
        
        Customer newCustomer2 = new Customer(market);
        queue2.add(newCustomer2);
        assertEquals(1, queue2.size());
        queue2.remove();
        assertEquals(0, queue2.size());
        
        
    }
}
