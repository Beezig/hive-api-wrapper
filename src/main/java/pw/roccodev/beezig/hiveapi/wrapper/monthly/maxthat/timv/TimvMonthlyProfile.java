package pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.timv;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.MaxthatMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class TimvMonthlyProfile extends MaxthatMonthlyProfile {

    private JObject source;

    public TimvMonthlyProfile(JObject source, int key) {
        super(source, key);
        this.source = source;
    }

    @Override
    public long getPoints() {
        return source.getLong("karma");
    }

    public long getInnocentPoints() {
        return source.getLong("innocent");
    }

    public long getDetectivePoints() {
        return source.getLong("detective");
    }

    public long getTraitorPoints() {
        return source.getLong("traitor");
    }

    public long getRolePoints() {
        return getInnocentPoints() + getDetectivePoints() + getTraitorPoints();
    }

}
