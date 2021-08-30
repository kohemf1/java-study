drop table project.gamelist;

create table project.gamelist(
	gameIdx int auto_increment primary key,
    gameName varchar(50) not null,
    gameSort varchar(20) not null,
    gamePerson varchar(30) ,
    gameTime varchar(30) ,
    gameLmtAge int,
    gamePublisher varchar(30),
    gamePubDate varchar(20),
    gamePhoto varchar(255) default 'photo.png',
    gameIntro text ,
    gameRule text not null,
    gameVideo text 
);

