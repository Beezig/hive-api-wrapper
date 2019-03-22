package pw.roccodev.beezig.hiveapi.wrapper.utils.download;

public class MonthlyUrlBuilder extends UrlBuilder {


    MonthlyUrlBuilder(UrlBuilder parent) {
        builder = parent.builder;
    }

    private void appendRoccoDev(String mode) {
        builder.append("api.rocco.dev/").append(mode).append("/monthlies/");
    }


    public MonthlyUrlBuilder bedwars() {
        appendRoccoDev("bed");
        return this;
    }

    public MonthlyUrlBuilder timv() {
        appendRoccoDev("timv");
        return this;
    }

    public MonthlyUrlBuilder dr() {
        appendRoccoDev("dr");
        return this;
    }

    public MonthlyUrlBuilder cai() {
        appendRoccoDev("cai");
        return this;
    }

    public MonthlyUrlBuilder hide() {
        appendRoccoDev("hide");
        return this;
    }

    public MonthlyUrlBuilder bp() {
        appendRoccoDev("bp");
        return this;
    }

    public MonthlyUrlBuilder gnt() {
        appendRoccoDev("gnt");
        return this;
    }

    public MonthlyUrlBuilder gntm() {
        appendRoccoDev("gntm");
        return this;
    }

    public MonthlyUrlBuilder sky() {
        appendRoccoDev("sky");
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
