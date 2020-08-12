package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.draw.DrawMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.draw.DrawMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.GameStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

public class DrawStats extends GameStats implements Titleable, MonthliesReady {

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

    @Override
    public CompletableFuture<DrawMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<DrawMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().draw().profile(uuid).build()).thenApplyAsync(DrawMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<DrawMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<DrawMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().draw().leaderboard().build()).thenApplyAsync(DrawMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<DrawMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().draw().leaderboard(from, to).build()).thenApplyAsync(DrawMonthlyLeaderboard::new);
    }
}
