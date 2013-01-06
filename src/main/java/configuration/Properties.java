package configuration;

/**
 * @author Marushevskiy L.
 */
public interface Properties {

    public String getRedisHost();

    public void setRedisHost(String redisHost);

    public String getRedisPort();

    public void setRedisPort(String redisPort);

    public String getRedisPassword();

    public void setRedisPassword(String redisPassword);

    public String getRedisUser();

    public void setRedisUser(String redisUser);

    public String getRedisMaxActive();

    public void setRedisMaxActive(String redisMaxActive);

    public String getRedisMaxIdle();

    public void setRedisMaxIdle(String redisMaxIdle);

    public String getRedisMinIdle();

    public void setRedisMinIdle(String redisMinIdle);

    public String getRedisMaxWait();

    public void setRedisMaxWait(String redisMaxWait);

}
