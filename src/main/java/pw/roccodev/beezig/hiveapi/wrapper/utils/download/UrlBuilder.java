package pw.roccodev.beezig.hiveapi.wrapper.utils.download;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlBuilder {

    StringBuilder builder;

    public UrlBuilder() {
        builder = new StringBuilder().append("https://");
    }

    public HiveUrlBuilder hive() {
        return new HiveUrlBuilder(this);
    }

    public URL build() {
        try {
            return new URL(builder.toString().trim());
        } catch (MalformedURLException e) {
            return null;
        }
    }



}
