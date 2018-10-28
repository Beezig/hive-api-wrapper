package pw.roccodev.beezig.hiveapi.wrapper.utils.download;

import pw.roccodev.beezig.hiveapi.wrapper.GlobalConfiguration;

public class MonthlyUrlBuilder extends UrlBuilder {


    MonthlyUrlBuilder(UrlBuilder parent) {
        builder = parent.builder;
    }

    public MonthlyUrlBuilder bedwars() {
        builder.append("api.roccodev.pw/bedwars/monthlies/");
        return this;
    }

    public MonthlyUrlBuilder timv() {
        builder.append("thtmx.rocks/timv/api/").append(GlobalConfiguration.MAXTHAT_KEY);
        return this;
    }

    public MonthlyUrlBuilder dr() {
        builder.append("thtmx.rocks/dr/api/").append(GlobalConfiguration.MAXTHAT_KEY);
        return this;
    }


    public MonthlyUrlBuilder leaderboard() {
        builder.append("leaderboard");
        return this;
    }

    public MonthlyUrlBuilder leaderboard(int from, int to) {
        builder.append("leaderboard?from=").append(from).append("&to=").append(to);
        return this;
    }

    public MonthlyUrlBuilder profile(String uuid) {
        builder.append("profile/").append(uuid);
        return this;
    }



}
