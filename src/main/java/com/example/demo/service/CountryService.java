package com.example.demo.service;

import com.example.demo.converter.CountryConverter;
import com.example.demo.entity.CountryEntity;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.specification.CountrySpecification;
import com.example.demo.vo.CountryVO;
import com.example.demo.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;


    public List<CountryVO> findAll() {
        return CountryConverter.toVO( countryRepository.findAll() );
    }

    public PageVO<CountryVO> findAll(final Pageable pageable) {
        return CountryConverter.toVO( countryRepository.findAll(pageable) );
    }

    public Optional<CountryVO> findByCountryCode(final String code) {
        final Optional<CountryEntity> countryEntity = countryRepository.findByCode(code);
        return countryEntity.flatMap(CountryConverter::toVO);
    }

    public PageVO<CountryVO> findAllWithCitiesPageable(final Pageable pageable) {
        return CountryConverter.toVO( countryRepository.findAllWithCitiesPageable(pageable) );
    }

    public PageVO<CountryVO> findByPopulationAndSurfaceArea(final Pageable pageable,
                                                            final Integer population,
                                                            final Integer surfaceArea) {

        Specification<CountryEntity> spec = CountrySpecification.getByPopulationAndSurfaceArea(population, surfaceArea);
        return CountryConverter.toVO( countryRepository.findAll( spec, pageable) );
    }

    public void create(final CountryVO countryVO) {
        final Optional<CountryEntity> countryEntity = CountryConverter.toEntity(countryVO);
        countryEntity.ifPresent( countryRepository::save );
    }

}
