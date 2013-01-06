package geoipredis.geoip;

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * User: Marushevskiy L.
 * Date: 06.01.13
 * Time: 16:12
 */
public class IpUtils {

    public static long getNumberIp(String ip) {

        AtomicReferenceArray<String> ipParts = new AtomicReferenceArray<String>(ip.split("\\."));

        return (16777216 * Integer.parseInt(ipParts.get(0))) + (65536 * Integer.parseInt(ipParts.get(1))) + (256 * Integer.parseInt(ipParts.get(2))) + Integer.parseInt(ipParts.get(3));
    }
}
