select s.name, s.surname, ss.number
from students as s join snilses as ss on s.snils_id = ss.id;

select s.name as Имя, s.surname as Фамилия, ss.number as Снилс
from students as s join snilses as ss on s.snils_id = ss.id;

select s.name Имя, s.surname Фамилия, ss.number Снилс
from students s join snilses ss on s.snils_id = ss.id;