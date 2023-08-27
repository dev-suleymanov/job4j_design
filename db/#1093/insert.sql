insert into users(name) values('Nebraska');
insert into roles(name, user_id) values('admin', 1);
insert into rules(name) values('maker');
insert into roles_rules(role_id, rule_id) values(1, 1);
insert into items(name, user_id) values ('Keys for STEAM', 1);
insert into comments(name, items_id) values('Круто!', 1);
insert into attachs(name, items_id) values('keys.txt', 1);
insert into categories(name, items_id) values('Keys', 1);
insert into states(name, items_id) values('verified', 1);


