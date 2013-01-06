package geoipredis.loader;

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
        String[] values = line.replaceAll("\"", "").split(",");
        StringBuilder json = new StringBuilder();
        json.append("{\"locId\"=\"").append(values[0]).append("\",\"country\"=\"").append(values[1]).append("\",\"region\"=\"").append(values[2]).append("\",\"city\"=\"").append(values[3]).append("\",\"postalCode\"=\"").append(values[4]).append("\",\"latitude\"=\"").append(values[5]).append("\",\"longitude\"=\"").append(values[6]).append("\",\"metroCode\"=\"").append(values[1]).append("\",\"areaCode\"=\"").append(values[1]).append("\"}");
        redisConnaction.set(values[0], json.toString());

        logger.debug("Line inserted {} at time: {}", json.toString(), (System.currentTimeMillis() - current));

    }
}

