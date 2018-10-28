package pw.roccodev.beezig.hiveapi.wrapper.monthly;

public interface MonthliesReady {

    MonthlyProfile getMonthlyProfile();
    MonthlyProfile getMonthlyProfile(String uuid);
    MonthlyProfile getMonthlyProfile(int humanPlace);

    MonthlyLeaderboard getMonthlyLeaderboard();
    MonthlyLeaderboard getMonthlyLeaderboard(int from, int to);

}
