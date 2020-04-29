package eu.beezig.hiveapi.wrapper.server;

import eu.beezig.hiveapi.wrapper.game.achievement.AchievementInfo;
import eu.beezig.hiveapi.wrapper.utils.download.Downloader;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Server {

    public CompletableFuture<Long> getUniquePlayerCount() {
        return JObject.get(new UrlBuilder().hive().serverUnique().build()).thenApplyAsync(o -> Long.parseLong(o.getString("count")));
    }

    public CompletableFuture<Long> getCurrentPlayerCount() {
        return JObject.get(new UrlBuilder().hive().serverCurrent().build()).thenApplyAsync(o -> Long.parseLong(o.getString("count")));
    }

    public CompletableFuture<List<AchievementInfo>> getAchievements() {
        return Downloader.getJsonArray(new UrlBuilder().hive().serverAchievements().build()).thenApplyAsync(arr -> {
            List<AchievementInfo> achievements = new ArrayList<>();
            for(Object achievement : arr.getInput()) {
                if(!(achievement instanceof JSONObject)) continue;
                achievements.add(new AchievementInfo(new JObject((JSONObject)achievement)));
            }
            return achievements;
        });
    }

}
