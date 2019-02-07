package com.example.demo.converter;

import com.example.demo.entity.CityEntity;
import com.example.demo.vo.CityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class CityConverter {

    private CityConverter() {
    }

    public static List<CityVO> toVO(final Set<CityEntity> countryEntities) {

        if (CollectionUtils.isEmpty(countryEntities)) {
            return Collections.emptyList();
        }

        return countryEntities
                .stream()
                .map(CityConverter::toVO)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        //.flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty)) // java 8
    }

    public static Optional<CityVO> toVO(final CityEntity CityEntity) {

        if (Objects.isNull(CityEntity)) {
            return Optional.empty();
        }

        final CityVO cityVO = new CityVO();
        BeanUtils.copyProperties(CityEntity, cityVO);
        return Optional.of(cityVO);
    }
}
