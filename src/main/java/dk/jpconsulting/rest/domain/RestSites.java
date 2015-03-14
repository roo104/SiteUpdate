package dk.jpconsulting.rest.domain;

import dk.jpconsulting.domain.Site;

import java.util.ArrayList;
import java.util.List;

public class RestSites {

    private List<RestSite> restSiteList;

    public RestSites() {
        this.restSiteList = new ArrayList<>();
    }

    public List<RestSite> getRestSiteList() {
        return restSiteList;
    }

    public void setRestSiteList(List<RestSite> restSiteList) {
        this.restSiteList = restSiteList;
    }

    public static RestSites fromSites(List<Site> sites) {
        RestSites restSites = new RestSites();
        for (Site site : sites) {
            restSites.restSiteList.add(RestSite.fromSite(site));
        }

        return restSites;
    }
}
