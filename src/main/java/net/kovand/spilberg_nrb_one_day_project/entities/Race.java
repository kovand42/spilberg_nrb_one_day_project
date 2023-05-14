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
@Table(name = "RACE")
public class Race implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The person id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "race_id")
    private long raceId;

    /**
     * The address
     */
    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @Nonnull
    @JoinColumn(name = "address_id")
    private Address address;

    /**
     * The date.
     */
    @Nonnull
    @Column(name = "date")
    private String raceDate;

    /**
     * Default constructor for Race class.
     */
    public Race() {
    }

    /**
     * Parametrised constructor for Race class.
     * @param address       the address.
     * @param raceDate      the race date.
     */
    public Race(@Nonnull Address address, @Nonnull String raceDate) {
        this.address = address;
        this.raceDate = raceDate;
    }


    /**
     * Parametrised constructor for StateProvince class.
     * @param raceId        the address id.
     * @param address       the address.
     * @param raceDate      the race date.
     */
    public Race(long raceId, @Nonnull Address address, @Nonnull String raceDate) {
        this.raceId = raceId;
        this.address = address;
        this.raceDate = raceDate;
    }

    /**
     * The getter for race id.
     *
     * @return the race id.
     */
    public long getRaceId() {
        return raceId;
    }

    /**
     * The getter for address.
     *
     * @return the address.
     */
    @Nonnull
    public Address getAddress() {
        return address;
    }

    /**
     * The getter for race date.
     *
     * @return the race date.
     */
    @Nonnull
    public String getRaceDate() {
        return raceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Race race = (Race) o;

        if (raceId != race.raceId) return false;
        if (!address.equals(race.address)) return false;
        return raceDate.equals(race.raceDate);
    }

    @Override
    public int hashCode() {
        int result = (int) (raceId ^ (raceId >>> 32));
        result = 31 * result + address.hashCode();
        result = 31 * result + raceDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceId=" + raceId +
                ", address=" + address +
                ", raceDate='" + raceDate + '\'' +
                '}';
    }
}
