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


}
