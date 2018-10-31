package pw.roccodev.beezig.hiveapi.wrapper.player;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.mojang.UsernameToUuid;
import pw.roccodev.beezig.hiveapi.wrapper.player.rank.PlayerRank;
import pw.roccodev.beezig.hiveapi.wrapper.player.status.PlayerStatus;
import pw.roccodev.beezig.hiveapi.wrapper.player.status.RawPlayerStatus;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HivePlayer {

    private LazyObject source;
    private String input;

    public HivePlayer(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public HivePlayer(String username, boolean convertToUUID) {

        if(convertToUUID)
            input = UsernameToUuid.getUUID(username);
        else input = username;

        source = new LazyObject(null, new UrlBuilder().hive().player(input).build());
    }

    public String getUsername() {
        return source.getString("username");
    }

    public long getTokens() {
        return source.getLong("tokens");
    }

    public String getUUID() {
        return source.getString("UUID");
    }

    public long getMedals() {
        return source.getLong("medals");
    }

    public long getCrates() {
        return source.getLong("crates");
    }

    public PlayerRank getRank() {
        return new PlayerRank(new JObject(source.getJSONObject("modernRank")));
    }

    public Date getFirstLogin() {
        return new Date(source.getLong("firstLogin") * 1000);
    }

    public Date getLastLogin() {
        return new Date(source.getLong("lastLogin") * 1000);
    }

    public Date getLastLogout() {
        return new Date(source.getLong("lastLogout") * 1000);
    }

    public Date getCachedAt() {
        return new Date(source.getLong("cached") * 1000);
    }

    public PlayerStatus getStatus() {
        return new PlayerStatus(source.getJObject("status"));
    }

    public RawPlayerStatus getRawStatus() {
        return new RawPlayerStatus(new LazyObject(null, new UrlBuilder().hive().status(input).build()));
    }

    public List<Achievement> getAchievements() {

        JSONObject rawAchievements = source.getJSONObject("achievements");
        List<Achievement> achievements = new ArrayList<>();
        parseAchievements(rawAchievements, achievements);

        return achievements;
    }

    static void parseAchievements(JSONObject rawAchievements, List<Achievement> achievements) {
        for(Object achievement : rawAchievements.entrySet()) {
            if(!(achievement instanceof Map.Entry)) continue;
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) achievement;
            if(!(entry.getValue() instanceof JSONObject)) continue; // Skip the version object
            achievements.add(new Achievement(entry.getKey(), new JObject((JSONObject)entry.getValue())));
        }
    }

    public List<Trophy> getTrophies() {
        List<Trophy> parsedTrophies = new ArrayList<>();
        JSONArray trophies = source.getJSONArray("trophies");
        for(Object trophy : trophies) {
            parsedTrophies.add(new Trophy(new JObject((JSONObject)trophy)));
        }
        return parsedTrophies;
    }

    public List<Achievement> getUnlockedAchievements() {
        return getAchievements().stream().filter(Achievement::isUnlocked).collect(Collectors.toList());
    }



}
