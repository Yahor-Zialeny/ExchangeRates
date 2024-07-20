create table if not exists currencies(
    Cur_id int primary key,
    Cur_ParentID int not null,
    Cur_Code varchar not null,
    Cur_Abbreviation varchar not null,
    Cur_Name varchar not null,
    Cur_Name_Bel varchar not null,
    Cur_Name_Eng varchar not null,
    Cur_QuotName varchar not null,
    Cur_Quot_Bel varchar not null,
    Cur_Quot_Eng varchar not null,
    Cur_NameMulti varchar not null,
    Cur_Name_BelMulti varchar not null,
    Cur_Name_EngMulti varchar not null,
    Cur_Scale int not null,
    Cur_Periodicity int not null,
    Cur_DateStart timestamp not null,
    Cur_DateEnd timestamp not null
);

create table if not exists rates(
    Cur_id int primary key,
    Date varchar not null,
    Cur_Abbreviation varchar not null,
    Cur_Scale int not null,
    Cur_Name varchar not null,
    Cur_OfficialRate double not null
);

create table if not exists shortrates(
    Cur_id int primary key,
    Date varchar not null,
    Cur_OfficialRate double not null
);