package dk.jpconsulting.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "site")
public class Site {

    @Id
    @Column(columnDefinition = "BINARY(16)", length = 16)
    private UUID id;
    private final String url;
    private LocalDateTime lastUpdate;
    private String checkSum;

    public Site(String url) {
        this.url = url;
    }

    public boolean isSiteUpdated() {
        return true;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", checkSum='" + checkSum + '\'' +
                '}';
    }
}
