package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.GameStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class MmStats extends GameStats implements Titleable {

    private LazyObject source;

    public MmStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public MmStats(String username, boolean convertToUUID) {
        super(username, "MM", convertToUUID);
        source = getSource();
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    public long getCorrectNotes() {
        return source.getLong("correctnotes");
    }

    public long getIncorrectNotes() {
        return source.getLong("incorrectnotes");
    }

    public long getPerfectNotes() {
        return source.getLong("notes_perfect");
    }

    public long getGoodNotes() {
        return source.getLong("notes_good");
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
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