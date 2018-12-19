package kata.testing.unittesting.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ListTest {

    @Mock
    List<Score> listMock;

    @Test
    public void should_mock_returning_once() {
        when(listMock.size()).thenReturn(5);

        assertEquals(5, listMock.size());
    }

    @Test
    public void should_mock_returning_twice() {
        when(listMock.size()).thenReturn(5).thenReturn(10);

        assertEquals(5, listMock.size());
        assertEquals(10, listMock.size());
    }

    @Test
    public void should_return_default_value_for_methods_not_mocked() {
        when(listMock.get(0)).thenReturn(new Score("Alex", 100));

        assertEquals(new Score("Alex", 100), listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void should_return_for_any_int() {
        when(listMock.get(anyInt())).thenReturn(new Score("Alex", 100));

        assertEquals(new Score("Alex", 100), listMock.get(0));
        assertEquals(new Score("Alex", 100), listMock.get(1));
    }

    @Test
    public void should_verify_times_of_method_called_with_parameters() {
        listMock.get(0);
        listMock.get(1);

        verify(listMock).get(0);
        verify(listMock, times(2)).get(anyInt());
        verify(listMock, atLeast(1)).get(anyInt());
        verify(listMock, atLeastOnce()).get(anyInt());
        verify(listMock, atMost(2)).get(anyInt());
        verify(listMock, never()).get(2);
    }

    @Test
    public void should_capture_an_argument() {
        listMock.add(new Score("Alex", 100));

        ArgumentCaptor<Score> captor = ArgumentCaptor.forClass(Score.class);
        verify(listMock).add(captor.capture());

        assertEquals("Alex", captor.getValue().getName());
    }

    @Test
    public void should_capture_multiple_arguments() {
        listMock.add(new Score("Alex", 100));
        listMock.add(new Score("Ben", 90));

        ArgumentCaptor<Score> captor = ArgumentCaptor.forClass(Score.class);
        verify(listMock, times(2)).add(captor.capture());

        List<Score> allScores = captor.getAllValues();
        assertEquals("Alex", allScores.get(0).getName());
        assertEquals("Ben", allScores.get(1).getName());
    }

    @Test
    public void a_mock_does_not_retain_behavior_of_the_original_class() {
        ArrayList<Score> arrayListMock = mock(ArrayList.class);
        assertEquals(null, arrayListMock.get(0));
        assertEquals(0, arrayListMock.size());

        arrayListMock.add(new Score("Alex", 100));
        arrayListMock.add(new Score("Ben", 90));
        assertEquals(0, arrayListMock.size());

        when(arrayListMock.size()).thenReturn(5);
        assertEquals(5, arrayListMock.size());

        arrayListMock.add(new Score("Susan", 80));
        assertEquals(5, arrayListMock.size());
    }

    @Test
    public void a_spy_by_default_retains_behavior_of_the_original_class() {
        ArrayList<Score> arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add(new Score("Alex", 100));
        assertEquals(new Score("Alex", 100), arrayListSpy.get(0));
        assertEquals(1, arrayListSpy.size());

        arrayListSpy.add(new Score("Alex", 100));
        arrayListSpy.add(new Score("Ben", 90));
        assertEquals(3, arrayListSpy.size());

        when(arrayListSpy.size()).thenReturn(5);
        assertEquals(5, arrayListSpy.size());

        arrayListSpy.add(new Score("Susan", 80));
        assertEquals(5, arrayListSpy.size());
    }
}
