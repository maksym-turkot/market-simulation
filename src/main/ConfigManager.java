package main;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

/**
 * This class reads cofigurations from files.
 *
 * @author Maksym Turkot
 * @version 03/27/2021
 */
public class ConfigManager
{
    private Scanner fileScanner;
    private ArrayList<String> data;
    private ArrayList<Integer> stallNumbers;
    private ArrayList<Integer> stallSpeeds;
    private String[] numbers;
    private String[] speeds;
    
    /**
     * Constructor for objects of class ConfigManager
     */
    public ConfigManager() {
    }

    /**
     * Constructor for objects of class ConfigManager
     * 
     * @param configName name of teh config file to read
     */
    public ConfigManager(String configName) {
        this.data = new ArrayList<String>();
        this.stallNumbers = new ArrayList<Integer>();
        this.stallSpeeds = new ArrayList<Integer>();
        this.readStallInfo(configName);
    }

    /**
     * Gets the list of numbers of stalls.
     * 
     * @return list of numbers of stalls
     */
    public ArrayList<Integer> getStallNumbers() {
        return this.stallNumbers;
    }

    /**
     * Gets the list of speeds of stalls.
     * 
     * @return list of numbers of stalls
     */
    public ArrayList<Integer> getStallSpeeds() {
        return this.stallSpeeds;
    }

    /**
     * Reads and stores configuration data.
     * 
     * @param configName is the name of config file
     */
    public void readStallInfo(String configName) {
        try {
            fileScanner = new Scanner(new FileReader("../../data/configs/" + configName + ".cnfg"));

            // Check if the next line exists
            while(fileScanner.hasNextLine()) {
                String currentLine = fileScanner.nextLine();
                // lineScanner = new Scanner(currentLine);

                // Record line to data list
                if(currentLine.length() > 0) {
                    data.add(currentLine);
                }
            }

            // Split lines in numbers
            numbers = data.get(0).split(",");
            speeds =  data.get(1).split(",");

            // Store numbers
            for(String number : numbers) {
                stallNumbers.add(Integer.parseInt(number));  
            }

            // Store speeds
            for(String speed : speeds) {
                stallSpeeds.add(Integer.parseInt(speed));  
            }

        } catch(IOException e) { 
            System.out.println(e);
        } 
    }
}
