package com.mockitoexercise;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise7Test {

    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        doThrow(new RuntimeException("API failed")).when(mockApi).processData("bad data");

        MyService service = new MyService(mockApi);

        assertThrows(RuntimeException.class, () -> service.processData("bad data"));

        verify(mockApi).processData("bad data");
    }
}
