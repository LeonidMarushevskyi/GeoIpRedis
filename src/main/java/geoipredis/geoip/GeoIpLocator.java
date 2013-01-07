package geoipredis.geoip;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import geoipredis.redis.RedisConnactionFactory;
import redis.clients.jedis.Jedis;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * User: Marushevskiy L.
 * Date: 06.01.13
 * Time: 16:11
 */

public class GeoIpLocator {
    
    private final static Logger logger = LoggerFactory.getLogger(GeoIpLocator.class);

    public IpLocation getIpLocation(String ip, int blocksDbIndex, int locationsDbIndex) {
        long current = System.currentTimeMillis();
        RedisConnactionFactory redis = null;
        IpLocation ipLocation = new IpLocation();
        try {
            long numberIp = IpUtils.getNumberIp(ip);

            redis = new RedisConnactionFactory();
            Jedis redisConnaction = redis.getConnection();
            redisConnaction.select(blocksDbIndex);

            Set<String> ipRange = redisConnaction.zrangeByScore("cityblocksindex", numberIp, Double.MAX_VALUE, 0, 1);
            Iterator<String> iterator = ipRange.iterator();
            String key = iterator.next();
            Map<String, String> range = redisConnaction.hgetAll(key);
            String locationId = range.get("locId");
            redisConnaction.select(locationsDbIndex);

            String locationJson = redisConnaction.get(locationId);
            ipLocation = jsonToObject(locationJson);
        } catch (Exception e) {
            logger.error("Can't get ip location", e);
        } finally {
            assert redis != null;
            redis.closeConnection();
        }
        logger.debug("GeoIp lookup time: {}", (System.currentTimeMillis() - current));
        return ipLocation;
    }
    
    public IpLocation jsonToObject(String json) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        IpLocation ipLocation = new IpLocation();
        try{
            ipLocation = mapper.readValue(json, IpLocation.class);
        } catch (Exception ex){
            logger.error(ex.getMessage(), ex);
        }
        return ipLocation;
    }
}
