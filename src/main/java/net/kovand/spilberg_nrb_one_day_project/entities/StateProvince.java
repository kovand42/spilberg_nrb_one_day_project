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
@Table(name = "STATE_PROVINCE")
public class StateProvince implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The state/province id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_province_id")
    private long stateProvinceId;

    /**
     * The state/province name.
     */
    @Nonnull
    @Column(name="state_province_name")
    private String stateProvinceName;

    /**
     * The country.
     */
    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="country_id")
    @Nonnull
    private Country country;

    /**
     * Default constructor for StateProvince class.
     */
    public StateProvince() {
    }

    /**
     * Parametrised constructor for StateProvince class.
     * @param stateProvinceName   the state/province name.
     * @param country             the Country.
     */
    public StateProvince(@Nonnull String stateProvinceName, @Nonnull Country country) {
        this.stateProvinceName = stateProvinceName;
        this.country = country;
    }


    /**
     * Parametrised constructor for StateProvince class.
     * @param stateProvinceId     the state/province id.
     * @param stateProvinceName   the state/province name.
     * @param country             the Country.
     */
    public StateProvince(long stateProvinceId, @Nonnull String stateProvinceName, @Nonnull Country country) {
        this.stateProvinceId = stateProvinceId;
        this.stateProvinceName = stateProvinceName;
        this.country = country;
    }

    /**
     * The getter for state/province id.
     *
     * @return the state/province id.
     */
    public long getStateProvinceId() {
        return stateProvinceId;
    }

    /**
     * The getter for state/province name.
     *
     * @return the state/province name.
     */
    @Nonnull
    public String getStateProvinceName() {
        return stateProvinceName;
    }

    /**
     * The getter for country.
     *
     * @return the state/province name.
     */
    @Nonnull
    public Country getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StateProvince that = (StateProvince) o;

        if (stateProvinceId != that.stateProvinceId) return false;
        if (!stateProvinceName.equals(that.stateProvinceName)) return false;
        return country.equals(that.country);
    }

    @Override
    public int hashCode() {
        int result = (int) (stateProvinceId ^ (stateProvinceId >>> 32));
        result = 31 * result + stateProvinceName.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StateProvince{" +
                "stateProvinceId=" + stateProvinceId +
                ", stateProvinceName='" + stateProvinceName + '\'' +
                ", country=" + country +
                '}';
    }
}
