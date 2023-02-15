package main;
import java.util.Random;

/**
 * This class uses Gaussian random distribution to generate random values
 * used throughout the program.
 *
 * @author Maksym Turkot
 * @version 03/2/2021
 */
public class Gaussian {
    private Random rand;

    /**
     * Constructor for objects of class Random
     */
    public Gaussian(int seed) {  
         rand = new Random(seed);
    }

    /**
     * Gets a random value generated on the basis of Gaussian distriution.
     * 
     * @param mean is the value around which random values will cluster
     * @param deviation is how much values will be scattered
     * @param lowerLim is the minimum random value that can be produced
     * @param upperLim is the maximum random value that can be produced
     * @return the generated random value based on Gaussian distribution
     */
    public int getGaussian(double mean, int deviation, int lowerLim, int upperLim) {
        Double val = 0.0;
        
        do {
            val = rand.nextGaussian() * deviation + mean;
        } while(val < lowerLim || upperLim < val);
        
        return val.intValue();
    }
}
