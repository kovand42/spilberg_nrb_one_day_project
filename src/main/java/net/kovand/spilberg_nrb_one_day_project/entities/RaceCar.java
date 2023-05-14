package net.kovand.spilberg_nrb_one_day_project.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="RACE_CAR")
public class RaceCar implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The race car id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "race_car_id")
    private long raceCarId;

    /**
     * The car.
     */
    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @Nonnull
    @JoinColumn(name = "car_id")
    private Car car;

    /**
     * The color.
     */
    @Nonnull
    @Column(name = "color")
    private String color;

    /**
     * The plate number.
     */
    @Nonnull
    @Column(name = "plate_number")
    private String plateNumber;

    /**
     * The modifications.
     */
    @Nonnull
    @Column(name = "modifications")
    private String modifications;

    /**
     * Default constructor for Car class.
     */
    public RaceCar() {
    }

    /**
     * Parametrised constructor for Car class.
     * @param car           the car.
     * @param color         the color.
     * @param plateNumber   the plate number.
     * @param modifications the modifications
     */
    public RaceCar(@Nonnull Car car, @Nonnull String color, @Nonnull String plateNumber, @Nonnull String modifications) {
        this.car = car;
        this.color = color;
        this.plateNumber = plateNumber;
        this.modifications = modifications;
    }

    /**
     * Parametrised constructor for Car class.
     * @param raceCarId     the race car id.
     * @param car           the car.
     * @param color         the color.
     * @param plateNumber   the plate number.
     * @param modifications the modifications
     */
    public RaceCar(long raceCarId, @Nonnull Car car, @Nonnull String color, @Nonnull String plateNumber,
                   @Nonnull String modifications) {
        this.raceCarId = raceCarId;
        this.car = car;
        this.color = color;
        this.plateNumber = plateNumber;
        this.modifications = modifications;
    }

    /**
     * The getter for race car id.
     *
     * @return the race car id.
     */
    public long getRaceCarId() {
        return raceCarId;
    }

    /**
     * The getter for car.
     *
     * @return the car.
     */
    @Nonnull
    public Car getCar() {
        return car;
    }

    /**
     * The getter for color.
     *
     * @return the color.
     */
    @Nonnull
    public String getColor() {
        return color;
    }

    /**
     * The getter for plate number.
     *
     * @return the plate number.
     */
    @Nonnull
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * The getter for modifications.
     *
     * @return the modifications.
     */
    @Nonnull
    public String getModifications() {
        return modifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceCar raceCar = (RaceCar) o;

        if (raceCarId != raceCar.raceCarId) return false;
        if (!car.equals(raceCar.car)) return false;
        if (!color.equals(raceCar.color)) return false;
        if (!plateNumber.equals(raceCar.plateNumber)) return false;
        return modifications.equals(raceCar.modifications);
    }

    @Override
    public int hashCode() {
        int result = (int) (raceCarId ^ (raceCarId >>> 32));
        result = 31 * result + car.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + plateNumber.hashCode();
        result = 31 * result + modifications.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RaceCar{" +
                "raceCarId=" + raceCarId +
                ", car=" + car +
                ", color='" + color + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", modifications='" + modifications + '\'' +
                '}';
    }
}
