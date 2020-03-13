create table if not exists app
(
	id bigint not null
		constraint app_pkey
			primary key,
	category varchar(255),
	name varchar(255)
);

alter table app owner to postgres;


create table if not exists review
(
	id bigint not null
		constraint review_pkey
			primary key,
	author varchar(255),
	date timestamp,
	rating integer not null,
	text varchar(100000),
	app_id bigint
		constraint fkgs7bcotf7vnyg54ryf9bjnn1p
			references app
);

alter table review owner to postgres;

