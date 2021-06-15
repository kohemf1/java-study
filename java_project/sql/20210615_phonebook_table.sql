--20210615

drop table phoneinfo_basic;
create table phoneInfo_basic(
    idx number(6)
    constraint basic_idx_nn not null,
    fr_name varchar2(20) -- 친구이름 
    constraint basic_name_nn not null,
    fr_phonenumber varchar2(20) -- 친구 전화번호
    constraint basic_phonenumber_nn not null,
    fr_email varchar2(20), -- 친구 이메일 
    fr_address varchar2(20),-- 친구주소
    fr_regdata date default sysdate+1,--등록 시간
    constraint basic_idx_pk PRIMARY KEY (idx)
);

desc phoneinfo_basic;

drop table phoneinfo_univ;
create table phoneInfo_univ(
    idx number(6)
    constraint univ_idx_nn not null,
    fr_u_major varchar2(20) -- 대학친구 전공 정보 
    default 'n'
    constraint univ_major_nn not null,
    fr_u_year number(1) -- 대학친구 학년
    default 1
    constraint univ_year_nn not null 
    constraint univ_year_ck check (0 < fr_u_year and fr_u_year < 5),
    fr_ref number(6) constraint univ_ref_nn not null -- 기본정보 외래키
    constraint univ_ref_pk REFERENCES phoneinfo_basic
);
desc phoneinfo_univ;

drop table phoneinfo_com;
create table phoneinfo_com(
    idx number(6)
    constraint com_idx_nn not null,
    fr_c_company varchar2(20) default 'n' -- 회사친구의 회사 이름
    constraint com_company_nn not null,
    fr_ref number(6) constraint com_ref_nn not null -- 기본정보 외래키
    constraint com_ref_pk REFERENCES phoneinfo_basic
); 

desc  phoneinfo_com;