package main;
import java.util.ArrayList;

/**
 * This class stores info relevant to the stall and 
 * performs stall-specific actions.
 *
 * @author Maksym Turkot
 * @version 03/21/2021
 */
public class Stall {
    private static int stallCnt;
    private ArrayList<Integer> queueLengths;
    private Market market;
    private Queue queue;
    private int id;
    private int productId;
    private int speed;
    private int randTimeOfPurchase;

    static {
        stallCnt = 1;
    }

    /**
     * Constructor for objects of class Stall
     * 
     * @param productId is id of the product to be sold
     * @param speed is how long on average a purchase will take
     */
    public Stall(int productId, int speed, Market market) {
        this.id = stallCnt++;
        this.queue = new Queue();
        this.market = market;
        this.productId = productId;
        this.speed = speed;
        this.queueLengths = new ArrayList<>();
    }

    /**
     * Gets id of this stall.
     * 
     * @return id of this stall
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets productId of this stall.
     * 
     * @return productId of this stall
     */
    public int getProductId() {
        return this.productId;
    }

    /**
     * Gets queue of this stall.
     * 
     * @return queue of this stall
     */
    public Queue getQueue() {
        return this.queue;
    }

    /**
     * Adds a customer to this queue
     * 
     * @param customer to be added
     */
    public void addToQueue(Customer customer) {
        this.queue.add(customer);
    }

    /**
     * Removes a customer from this queue
     * 
     * @return removed customer
     */
    public void removeFromQueue() {
        this.queue.remove();
    }

    /**
     * Sells a product to a customer
     */
    public void sell() {
        // Check if queue isn't empty
        if (!queue.isEmpty()) {
            Customer curr = queue.peek();
            // Check if customer was already buying a product
            if (curr.isBuying) {
                // Check if customer is done buying
                if (Clock.time == curr.getStartBuyingTime() + randTimeOfPurchase) {
                    curr.getGroceries().remove((Integer) productId);
                    int queueTime = Clock.time - curr.queueStartTime;
                    curr.getQueueTimes().add(queueTime);
                    curr.isInQueue = false;
                    curr.isBuying = false;
                    this.removeFromQueue();
                    curr.doShopping();
                } 
            } else {
                    curr.setStartBuyingTime(Clock.time);
                    curr.isBuying = true;
                    randTimeOfPurchase = market.getGaussian().getGaussian(speed, 1, 1, 15);
            }
        }
        
        queueLengths.add(this.queue.size());
    }
    
    /**
     * Returns the time spent shopping
     */
    public int getAvgQueueLength() {
        int avg = 0;
        int sum = 0;
        
        for (int queueLength : queueLengths) {
            sum += queueLength;
        }
        
        avg = sum / queueLengths.size();
        
        return avg;
    }
    
    /**
     * Returns the minimum length of a queue
     * 
     * @return minimum length of a queue
     */
    public int getMinQueueLength() {
        int min = queueLengths.get(0);

        // Search for smalles queue time
        for (int queueLength : queueLengths) {
            // Check if current queue time is smaller than the minimum
            if (min > queueLength) {
                min = queueLength;
            }
        }

        return min;
    }
    
    /**
     * Returns the minimum length of a queue
     * 
     * @return maximum length of a queue
     */
    public int getMaxQueueLength() {
        int max = queueLengths.get(0);

        // Search for smalles queue time
        for (int queueLength : queueLengths) {
            // Check if current queue time is smaller than the minimum
            if (max < queueLength) {
                max = queueLength;
            }
        }

        return max;
    }

    /**
     * Outputs data about the stall
     */
    public String toString() {
        String ret = "";

        ret += "id: " + this.id + " | product: " + this.productId + " | speed: " + this.speed + " | queue: " + this.queue.toString() + "\n";
        return ret;
    }
}
