// https://www.codewars.com/kata/5941c545f5c394fef900000c/train/java

import java.util.*;

public class Warrior {
    private int level = 1;
    private int experience = 100;
    private String rank = "Pushover";
    private List<String> achievements = new ArrayList<>();
    private String[] ranks = {"Pushover", "Novice", "Fighter", "Warrior", "Veteran", "Sage", 
                            "Elite", "Conqueror", "Champion", "Master", "Greatest"};
    static int maxLevel = 100;
    static int maxExperience = 10000;

    public Warrior() {

    }

    private void updateExperience(int experience) {
        if (this.experience + experience >= maxExperience) {
            this.experience = maxExperience;
        } else {
            this.experience += experience;
        }
        this.level = this.experience / 100;
        this.rank = this.ranks[this.level / 10];
    }

    public String battle(int enemyLevel) {
        if (enemyLevel < 1 || enemyLevel > 100) {
            return "Invalid level";
        }

        int diff = enemyLevel - this.level;

        if (diff >= 5 && !this.ranks[enemyLevel / 10].equals(this.rank)) {
            return "You've been defeated";
        }
        
        if (diff == 0) {
            updateExperience(10);
            return "A good fight";
        } else if (diff == -1) {
            updateExperience(5);
            return "A good fight";
        } else if (diff > 0) {
            updateExperience(20 * diff * diff);
            return "An intense fight";
        }

        return "Easy fight";
    }

    public String training(String description, int points, int minLevelReq) {
        if (this.level < minLevelReq) {
            return "Not strong enough";
        }

        updateExperience(points);
        achievements.add(description);
        return description;
    }

    public int level() {
        return this.level;
    }

    public int experience() {
        return this.experience;
    }

    public String rank() {
        return this.rank;
    }

    public List<String> achievements() {
        return this.achievements;
    }
}
