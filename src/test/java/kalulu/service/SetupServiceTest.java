package kalulu.service;

import kalulu.service.impl.SetupServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class SetupServiceTest {
    @Mock
    PollingStationService mockPollingStationService;

    SetupServiceImpl setupService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        setupService = new SetupServiceImpl(mockPollingStationService);
    }

    @Test
    public void shouldLoadPollingStations() throws Exception {

        setupService.init();

        verify(mockPollingStationService, times(1)).load("src/resources/uganda-polling-stations.json");
    }

}
