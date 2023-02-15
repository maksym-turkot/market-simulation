import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Customer;
import main.Market;
import main.Stall;

import java.util.ArrayList;

/**
 * The test class CustomerTest.
 *
 * @author  Maksym Turkot
 * @version 03/21/2021
 */
public class CustomerTest
{
    Customer customer;
    ArrayList<Integer> list;
    Market market;
    Stall stall;
    
    
    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest() {
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
        customer = new Customer(market);
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
        customer = null;
    }

    /**
     * Tests if generateGroceries correctly creates a list of groceries.
     */
    @Test
    public void generateGroceriesTest() {
        System.out.println("============================");
        System.out.println("Customer.generateGroceriesTest:");
        System.out.println("----------------------------");
        System.out.println(customer.getGroceries().toString());
        customer.getGroceries().clear();
    }
}
