package main;
import java.util.ArrayList;

/**
 * This class takes care of all market logic.
 *
 * @author Maksym Turkot
 * @version 03/21/2021
 */
public class Market {
    private ArrayList<Stall> stalls = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    public Gaussian gaussian;
    private int seed;
    
    /**
     * Constructor for objects of class Market
     */
    public Market() {
    }

    /**
     * Constructor for objects of class Market
     * 
     * @param stallNumbers are numbers of stalls to be created
     * @param stallSpeeds are speeds of stalls to be created
     * @param seed is the randomizer seed for this run of market
     */
    public Market(ArrayList<Integer> stallNumbers, ArrayList<Integer> stallSpeeds, int seed) {
        this.gaussian = new Gaussian(seed);
        this.createStalls(stallNumbers, stallSpeeds);
        this.createCustomers();
        this.seed = seed;
    }
    
    /**
     * Gets the list of stalls of this market
     * 
     * @return list of stalls of this market
     */
    public ArrayList<Stall> getStalls() {
        return stalls;
    }
    
    /**
     * Gets the list of customers of this market
     * 
     * @return list of customers of this market
     */
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    
    /**
     * Gets the gaussian number for this market
     * 
     * @return gaussian number for this market
     */
    public Gaussian getGaussian() {
        return gaussian;
    }
    
    /**
     * Gets the seed of this market
     * 
     * @return seed of this market
     */
    public int getSeed() {
        return seed;
    }

    /**
     * Generates stalls based on passed parameters
     * 
     * @param stallNumbers indicates number of stalls of a given type, where index indicates the type.
     * @param stallSpeed indicases how fast stall of a given type will process the order
     */
    public void createStalls(ArrayList<Integer> stallNumbers, ArrayList<Integer> stallSpeed) {
        for (int type = 0; type < stallNumbers.size(); type++) {
            for (int cnt = 0; cnt < stallNumbers.get(type); cnt++) {
                Stall a = new Stall(type + 1, stallSpeed.get(type), this);
                stalls.add(a);
            }
        }
    }

    /**
     * Generates customers of three types.
     */
    protected void createCustomers() {
        // Create customers
        for (int cnt = 0; cnt < 20; cnt++) {
            Customer one = new CustomerOne(this);
            Customer two = new CustomerTwo(this);
            Customer three = new CustomerThree(this);
            customers.add(one);
            customers.add(two);
            customers.add(three);
        }
    }

    /**
     * Runs market for one minute by trigerring customers to shop 
     * and stalls to sell gooods.
     */
    public void runMarket() {
        // Trigger each customer to shop
        for (Customer customer : customers) {
            // Check if market closed, if customer is still there and not buying anything
            if (Clock.time >= 210 && !customer.departed && !customer.isBuying) {
                customer.timeDeparted = Clock.time;
                customer.departed = true;
            }
            
            // Check if given customer entered the market
            if (Clock.time >= customer.getTimeEntered()) {
                customer.doShopping();
            }
        }
        
        // Trigger each stall to sell goods
        for (Stall stall : stalls) {
            stall.sell();
        }
    }

    /**
     * Logs state of the market.
     * 
     * @return log of the state of the market
     */
    public String toString() {
        String ret = "";

        ret += "*****************************************" + "\n";
        ret += "Tick: " + Clock.time + " | Seed: " + seed + "\n";
        ret += "=========================================" + "\n";
        ret += "Stall info:" + "\n";
        
        // Print info about stalls:
        for (Stall stall : stalls) {
            ret += stall.toString();
        }
        
        ret += "=========================================" + "\n";
        ret += "Customer info:" + "\n";

        // Print info about stalls:
        for (Customer customer : customers) {
            ret += customer.toString();
        }
        
        ret += "*****************************************" + "\n";
        ret += "\n";
        
        return ret;
    }
}
