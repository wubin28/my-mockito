package kata.testing.unittesting.domain;

import java.util.Objects;

public class Score {
    private final String name;
    private final int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return score == score1.score &&
                name.equals(score1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
