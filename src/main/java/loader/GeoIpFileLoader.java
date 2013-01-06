package loader;

/**
 * User: Marushevskiy L.
 * Date: 05.01.13
 * Time: 23:38
 */
public class GeoIpFileLoader {

    public static void main(String[] args) throws Exception {
        GeoIpFileLoader geoIpLoader = new GeoIpFileLoader();
        geoIpLoader.loadDataFromFiles("/home/user/Dropbox/GeoIp/GeoLiteCity_20130101/GeoLiteCity-Blocks.csv", "/home/user/Dropbox/GeoIp/GeoLiteCity_20130101/GeoLiteCity-Location.csv");
    }

    public void loadDataFromFiles(String blocksFilePath, String locationFilePath) throws Exception {

        FileLoader blocksFileLoader = new GeoLiteCityBlocksLoader();
        blocksFileLoader.loadFile(blocksFilePath, 1);

        FileLoader locationFileLoader = new GeoLiteCityLocationLoader();
        locationFileLoader.loadFile(locationFilePath, 2);

    }
}
