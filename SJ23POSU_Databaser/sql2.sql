SELECT * FROM Topswe.topimport LIMIT 10000;
SELECT * FROM Topswe.artist LIMIT 10000;
SELECT * FROM Topswe.title LIMIT 10000;
SELECT * FROM Topswe.place_and_point LIMIT 10000;

SELECT * FROM Topswe.title where title_id = 123;
select * from topimport where artist like 'OLIVIA LOBATO';
select * from topimport where weeks = 3;
SELECT * FROM Topswe.place_and_point  where weeks = 52;


-- select artist from Topswe.topimport group by artist;

-- group all artis from top tabel and import to artis tabel 
-- insert into Topswe.artist (name) select artist from Topswe.topimport group by artist;

/*
-- get title ande artisID from topimport and artist tabel and import to title tabel
insert into title (title,artist_id) 
	SELECT t.title, a.artist_id 
		FROM Topswe.topimport as t, Topswe.artist as a  
		where t.artist like a.name;
*/
/*
-- V2 get title ande artisID from topimport and artist tabel and import to title tabel
insert into title (title,artist_id) 
SELECT t.title, a.artist_id
	FROM Topswe.topimport as t, Topswe.artist as a  
	where t.artist like a.name 
    group by  t.title,a.artist_id ;
*/

/*
-- Get weeks and placement from topimport and title_id from title. inport repose data to place_and_point
insert into place_and_point (weeks,placement,title_id)
	SELECT t.weeks, t.placement ,ti.title_id
	FROM Topswe.topimport as t, Topswe.title as ti
    where t.title like ti.title ;
*/


-- -------------------------------------
-- -------------------------------------
select * from place_and_point where placement in (1,2,3);
update place_and_point set place_point = 18 where placement = 3;
-- 22:26:58	update place_and_point set place_point = 25 where placement = 1	Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.000 sec



select count(*) from place_and_point where placement = 1 ;
select weeks  from place_and_point group by weeks;



SELECT t.weeks, t.placement ,ti.title_id
	FROM Topswe.topimport as t, Topswe.title as ti
    where t.title like ti.title ;

select count(t.title) FROM Topswe.topimport as t where t.title like 'LAST CHRISTMAS';
    
SELECT t.weeks, t.placement ,t.title
	FROM Topswe.topimport as t;


SELECT t.title, a.artist_id
	FROM Topswe.topimport as t, Topswe.artist as a  
	where t.artist like a.name 
    group by  t.title,a.artist_id ;




SELECT t.title, a.artist_id , a.name 
	FROM Topswe.topimport as t, Topswe.artist as a  
    where t.artist like a.name group by t.title;




