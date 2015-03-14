package dk.jpconsulting.batch;


import dk.jpconsulting.domain.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class SiteBatchProcessor implements ItemProcessor<Site, Site> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SiteBatchProcessor.class);

    @Override
    public Site process(final Site site) throws Exception {
        LOGGER.info("Processing site [{}]", site);
        return site;
    }
}
