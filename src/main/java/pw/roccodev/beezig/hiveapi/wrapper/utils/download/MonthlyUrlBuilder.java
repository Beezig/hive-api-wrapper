package pw.roccodev.beezig.hiveapi.wrapper.utils.download;

public class MonthlyUrlBuilder extends UrlBuilder {


    MonthlyUrlBuilder(UrlBuilder parent) {
        builder = parent.builder;
    }

    public MonthlyUrlBuilder bedwars() {
        builder.append("api.roccodev.pw/bed/monthlies/");
        return this;
    }

    public MonthlyUrlBuilder timv() {
        builder.append("api.roccodev.pw/timv/monthlies/");
        return this;
    }

    public MonthlyUrlBuilder dr() {
        builder.append("api.roccodev.pw/dr/monthlies/");
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
