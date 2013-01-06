package geoipredis.configuration;

/**
 * @author Marushevskiy L.
 */

public class PropertiesImpl implements Properties {

    private String redisHost;
    private String redisPort;
    private String redisPassword;
    private String redisUser;
    private String redisMaxActive;
    private String redisMaxIdle;
    private String redisMinIdle;
    private String redisMaxWait;

    @Override
    public String getRedisHost() {
        return redisHost;
    }

    @Override
    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    @Override
    public String getRedisPort() {
        return redisPort;
    }

    @Override
    public void setRedisPort(String redisPort) {
        this.redisPort = redisPort;
    }

    @Override
    public String getRedisPassword() {
        return redisPassword;
    }

    @Override
    public void setRedisPassword(String redisPassword) {
        this.redisPassword = redisPassword;
    }

    @Override
    public String getRedisUser() {
        return redisUser;
    }

    @Override
    public void setRedisUser(String redisUser) {
        this.redisUser = redisUser;
    }

    @Override
    public String getRedisMaxActive() {
        return redisMaxActive;
    }

    @Override
    public void setRedisMaxActive(String redisMaxActive) {
        this.redisMaxActive = redisMaxActive;
    }

    @Override
    public String getRedisMaxIdle() {
        return redisMaxIdle;
    }

    @Override
    public void setRedisMaxIdle(String redisMaxIdle) {
        this.redisMaxIdle = redisMaxIdle;
    }

    @Override
    public String getRedisMinIdle() {
        return redisMinIdle;
    }

    @Override
    public void setRedisMinIdle(String redisMinIdle) {
        this.redisMinIdle = redisMinIdle;
    }

    public String getRedisMaxWait() {
        return redisMaxWait;
    }

    @Override
    public void setRedisMaxWait(String redisMaxWait) {
        this.redisMaxWait = redisMaxWait;
    }
}
