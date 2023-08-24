// ONE TO ONE

create table numbers(
	id serial primary key, 
	number varchar(32)
);

create table peoples(
	id serial primary key, 
	name varchar(64),
	number_id int references numbers(id) unique
);

// MANY TO ONE

create table tarifs(
	id serial primary key,
	tarif varchar(64)
);

create tables users(
	id serial primary key, 
	name varchar(64),
	tarif_id int references tarifs(id)
);

// MANY TO MANY

create table tarifs(
	id serial primary key,
	tarif varchar(64)
);

create tables users(
	id serial primary key, 
	name varchar(64),
);

create table network_system(
	id serial primary key,
	user_id int references users(id),
	tarif_id int references tarifs(id)
);