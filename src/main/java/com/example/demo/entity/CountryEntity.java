package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "country")
@Entity
public class CountryEntity {

    @Id
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "continent", nullable = false)
    private String continent;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "surfacearea")
    private Float surfaceArea;

    @Column(name = "indepyear", nullable = false)
    private Float IndepYear;

    @Column(name = "population", nullable = false)
    private Integer population;

    @Column(name = "lifeexpectancy")
    private Float lifeExpectancy;

    @Column(name = "gnp")
    private Float gnp;

    @Column(name = "gnpold")
    private Float gnpOld;

    @Column(name = "localname", nullable = false)
    private String localName;

    @Column(name = "governmentform", nullable = false)
    private String governmentForm;

    @Column(name = "headofstate", nullable = false)
    private String headOfState;

    @Column(name = "capital")
    private Integer capital;

    @Column(name = "code2", nullable = false)
    private String code2;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<CityEntity> cities;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Float getIndepYear() {
        return IndepYear;
    }

    public void setIndepYear(Float indepYear) {
        IndepYear = indepYear;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Float getGnp() {
        return gnp;
    }

    public void setGnp(Float gnp) {
        this.gnp = gnp;
    }

    public Float getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(Float gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public Set<CityEntity> getCities() {
        return cities;
    }

    public void setCities(Set<CityEntity> cities) {
        this.cities = cities;
    }
}
