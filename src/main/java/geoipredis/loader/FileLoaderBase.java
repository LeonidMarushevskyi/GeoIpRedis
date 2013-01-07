package geoipredis.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import geoipredis.redis.RedisConnactionFactory;
import redis.clients.jedis.Jedis;

import java.io.*;

/**
 * User: Marushevskiy L.
 * Date: 05.01.13
 * Time: 23:56
 */
public abstract class FileLoaderBase implements FileLoader {

    private final static Logger logger = LoggerFactory.getLogger(FileLoaderBase.class);


    @Override
    public void loadFile(String filePath, int redisDatabaseIndex) throws IOException {
        RedisConnactionFactory redis = null;
        FileInputStream fileStream = null;
        DataInputStream dataInputStream = null;
        try {
            long current = System.currentTimeMillis();
            fileStream = new FileInputStream(filePath);
            dataInputStream = new DataInputStream(fileStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            redis = new RedisConnactionFactory();
            Jedis redisConnaction = redis.getConnection();
            redisConnaction.select(redisDatabaseIndex);
            try {
                redisConnaction.flushDB();
                logger.info("Database flushed");
            } catch (Exception e) {
                logger.error("Flush DB timeout", e);
            }
            logger.info("Start loading data ...");
            String strLine;
            int iterator = 1;
            while ((strLine = bufferedReader.readLine()) != null) {
                if (strLine.contains("Copyright") || strLine.contains("locId")) {
                    continue;
                }
                loadLineToRedis(redisConnaction, strLine, iterator);
                iterator++;
            }
            logger.info("Data loading complete in time: {} sec", (System.currentTimeMillis() - current) / 1000);
        } finally {
            assert fileStream != null;
            fileStream.close();
            assert dataInputStream != null;
            dataInputStream.close();
            assert redis != null;
            redis.closeConnection();
        }
    }

    protected abstract void loadLineToRedis(Jedis redisConnaction, String line, int iterator);

}
