package com.mockitoexercise;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class Exercise6Test {

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.fetchData();
        service.sendData("Hello");
        service.fetchDataById(1);

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).sendData("Hello");
        inOrder.verify(mockApi).getDataById(1);
    }
}
