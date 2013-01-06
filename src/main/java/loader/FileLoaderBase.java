package loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.RedisConnactionFactory;
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
            } catch (Exception e) {
                logger.error("Flush DB timeout", e);
            }
            String strLine;
            int iterator = 1;
            while ((strLine = bufferedReader.readLine()) != null) {
                loadLineToRedis(redisConnaction, strLine, iterator);
                iterator++;
            }
            logger.info("Loading total time: {} sec", (System.currentTimeMillis() - current) / 1000);
        } finally {
            fileStream.close();
            dataInputStream.close();
            redis.closeConnection();
        }
    }

    protected abstract void loadLineToRedis(Jedis redisConnaction, String line, int iterator);

}
