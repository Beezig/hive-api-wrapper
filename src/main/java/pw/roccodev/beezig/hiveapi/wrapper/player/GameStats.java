package pw.roccodev.beezig.hiveapi.wrapper.player;

import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameStats {

    private LazyObject source;

    public GameStats(String usernameOrUUID, String shortcode) {
        source = new LazyObject(null, new UrlBuilder().hive().player(usernameOrUUID, shortcode).build());
    }

    public String getUUID() {
        return source.getString("UUID");
    }

    public long getPoints() {
        return source.getLong("total_points");
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public long getGamesPlayed() {
        return source.getLong("games_played");
    }

    public String getTitle() {
        return source.getString("title");
    }

    public List<GameAchievement> getAchievements() {

        JSONObject rawAchievements = source.getJSONObject("achievements");
        List<GameAchievement> achievements = new ArrayList<>();
        for(Object achievement : rawAchievements.entrySet()) {
            if(!(achievement instanceof Map.Entry)) continue;
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) achievement;
            if(!(entry.getValue() instanceof JSONObject)) continue; // Skip the version object
            achievements.add(new GameAchievement(entry.getKey(), new JObject((JSONObject)entry.getValue())));
        }

        return achievements;
    }

    public List<GameAchievement> getUnlockedAchievements() {
        return getAchievements().stream().filter(GameAchievement::isUnlocked).collect(Collectors.toList());
    }

    public LazyObject getSource() {
        return source;
    }

}
