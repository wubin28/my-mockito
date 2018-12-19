package kata.testing.unittesting.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SumServiceTest {

    @InjectMocks
    SumService sumService = new SumService();

    @Mock
    ScoreRepository scoreRepositoryMock;

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