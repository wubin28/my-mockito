package kata.testing.unittesting;

import java.util.stream.IntStream;

public class SomeBusinessImpl {
    private SomeDataService someDataServivce;

    public int calculateSumUsingDataService() {
        int[] data = this.someDataServivce.retrieveAllData();
        return IntStream.of(data).sum();
    }

    public void setSomeDataService(SomeDataService dataService) {
        this.someDataServivce = dataService;
    }
}
