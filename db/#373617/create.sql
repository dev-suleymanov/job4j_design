create table snilses(
	id serial primary key,
	number int
);

create table students(
	id serial primary key, 
	name varchar(32),
	surname varchar(32),
	snils_id int references snilses(id) unique
);