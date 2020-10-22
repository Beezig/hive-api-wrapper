package eu.beezig.hiveapi.wrapper.mojang;

import eu.beezig.hiveapi.wrapper.HiveWrapper;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.concurrent.CompletableFuture;

public class UsernameToUuid {
    public static CompletableFuture<String> getUUID(String username) {
        if(HiveWrapper.usernameToUUIDCache == null) return loadUUID(username);
        return HiveWrapper.usernameToUUIDCache.get(username, (k, exec) -> loadUUID(k));
    }

    private static CompletableFuture<String> loadUUID(String username) {
        CompletableFuture<JObject> responseFromMojang = JObject.get(new UrlBuilder().mojang(username).build());
        return responseFromMojang.thenApplyAsync(json -> json.getString("id"));
    }
}
