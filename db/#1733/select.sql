select b.name "Кузова" from car_bodies b 
left join car c on b.id = c.body_id 
where c.body_id is null;

select e.name "Двигатели" from car_engines e 
left join car c on e.id = c.body_id 
where c.body_id is null;

select t.name "Коробки передач" from car_transmissions t 
left join car c on t.id = c.body_id 
where c.body_id is null;