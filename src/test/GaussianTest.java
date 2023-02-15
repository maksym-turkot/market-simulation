import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Gaussian;

/**
 * The test class GaussianTest.
 *
 * @author  Maksym Turkot
 * @version 03/21/2021
 */
public class GaussianTest {
    Gaussian gaussian;
    
    /**
     * Default constructor for test class GaussianTest
     */
    public GaussianTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        gaussian = new Gaussian(1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
    }

    /**
     * Tests if getGaussian produces reasonable random 
     * values for given parameters.
     */
    @Test
    public void getGaussianTest() {
        System.out.println("============================");
        System.out.println("Gaussian.getGaussianTest:");
        System.out.println("----------------------------");
        
        // Generate 20 Gaussian values
        for (int i = 0 ; i < 20; i++) {
            System.out.println("getGaussian(5, 1, 1, 10): " + gaussian.getGaussian(5, 1, 1, 10));
        }
        System.out.println("----------------------------");
        for (int i = 0 ; i < 20; i++) {
            System.out.println("getGaussian(3.5, 10, 1, 7): " + gaussian.getGaussian(3.5, 10, 1, 7));
        }
    }
}
