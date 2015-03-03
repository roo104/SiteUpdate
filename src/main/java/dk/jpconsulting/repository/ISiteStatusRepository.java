package dk.jpconsulting.repository;

import dk.jpconsulting.domain.Site;

import java.util.List;

public interface ISiteStatusRepository {

    List<Site> getSites();
}
