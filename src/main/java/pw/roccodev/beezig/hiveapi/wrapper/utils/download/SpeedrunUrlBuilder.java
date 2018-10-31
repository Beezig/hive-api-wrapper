package pw.roccodev.beezig.hiveapi.wrapper.utils.download;

public class SpeedrunUrlBuilder extends UrlBuilder {

    SpeedrunUrlBuilder(UrlBuilder parent) {
        builder = parent.builder.append(URLs.SPEEDRUN_BASE);
    }

    public SpeedrunUrlBuilder level(String id) {
        builder.append("leaderboards/369ep8dl/level/").append(id).append("/824xzvmd?top=1");
        return this;
    }

    public SpeedrunUrlBuilder user(String id) {
        builder.append("users/").append(id);
        return this;
    }

}
