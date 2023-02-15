package main;

/**
 * This class stores data relevant to the customer of type two, 
 * controls customer's actions.
 *
 * @author Maksym Turkot
 * @version 03/26/2021
 */
public class CustomerTwo extends Customer {   
    /**
     * Constructor for objects of class CustomerTwo
     */
    public CustomerTwo(Market market) {
        super(market);       
    }

    /**
     * Implements the shopping logic for the customer. This customer chooses
     * the stall with the smallest queue.
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
                int min = 100000;
                Stall minQueue = market.getStalls().get(0);
                // Go through all stalls
                for (int cnt = 0; cnt < market.getStalls().size(); cnt++) {
                    // Check if this stall has the correct product
                    if(getGroceries().contains(market.getStalls().get(cnt).getProductId())) {
                        // Check if this stall has the smallest queue
                        if (min > market.getStalls().get(cnt).getQueue().size()) {
                            min = market.getStalls().get(cnt).getQueue().size();
                            minQueue = market.getStalls().get(cnt);
                        }
                    }
                } 
                this.queueStartTime = Clock.time;
                this.isInQueue = true;
                this.isBuying = false;
                minQueue.addToQueue(this);
            }
        }
    }
}
