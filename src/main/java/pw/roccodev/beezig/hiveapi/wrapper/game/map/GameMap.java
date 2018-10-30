package pw.roccodev.beezig.hiveapi.wrapper.game.map;

import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;

public class GameMap {

    private JObject source;

    public GameMap(JObject source) {
        this.source = source;
    }

    public String getWorldName() {
        return source.getString("worldname");
    }

    public String getName() {
        return source.getString("mapname");
    }

    public String getAuthor() {
        return source.getString("mapauthor");
    }

    public Date getAddedAt() {
        return new Date(source.getLong("added") * 1000);
    }

}
