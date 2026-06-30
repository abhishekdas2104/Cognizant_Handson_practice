package com.mockitoexercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise3Test {

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        when(mockApi.getDataById(anyInt())).thenReturn("Data for any ID");
        when(mockApi.getDataById(eq(5))).thenReturn("Data for ID 5");

        MyService service = new MyService(mockApi);

        String resultForId5 = service.fetchDataById(5);
        String resultForId10 = service.fetchDataById(10);

        assertEquals("Data for ID 5", resultForId5);
        assertEquals("Data for any ID", resultForId10);

        verify(mockApi).getDataById(eq(5));
        verify(mockApi).getDataById(eq(10));
    }
}
