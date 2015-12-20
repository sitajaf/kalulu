package kalulu.models;

public enum PSFieldValues {
    NO {
        @Override
        public void setValue(PollingStation pollingStation, String value) {
            pollingStation.setNumber(Integer.parseInt(value));
        }
    },
    DIST_CODE {
        @Override
        public void setValue(PollingStation pollingStation, String value) {
            pollingStation.setDistrictCode(Integer.parseInt(value));
        }
    },
    DISTRICT_NAME {
        @Override
        public void setValue(PollingStation pollingStation, String value) {
            pollingStation.setDistrictName(value);
        }
    },
    EA_CODE {
        @Override
        public void setValue(PollingStation pollingStation, String value) {
            pollingStation.setEaCode(Integer.parseInt(value));
        }
    },
    EA_NAME {
        @Override
        public void setValue(PollingStation pollingStation, String value) {
            pollingStation.setEaName(value);
        }
    },
    SUB_COUNTY_CODE {
        @Override
        public void setValue(PollingStation pollingStation, String value) {
            pollingStation.setSubCountyCode(Integer.parseInt(value));
        }
    },
    SUB_COUNTY_NAME {
        @Override
        public void setValue(PollingStation pollingStation, String value) {
            pollingStation.setSubCountyName(value);
        }
    },
    PARISH_CODE {
        @Override
        public void setValue(PollingStation pollingStation, String value) {
            pollingStation.setParishCode(Integer.parseInt(value));
        }
    },
    PARISH_NAME {
        @Override
        public void setValue(PollingStation pollingStation, String value) {
            pollingStation.setParishName(value);
        }
    },
    PS_CODE {
        @Override
        public void setValue(PollingStation pollingStation, String value) {
            pollingStation.setPsCode(Integer.parseInt(value));
        }
    },
    POLLING_STATION_NAME {
        @Override
        public void setValue(PollingStation pollingStation, String value) {
            pollingStation.setPsName(value);
        }
    };

    public abstract void setValue(PollingStation pollingStation, String value);
}
