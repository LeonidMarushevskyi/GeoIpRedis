package geoipredis.geoip;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Marushevskiy L.
 */
public class GeoIpLocatorTest extends TestCase {
    
    private final static Logger logger = LoggerFactory.getLogger(GeoIpLocatorTest.class);

    
    public GeoIpLocatorTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getIpLocation method, of class GeoIpLocator.
     */
    public void testGetIpLocation() {
        System.out.println("getIpLocation");
        String ip = "110.77.205.127";
        int blocksDbIndex = 1;
        int locationsDbIndex = 2;
        GeoIpLocator instance = new GeoIpLocator();
        IpLocation result = instance.getIpLocation(ip, blocksDbIndex, locationsDbIndex);
        logger.info("Country: {} City: {}", result.getCountry(), result.getCity());
    }

    
}
