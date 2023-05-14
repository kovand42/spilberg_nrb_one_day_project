package net.kovand.spilberg_nrb_one_day_project.repositories;

import net.kovand.spilberg_nrb_one_day_project.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByCountryName(String countryName);
}
