package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class HeroStats extends PvPStats {

    private LazyObject source;

    public HeroStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public HeroStats(String username, boolean convertToUUID) {
        super(username, "HERO", convertToUUID);
        source = getSource();
    }

    public long getDeathmatches() {
        return source.getLong("deathmatches");
    }

    public long get1v1Victories() {
        return source.getLong("one_vs_ones_wins");
    }

    public long getTntUsed() {
        return source.getLong("tnt_used");
    }

    public long getFoodConsumed() {
        return source.getLong("food_consumed");
    }

    public long getCratesOpened() {
        return source.getLong("crates_opened");
    }


    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }


}
