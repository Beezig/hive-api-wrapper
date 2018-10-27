package pw.roccodev.beezig.hiveapi.wrapper.game;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.game.achievement.AchievementInfo;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private LazyObject source;

    public Game(String shortcode) {
        source = new LazyObject(null, new UrlBuilder().hive().game(shortcode).build());
    }

    public long getUniquePlayers() {
        return source.getLong("uniqueplayers");
    }

    public List<AchievementInfo> getAchievements() {

        JSONArray rawAchievements = source.getJSONArray("achievements");
        List<AchievementInfo> achievements = new ArrayList<>();
        for(Object achievement : rawAchievements) {
            if(!(achievement instanceof JSONObject)) continue;
            achievements.add(new AchievementInfo(new JObject((JSONObject)achievement)));
        }

        return achievements;
    }

}
