package geoipredis.geoip;

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * User: Marushevskiy L.
 * Date: 06.01.13
 * Time: 16:12
 */
public class IpUtils {

    public static Double getNumberIp(String ip) {

        AtomicReferenceArray<String> ipParts = new AtomicReferenceArray<String>(ip.split("\\."));
        
        String part1 = ipParts.get(0);
        String part2 = ipParts.get(1);
        String part3 = ipParts.get(2);
        String part4 = ipParts.get(3);
        
        Double numberIp = (16777216 * Double.parseDouble(ipParts.get(0))) + (65536 * Double.parseDouble(ipParts.get(1))) + (256 * Double.parseDouble(ipParts.get(2))) + Double.parseDouble(ipParts.get(3));

        return numberIp;
    }
}
