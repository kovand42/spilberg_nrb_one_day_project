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
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;

import java.io.Serializable;

@Entity
@Table(name = "DRIVER")
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The driver id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private long driverId;

    /**
     * The person.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @Nonnull
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    /**
     * The date of birth.
     */
    @Nonnull
    @Column(name = "birth_date")
    private String birthDate;

    /**
     * The email.
     */
    @Nonnull
    @Column(name = "email")
    private String email;

    /**
     * The emergency contact person.
     */
    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @Nonnull
    @JoinColumn(name = "emergency_contact")
    private Person erContact;

    /**
     * The emergency contact relationship
     */
    @Nonnull
    @Column(name = "er_relationship")
    private String erRelationship;

    /**
     * Default constructor for Driver class.
     */
    public Driver() {
    }

    /**
     * Parametrised constructor for Driver class.
     * @param person            the person.
     * @param birthDate         the date of birth.
     * @param email             the email address.
     * @param erContact         the emergency contact.
     * @param erRelationship    the emergency relationship.
     */
    public Driver(@Nonnull Person person, @Nonnull String birthDate, @Nonnull String email,
                  @Nonnull Person erContact, @Nonnull String erRelationship) {
        this.person = person;
        this.birthDate = birthDate;
        this.email = email;
        this.erContact = erContact;
        this.erRelationship = erRelationship;
    }

    /**
     * Parametrised constructor for Driver class.
     * @param person            the person.
     * @param birthDate         the date of birth.
     * @param email             the email address.
     * @param erContact         the emergency contact.
     * @param erRelationship    the emergency relationship.
     */
    public Driver(long driverId, @Nonnull Person person, @Nonnull String birthDate, @Nonnull String email,
                  @Nonnull Person erContact, @Nonnull String erRelationship) {
        this.driverId = driverId;
        this.person = person;
        this.birthDate = birthDate;
        this.email = email;
        this.erContact = erContact;
        this.erRelationship = erRelationship;
    }

    /**
     * The getter for driver id.
     *
     * @return the driver id.
     */
    public long getDriverId() {
        return driverId;
    }

    /**
     * The getter for person.
     *
     * @return the person.
     */
    @Nonnull
    public Person getPerson() {
        return person;
    }

    /**
     * The getter for date of birth.
     *
     * @return the date of birth.
     */
    @Nonnull
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * The getter for email.
     *
     * @return the email.
     */
    @Nonnull
    public String getEmail() {
        return email;
    }

    /**
     * The getter for emergency contact.
     *
     * @return the emergency contact person.
     */
    @Nonnull
    public Person getErContact() {
        return erContact;
    }

    /**
     * The getter for emergency relationship.
     *
     * @return the emergency relationship.
     */
    @Nonnull
    public String getErRelationship() {
        return erRelationship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (driverId != driver.driverId) return false;
        if (!person.equals(driver.person)) return false;
        if (!birthDate.equals(driver.birthDate)) return false;
        if (!email.equals(driver.email)) return false;
        if (!erContact.equals(driver.erContact)) return false;
        return erRelationship.equals(driver.erRelationship);
    }

    @Override
    public int hashCode() {
        int result = (int) (driverId ^ (driverId >>> 32));
        result = 31 * result + person.hashCode();
        result = 31 * result + birthDate.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + erContact.hashCode();
        result = 31 * result + erRelationship.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", person=" + person +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", erContact=" + erContact +
                ", erRelationship='" + erRelationship + '\'' +
                '}';
    }
}
