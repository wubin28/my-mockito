package kata.testing.unittesting.domain;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class SumServiceTest {

    @Test
    public void should_sum_using_mock_of_score_repository() {
        SumService sumService = new SumService();
        ScoreRepository scoreRepositoryMock = Mockito.mock(ScoreRepository.class);
        Mockito.when(scoreRepositoryMock.retrieveAllScores()).thenReturn(new int[] {1, 2, 3});
        sumService.setSomeDataService(scoreRepositoryMock);

        Assert.assertEquals(6, sumService.sum());
    }
}