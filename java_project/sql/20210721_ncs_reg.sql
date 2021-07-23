create table ncs.memberInfo (
idx int(11) not null auto_increment,
ID VARCHAR(20) collate utf8_bin NULL,
PW VARCHAR(20) collate utf8_bin NOT NULL,
USERNAME VARCHAR(20) collate utf8_bin NOT NULL,
REGDATE datetime default current_timestamp not null,
primary key(idx)
);


commit;