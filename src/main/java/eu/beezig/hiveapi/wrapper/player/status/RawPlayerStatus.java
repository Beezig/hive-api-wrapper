package eu.beezig.hiveapi.wrapper.player.status;

import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;

public class RawPlayerStatus {

    private JObject source;

    public RawPlayerStatus(JObject source) {
        this.source = source;
    }

    public Date getCachedAt() {
        return new Date(source.getLong("cached") * 1000);
    }

    public String getGame() {
        return source.getString("status");
    }

    public boolean isOnline() {
        return !getGame().equals("OFFLINE");
    }

}
