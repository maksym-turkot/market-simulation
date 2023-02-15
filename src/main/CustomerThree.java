package main;
/**
 * This class stores data relevant to the customer of type three, 
 * controls customer's actions.
 *
 * @author Maksym Turkot
 * @version 03/19/2021
 */
public class CustomerThree extends Customer
{
    /**
     * Constructor for objects of class CustomerThree
     */
    public CustomerThree(Market market) {
        super(market);
    }
    
    /**
     * Implements the shopping logic for the customer. This customer
     * goes to the first stall that has the item they need.
     */
    public void doShopping() {
        // Check if customer has exhausted their shopping list
        if(getGroceries().isEmpty() && !departed) {
            this.departed = true;
            this.timeDeparted = Clock.time;
        }
        
        // Check if customer has not departed
        if (!departed) {
            // Check if customer is currently in queue
            if(!isInQueue) {
                // Look through the available stalls
                for (int cnt = 0; cnt < market.getStalls().size(); cnt++) {
                    // Check if this stall has the correct product
                    if(getGroceries().get(0) == market.getStalls().get(cnt).getProductId()) {
                        this.queueStartTime = Clock.time;
                        this.isInQueue = true;
                        this.isBuying = false;
                        market.getStalls().get(cnt).addToQueue(this);
                        break;
                    }
                }
            }
        } 
    }

}
