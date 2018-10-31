package pw.roccodev.beezig.hiveapi.wrapper.game;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.game.achievement.AchievementInfo;
import pw.roccodev.beezig.hiveapi.wrapper.game.leaderboard.GameLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.game.map.GameMap;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {

    private LazyObject source;
    private String shortcode;

    public Game(String shortcode) {
        this.shortcode = shortcode;
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

    public List<GameMap> getMaps() {

        List<GameMap> maps = new ArrayList<>();

        LazyObject mapsList = new LazyObject(null, new UrlBuilder().hive().game(shortcode).maps().build());
        mapsList.fetch();

        JSONObject raw = mapsList.getInput();
        for(Object map : raw.entrySet()) {
            if(!(map instanceof Map.Entry)) continue;
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) map;
            maps.add(new GameMap(new JObject((JSONObject)entry.getValue())));
        }
        return maps;
    }

    public GameLeaderboard getLeaderboard(int start, int end) {
        URL url;
        if(shortcode.matches("BED."))
            url = new UrlBuilder().hive().leaderboardWithVariation("BED", shortcode, start, end).build();
        else url = new UrlBuilder().hive().game(shortcode).leaderboard(start, end).build();
        return new GameLeaderboard(new LazyObject(null, url));
    }

    public GameLeaderboard getLeaderboard() {
        return getLeaderboard(0, 200);
    }

}
