package pw.roccodev.beezig.hiveapi.wrapper.monthly.timv;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class TimvMonthlyProfile extends MonthlyProfile {

    private JObject source;

    public TimvMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public long getPoints() {
        return source.getLong("karma");
    }

    @Override
    public long getPlace() {
        return source.getLong("place");
    }

    public String getUsername() {
        return source.getString("username");
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
