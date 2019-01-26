package pw.roccodev.beezig.hiveapi.wrapper.monthly.timv;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.RoccoDevMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class TimvMonthlyProfile extends RoccoDevMonthlyProfile {

    private JObject source;

    public TimvMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public long getPoints() {
        return source.getLong("karma");
    }

    public long getInnocentPoints() {
        return source.getLong("i_points");
    }

    public long getDetectivePoints() {
        return source.getLong("d_points");
    }

    public long getTraitorPoints() {
        return source.getLong("t_points");
    }

    public long getRolePoints() {
        return getInnocentPoints() + getDetectivePoints() + getTraitorPoints();
    }

}
