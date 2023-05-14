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
@Table(name = "ADDRESS")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The address id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private long addressId;

    /**
     * The street name.
     */
    @Nonnull
    @Column(name = "street")
    private String streetName;

    /**
     * The address line 2 value.
     */
    @Nonnull
    @Column(name = "address_line_2")
    private String addressLine2;

    /**
     * The city.
     */
    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @Nonnull
    @JoinColumn(name = "city_id")
    private City city;

    /**
     * Default constructor for Address class.
     */
    public Address() {
    }

    /**
     * Parametrised constructor for Address class.
     * @param streetName         the street name.
     * @param addressLine2       the address line 2.
     * @param city               the city.
     */
    public Address(@Nonnull String streetName, @Nonnull String addressLine2, @Nonnull City city) {
        this.streetName = streetName;
        this.addressLine2 = addressLine2;
        this.city = city;
    }


    /**
     * Parametrised constructor for StateProvince class.
     * @param addressId          the address id.
     * @param streetName         the street name.
     * @param addressLine2       the address line 2.
     * @param city               the city.
     */
    public Address(long addressId, @Nonnull String streetName, @Nonnull String addressLine2, @Nonnull City city) {
        this.addressId = addressId;
        this.streetName = streetName;
        this.addressLine2 = addressLine2;
        this.city = city;
    }

    /**
     * The getter for address id.
     *
     * @return the address id.
     */
    public long getAddressId() {
        return addressId;
    }

    /**
     * The getter for street name.
     *
     * @return the street name.
     */
    @Nonnull
    public String getStreetName() {
        return streetName;
    }

    /**
     * The getter for address line 2 .
     *
     * @return the address line 2 .
     */
    @Nonnull
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * The getter for city.
     *
     * @return the city.
     */
    @Nonnull
    public City getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (addressId != address.addressId) return false;
        if (!streetName.equals(address.streetName)) return false;
        if (!addressLine2.equals(address.addressLine2)) return false;
        return city.equals(address.city);
    }

    @Override
    public int hashCode() {
        int result = (int) (addressId ^ (addressId >>> 32));
        result = 31 * result + streetName.hashCode();
        result = 31 * result + addressLine2.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", streetName='" + streetName + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city=" + city +
                '}';
    }
}
