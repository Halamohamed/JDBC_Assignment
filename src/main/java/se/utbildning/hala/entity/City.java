package se.utbildning.hala.entity;

import java.util.Objects;

public class City {
    private int cityId;
    private String cityName;
    private String cityCode;
    private String district;
    private int population;

    public City(int cityId, String cityName, String cityCode ,String district, int population) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.district = district;
        this.population = population;
    }
    public City(String cityName, String cityCode,String district, int population) {
        this(0,cityName,cityCode,district,population);
    }

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId &&
                population == city.population &&
                Objects.equals(cityName, city.cityName) &&
                Objects.equals(cityCode, city.cityCode) &&
                Objects.equals(district, city.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName, cityCode, district, population);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("cityId=").append(cityId);
        sb.append(", cityName='").append(cityName).append('\'');
        sb.append(", cityCode='").append(cityCode).append('\'');
        sb.append(", district='").append(district).append('\'');
        sb.append(", population=").append(population);
        sb.append('}');
        return sb.toString();
    }
}
