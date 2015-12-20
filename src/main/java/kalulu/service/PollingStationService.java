package kalulu.service;

import java.io.IOException;

public interface PollingStationService {
    void load(String file) throws IOException;

    boolean alreadyLoaded();
}
