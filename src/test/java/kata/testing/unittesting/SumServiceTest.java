package kata.testing.unittesting;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SumServiceTest {

    @Test
    public void should_sum_using_mock_of_score_repository() {
        SumService sumService = new SumService();
        ScoreRepository scoreRepositoryMock = mock(ScoreRepository.class);
        when(scoreRepositoryMock.retrieveAllScores()).thenReturn(new int[] {1, 2, 3});
        sumService.setSomeDataService(scoreRepositoryMock);

        assertEquals(6, sumService.sum());
    }
}