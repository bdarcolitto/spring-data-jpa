package com.example.demo.converter;

import com.example.demo.entity.CountryEntity;
import com.example.demo.vo.CountryVO;
import com.example.demo.vo.PageVO;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountryConverter {

    private CountryConverter() {    }

    public static List<CountryVO> toVO(final List<CountryEntity> countryEntities) {

        if( CollectionUtils.isEmpty(countryEntities) ) {
            return Collections.emptyList();
        }

        return countryEntities
                .stream()
                .map(CountryConverter::toVO)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        //.flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty)) // java 8
    }

    public static Optional<CountryVO> toVO(final CountryEntity countryEntity) {

        if(Objects.isNull(countryEntity)) {
            return Optional.empty();
        }

        final CountryVO countryVO = new CountryVO();
        BeanUtils.copyProperties(countryEntity, countryVO);

        try {
            // converte cidades caso inicializadas
            countryVO.setCities(CityConverter.toVO(countryEntity.getCities()));
        } catch ( LazyInitializationException e) {
            // nothing to do
        }

        return Optional.of(countryVO);
    }

    public static PageVO<CountryVO> toVO(final Page<CountryEntity> page) {
        List<CountryVO> countryVOS = page
                .get()
                .map(CountryConverter::toVO)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        return new PageVO<>(countryVOS, page.getTotalPages(), page.getTotalElements());
    }
}
