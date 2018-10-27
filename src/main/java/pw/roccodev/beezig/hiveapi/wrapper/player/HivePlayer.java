package pw.roccodev.beezig.hiveapi.wrapper.player;

import pw.roccodev.beezig.hiveapi.wrapper.player.rank.PlayerRank;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class HivePlayer {

    private LazyObject source;

    public HivePlayer(String usernameOrUUID) {
        source = new LazyObject(null, new UrlBuilder().hive().player(usernameOrUUID).build());
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

    public Date getCachedAt() {
        return new Date(source.getLong("cached") * 1000);
    }



}
