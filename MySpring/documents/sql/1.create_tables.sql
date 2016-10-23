create table board (
	seq int primary key,
	title varchar(500),
	content text,
    view_cnt int,
    creator varchar(20),
    create_datetime datetime,
    updater varchar(20),
    update_datetime datetime,
    del_flg char(1) default '0',
    version int default 0
);

create table users(
	id varchar(8) primary key,
    password varchar(8),
    name varchar(20),
    role varchar(5),
	creator varchar(20),
    create_datetime datetime,
    updater varchar(20),
    update_datetime datetime,
    del_flg char(1) default '0',
    version int default 0
);

insert into users(id, password, name, role, creator, create_datetime, updater, update_datetime, del_flg, version)
values('admin', 'admin', 'ADMIN', '1', 'admin', now(), 'admin', now(), '0', 1);

commit;