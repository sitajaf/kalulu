package kalulu.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PollingStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number;
    private int districtCode;
    private String districtName;
    private int eaCode;
    private String eaName;
    private int subCountyCode;
    private String subCountyName;
    private int parishCode;
    private String parishName;
    private int psCode;
    private String psName;
}
