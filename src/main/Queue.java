package main;
/**
 * This class represents a queue of customer, stores all relevant data and controls 
 * basic queue actions.
 *
 * @author Maksym Turkot
 * @version 03/26/2021
 */
public class Queue {
    private Customer firstInQueue;
    private Customer lastInQueue;

    /**
     * Constructor for objects of class Queue with
     * default length 0.
     */
    public Queue() {
        firstInQueue = null;
        lastInQueue = null;
    }

    /**
     * Appends the specified customer to the end of the queue.
     * 
     * @param newCustomer is the customer to be added to the end of queue
     */
    public void add(Customer newCustomer) {
        // Special case for an empty queue
        if(firstInQueue == null) {
            firstInQueue = newCustomer;
            lastInQueue = newCustomer;
            return;
        }

        lastInQueue.setLaterInQueue(newCustomer);
        newCustomer.setSoonerInQueue(lastInQueue);

        lastInQueue = lastInQueue.getLaterInQueue(); // Update lastInQueue
    }

    /**
     * Removes all customers from this queue.
     */
    public void clear() {
        this.firstInQueue = null;
    }
    
    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty() {
        // Check if there is noone at the front of queue
        if (this.firstInQueue == null) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Retrieves, but does not remove, the firstInQueue of this queue, 
     * or returns null if this queue is empty.
     * 
     * @return returns the firstInQueue of the queue.
     */
    public Customer peek() {
        // Special case if queue is empty
        if (firstInQueue == null) {
            return null;
        }

        return firstInQueue;
    }
    
    /**
     * Retrieves and removes the firstInQueue of this queue, or returns null 
     * if this queue is empty.
     * 
     * @return returns the firstInQueue of the of the queue.
     */
    public Customer remove() {
        // Special case if queue is empty
        if (firstInQueue == null) {
            return null;
        }

        // Special case for one customer
        if (firstInQueue.getLaterInQueue() == null) {
            Customer served = firstInQueue; // Remember first in Queue
            firstInQueue = null; // Set firstInQueue equal to next customer

            served.setLaterInQueue(null); // Disconnect first customer
            served.setSoonerInQueue(null);
            return served;
        }

        Customer served = firstInQueue; // Remember first in Queue
        firstInQueue = firstInQueue.getLaterInQueue(); // Set firstInQueue equal to next customer

        firstInQueue.setSoonerInQueue(null); // Forget first customer

        served.setLaterInQueue(null); // Disconnect first customer
        served.setSoonerInQueue(null);

        return served;
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    public int size() {
        int sizeCnt = 0;

        // Special case for an empty list
        if (this.isEmpty()) {
            return 0;
        }

        Customer curr = firstInQueue;

        // Go through the list
        while (curr != null) {
            sizeCnt++;
            Customer next = curr.getLaterInQueue();
            curr = next;
        }
        return sizeCnt;
    }
    
    /**
     * The toString to return the current queue as a comma
     * separated sequence of ids of customers, the customer's id at 
     * the front of the queue, and that of the one at the back.
     * 
     * Example: a queue [1, 2, 3, 4] will be returned as
     * the string "1,2,3,4;front:1;back:4".
     *
     */
    public String toString() {
        String retString = "";

        // If queue is empty
        if (firstInQueue == null) {
            return "0";
        }

        // Add each node's value to the return string
        for (Customer curr = firstInQueue; curr != null; curr = curr.getLaterInQueue()) {
            retString += curr.getId();

            // Check if index is not on last element to skip comma
            if(curr.getLaterInQueue() != null) {
                retString += ",";
            }
        }

        return retString;
    }
}

