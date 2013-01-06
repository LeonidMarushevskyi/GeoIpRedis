package configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * User: Marushevskiy L.
 * Date: 05.01.13
 * Time: 17:30
 */

@Configuration
@ImportResource("classpath:/properties-config.xml")
public class SpringConfiguration {

    private
    @Value("#{redisProperties['properties.redisHost']}")
    String redisHost;
    private
    @Value("#{redisProperties['properties.redisPort']}")
    String redisPort;
    private
    @Value("#{redisProperties['properties.redisUser']}")
    String redisUser;
    private
    @Value("#{redisProperties['properties.redisPassword']}")
    String redisPassword;
    private
    @Value("#{redisProperties['properties.redisMaxActive']}")
    String redisMaxActive;
    private
    @Value("#{redisProperties['properties.redisMaxIdle']}")
    String redisMaxIdle;
    private
    @Value("#{redisProperties['properties.redisMaxWait']}")
    String redisMaxWait;
    private
    @Value("#{redisProperties['properties.redisMinIdle']}")
    String redisMinIdle;

    @Bean
    @Scope("prototype")
    public Jedis jedis() throws Exception {
        return new Jedis(redisHost);
    }

    @Bean
    @Scope("singleton")
    public JedisPool jedisPool() throws Exception {
        return new JedisPool(jedisPoolConfig(), redisHost);
    }

    @Bean
    @Scope("singleton")
    public JedisPoolConfig jedisPoolConfig() throws Exception {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxActive(Integer.parseInt(redisMaxActive));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(redisMaxIdle));
        jedisPoolConfig.setMinIdle(Integer.parseInt(redisMinIdle));
        jedisPoolConfig.setMaxWait(Long.parseLong(redisMaxWait));

        return jedisPoolConfig;
    }

}
