insert into comments(name) values('Круто!');
insert into attachs(name) values('keys.txt');
insert into categories(name) values('Keys');
insert into states(name) values('verified');

insert into items(name, comment_id, attach_id, categorie_id, state_id)
values ('Keys for STEAM', 1, 1, 1, 1);

insert into roles(name) values('admin');
insert into rules(name) values('maker');
insert into roles_rules(role_id, rule_id) values(1, 1);

insert into users(name, role_id, item_id) values('Nebraska', 1, 1);