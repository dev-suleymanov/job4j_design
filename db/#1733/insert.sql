insert into car_bodies(name) values('bodie-v1');
insert into car_bodies(name) values('bodie-v2');
insert into car_bodies(name) values('bodie-v3');
insert into car_bodies(name) values('bodie-v4');
insert into car_bodies(name) values('bodie-v5');

insert into car_engines(name) values('engine-v1');
insert into car_engines(name) values('engine-v2');
insert into car_engines(name) values('engine-v3');
insert into car_engines(name) values('engine-v4');
insert into car_engines(name) values('engine-v5');

insert into car_transmissions(name) values('transmission-v1');
insert into car_transmissions(name) values('transmission-v2');
insert into car_transmissions(name) values('transmission-v3');
insert into car_transmissions(name) values('transmission-v4');
insert into car_transmissions(name) values('transmission-v5');

insert into car(name, body_id, engine_id, transmission_id) 
values ('first car', 1, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) 
values ('second car', 2, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) 
values ('third car', 4, 4, 4);