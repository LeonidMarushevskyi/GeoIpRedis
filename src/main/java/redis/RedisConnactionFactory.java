package redis;

import configuration.SpringContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * User: Marushevskiy L.
 * Date: 05.12.12
 * Time: 12:34
 */

public class RedisConnactionFactory {

    private final static Logger logger = LoggerFactory.getLogger(RedisConnactionFactory.class);

    private Jedis connection;

    public RedisConnactionFactory() {
        connection = openConnection();
    }

    public Jedis getConnection() {
        return connection;
    }

    public void closeConnection() {
        ((JedisPool) SpringContext.getInstance().getContext().getBean("jedisPool")).returnResource(connection);
    }

    private Jedis openConnection() {

        long current = System.currentTimeMillis();
        Jedis jedis = ((JedisPool) SpringContext.getInstance().getContext().getBean("jedisPool")).getResource();
        logger.debug("Time get-redis-resource: " + (System.currentTimeMillis() - current));

        return jedis;
    }

}
