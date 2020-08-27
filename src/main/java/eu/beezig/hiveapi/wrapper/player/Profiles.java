package eu.beezig.hiveapi.wrapper.player;

import eu.beezig.hiveapi.wrapper.mojang.UsernameToUuid;
import eu.beezig.hiveapi.wrapper.player.games.*;
import eu.beezig.hiveapi.wrapper.player.games.arcade.*;
import eu.beezig.hiveapi.wrapper.speedrun.WorldRecord;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public class Profiles {
    private static CompletableFuture<JObject> getStats(String shortcode, String username) {
        if(username.length() < 16) {
            return UsernameToUuid.getUUID(username).thenApplyAsync(uuid -> JObject.get(new UrlBuilder().hive().player(uuid, shortcode).build()).join());
        }
        return JObject.get(new UrlBuilder().hive().player(username, shortcode).build());
    }

    public static CompletableFuture<HivePlayer> global(String username) {
        if(username.length() < 16) {
            return UsernameToUuid.getUUID(username).thenApplyAsync(uuid -> JObject.get(new UrlBuilder().hive().player(uuid).build()).join()).thenApplyAsync(HivePlayer::new);
        }
        return JObject.get(new UrlBuilder().hive().player(username).build()).thenApplyAsync(HivePlayer::new);
    }

    public static CompletableFuture<WorldRecord> speedrun(String levelId) {
        CompletableFuture<JObject> wrData = JObject.get(new UrlBuilder().speedrun().level(levelId).build());
        return wrData.thenApplyAsync(json -> {
            String holderId = json.getJObject("data").getJArray("runs").getJObject(0).getJObject("run")
                    .getJArray("players").getJObject(0).getString("id");
            return JObject.get(new UrlBuilder().speedrun().user(holderId).build()).thenApplyAsync(j2 -> new WorldRecord(json, j2)).join();
        });
    }

    public static CompletableFuture<TimvStats> timv(String username) {
        return getStats("TIMV", username).thenApplyAsync(TimvStats::new);
    }
    public static CompletableFuture<BedStats> bed(String username) {
        return getStats("BED", username).thenApplyAsync(BedStats::new);
    }
    public static CompletableFuture<BedSpecificStats> bedSpecific(String username, String gameCode) {
        return getStats(gameCode.toUpperCase(Locale.ROOT), username).thenApplyAsync(BedSpecificStats::new);
    }
    public static CompletableFuture<BpStats> bp(String username) {
        return getStats("BP", username).thenApplyAsync(BpStats::new);
    }
    public static CompletableFuture<CaiStats> cai(String username) {
        return getStats("CAI", username).thenApplyAsync(CaiStats::new);
    }
    public static CompletableFuture<DrStats> dr(String username) {
        return getStats("DR", username).thenApplyAsync(DrStats::new);
    }
    public static CompletableFuture<GntmStats> gntm(String username) {
        return getStats("GNTM", username).thenApplyAsync(GntmStats::new);
    }
    public static CompletableFuture<GntStats> gnt(String username) {
        return getStats("GNT", username).thenApplyAsync(GntStats::new);
    }
    public static CompletableFuture<GravStats> grav(String username) {
        return getStats("GRAV", username).thenApplyAsync(GravStats::new);
    }
    public static CompletableFuture<HideStats> hide(String username) {
        return getStats("HIDE", username).thenApplyAsync(HideStats::new);
    }
    public static CompletableFuture<LabStats> lab(String username) {
        return getStats("LAB", username).thenApplyAsync(LabStats::new);
    }
    public static CompletableFuture<MimvStats> mimv(String username) {
        return getStats("MIMV", username).thenApplyAsync(MimvStats::new);
    }
    public static CompletableFuture<SgnStats> sgn(String username) {
        return getStats("SGN", username).thenApplyAsync(SgnStats::new);
    }
    public static CompletableFuture<SgStats> sg(String username) {
        return getStats("SG", username).thenApplyAsync(SgStats::new);
    }
    public static CompletableFuture<SkyStats> sky(String username) {
        return getStats("SKY", username).thenApplyAsync(SkyStats::new);
    }
    public static CompletableFuture<BdStats> bd(String username) {
        return getStats("BD", username).thenApplyAsync(BdStats::new);
    }
    public static CompletableFuture<CrStats> cr(String username) {
        return getStats("CR", username).thenApplyAsync(CrStats::new);
    }
    public static CompletableFuture<DrawStats> draw(String username) {
        return getStats("DRAW", username).thenApplyAsync(DrawStats::new);
    }
    public static CompletableFuture<EeStats> ee(String username) {
        return getStats("EE", username).thenApplyAsync(EeStats::new);
    }
    public static CompletableFuture<EfStats> ef(String username) {
        return getStats("EF", username).thenApplyAsync(EfStats::new);
    }
    public static CompletableFuture<HbStats> hb(String username) {
        return getStats("HB", username).thenApplyAsync(HbStats::new);
    }
    public static CompletableFuture<HeroStats> hero(String username) {
        return getStats("HERO", username).thenApplyAsync(HeroStats::new);
    }
    public static CompletableFuture<MmStats> mm(String username) {
        return getStats("MM", username).thenApplyAsync(MmStats::new);
    }
    public static CompletableFuture<OitcStats> oitc(String username) {
        return getStats("OITC", username).thenApplyAsync(OitcStats::new);
    }
    public static CompletableFuture<PmkStats> pmk(String username) {
        return getStats("PMK", username).thenApplyAsync(PmkStats::new);
    }
    public static CompletableFuture<RrStats> rr(String username) {
        return getStats("RR", username).thenApplyAsync(RrStats::new);
    }
    public static CompletableFuture<SlapStats> slap(String username) {
        return getStats("SLAP", username).thenApplyAsync(SlapStats::new);
    }
    public static CompletableFuture<SplStats> spl(String username) {
        return getStats("SPL", username).thenApplyAsync(SplStats::new);
    }
    public static CompletableFuture<SpStats> sp(String username) {
        return getStats("SP", username).thenApplyAsync(SpStats::new);
    }
    public static CompletableFuture<SurvStats> surv(String username) {
        return getStats("SURV", username).thenApplyAsync(SurvStats::new);
    }
}
