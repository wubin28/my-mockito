package kata.testing.unittesting.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListTest {

    @Mock
    List<Object> listMock;

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
        when(listMock.get(0)).thenReturn("hello");

        assertEquals("hello", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

}
