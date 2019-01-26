package pw.roccodev.beezig.hiveapi.wrapper.monthly;

import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class RoccoDevMonthlyProfile extends MonthlyProfile {

    public RoccoDevMonthlyProfile(JObject source) {
        super(source);
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    @Override
    public long getPlace() {
        return source.getLong("place");
    }

    public String getUsername() {
        return source.getString("username");
    }


}
