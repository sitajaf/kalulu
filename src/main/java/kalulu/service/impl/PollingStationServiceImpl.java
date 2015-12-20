package kalulu.service.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import kalulu.dao.PollingStationRepository;
import kalulu.models.PollingStation;
import kalulu.service.PollingStationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PollingStationServiceImpl implements PollingStationService {

    @Autowired
    PollingStationRepository pollingStationRepository;

    public PollingStationServiceImpl(PollingStationRepository pollingStationRepository) {
        this.pollingStationRepository = pollingStationRepository;
    }

    @Override
    public void load(String file) throws IOException {
        JsonParser jsonParser = new JsonFactory().createParser(new File(file));
        PollingStation pollingStation = new PollingStation();
        List<PollingStation> pollingStations = new ArrayList<>();

        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
            JsonToken currentToken = jsonParser.getCurrentToken();

            if (currentToken == JsonToken.START_OBJECT) {
                pollingStation = new PollingStation();
            } else if (currentToken == JsonToken.END_OBJECT) {
                pollingStations.add(pollingStation);
            } else if (currentToken == JsonToken.FIELD_NAME) {
                String fieldName = jsonParser.getValueAsString();
                jsonParser.nextToken();
                String value = jsonParser.getValueAsString();

                switch (fieldName) {
                    case "NO":
                        pollingStation.setNumber(Integer.parseInt(value));
                        break;
                    case "DIST_CODE":
                        pollingStation.setDistrictCode(Integer.parseInt(value));
                        break;
                    case "DISTRICT_NAME":
                        pollingStation.setDistrictName(value);
                        break;
                    case "EA_CODE":
                        pollingStation.setEaCode(Integer.parseInt(value));
                        break;
                    case "EA_NAME":
                        pollingStation.setEaName(value);
                        break;
                    case "SUB_COUNTY_CODE":
                        pollingStation.setSubCountyCode(Integer.parseInt(value));
                        break;
                    case "SUB_COUNTY_NAME":
                        pollingStation.setSubCountyName(value);
                        break;
                    case "PARISH_CODE":
                        pollingStation.setParishCode(Integer.parseInt(value));
                        break;
                    case "PARISH_NAME":
                        pollingStation.setParishName(value);
                        break;
                    case "PS_CODE":
                        pollingStation.setPsCode(Integer.parseInt(value));
                        break;
                    case "POLLING_STATION_NAME":
                        pollingStation.setPsName(value);
                        break;
                }
            }
        }

        pollingStationRepository.save(pollingStations);
    }
}
