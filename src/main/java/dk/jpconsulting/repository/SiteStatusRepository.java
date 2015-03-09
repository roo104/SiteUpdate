package dk.jpconsulting.repository;

import dk.jpconsulting.domain.Site;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SiteStatusRepository implements ISiteStatusRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Site> getSites() {
        List<Site> sites = new ArrayList<>();
        sites.add(Site.createSite("http://eb.dk"));

        return sites;
    }
}
