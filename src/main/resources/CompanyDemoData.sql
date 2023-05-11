insert into department (department_name, start_date)
values('dcfg', '2023-04-26');

insert into employee (employee_id, date_of_birth, first_name, gender, last_name, salary)
values('MNC231', '2022-01-23', 'Alex', 'MALE', 'Brown', 56000);

insert into relatives (full_name, gender, phone_number, relationship, employeeid)
values('Andy Ng', 'MALE', '865-456-899', 'Brother', 'MNC231');

insert into project ("area", project_name, managed_department)
values('area 1', 'Meo meo meo', 1);

insert into "assignment" (number_of_hour, employeeid, projectid)
values(5.5, 'MNC231', 2);



-----INSERT DATA TO DEPARTMENT-----
insert into department (department_name, start_date)
values ('Support','2022-07-16'),
('Sales','2021-04-22'),
 ('Human Resources','2020-04-01'),
 ('Training','2019-10-28'),
 ('Engineering','2020-03-03'),
 ('Services','2020-07-10'),
 ('Accounting','2019-04-11'),
 ('Business Development','2019-05-01'),
 ('Legal','2021-08-06'),
 ('Research and Development','2021-07-01');



-----INSERT DATA TO DEPARTMENTLOCATION-----
insert into department_location("location", deptid)
values ('nhatrang',3),
('laocai',1),
('dienbien',2),
('tayninh',5),
('yenbai',24),
('haiphong',25),
('binhthuan',26),
('dongnai',25),
('binhduong',19),
('vungtau',18),
('caobang',7);

	
-----INSERT DATA INTO PROJECT-----
insert into project (area, project_name, managed_department)
values ('Wakayama-shi','Eare',1),
('Riyom','Wordify',2),
('Ayrihuanca','Pixonyx',23),
('Arbais','Yakijo',19),
('Savalou','Zoonoodle',24),
('Yangshan','Voomm',25),
('Cowansville','Reallinks',3),
('Santo Domingo','Mymm',5),
('Santa Monica','Skaboo',26),
('Le Raincy','Zooveo',21),
('Vrýses','Innojam',27),
('Hinapalanan','Twitterlist',20),
('Middelburg','Tagcat',18),
('Metapán','Mynte',7),
('Cochrane','Skippad',18);




-----INSERT DATA TO EMPLOYEE-----
INSERT INTO public.employee (employee_id,date_of_birth,first_name,gender,last_name,middle_name,salary,deptid) VALUES
	 ('mlates0','1964-05-13','Candi','Female','Lates','Muire',1420.6,19),
	 ('bfairpo1','1984-10-13','Harper','Male','Fairpo','Bealle',2928.77,1),
	 ('deskriet2','1986-08-29','Taddeo','Male','Eskriet','Dietrich',2475.61,7),
	 ('hmacclenan3','1953-03-05','Hill','Polygender','MacClenan','Harri',2004.85,20),
	 ('ajerram4','1971-08-11','Starlene','Female','Jerram','Anastassia',1853.34,20),
	 ('rmulhill5','1999-09-29','Igor','Male','Mulhill','Renado',1731.99,18),
	 ('bescala6','1962-11-23','Kellen','Male','Escala','Barris',1804.97,27),
	 ('suren7','1980-04-09','Emmott','Male','Uren','Sonnie',2581.03,24),
	 ('iinnis8','1970-10-13','Wilmer','Male','Innis','Iosep',3172.26,18),
	 ('cvinsen9','1998-04-22','Miner','Genderqueer','Vinsen','Carleen',3613.83,21),
	 ('etoffula','1966-03-01','Falkner','Male','Tofful','Elston',984.81,5),
	 ('mratcliffeb','1997-10-24','Frieda','Female','Ratcliffe','Merridie',3734.21,23),
	 ('hdodmanc','1999-06-02','Myrwyn','Male','Dodman','Heriberto',2066.72,27),
	 ('awinbornd','1989-12-19','Tore','Male','Winborn','Aguie',2614.83,20),
	 ('odonnellye','1972-08-09','Billy','Female','Donnelly','Onida',2499.51,25),
	 ('odiwellf','1989-12-23','Corina','Female','Diwell','Orelee',2947.25,26),
	 ('ddobrowlskig','1963-10-22','Sky','Male','Dobrowlski','Dennie',1619.52,3),
	 ('avidlerh','1954-09-09','Kristofor','Male','Vidler','Alejandro',1248.46,21),
	 ('rciccii','1981-12-06','Lyndel','Female','Cicci','Ryann',2650.39,5),
	 ('fgrabertj','1963-06-23','Garv','Male','Grabert','Fabian',2395.47,7),
	 ('spflegerk','1990-01-21','Tabb','Male','Pfleger','Staffard',3544.39,25),
	 ('doneilll','1993-05-28','Norina','Female','O''Neill','Dian',3007.01,24),
	 ('ogeorgievm','1998-10-21','Etti','Female','Georgiev','Odessa',2050.38,5),
	 ('jmushettn','1956-01-02','Zuzana','Female','Mushett','Jacki',2851.51,7),
	 ('eburgeno','1985-01-21','Gay','Female','Burgen','Edee',3679.9,7),
	 ('smittenp','1964-01-31','Zechariah','Male','Mitten','Skip',1061.81,26),
	 ('pcuttleq','1958-11-25','Garrot','Male','Cuttle','Peter',1041.57,24),
	 ('nimortr','1958-06-26','Martha','Female','Imort','Nataline',3892.38,22),
	 ('pwisedales','1977-07-14','Reinald','Male','Wisedale','Padgett',3300.0,19),
	 ('elafayettet','1953-12-12','Gay','Male','Lafayette','Everett',3568.65,25);


