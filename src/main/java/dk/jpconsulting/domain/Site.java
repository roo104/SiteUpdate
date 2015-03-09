package dk.jpconsulting.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "site")
public class Site implements Serializable {

    @Id
    @Column(columnDefinition = "BINARY(16)", length = 16)
    private UUID id;
    private final String url;
    private LocalDateTime lastUpdate;
    private String checkSum;

    public Site(String url) {
        this.url = url;
    }

    public UUID getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public String getCheckSum() {
        return checkSum;
    }

    public boolean isSiteUpdated() {
        return true;
    }

    public static Site createSite(String url) {
        Site site = new Site(url);
        site.id = UUID.randomUUID();

        return site;
    }

    @Override
    public String toString() {
        return "RestSite{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", checkSum='" + checkSum + '\'' +
                '}';
    }
}
