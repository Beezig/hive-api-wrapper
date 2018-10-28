package pw.roccodev.beezig.hiveapi.wrapper;

public class GlobalConfiguration {

    public static String USER_AGENT;
    public static String MAXTHAT_KEY;

    public static void setUserAgent(String userAgent) {
        USER_AGENT = userAgent;
    }

    public static void setMaxthatApiKey(String key) {
        MAXTHAT_KEY = key;
    }

}
