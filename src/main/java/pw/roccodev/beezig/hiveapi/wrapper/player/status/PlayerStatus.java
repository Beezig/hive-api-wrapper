package pw.roccodev.beezig.hiveapi.wrapper.player.status;

import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class PlayerStatus {

    private JObject source;

    public PlayerStatus(JObject source) {
        this.source = source;
    }

    public String getDescription() {
        return source.getString("description");
    }

    public String getGame() {
        return source.getString("game");
    }

    public boolean isOnline() {
        return !getGame().equals("the Land of Nods!");
    }
}
