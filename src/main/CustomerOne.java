package main;
/**
 * This class stores data relevant to the customer of type one, 
 * controls customer's actions. This customers buys their groceries
 * in the order they apper in the list, and picks the first stall they find.
 *
 * @author Maksym Turkot
 * @version 03/21/2021
 */
public class CustomerOne extends Customer {
    Market market;

    /**
     * Constructor for objects of class CustomerOne
     */
    public CustomerOne(Market market) {
        super(market);
        this.market = market;
    }

    /**
     * Implements the shopping logic for the customer. This customer
     * simply goes through his shopping list and buys items in presented
     * order.
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
                    if(getGroceries().contains(market.getStalls().get(cnt).getProductId())) {
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
