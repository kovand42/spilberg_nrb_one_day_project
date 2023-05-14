package net.kovand.spilberg_nrb_one_day_project.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

import java.io.Serializable;

@Entity
@Table(name = "CITY")
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The city id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private long cityId;

    /**
     * The city name.
     */
    @Nonnull
    @Column(name = "city_name")
    private String cityName;

    /**
     * The zip code.
     */
    @Nonnull
    @Column(name = "zip")
    private Integer zip;

    /**
     * The State/province.
     */
    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @Nonnull
    @JoinColumn(name = "state_province_id")
    private StateProvince stateProvince;

    /**
     * Default constructor for City class.
     */
    public City() {
    }

    /**
     * Parametrised constructor for City class.
     * @param cityName          the city name.
     * @param zip               the zip code.
     * @param stateProvince     the state/province.
     */
    public City(@Nonnull String cityName, @Nonnull Integer zip, @Nonnull StateProvince stateProvince) {
        this.cityName = cityName;
        this.zip = zip;
        this.stateProvince = stateProvince;
    }


    /**
     * Parametrised constructor for City class.
     * @param cityId            the city id.
     * @param cityName          the city name.
     * @param zip               the zip code.
     * @param stateProvince     the state/province.
     */
    public City(long cityId, @Nonnull String cityName, @Nonnull Integer zip, @Nonnull StateProvince stateProvince) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.zip = zip;
        this.stateProvince = stateProvince;
    }

    /**
     * The getter for city id.
     *
     * @return the city id.
     */
    public long getCityId() {
        return cityId;
    }

    /**
     * The getter for city name.
     *
     * @return the city name.
     */
    @Nonnull
    public String getCityName() {
        return cityName;
    }

    /**
     * The getter for zip code.
     *
     * @return the zip code.
     */
    @Nonnull
    public Integer getZip() {
        return zip;
    }

    /**
     * The getter for state/province.
     *
     * @return the state/province.
     */
    @Nonnull
    public StateProvince getStateProvince() {
        return stateProvince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (cityId != city.cityId) return false;
        if (zip != city.zip) return false;
        if (!cityName.equals(city.cityName)) return false;
        return stateProvince.equals(city.stateProvince);
    }

    @Override
    public int hashCode() {
        int result = (int) (cityId ^ (cityId >>> 32));
        result = 31 * result + cityName.hashCode();
        result = 31 * result + zip;
        result = 31 * result + stateProvince.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", zip=" + zip +
                ", stateProvince=" + stateProvince +
                '}';
    }
}
