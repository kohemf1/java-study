create table project. member (
id varchar(30) collate utf8_bin not null,
pw varchar(30) collate utf8_bin not null,
name varchar(30) collate utf8_bin not null,
regdate datetime default current_timestamp,
primary key(id)
);

insert into project.member values("admin","admin","son", "2020-07-21");

commit;