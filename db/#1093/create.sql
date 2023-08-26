create table users(
	id serial primary key,
	name varchar(32),
	role_id int references roles(id),
	item_id int references items(id)
);

create table roles(
	id serial primary key, 
	name varchar(32)
);

create table rules(
	id serial primary key, 
	name varchar(32)
);

create table roles_rules(
	id serial primary key, 
	role_id int references roles(id),
	rule_id int references rules(id)
);

create table items(
	id serial primary key, 
	name varchar(32),
	comment_id int references comments(id),
	attach_id int references attachs(id),
	categorie_id int references categories(id),
	state_id int references states(id)
);

create table comments(
	id serial primary key, 
	name text
);

create table attachs(
	id serial primary key, 
	name varchar(32)
);

create table categories(
	id serial primary key,
	name varchar(32)
);

create table states(
	id serial primary key,
	name varchar(32)
);