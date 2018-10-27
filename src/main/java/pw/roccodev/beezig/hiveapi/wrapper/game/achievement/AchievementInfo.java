package pw.roccodev.beezig.hiveapi.wrapper.game.achievement;

import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class AchievementInfo {

    private JObject source;

    public AchievementInfo(JObject source) {
        this.source = source;
    }

    public String getEnumName() {
        return source.getString("name");
    }

    public String getPublicName() {
        return source.getString("publicname");
    }

    public String getDescription() {
        return source.getString("description");
    }

    public int getStages() {
        return source.getInt("stages");
    }

    public boolean isSecret() {
        return source.getBoolean("secret");
    }

    public boolean isCustom() {
        return source.getBoolean("custom");
    }

    public boolean isDisabled() {
        return source.getBoolean("disabled");
    }

    public RewardType getRewardType() {
        return RewardType.get(source.getString("rewardtype"));
    }

    public String getRewardArguments() {
        return source.getString("rewardarguments");
    }

    public enum RewardType {

        /**
         * No reward.
         * The majority of achievements has this.
         */
        NONE,

        /**
         * Gives a banner as a reward.
         * Currently used in DeathRun.
         *
         * The rewardarguments field will have the banner data.
         */
        BANNER,

        /**
         * Gives a certain amount of tokens as a reward.
         * Currently used in Trouble in Mineville.
         *
         * The rewardarguments field will have the token amount.
         */
        TOKEN,

        /**
         * Fallback for any unknown type.
         */
        UNKNOWN;

        public static RewardType get(String query) {
            for(RewardType type : values()) {
                if(type.toString().equals(query)) return type;
            }
            return UNKNOWN;
        }

    }

}
