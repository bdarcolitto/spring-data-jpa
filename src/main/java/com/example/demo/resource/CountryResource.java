package com.example.demo.resource;

import com.example.demo.service.CountryService;
import com.example.demo.vo.CountryVO;
import com.example.demo.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa/country")
public class CountryResource {

    @Autowired
    private CountryService countryService;


    ///// JPA

    @GetMapping("/list-all") // http://localhost:8080/jpa/country/list-all
    public ResponseEntity<List<CountryVO>> findAll() {
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list") // http://localhost:8080/jpa/country/list?page=1&size=3&sort=code,DESC
    public ResponseEntity<PageVO<CountryVO>> findAllPageable(final Pageable pageable) {
        return new ResponseEntity<>(countryService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{code}") // http://localhost:8080/jpa/country/AIA
    public ResponseEntity<Optional<CountryVO>> findByCountryCode(@PathVariable("code") final String code) {
        return new ResponseEntity<>(countryService.findByCountryCode(code), HttpStatus.OK);
    }

    // JPA WITH @QUERY

    @GetMapping("/query/list") // http://localhost:8080/jpa/country/query/list?page=1&size=3&sort=code,DESC
    public ResponseEntity<PageVO<CountryVO>> findAllWithCitiesPageable(final Pageable pageable) {
        return new ResponseEntity<>(countryService.findAllWithCitiesPageable(pageable), HttpStatus.OK);
    }

    // SPECIFICATION


    @GetMapping("/spec/list") // http://localhost:8080/jpa/country/spec/list?page=1&size=3&sort=code,DESC
    public ResponseEntity<PageVO<CountryVO>> findByPopulationAndSurfaceArea(final Pageable pageable,
                                                                            @PathParam("population") final Integer population,
                                                                            @PathParam("surfaceArea") Integer surfaceArea) {

        return new ResponseEntity<>(countryService
                .findByPopulationAndSurfaceArea(pageable, population, surfaceArea), HttpStatus.OK
        );
    }
}
