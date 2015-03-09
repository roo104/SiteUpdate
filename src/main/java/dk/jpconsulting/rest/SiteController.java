package dk.jpconsulting.rest;

import dk.jpconsulting.domain.Site;
import dk.jpconsulting.repository.ISiteStatusRepository;
import dk.jpconsulting.rest.domain.RestSite;
import dk.jpconsulting.rest.domain.RestSites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/site")
public class SiteController {

    @Autowired
    private ISiteStatusRepository siteStatusRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<RestSite> addSite(@RequestBody RestSite site) {

        return new ResponseEntity<RestSite>(site, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<RestSites> getSites() {

        List<Site> sites = siteStatusRepository.getSites();

        return new ResponseEntity<RestSites>(RestSites.fromSites(sites), HttpStatus.OK);
    }

}