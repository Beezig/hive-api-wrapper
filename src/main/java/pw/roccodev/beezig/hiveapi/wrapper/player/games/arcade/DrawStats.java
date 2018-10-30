package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.GameStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class DrawStats extends GameStats implements Titleable {

    private LazyObject source;

    public DrawStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public DrawStats(String username, boolean convertToUUID) {
        super(username, "DRAW", convertToUUID);
        source = getSource();
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
