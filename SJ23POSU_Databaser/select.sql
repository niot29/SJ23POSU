

-- Vilka singlar återfinns på placering 1-100, sorterade i ordning från lägst till högst(1-100)
select * from (
select  sum(pp.place_point) as  TotalP, t.title, a.name
	from place_and_point as pp
    INNER JOIN title as t ON pp.title_id = t.title_id
    INNER JOIN artist as a ON t.artist_id = a.artist_id
    group by pp.title_id
    order by TotalP desc limit 100) as lista order by TotalP;

-- Vilka singlar återfinns på placering 1-20 sorterade i ordning från lägst till högst (1-20) 
select * from (
select  sum(pp.place_point) as  TotalP, t.title, a.name
	from place_and_point as pp
    INNER JOIN title as t ON pp.title_id = t.title_id
    INNER JOIN artist as a ON t.artist_id = a.artist_id
    group by pp.title_id
    order by TotalP desc limit 20) as lista order by TotalP;

-- Vilken (antal 1st) artist har flest singlar på listan 
select  a.name, count(a.name) as c
from place_and_point as pp 
    INNER JOIN title as t ON pp.title_id = t.title_id
    INNER JOIN artist as a ON t.artist_id = a.artist_id
    GROUP BY a.name ORDER BY c DESC limit 1;

-- Vilken låt har flest veckor på listan 
select count(pp.title_id) as c, t.title
from place_and_point as pp 
    INNER JOIN title as t ON pp.title_id = t.title_id
    INNER JOIN artist as a ON t.artist_id = a.artist_id
    GROUP BY pp.title_id ORDER BY c DESC ;
