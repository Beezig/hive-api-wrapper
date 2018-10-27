package pw.roccodev.beezig.hiveapi.wrapper.player;

import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;

public class Achievement {

    private JObject source;
    private String key;

    public Achievement(String key, JObject source) {
        this.key = key;
        this.source = source;
    }

    public String getEnumName() {
        return key;
    }

    public boolean isUnlocked() {
        return source.getLong("unlockedAt") != -1;
    }

    public Date getUnlockedAt() {
        if(!isUnlocked()) return null;
        return new Date(source.getLong("unlockedAt") * 1000);
    }

    public int getProgress() {
        return source.getInt("progress");
    }

}
