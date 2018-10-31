package pw.roccodev.beezig.hiveapi.wrapper.player;

import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class Trophy {

    private JObject source;

    public Trophy(JObject source) {
        this.source = source;
    }

    public String getGame() {
        return source.getString("game");
    }

    public String getAchievement() {
        return source.getString("achievement");
    }

}
