package com.bridelabz.json.iplcensoranalyser;

import java.util.Map;

// Class representing the structure of an IPL match
public class MatchDetails {
    // Attributes
    public int match_id;
    public String team1;
    public String team2;
    public Map<String, Integer> score;
    public String winner;
    public String player_of_match;

    // Default constructor
    public MatchDetails() {}
}
