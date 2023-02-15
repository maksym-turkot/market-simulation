import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Customer;
import main.Market;
import main.Stall;

import java.util.ArrayList;

/**
 * The test class CustomerOneTest.
 *
 * @author  Maksym Turkot
 * @version 03/21/2021
 */
public class CustomerOneTest {
    Customer customer;
    ArrayList<Integer> list;
    Market market;
    Stall stall;

    /**
     * Default constructor for test class CustomerOneTest
     */
    public CustomerOneTest() {
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
        
        ArrayList<Integer> stallNumbers = new ArrayList<Integer>();
        ArrayList<Integer> stallSpeed = new ArrayList<Integer>();
        stallNumbers.add(1);
        stallNumbers.add(1);
        stallNumbers.add(3);
        stallNumbers.add(2);
        stallNumbers.add(1);
        stallNumbers.add(4);

        stallSpeed.add(10);
        stallSpeed.add(5);
        stallSpeed.add(6);
        stallSpeed.add(3);
        stallSpeed.add(5);
        stallSpeed.add(5);

        market = new Market(stallNumbers, stallSpeed, 1);
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
     * Tests if doShopping assigns customer to a correct queue and removes shopping item.
     */
    @Test
    public void doShoppingTest() {
        System.out.println("============================");
        System.out.println("CustomerOne.doShoppingTest:");
        System.out.println("----------------------------");
        System.out.println(customer.getGroceries());

        ArrayList<Integer> groceriesMem = customer.getGroceries();
        groceriesMem.remove(0);
        Stall stall = null;

        for (int cnt = 0; cnt < market.getStalls().size(); cnt++) {
            if(customer.getGroceries().get(0).equals(market.getStalls().get(cnt).getProductId())) {
                stall = market.getStalls().get(cnt);
                market.getStalls().get(cnt).addToQueue(customer);
                break;
            }
        }
        
        customer.doShopping();
        assertEquals(groceriesMem, customer.getGroceries());

        assertEquals(stall.getQueue().peek().getId(), customer.getId());
    }
}
