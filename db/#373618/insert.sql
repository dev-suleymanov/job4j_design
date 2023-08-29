insert into devices(name, price) values('GeForce GTX 1060 6Gb', 27500.0);
insert into devices(name, price) values('Intel Core i3 8350K', 8650.0);
insert into devices(name, price) values('A4Tech X-718BK', 1350.0);
insert into devices(name, price) values('Intel Core i5 9600KF', 11590.0);
insert into devices(name, price) values('GeForce GTX 3050 8Gb', 31000.0);

insert into people(name) values('Ivan');
insert into people(name) values('Petr');
insert into people(name) values('Oleg');

insert into devices_people(device_id, people_id) values(1, 1);
insert into devices_people(device_id, people_id) values(2, 1);
insert into devices_people(device_id, people_id) values(3, 2);
insert into devices_people(device_id, people_id) values(4, 3);
insert into devices_people(device_id, people_id) values(5, 3);
