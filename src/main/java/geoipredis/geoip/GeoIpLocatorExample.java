package geoipredis.geoip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Marushevskiy L.
 * Date: 05.01.13
 * Time: 23:38
 */
public class GeoIpLocatorExample {

    private final static Logger logger = LoggerFactory.getLogger(GeoIpLocatorExample.class);


    public static void main(String[] args) throws Exception {
        GeoIpLocatorExample geoIpLocator = new GeoIpLocatorExample();
        int i = 0;
        long current = System.currentTimeMillis();
        while (i < 1000) {
            logger.info(geoIpLocator.getIpLocationJson(args[0]));
            i++;
        }
        logger.info("{} queries processed at at time: {}", i, (System.currentTimeMillis()-current));
    }

    private String getIpLocationJson(String ip) {
        return new GeoIpLocator().getIpLocation(ip, 1, 2);
    }
}
