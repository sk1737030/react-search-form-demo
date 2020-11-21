/*create user 'loltft'@'%' identified by 'loltft123';

create database loltft;

grant all privileges on loltft.* to 'loltft'@'%';
*/
create table tbl_summoner (
    id varchar(100),
    accountId varchar(50),
    puuid varchar(100),
    profileIconId int(10),
    revisionDate datetime,
    name varchar(30),
    summonerLevel int(10)
);
