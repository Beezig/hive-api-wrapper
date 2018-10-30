package pw.roccodev.beezig.hiveapi.wrapper.player.games;

public class GntmStats extends GntStats {

    public GntmStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public GntmStats(String username, boolean convertToUUID) {
        super(username, "GNTM", convertToUUID);
    }
}
