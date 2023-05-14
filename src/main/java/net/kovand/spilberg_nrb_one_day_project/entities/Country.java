package net.kovand.spilberg_nrb_one_day_project.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.io.Serializable;

@Entity
@Table(name="COUNTRY")
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The country id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private long countryId;

    /**
     * The country name.
     */
    @Nonnull
    @Column(name="country_name")
    private String countryName;

    /**
     * Default constructor for Country class.
     */
    public Country() {
    }

    /**
     * Parametrised constructor for Country class.
     * @param countryName   the country name.
     */
    public Country(@Nonnull String countryName) {
        this.countryName = countryName;
    }

    /**
     * Parametrised constructor for Country class.
     * @param countryId     the country id.
     * @param countryName   the country name.
     */
    public Country(long countryId, @Nonnull String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    /**
     * The getter for country id.
     *
     * @return the country id.
     */
    public long getCountryId() {
        return countryId;
    }

    /**
     * The getter for country name.
     *
     * @return the country name.
     */
    @Nonnull
    public String getCountryName() {
        return countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (countryId != country.countryId) return false;
        return countryName.equals(country.countryName);
    }

    @Override
    public int hashCode() {
        int result = (int) (countryId ^ (countryId >>> 32));
        result = 31 * result + countryName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
