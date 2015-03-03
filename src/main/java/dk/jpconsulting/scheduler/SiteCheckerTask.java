package dk.jpconsulting.scheduler;

import dk.jpconsulting.domain.Site;
import dk.jpconsulting.repository.ISiteStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SiteCheckerTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(SiteCheckerTask.class);

    @Autowired
    private ISiteStatusRepository siteStatusRepository;

    @Scheduled(fixedRate = 60000)
    public void checkSites() {
        List<Site> sites = siteStatusRepository.getSites();

        for (Site site : sites) {
            boolean isSiteUpdated = site.isSiteUpdated();
            LOGGER.info("site: [{}] was updated? [{}]", site, isSiteUpdated);
        }
    }
}
