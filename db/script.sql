create table stats(
	id serial primary key,
	name varchar(32),
	steam varchar(32),
	points integer,
	verified boolean
);

insert into stats(name, steam, points, verified)
values ('Nebraska', 'STEAM:118423', 1425, true);

update stats set name = 'Maurice', steam = 'STEAM:49182';

delete from stats;