package main;

/**
 * This class implements a counter clock which drives actions throughout the market.
 *
 * @author Maksym Turkot
 * @version 03/27/2021
 */
public class Clock {
    public static int time;
    public static String logString;
    
    /**
     * Constructor for objects of class Clock
     */
    public Clock() {
    }
    
    public static void tick(Market market) {
        logString = "";
        time = 0;
        // Counts minutes. Adds extra 15 minutes to finish purchases
        for (int minute = 0; minute < 225; minute++, time++) {
            market.runMarket();
            logString += market.toString();
        }
    }
}
