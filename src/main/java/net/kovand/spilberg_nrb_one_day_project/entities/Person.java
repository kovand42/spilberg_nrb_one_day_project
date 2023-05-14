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
@Table(name = "PERSON")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The person id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private long personId;

    /**
     * The first name.
     */
    @Nonnull
    @Column(name = "first_name")
    private String firstName;

    /**
     * The last name.
     */
    @Nonnull
    @Column(name = "last_name")
    private String lastName;

    /**
     * The telephone number.
     */
    @Nonnull
    @Column(name = "tel")
    private String telephone;

    /**
     * Default constructor for Person class.
     */
    public Person() {
    }

    /**
     * Parametrised constructor for Person class.
     * @param firstName      the first name.
     * @param lastName       the last name.
     * @param telephone      the telephone number.
     */
    public Person(@Nonnull String firstName, @Nonnull String lastName, @Nonnull String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }


    /**
     * Parametrised constructor for Person class.
     * @param
     * @param firstName      the first name.
     * @param lastName       the last name.
     * @param telephone      the telephone number.
     */
    public Person(long personId, @Nonnull String firstName, @Nonnull String lastName, @Nonnull String telephone) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    /**
     * The getter for person id.
     *
     * @return the person id.
     */
    public long getPersonId() {
        return personId;
    }


    /**
     * The getter for first name.
     *
     * @return the first name.
     */
    @Nonnull
    public String getFirstName() {
        return firstName;
    }


    /**
     * The getter for last name.
     *
     * @return the last name.
     */
    @Nonnull
    public String getLastName() {
        return lastName;
    }


    /**
     * The getter for telephone number.
     *
     * @return the telephone number.
     */
    @Nonnull
    public String getTelephone() {
        return telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (personId != person.personId) return false;
        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;
        return telephone.equals(person.telephone);
    }

    @Override
    public int hashCode() {
        int result = (int) (personId ^ (personId >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + telephone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
