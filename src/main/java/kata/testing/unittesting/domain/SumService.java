package kata.testing.unittesting.domain;

import java.util.stream.IntStream;

public class SumService {
    private ScoreRepository someDataServivce;

    public int sum() {
        int[] data = this.someDataServivce.retrieveAllScores();
        return IntStream.of(data).sum();
    }

    public void setSomeDataService(ScoreRepository dataService) {
        this.someDataServivce = dataService;
    }
}
