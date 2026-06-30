package com.mockitoexercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise5Test {

    @Test
    public void testMultipleReturnValues() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        when(mockApi.getData()).thenReturn("First Call", "Second Call", "Third Call");

        MyService service = new MyService(mockApi);

        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());
        assertEquals("Third Call", service.fetchData());
    }
}
