package main;
import java.util.ArrayList;

/**
 * This class stores data relevant to the customer, controls customer's actions.
 *
 * @author Maksym Turkot
 * @version 03/28/2021
 */
public class Customer {
    private static int customerCnt;
    protected ArrayList<Integer> groceries = new ArrayList<>();
    protected ArrayList<Integer> queueTimes = new ArrayList<>();
    protected Customer soonerInQueue;
    protected Customer laterInQueue;
    protected int id;
    protected int timeShopping;
    protected int startBuyingTime;
    protected int timeEntered;
    protected int timeDeparted;
    protected Market market;
    protected int queueStartTime;
    protected boolean isBuying;
    protected boolean isInQueue;
    protected boolean departed;

    static {
        customerCnt = 1;
    }

    /**
     * Constructor for objects of class Customer
     * 
     * @param market customer is in
     */
    public Customer(Market market) {
        this.market = market;
        this.generateGroceries();
        this.queueStartTime = 0;
        this.soonerInQueue = null;
        this.laterInQueue = null;
        this.id = customerCnt++;
        this.timeShopping = 0;
        this.startBuyingTime = 0;
        this.timeEntered = market.getGaussian().getGaussian(20, 10, 1, 30);
        this.timeDeparted = 0;
        this.queueStartTime = 0;
        this.isBuying = false;
        this.isInQueue = false;
        this.departed = false;
    }

    /**
     * Gets customer's grocery list
     * 
     * @return customer's grocery list
     */
    public ArrayList<Integer> getGroceries() {
        return this.groceries;
    }

    /**
     * Gets customer's queue times
     * 
     * @return customer's queue times
     */
    public ArrayList<Integer> getQueueTimes() {
        return this.queueTimes;
    }

    /**
     * Gets customer's id
     * 
     * @return customer's id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets customer's time entered
     * 
     * @return customer's time entered
     */
    public int getTimeEntered() {
        return this.timeEntered;
    }

    /**
     * Gets customer's start buying time
     * 
     * @return customer's start buying time
     */
    public int getStartBuyingTime() {
        return this.startBuyingTime;
    }

    /**
     * Sets customer's start buying time
     * 
     * @param customer's start buying time
     */
    public void setStartBuyingTime(int startBuyingTime) {
        this.startBuyingTime = startBuyingTime;
    }

    /**
     * Gets customer sooner in Queue
     * 
     * @return customer sooner in Queue
     */
    public Customer getSoonerInQueue() {
        return this.soonerInQueue;
    }

    /**
     * Sets customer sooner in Queue
     * 
     * @param soonerInQueue customer sooner in Queue
     */
    public void setSoonerInQueue(Customer soonerInQueue) {
        this.soonerInQueue = soonerInQueue;
    }

    /**
     * Gets customer later in Queue
     * 
     * @return customer later in Queue
     */
    public Customer getLaterInQueue() {
        return this.laterInQueue;
    }

    /**
     * Sets customer later in Queue
     * 
     * @param laterInQueue customer later in Queue
     */
    public void setLaterInQueue(Customer laterInQueue) {
        this.laterInQueue = laterInQueue;
    }

    /**
     * Generates the shopping list of groceries.
     */
    protected void generateGroceries() {
        int val;
        int n = market.getGaussian().getGaussian(4, 10, 2, 7);

        // Generate each item for a list
        for (int cnt = 0; cnt < n; cnt++) {
            // Check if item is already on the list
            do {
                val = market.getGaussian().getGaussian(3.5, 10, 1, 7);
            } while(this.groceries.contains(val));
            this.groceries.add(val);
        }
    }

    /**
     * This method contains shopping logic for each type of 
     * cusromer. Overriden in children classes.
     */
    public void doShopping() {
    }

    /**
     * Returns the time spent shopping
     */
    public int getTimeShopping() {
        this.timeShopping = this.timeDeparted - this.timeEntered;
        return this.timeShopping;
    }

    /**
     * Returns the time spent in a queue
     * 
     * @return average time in a queue
     */
    public int getAvgQueueTime() {
        int avg = 0;
        int sum = 0;

        // Add all queue times
        for (int queueTime : queueTimes) {
            sum += queueTime;
        }

        avg = sum / queueTimes.size();

        return avg;
    }

    /**
     * Returns the minimum time spent in a queue
     * 
     * @return minimum time in a queue
     */
    public int getMinQueueTime() {
        int min = queueTimes.get(0);

        // Search for smalles queue time
        for (int queueTime : queueTimes) {
            // Check if current queue time is smaller than the minimum
            if (min > queueTime) {
                min = queueTime;
            }
        }
        return min;
    }
    
    /**
     * Returns the maximum time spent in a queue
     * 
     * @return maximum time in a queue
     */
    public int getMaxQueueTime() {
        int max = queueTimes.get(0);

        // Search for smalles queue time
        for (int queueTime : queueTimes) {
            // Check if current queue time is smaller than the minimum
            if (max < queueTime) {
                max = queueTime;
            }
        }
        return max;
    }

    /**
     * Outputs data about the customer
     */
    public String toString() {
        String ret = "";
        ret += "id: " + this.id + " | Groceries: " + groceries.toString() + "\n";
        return ret;
    }
}