package com.mockitoexercise;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise4Test {

    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        doNothing().when(mockApi).sendData("Hello");

        MyService service = new MyService(mockApi);
        service.sendData("Hello");

        verify(mockApi).sendData("Hello");
    }
}
