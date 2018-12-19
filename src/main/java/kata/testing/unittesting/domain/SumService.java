package kata.testing.unittesting.domain;

import java.util.stream.IntStream;

public class SumService {
    private ScoreRepository scoreRepository;

    public int sum() {
        return IntStream.of(this.scoreRepository.retrieveAllScores()).sum();
    }

    public void setScoreRepository(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }
}
