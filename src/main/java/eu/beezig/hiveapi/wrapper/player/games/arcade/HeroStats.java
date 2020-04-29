package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;

public class HeroStats extends PvPStats {

    public HeroStats(JObject source) {
        super(source);
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
