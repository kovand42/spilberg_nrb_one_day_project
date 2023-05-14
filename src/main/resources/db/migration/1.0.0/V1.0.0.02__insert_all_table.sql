insert into COUNTRY (country_name)
values
    ('BELGIUM'),
    ('GERMANY'),
    ('NETHERLANDS');

insert into STATE_PROVINCE (state_province_name, country_id)
values
    ('Flemish Brabant',(select c.country_id from COUNTRY c where c.country_name = 'BELGIUM')),
    ('Walloon Brabant',(select c.country_id from COUNTRY c where c.country_name = 'BELGIUM')),
    ('North Brabant',(select c.country_id from COUNTRY c where c.country_name = 'NETHERLANDS'));

insert into CITY (city_name, zip, state_province_id)
values
    ('Leuven',3000,(select sp.state_province_id from STATE_PROVINCE sp where sp.state_province_name = 'Flemish Brabant')),
    ('Waver',1300,(select sp.state_province_id from STATE_PROVINCE sp where sp.state_province_name = 'Walloon Brabant')),
    ('Eindhoven',5615,(select sp.state_province_id from STATE_PROVINCE sp where sp.state_province_name = 'North Brabant'));

insert into ADDRESS (street, address_line_2, city_id)
values
    ('De Drie Kreeften', '2', (select c.city_id from CITY c where c.city_name = 'Leuven')),
    ('Chaussée de Bruxelles','266', (select c.city_id from CITY c where c.city_name = 'Waver')),
    ('Alberdingk Thijmlaan','106', (select c.city_id from CITY c where c.city_name = 'Leuven'));

insert into PERSON (first_name, last_name, tel)
values
    ('Andras','Kovacs','+32486789011'),
    ('Thomas','Brasseur','+32484567890');

insert into DRIVER (person_id, birth_date, email, emergency_contact, er_relationship)
values
    ((select p.person_id from PERSON p where p.tel = '+32486789011'),'06-11-1975','andkov73939@yopmail.com',(select p.person_id from PERSON p where p.tel = '+32484567890' ),'brother');

insert into CAR (make, model, year)
values
    ('Honda','Civic','2015');

insert into RACE_CAR (car_id, color, plate_number, modifications)
values
    ((select c.car_id from CAR c where c.make = 'Honda' and c.model = 'Civic' and c.year = '2015'),'black','1-ABC-123','wheels on the roof to race upside down too');


