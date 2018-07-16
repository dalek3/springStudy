create table tbl_user(
	uid varchar(50) not null,
	upw varchar(50) not null,
	uname varchar(100) not null,
	upoint int(11) default 0,
	primary key(uid)
);

create table tbl_message (
	mno int not null auto_increment,
	targetid varchar(50) not null,
	sender varchar(50) not null,
	message text not null,
	opendate timestamp,
	senddate timestamp not null default now(),
	primary key(mno)
);

alter table tbl_message add constraint fk_usertarget
foreign key (targetid) references tbl_user (uid);

alter table tbl_message add constraint fk_usertarget
foreign key (sender) references tbl_user (uid);

insert into tbl_user(uid, upw, uname) values ('user00', 'user00', 'IRON MAN');
insert into tbl_user(uid, upw, uname) values ('user01', 'user01', 'CAPTAIN');
insert into tbl_user(uid, upw, uname) values ('user02', 'user02', 'HULK');
insert into tbl_user(uid, upw, uname) values ('user03', 'user03', 'Thor');
insert into tbl_user(uid, upw, uname) values ('user10', 'user10', 'Quick Silver');
