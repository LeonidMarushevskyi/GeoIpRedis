package geoipredis.loader;

import geoipredis.geoip.IpLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * User: Marushevskiy L.
 * Date: 05.01.13
 * Time: 23:56
 */
public class GeoLiteCityLocationLoader extends FileLoaderBase implements FileLoader {

    private final static Logger logger = LoggerFactory.getLogger(GeoLiteCityLocationLoader.class);

    protected void loadLineToRedis(Jedis redisConnaction, String line, int iterator) {
        long current = System.currentTimeMillis();
        String newLine = line.replaceAll("\"", "")+" ,";
        String[] values = newLine.split(",");
        IpLocation ipLocation = new IpLocation(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]);
        redisConnaction.set(values[0], ipLocation.toJson());

        logger.debug("Line inserted {} at time: {}", ipLocation.toJson(), (System.currentTimeMillis() - current));

    }
}

