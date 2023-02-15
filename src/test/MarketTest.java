import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Market;

import java.util.ArrayList;

/**
 * The test class MarketTest.
 *
 * @author  Maksym Turkot
 * @version 03/21/2021
 */
public class MarketTest
{
    ArrayList<Integer> stallNumbers;
    ArrayList<Integer> stallSpeeds;
    Market market;
    
    /**
     * Default constructor for test class MarketTest
     */
    public MarketTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        stallNumbers = new ArrayList<Integer>();
        stallSpeeds = new ArrayList<Integer>();
        stallNumbers.add(1);
        stallNumbers.add(1);
        stallNumbers.add(3);
        stallNumbers.add(2);
        stallNumbers.add(1);
        stallNumbers.add(4);

        stallSpeeds.add(10);
        stallSpeeds.add(5);
        stallSpeeds.add(6);
        stallSpeeds.add(3);
        stallSpeeds.add(5);
        stallSpeeds.add(5);

        market = new Market(stallNumbers, stallSpeeds, 1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
        market = null;
        System.out.println("\n");
    }

    /**
     * Tests if add correctly adds new customer to a queue
     */
    @Test
    public void createStallsTest() {
        System.out.println("============================");
        System.out.println("Market.createStallsTest:");
        System.out.println("----------------------------");
        
        market.createStalls(stallNumbers, stallSpeeds);
        // Print ids of created stalls
        for (int cnt = 0; cnt < market.getStalls().size(); cnt++) {
            System.out.print(String.valueOf(market.getStalls().get(cnt).getId()) + " ");
        }
    }
    
    /**
     * Tests if add correctly adds new customer to a queue
     */
    @Test
    public void createCustomersTest() {
        System.out.println("============================");
        System.out.println("Market.createCustomersTest:");
        System.out.println("----------------------------");
        
        // Print ids of created customers
        for (int cnt = 0; cnt < market.getCustomers().size(); cnt++) {
            System.out.print(String.valueOf(market.getCustomers().get(cnt).getId()) + " ");
        }
    }
}
