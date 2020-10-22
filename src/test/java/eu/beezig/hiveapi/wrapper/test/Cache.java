package eu.beezig.hiveapi.wrapper.test;

import com.github.benmanes.caffeine.cache.Caffeine;
import eu.beezig.hiveapi.wrapper.HiveWrapper;
import eu.beezig.hiveapi.wrapper.mojang.UsernameToUuid;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

public class Cache {
    @BeforeAll
    public static void setup() {
        HiveWrapper.setAsyncExecutor(Executors.newSingleThreadExecutor());
        HiveWrapper.setUUIDCache(Caffeine.newBuilder().buildAsync());
    }

    @Test
    public void correctProfile() {
        assert "069a79f444e94726a5befca90e38aaf5".equals(UsernameToUuid.getUUID("Notch").join());
        assert HiveWrapper.usernameToUUIDCache.synchronous().getIfPresent("Notch") != null;
    }
}
