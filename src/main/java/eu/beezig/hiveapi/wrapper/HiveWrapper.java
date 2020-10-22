package eu.beezig.hiveapi.wrapper;

import com.github.benmanes.caffeine.cache.AsyncCache;

import java.util.concurrent.ExecutorService;

public class HiveWrapper {

    public static String USER_AGENT;
    public static String MAXTHAT_KEY;
    public static ExecutorService ASYNC_EXECUTOR;
    public static AsyncCache<String, String> usernameToUUIDCache;

    public static void setUserAgent(String userAgent) {
        USER_AGENT = userAgent;
    }

    public static void setMaxthatApiKey(String key) {
        MAXTHAT_KEY = key;
    }

    public static void setAsyncExecutor(ExecutorService executor) {
        ASYNC_EXECUTOR = executor;
    }

    public static void setUUIDCache(AsyncCache<String, String> usernameToUUIDCache) {
        HiveWrapper.usernameToUUIDCache = usernameToUUIDCache;
    }

    public static void asyncExecute(Runnable callback) {
        if(ASYNC_EXECUTOR == null) throw new RuntimeException("Async executor wasn't properly set up. Run HiveWrapper#setAsyncExecutor first.");
        ASYNC_EXECUTOR.submit(callback);
    }
}
