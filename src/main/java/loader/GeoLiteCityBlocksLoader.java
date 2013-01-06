package loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Marushevskiy L.
 * Date: 05.01.13
 * Time: 23:56
 */
public class GeoLiteCityBlocksLoader extends FileLoaderBase implements FileLoader {

    private final static Logger logger = LoggerFactory.getLogger(GeoLiteCityBlocksLoader.class);

    protected void loadLineToRedis(Jedis redisConnaction, String line, int iterator) {
        long current = System.currentTimeMillis();
        String[] values = line.replaceAll("\"", "").split(",");
        Map<String, String> range = new HashMap<String, String>();
        range.put("locId", values[2]);
        range.put("startIpNum", values[0]);
        range.put("endIpNum", values[1]);

        redisConnaction.hmset(String.valueOf(iterator), range);
        redisConnaction.zadd("cityblocksindex", Double.parseDouble(values[1]), String.valueOf(iterator));

        logger.debug("Line inserted {} at time: {}", range, (System.currentTimeMillis() - current));
    }
}
