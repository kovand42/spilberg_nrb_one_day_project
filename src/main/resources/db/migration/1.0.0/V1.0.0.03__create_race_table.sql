--
-- Table structure for table ADDRESS
--
CREATE TABLE RACE (
    race_id int unsigned NOT NULL AUTO_INCREMENT primary key,
    address_id int unsigned NOT NULL,
    date varchar(15) NOT NULL,
    CONSTRAINT race_address_id FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id)
);

insert into RACE (address_id, date)
values
    ((select a.address_id from ADDRESS a where a.street = 'De Drie Kreeften'), '01-06-2023');