drop table if exists project.member1;

create table project.member1 (
	idx int auto_increment,
    memberid varchar(14) not null,
    password varchar(20) not null,
    membername varchar(20) not null,
    memberphoto varchar(50) default 'photo.png',
    regdate timestamp default current_timestamp,
    constraint member_idx_pk primary key (idx),
    constraint member_memberid_uq unique (memberid)        
);

-- Select
select * from project.member1;
select * from project.member1 where idx=1;
select * from project.member1 where memberid='cool' and passwmember1ord = '1111';
select count(*) from project.member1 where memberid='cool';
-- insert
INSERT INTO project.member1
(memberid, password, membername)
VALUES
('cool', '1111', 'COOL');

-- update
update project.member1
set
password='0000', membername='tester'
where idx=1
;

-- Delete
delete from project.member1 where idx=1;

commit;