----INSERT DATA INTO RELATIVE-----
INSERT INTO relatives (full_name,gender,phone_number,relationship,employeeid) VALUES
	 ('Noah Boote','1','285-881-3811','daughter','mlates0'),
	 ('Gunter Moneti','0','661-707-8879','son','deskriet2'),
	 ('Dari Wragge','1','905-900-0317','wife','rmulhill5'),
	 ('Jodie Toomey','1','680-323-3489','daughter','cvinsen9'),
	 ('Violante Edwardson','0','285-601-7042','husband','suren7'),
	 ('Brynna McKeighen','1','838-755-7880','mother','etoffula'),
	 ('Tillie Nys','1','390-270-8356','mother','awinbornd'),
	 ('Melita Eaddy','1','657-792-8534','daughter','odiwellf'),
	 ('Larisa Van der Merwe','0','147-928-8342','son','avidlerh'),
	 ('Sylas Van der Merwe','1','546-166-7562','wife','fgrabertj'),
	 ('Suellen McCloy','0','400-276-9702','husband','spflegerk'),
	 ('Dilly Iacovazzi','0','806-909-1259','father','doneilll'),
	 ('Austin Sloam','1','634-301-6906','niece','jmushettn'),
	 ('Fara Cuckson','0','292-881-1666','nephew','ogeorgievm'),
	 ('Keene Albrooke','0','376-376-6297','son','pcuttleq');



-----INSERT DATA INTO ASSIGNMENT-----

INSERT INTO public."assignment" (number_of_hour,employeeid,projectid) VALUES
	 (54.0,'mlates0',18),
	 (22.0,'deskriet2',6),
	 (31.0,'ajerram4',9),
	 (94.0,'rmulhill5',8),
	 (60.0,'bescala6',1),
	 (21.0,'suren7',2),
	 (64.0,'cvinsen9',2),
	 (96.0,'mratcliffeb',10),
	 (62.0,'hdodmanc',4),
	 (73.0,'awinbornd',18),
	 (93.0,'odonnellye',16),
	 (40.0,'odiwellf',12),
	 (43.0,'avidlerh',11),
	 (41.0,'rciccii',18),
	 (27.0,'fgrabertj',6),
	 (31.0,'doneilll',13),
	 (93.0,'ogeorgievm',17),
	 (51.0,'jmushettn',2),
	 (13.0,'smittenp',16),
	 (19.0,'nimortr',13);

