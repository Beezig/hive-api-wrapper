package eu.beezig.hiveapi.wrapper.game;

import eu.beezig.hiveapi.wrapper.game.achievement.AchievementInfo;
import eu.beezig.hiveapi.wrapper.game.leaderboard.GameLeaderboard;
import eu.beezig.hiveapi.wrapper.game.map.GameMap;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Game {

    private JObject source;
    private String shortcode;

    public Game(String shortcode, JObject source) {
        this.shortcode = shortcode;
        this.source = source;
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

    public CompletableFuture<List<GameMap>> getMaps() {
        return JObject.get(new UrlBuilder().hive().game(shortcode).maps().build()).thenApplyAsync(list -> {
            List<GameMap> maps = new ArrayList<>();
            JSONObject raw = list.getInput();
            for(Object map : raw.entrySet()) {
                if(!(map instanceof Map.Entry)) continue;
                Map.Entry<String, Object> entry = (Map.Entry<String, Object>) map;
                maps.add(new GameMap(new JObject((JSONObject)entry.getValue())));
            }
            return maps;
        });
    }

    public CompletableFuture<GameLeaderboard> getLeaderboard(int start, int end) {
        URL url;
        if(shortcode.matches("BED."))
            url = new UrlBuilder().hive().leaderboardWithVariation("BED", shortcode, start, end).build();
        else url = new UrlBuilder().hive().game(shortcode).leaderboard(start, end).build();
        return JObject.get(url).thenApplyAsync(GameLeaderboard::new);
    }

    public CompletableFuture<GameLeaderboard> getLeaderboard() {
        return getLeaderboard(0, 200);
    }

}
