package kalulu.service.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import kalulu.dao.PollingStationRepository;
import kalulu.models.PSFieldValues;
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

                PSFieldValues.valueOf(fieldName).setValue(pollingStation, value);
            }
        }

        pollingStationRepository.save(pollingStations);
    }
}
