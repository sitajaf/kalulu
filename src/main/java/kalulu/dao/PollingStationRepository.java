package kalulu.dao;

import kalulu.models.PollingStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollingStationRepository extends JpaRepository<PollingStation, Long> {
    // inherit all default behaviour
}
