package eu.beezig.hiveapi.wrapper.monthly.draw;

import eu.beezig.hiveapi.wrapper.monthly.RoccoDevMonthlyProfile;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class DrawMonthlyProfile extends RoccoDevMonthlyProfile {
    private JObject source;

    public DrawMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public long getGamesPlayed() {
        return source.getLong("played");
    }

    public long getCorrectGuesses() {
        return source.getLong("correct");
    }

    public long getIncorrectGuesses() {
        return source.getLong("incorrect");
    }

    public long getSkips() {
        return source.getLong("skips");
    }
}
