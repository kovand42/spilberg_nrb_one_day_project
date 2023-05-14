--
-- Table structure for table COUNTRY
--
CREATE TABLE COUNTRY (
    country_id int unsigned NOT NULL AUTO_INCREMENT primary key,
    country_name varchar(63) NOT NULL unique
);

--
-- Table structure for table STATE_PROVINCE
--
CREATE TABLE STATE_PROVINCE (
    state_province_id int unsigned NOT NULL AUTO_INCREMENT primary key,
    state_province_name varchar(64) NOT NULL,
    country_id int unsigned NOT NULL,
    CONSTRAINT state_province_country_id FOREIGN KEY (country_id) REFERENCES COUNTRY(country_id),
    UNIQUE KEY `unique_state_province_id` (`state_province_name`,`country_id`)
);

--
-- Table structure for table CITY
--
CREATE TABLE CITY (
    city_id int unsigned NOT NULL AUTO_INCREMENT primary key,
    city_name varchar(63) NOT NULL,
    zip int unsigned NOT NULL,
    state_province_id int unsigned NOT NULL,
    CONSTRAINT city_state_province_id FOREIGN KEY (state_province_id) REFERENCES STATE_PROVINCE(state_province_id),
    UNIQUE KEY `unique_city_id` (`state_province_id`,`zip`)
);

--
-- Table structure for table ADDRESS
--
CREATE TABLE ADDRESS (
    address_id int unsigned NOT NULL AUTO_INCREMENT primary key,
    street varchar(63) NOT NULL,
    address_line_2 varchar(63) NOT NULL,
    city_id int unsigned NOT NULL,
    CONSTRAINT address_city_id FOREIGN KEY (city_id) REFERENCES CITY(city_id)
);

--
-- Table structure for table PERSON
--
CREATE TABLE PERSON (
    person_id int unsigned NOT NULL AUTO_INCREMENT primary key,
    first_name varchar(63) NOT NULL,
    last_name varchar(63) NOT NULL,
    tel varchar(15) NOT NULL UNIQUE
);

--
-- Table structure for table DRIVER
--
CREATE TABLE DRIVER (
    driver_id int unsigned NOT NULL AUTO_INCREMENT primary key,
    person_id int unsigned NOT NULL,
    birth_date varchar(10),
    email varchar(63) NOT NULL UNIQUE,
    emergency_contact int unsigned NOT NULL,
    er_relationship varchar(127) NOT NULL,
    CONSTRAINT emergency_contact_id FOREIGN KEY (emergency_contact) REFERENCES PERSON(person_id)
);

--
-- Table structure for table CAR
--
CREATE TABLE CAR (
    car_id int unsigned NOT NULL AUTO_INCREMENT primary key,
    make varchar(63) NOT NULL,
    model varchar(63) NOT NULL,
    year varchar(4) NOT NULL
);

--
-- Table structure for table RACE_CAR
--
CREATE TABLE RACE_CAR (
    race_car_id int unsigned NOT NULL AUTO_INCREMENT primary key,
    car_id int unsigned NOT NULL,
    color varchar(63) NOT NULL,
    plate_number varchar(15) NOT NULL,
    modifications varchar(511),
    CONSTRAINT race_car_car_id FOREIGN KEY (car_id) REFERENCES CAR(car_id)
);
