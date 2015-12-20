package kalulu.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollingStation that = (PollingStation) o;

        if (number != that.number) return false;
        if (districtCode != that.districtCode) return false;
        if (eaCode != that.eaCode) return false;
        if (subCountyCode != that.subCountyCode) return false;
        if (parishCode != that.parishCode) return false;
        if (psCode != that.psCode) return false;
//        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (districtName != null ? !districtName.equals(that.districtName) : that.districtName != null) return false;
        if (eaName != null ? !eaName.equals(that.eaName) : that.eaName != null) return false;
        if (subCountyName != null ? !subCountyName.equals(that.subCountyName) : that.subCountyName != null)
            return false;
        if (parishName != null ? !parishName.equals(that.parishName) : that.parishName != null) return false;
        return !(psName != null ? !psName.equals(that.psName) : that.psName != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + number;
        result = 31 * result + districtCode;
        result = 31 * result + (districtName != null ? districtName.hashCode() : 0);
        result = 31 * result + eaCode;
        result = 31 * result + (eaName != null ? eaName.hashCode() : 0);
        result = 31 * result + subCountyCode;
        result = 31 * result + (subCountyName != null ? subCountyName.hashCode() : 0);
        result = 31 * result + parishCode;
        result = 31 * result + (parishName != null ? parishName.hashCode() : 0);
        result = 31 * result + psCode;
        result = 31 * result + (psName != null ? psName.hashCode() : 0);
        return result;
    }
}
