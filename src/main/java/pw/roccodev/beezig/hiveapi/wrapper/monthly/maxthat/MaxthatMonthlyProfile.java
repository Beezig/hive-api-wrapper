package pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class MaxthatMonthlyProfile extends MonthlyProfile {

    private JObject source;
    private int key;

    public MaxthatMonthlyProfile(JObject source, int key) {
        super(source);
        this.source = source;
        this.key = key;
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    public String getUsername() {
        return source.getString("name");
    }

    public String getUUID() {
        return source.getString("uuid");
    }

    @Override
    public long getPlace() {
        return key;
    }

    public long getHumanPlace() {
        return key + 1;
    }
}
