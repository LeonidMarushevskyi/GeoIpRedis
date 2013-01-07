package geoipredis.loader;

/**
 * User: Marushevskiy L.
 * Date: 05.01.13
 * Time: 23:38
 */
public class GeoIpFileLoader {

    public static void main(String[] args) throws Exception {
        GeoIpFileLoader geoIpLoader = new GeoIpFileLoader();
        geoIpLoader.loadDataFromFiles(args[0], args[1]);
    }

    private void loadDataFromFiles(String blocksFilePath, String locationFilePath) throws Exception {

        FileLoader blocksFileLoader = new GeoLiteCityBlocksLoader();
        blocksFileLoader.loadFile(blocksFilePath, 1);

        FileLoader locationFileLoader = new GeoLiteCityLocationLoader();
        locationFileLoader.loadFile(locationFilePath, 2);

    }
}
