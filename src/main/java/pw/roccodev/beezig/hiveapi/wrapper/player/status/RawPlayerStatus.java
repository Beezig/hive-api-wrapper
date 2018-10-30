package pw.roccodev.beezig.hiveapi.wrapper.player.status;

import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class RawPlayerStatus {

    private LazyObject source;

    public RawPlayerStatus(LazyObject source) {
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
