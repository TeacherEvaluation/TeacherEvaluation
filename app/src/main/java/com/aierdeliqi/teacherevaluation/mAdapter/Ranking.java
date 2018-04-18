package com.aierdeliqi.teacherevaluation.mAdapter;

public class Ranking {
    private String rankteacher;
    private String rankscore;

    public Ranking() {
    }

    public Ranking(String rankteacher, String rankscore) {
        this.rankteacher = rankteacher;
        this.rankscore = rankscore;
    }

    public String getRankteacher() {
        return rankteacher;
    }

    public String getRankscore() {
        return rankscore;
    }

    public void setRankteacher(String rankteacher) {
        this.rankteacher = rankteacher;
    }

    public void setRankscore(String rankscore) {
        this.rankscore = rankscore;
    }

}
