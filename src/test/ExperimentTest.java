import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Experiment;

import java.util.ArrayList;

/**
 * The test class ExperimentTest.
 *
 * @author  Maksym Turkot
 * @version 03/28/2021
 */
public class ExperimentTest
{
    static Experiment experiment;
    static ArrayList<Integer> data;
    /**
     * Default constructor for test class ExperimentTest
     */
    public ExperimentTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        data = new ArrayList<Integer>();
        data.add(3);
        data.add(5);
        data.add(2);
        data.add(1);
        
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
     * Tests if dataToCsV correctly converst array list of data into CSV string.
     */
    @Test
    public void dataToCsVTest() {
        assertEquals("3,5,2,1,", Experiment.dataToCsV(data));
    }
}
