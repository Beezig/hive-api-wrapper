package eu.beezig.hiveapi.wrapper.speedrun;

import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class WorldRecord {

    private JObject run;

    private JObject holderData;

    public WorldRecord(JObject wrData, JObject holderData) {
        this.holderData = holderData;
        run = wrData.getJObject("data").getJArray("runs").getJObject(0).getJObject("run");
    }

    public double getTime() {
        return run.getJObject("times").getDouble("primary_t");
    }

    public String getHolderId() {
        return run.getJArray("players").getJObject(0).getString("id");
    }

    public String getHolderName() {
        return holderData.getJObject("data").getJObject("names").getString("international");
    }
}
