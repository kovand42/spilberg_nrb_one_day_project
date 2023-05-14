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
@Table(name = "CAR")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The car id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private long carId;

    /**
     * The make.
     */
    @Nonnull
    @Column(name = "make")
    private String make;

    /**
     * The model.
     */
    @Nonnull
    @Column(name = "model")
    private String model;

    /**
     * The year.
     */
    @Nonnull
    @Column(name = "year")
    private String year;

    /**
     * Default constructor for Car class.
     */
    public Car() {
    }

    /**
     * Parametrised constructor for Car class.
     * @param make          the make.
     * @param model         the model.
     * @param year          the year.
     */
    public Car(@Nonnull String make, @Nonnull String model, @Nonnull String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    /**
     * Parametrised constructor for Car class.
     * @param carId         the car id.
     * @param make          the make.
     * @param model         the model.
     * @param year          the year.
     */
    public Car(long carId, @Nonnull String make, @Nonnull String model, @Nonnull String year) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    /**
     * The getter for car id.
     *
     * @return the car id.
     */
    public long getCarId() {
        return carId;
    }

    /**
     * The getter for make.
     *
     * @return the make.
     */
    @Nonnull
    public String getMake() {
        return make;
    }

    /**
     * The getter for model.
     *
     * @return the model.
     */
    @Nonnull
    public String getModel() {
        return model;
    }

    /**
     * The getter for year.
     *
     * @return the year.
     */
    @Nonnull
    public String getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (carId != car.carId) return false;
        if (!make.equals(car.make)) return false;
        if (!model.equals(car.model)) return false;
        return year.equals(car.year);
    }

    @Override
    public int hashCode() {
        int result = (int) (carId ^ (carId >>> 32));
        result = 31 * result + make.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + year.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
