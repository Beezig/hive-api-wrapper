package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.player.GameStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;

public class DrawStats extends GameStats implements Titleable {

    public DrawStats(JObject source) {
        super(source);
    }

    public long getCorrectGuesses() {
        return source.getLong("correct_guesses");
    }

    public long getIncorrectGuesses() {
        return source.getLong("incorrect_guesses");
    }

    public long getSkips() {
        return source.getLong("skips");
    }

    @Override
    public Date getLastLogin() {
        return null;
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
