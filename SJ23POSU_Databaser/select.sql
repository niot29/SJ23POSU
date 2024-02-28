

-- Vilka singlar återfinns på placering 1-100, sorterade i ordning från lägst till högst(1-100)
set @row_num=0;
select  (@row_num:=@row_num+1) AS place , a.* from	
	(select sum(pp.place_point) as  TotalP, t.title, a.name
	from place_and_point as pp
    INNER JOIN title as t ON pp.title_id = t.title_id
    INNER JOIN artist as a ON t.artist_id = a.artist_id
    group by pp.title_id
    order by TotalP desc limit 100)  a;
    
-- Vilka singlar återfinns på placering 1-20 sorterade i ordning från lägst till högst (1-20). (av kommentera för att lista bara 20 firsta vekorna)
set @row_num=0;
select  (@row_num:=@row_num+1) AS place , a.* 
	from ( select sum(pp.place_point) as  totalp, t.title, a.name
	from place_and_point as pp
    INNER JOIN title as t ON pp.title_id = t.title_id
    INNER JOIN artist as a ON t.artist_id = a.artist_id
    WHERE pp.place_point > 0 
    and pp.placement < 20
    and pp.weeks < 20
    group by pp.title_id
    order by totalp desc limit 20) a;

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
