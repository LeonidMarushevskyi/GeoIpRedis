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
            IpLocation result = new GeoIpLocator().getIpLocation("193.25.120.189", 1, 2);
            logger.info("Result: {}", result.toJson());
        }

    
}
