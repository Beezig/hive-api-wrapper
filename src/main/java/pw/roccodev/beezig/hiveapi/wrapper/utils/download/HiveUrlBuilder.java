package pw.roccodev.beezig.hiveapi.wrapper.utils.download;

public class HiveUrlBuilder extends UrlBuilder {

    HiveUrlBuilder(UrlBuilder parent) {
        builder = parent.builder.append(URLs.HIVE_BASE);
    }

    public HiveUrlBuilder player(String player) {
        builder.append(URLs.PLAYER_ENDPOINT).append(player);

        return this;
    }

    public HiveUrlBuilder player(String player, String game) {
        player(player);
        builder.append("/").append(game);
        return this;
    }

    public HiveUrlBuilder game(String game) {
        builder.append(URLs.GAME_ENDPOINT).append(game);
        return this;
    }

    public HiveUrlBuilder status(String player) {
        player(player);
        builder.append("/status/raw");
        return this;
    }

    public HiveUrlBuilder maps() {
        builder.append("/maps");
        return this;
    }

    public HiveUrlBuilder leaderboard(int start, int end) {
        builder.append("/leaderboard/").append(start).append('/').append(end);
        return this;
    }

    public HiveUrlBuilder leaderboardWithVariation(String shortcode, String variation, int start, int end) {
        builder.append("game/").append(shortcode)
                .append("/leaderboard/").append(start).append('/').append(end).append('/').append(variation);
        return this;
    }

    private void server(String extra) {
        builder.append(URLs.SERVER_ENDPOINT).append(extra);
    }

    public HiveUrlBuilder serverUnique() {
        server("/uniquecount");
        return this;
    }

    public HiveUrlBuilder serverCurrent() {
        server("/playercount");
        return this;
    }

    public HiveUrlBuilder serverAchievements() {
        server("/achievements");
        return this;
    }


}
