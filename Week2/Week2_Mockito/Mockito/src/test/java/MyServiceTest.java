import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.ExternalApi;
import org.example.MyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        System.out.println("Running testExternalApi...");

        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        System.out.println("Fetched Data: " + result);
        assertEquals("Mock Data", result);

        System.out.println("testExternalApi PASSED ✅\n");
    }

    @Test
    public void testVerifyInteraction() {
        System.out.println("Running testVerifyInteraction...");

        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();
        verify(mockApi).getData();

        System.out.println("Verified interaction with getData() method.");
        System.out.println("testVerifyInteraction PASSED ✅\n");
    }
}