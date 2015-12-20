package kalulu.service.impl;

import kalulu.service.PollingStationService;
import kalulu.service.SetupService;

import java.io.IOException;

public class SetupServiceImpl implements SetupService {
    private PollingStationService pollingStationService;

    public SetupServiceImpl(PollingStationService pollingStationService) {
        this.pollingStationService = pollingStationService;
    }

    @Override
    public void init() {
        try {
            pollingStationService.load("src/resources/uganda-polling-stations.json"); //TODO: move this file name to properties file
        } catch (IOException e) {
            e.printStackTrace(); //TODO: add custom Exception
        }
    }
}
