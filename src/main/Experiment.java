package main;
import java.util.ArrayList;

/**
 * This class runs the simpulation of the market with different configurations.
 * It also analyzes the final data produced by the simulations.
 *
 * @author Maksym Turkot
 * @version 03/28/2021
 */
public class Experiment {
    private static ArrayList<Integer> customerIds = new ArrayList<>();
    private static ArrayList<Integer> stallIds = new ArrayList<>();
    private static ArrayList<Integer> shoppingTimes = new ArrayList<>();
    private static ArrayList<Integer> queueTimeAvgs = new ArrayList<>();
    private static ArrayList<Integer> queueTimeMins = new ArrayList<>();
    private static ArrayList<Integer> queueTimeMaxs = new ArrayList<>();
    private static ArrayList<Integer> queueLengthAvgs =  new ArrayList<>();
    private static ArrayList<Integer> queueLengthMins = new ArrayList<>();
    private static ArrayList<Integer> queueLengthMaxs = new ArrayList<>();

    /**
     * Constructor for objects of class Experiment
     */
    public Experiment() {
    }

    /**
     * Runs the experiemt
     */
    public static void main() {
        OutputManager outputManager = new OutputManager();
        String[] configFiles = {"config1", "config2", "config3", "config4", "config5", "config6"};
        Integer[] seeds = {1, 2, 3, 4, 5};

        // Run each configuration
        for (String configFile : configFiles) {
            ConfigManager configManager = new ConfigManager(configFile);
            // Run with five different random seeds
            for (int seed : seeds) {
                Market market = new Market(configManager.getStallNumbers(), configManager.getStallSpeeds(), seed);
                Clock.tick(market); // Run the time

                outputManager.writeLog("log_" + configFile + "_seed" + seed, Clock.logString);
                
                // Retrieve customer's simulation data
                for (Customer customer : market.getCustomers()) {
                    customerIds.add(customer.getId());
                    shoppingTimes.add(customer.getTimeShopping());
                    queueTimeAvgs.add(customer.getAvgQueueTime());
                    queueTimeMins.add(customer.getMinQueueTime());
                    queueTimeMaxs.add(customer.getMaxQueueTime());
                }
                
                // Retrieve stall's simulation data
                for (Stall stall : market.getStalls()) {
                    stallIds.add(stall.getId());
                    queueLengthAvgs.add(stall.getAvgQueueLength());
                    queueLengthMins.add(stall.getMinQueueLength());
                    queueLengthMaxs.add(stall.getMaxQueueLength());
                }
                
                outputManager.writeOutput("output_" + configFile + "_seed" + seed + "_shoppingTimes", 
                                          "CustomerID:," + dataToCsV(customerIds) + "\n" + 
                                          "ShopingTime:," + dataToCsV(shoppingTimes));
                outputManager.writeOutput("output_" + configFile + "_seed" + seed + "_queueTimes", "CustomerID:," + dataToCsV(customerIds) + "\n" + 
                                          "QueueTimeAvg:," + dataToCsV(queueTimeAvgs) + "\n" + 
                                          "QueueTimeMin:," + dataToCsV(queueTimeMins) + "\n" + 
                                          "QUeueTimeMax:," + dataToCsV(queueTimeMaxs));
                outputManager.writeOutput("output_" + configFile + "_seed" + seed + "_queueLengths", 
                                          "StallID:," + dataToCsV(stallIds) + "\n" + 
                                          "QueueLengthAvs," + dataToCsV(queueLengthAvgs) + "\n" + 
                                          "QueueLengthMin:," + dataToCsV(queueLengthMins) + "\n" + 
                                          "QueueLengthMax:," + dataToCsV(queueLengthMaxs));
                
                customerIds.clear();
                stallIds.clear();
                queueTimeAvgs.clear();
                queueTimeMins.clear();
                queueTimeMaxs.clear();
                shoppingTimes.clear();
                queueLengthAvgs.clear();
                queueLengthMins.clear();
                queueLengthMaxs.clear();
            }
        }
    }
    
    /**
     * Converts data from ArrayList to string of CSV.
     * 
     * @param list array list to be converted
     * @return string of csv
     */
    public static String dataToCsV(ArrayList<Integer> list) {
        String ret = "";
        
        // Goes through the list, converting it to CSV string
        for (int element : list) {
            ret += String.valueOf(element) + ",";
        }
        
        return ret;
    }
}