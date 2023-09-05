insert into type(name) values('СЫР');
insert into type(name) values('МЯСО');
insert into type(name) values('МОЛОКО');
insert into type(name) values('СЛАДКОЕ');

insert into product(name, type_id, expired_date, price)
values ('пармезан', 1, '30.09.2023', 627.0);
insert into product(name, type_id, expired_date, price)
values ('сулугуни', 1, '27.08.2023', 234.0);
insert into product(name, type_id, expired_date, price)
values ('моцарелла', 1, '16.09.2023', 1982.0);

insert into product(name, type_id, expired_date, price)
values ('говядина', 2, '16.09.2023', 1872.0);
insert into product(name, type_id, expired_date, price)
values ('баранина', 2, '25.08.2023', 1562.0);
insert into product(name, type_id, expired_date, price)
values ('курица', 2, '25.09.2023', 673.0);

insert into product(name, type_id, expired_date, price)
values ('домик в деревне', 3, '26.09.2023', 182.0);
insert into product(name, type_id, expired_date, price)
values ('простоквашино', 3, '29.08.2023', 150.0);
insert into product(name, type_id, expired_date, price)
values ('агуша', 3, '15.09.2023', 189.0);

insert into product(name, type_id, expired_date, price)
values ('мороженное пломбир', 4, '15.09.2023', 67.0);
insert into product(name, type_id, expired_date, price)
values ('мороженное лединец', 4, '27.08.2023', 26.0);
insert into product(name, type_id, expired_date, price)
values ('мороженное стаканчик', 4, '18.09.2023', 45.0);