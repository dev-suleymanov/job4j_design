select p.name "Человек", c.name "Компания" 
from person p join company c on p.company_id = c.id
where p.company_id != 5;

select c.name "Компания", count(p) "Штат"
from company c join person p 
on c.id = p.company_id
group by c.name
having count(p) = (select count(pp) 
				   from person pp
				   group by pp.company_id
				   order by count(pp) desc limit 1);