package kalulu.service;

import kalulu.dao.PollingStationRepository;
import kalulu.models.PollingStation;
import kalulu.service.impl.PollingStationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class PollingStationServiceTest {

    @Mock
    private PollingStationRepository mockPollingStationRepository;

    private PollingStationService pollingStationService;

    @Before
    public void setUp() {
        initMocks(this);
        pollingStationService = new PollingStationServiceImpl(mockPollingStationRepository);
    }

    @Test
    public void shouldLoadPollingStationsIntoDb() throws Exception {
        pollingStationService.load("src/test/resources/polling-stations-test-mini.json");

        verify(mockPollingStationRepository, times(1))
                .save(Arrays.asList(
                        new PollingStation(0L, 1, 1, "APAC", 2, "KWANIA COUNTY", 1, "ADUKU", 1, "ADYEDA", 1, "ADYEDA CENTRE"),
                        new PollingStation(0L, 2, 1, "APAC", 2, "KWANIA COUNTY", 1, "ADUKU", 1, "ADYEDA", 2, "APORWEGI P.7 SCHOOL")
                ));
    }

    @Test
    public void shouldLoadOtherPollingStationsIntoDb() throws Exception {
        pollingStationService.load("src/test/resources/polling-stations-test.json");

        verify(mockPollingStationRepository, times(1))
                .save(Arrays.asList(
                        new PollingStation(0L, 1, 1, "APAC", 2, "KWANIA COUNTY", 1, "ADUKU", 1, "ADYEDA", 1, "ADYEDA CENTRE"),
                        new PollingStation(0L, 2, 1, "APAC", 2, "KWANIA COUNTY", 1, "ADUKU", 1, "ADYEDA", 2, "APORWEGI P.7 SCHOOL"),
                        new PollingStation(0L, 3, 1, "APAC", 2, "KWANIA COUNTY", 1, "ADUKU", 1, "ADYEDA", 3, "ADYEDA IMALO"),
                        new PollingStation(0L, 4, 1, "APAC", 2, "KWANIA COUNTY", 1, "ADUKU", 2, "ALIRA", 1, "ALIRA B"),
                        new PollingStation(0L, 5, 1, "APAC", 2, "KWANIA COUNTY", 1, "ADUKU", 2, "ALIRA", 2, "AKOT A")
                ));
    }

    @Test
    public void shouldNotLoadpollingStationsToDB() throws Exception {
        pollingStationService.load("src/test/resources/empty-polling-stations-test.json");

        verify(mockPollingStationRepository, times(0)).save(Collections.emptyList());
    }
}