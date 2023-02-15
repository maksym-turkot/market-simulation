import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ConfigManager;

/**
 * The test class ConfigManagerTest.
 *
 * @author  Maksym Turkot
 * @version 03/27/2021
 */
public class ConfigManagerTest {
    ConfigManager ConfigManager;
    
    /**
     * Default constructor for test class ConfigManagerTest
     */
    public ConfigManagerTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        ConfigManager = new ConfigManager("config1");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
        ConfigManager = null;
    }
    
    /**
     * Tests if program correctly reads and stores 
     * configuration data.
     */
    @Test
    public void readStallInfoTest() {
        assertEquals("[1, 1, 1, 1, 1, 1]", ConfigManager.getStallNumbers().toString());
        assertEquals("[5, 5, 5, 5, 5, 2]", ConfigManager.getStallSpeeds().toString());
    }
}
