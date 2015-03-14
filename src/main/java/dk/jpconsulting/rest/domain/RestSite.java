package dk.jpconsulting.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dk.jpconsulting.domain.Site;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestSite {

    private String id;
    private String url;
    private LocalDateTime lastUpdate;
    private String checkSum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }

    public Site createSite() {
        Site site = Site.createSite(this.url);
        this.id = site.getId().toString();
        return site;
    }

    public static RestSite fromSite(Site site) {
        RestSite restSite = new RestSite();
        restSite.id = site.getId().toString();
        restSite.url = site.getUrl();
        restSite.lastUpdate = site.getLastUpdate();
        restSite.checkSum = site.getCheckSum();

        return restSite;

    }

}
