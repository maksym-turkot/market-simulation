package main;

import java.io.*;

/**
 * This class manages output file creation and writing.
 *
 * @author Maksym Turkot
 * @version 03/28/2021
 */
public class OutputManager
{
    PrintWriter fileWriter;
    File outputFile;

    /**
     * Constructor for objects of class OutputManager
     */
    public OutputManager() {
    }

    /**
     * Writes the log file.
     * 
     * @param name piece of the specific log
     * @param data to output
     */
    public void writeLog(String name, String data) {
        try {
            outputFile = new File("data/logs/" + name +".txt");
            outputFile.createNewFile();
            fileWriter = new PrintWriter(outputFile);
            fileWriter.write(data);
            fileWriter.flush();
            fileWriter.close();
        } catch(IOException e) { 
            System.out.println(e);
        } catch (Exception e) { 
            System.out.println(e);
        }
    }

    /**
     * Writes program output file.
     * 
     * @param data to output.
     */
    public void writeOutput(String name, String data) {
        try {
            outputFile = new File("data/output/" + name +".csv");
            outputFile.createNewFile();
            fileWriter = new PrintWriter(outputFile);
            fileWriter.write(data);
            fileWriter.flush();
            fileWriter.close();
        } catch(IOException e) { 
            System.out.println(e);
        } catch (Exception e) { 
            System.out.println(e);
        }
    }
}
