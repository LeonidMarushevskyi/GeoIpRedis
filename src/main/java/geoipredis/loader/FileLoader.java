package geoipredis.loader;

import java.io.IOException;

/**
 * User: Marushevskiy L.
 * Date: 05.01.13
 * Time: 23:53
 */
public interface FileLoader {

    public void loadFile(String filePath, int redisDatabaseIndex) throws IOException;

}
