package pw.roccodev.beezig.hiveapi.wrapper.server;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.game.achievement.AchievementInfo;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyArray;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.ArrayList;
import java.util.List;

public class Server {

    public long getUniquePlayerCount() {
        return Long.parseLong(new LazyObject(null, new UrlBuilder().hive().serverUnique().build()).getString("count"));
    }

    public long getCurrentPlayerCount() {
        return new LazyObject(null, new UrlBuilder().hive().serverCurrent().build()).getLong("count");
    }

    public List<AchievementInfo> getAchievements() {

        LazyArray arr = new LazyArray(null, new UrlBuilder().hive().serverAchievements().build());
        JSONArray rawAchievements = arr.getInput();
        List<AchievementInfo> achievements = new ArrayList<>();
        for(Object achievement : rawAchievements) {
            if(!(achievement instanceof JSONObject)) continue;
            achievements.add(new AchievementInfo(new JObject((JSONObject)achievement)));
        }

        return achievements;
    }

}
