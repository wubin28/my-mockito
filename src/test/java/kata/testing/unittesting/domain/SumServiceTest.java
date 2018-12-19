package kata.testing.unittesting.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class SumServiceTest {

    SumService sumService = new SumService();
    ScoreRepository scoreRepositoryMock = Mockito.mock(ScoreRepository.class);

    @Before
    public void before() {
        sumService.setSomeDataService(scoreRepositoryMock);
    }

    @Test
    public void should_sum_zero_score_using_mock_of_score_repository() {
        Mockito.when(scoreRepositoryMock.retrieveAllScores()).thenReturn(new int[] {});

        Assert.assertEquals(0, sumService.sum());
    }

    @Test
    public void should_sum_three_scores_using_mock_of_score_repository() {
        Mockito.when(scoreRepositoryMock.retrieveAllScores()).thenReturn(new int[] {1, 2, 3});

        Assert.assertEquals(6, sumService.sum());
    }
}