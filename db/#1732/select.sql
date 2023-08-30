select p.name "Название", p.expired_date "Срок", p.price "Цена" 
from product p join type t on p.type_id = t.id where t.name = 'СЫР'; 

select p.name "Название", p.expired_date "Срок", p.price "Цена" 
from product p where p.name like '%мороженное%';

select p.name "Название", p.expired_date "Дата", p.price "Цена" 
from product p where p.expired_date < current_date;

select t.name "Тип", count(t.name) "Кол-во" 
from product p join type t on p.type_id = t.id group by t.name;

select p.name "Название", p.expired_date "Дата", p.price "Срок" 
from product p join type t on p.type_id = t.id 
where t.name = 'СЫР' or t.name = 'МОЛОКО';

select t.name "Тип" from type t group by t.name having count(t.name) < 10;

select p.name "Название", p.expired_date "Срок", p.price "Цена", t.name "Тип"
from product p join type t on p.type_id = t.id; 