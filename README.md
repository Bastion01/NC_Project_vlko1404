# NC_Project_vlko1404
Initial version
Пока без gitignore'а,увы
database name jobs, port:3306
create table companies
(
	id int auto_increment
		primary key,
	name varchar(30) not null,
	workers_number int null,
	rating int null
)
;

create table peoples
(
	id int auto_increment
		primary key,
	fname varchar(30) null,
	password varchar(30) null,
	company_id int null,
	constraint peoples___company_id
		foreign key (company_id) references companies (id)
)
;

create index peoples___company_id
	on peoples (company_id)
;
Удалять компании не рекомендую,хотя это и работает - выкидывает ошибки,ведь пользователя остаются без работы

