package geoipredis.geoip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Marushevskiy L. Date: 05.01.13 Time: 23:38
 */
public class GeoIpLocatorExample {

    private final static Logger logger = LoggerFactory.getLogger(GeoIpLocatorExample.class);

    public static void main(String[] args) throws Exception {
        GeoIpLocatorExample geoIpLocator = new GeoIpLocatorExample();

        for (int i = 0; i < 10; i++) {
            geoIpLocator.runThread();
        }
    }

    private void runThread() {
        Executor exec = new Executor();
        exec.start();
    }

    private class Executor extends Thread {

        @Override
        public void run() {
            long current = System.currentTimeMillis();
            int i = 0;
            while (i < 10000) {
                IpLocation ipLocation = getIpLocation("46.98.76.70");
                logger.debug("Country: {} City: {}", ipLocation.getCountry(), ipLocation.getCity());
                i++;
            }
            logger.info("{} queries processed at at time: {}", new Object[]{i, (System.currentTimeMillis() - current)});
        }

        private IpLocation getIpLocation(String ip) {
            return new GeoIpLocator().getIpLocation(ip, 1, 2);
        }
    }
//    private void scanAllIp() {
//        int i = 0;
//        int j = 0;
//        for (int i1 = 1; i1 < 255; i1++) {
//            for (int i2 = 1; i2 < 255; i2++) {
//                for (int i3 = 1; i3 < 255; i3++) {
//                    for (int i4 = 1; i4 < 255; i4++) {
//                        IpLocation ipLocation = getIpLocation(i1+"."+i2+"."+i3+"."+i4);
//                        logger.info("IP: {}", (i1+"."+i2+"."+i3+"."+i4));
//                        logger.info("IP: {} Country: {} City: {}", new Object[]{(i1+"."+i2+"."+i3+"."+i4), ipLocation.getCountry(), ipLocation.getCity()});
//                            
//                        if ("UA".equals(ipLocation.getCountry())) {
//                            logger.info("!!!! Ukraine IP: {} Country: {} City: {}", new Object[]{(i1+"."+i2+"."+i3+"."+i4), ipLocation.getCountry(), ipLocation.getCity()});
//                            j++;
//                        }
//                        i++;
//                    }
//                }
//            }
//        }
//    }
//            
}
