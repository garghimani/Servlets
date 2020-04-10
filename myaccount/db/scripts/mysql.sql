CREATE TABLE `login`
(
   `username`   varchar(100) NOT NULL DEFAULT '',
   `password`   varchar(100) NOT NULL DEFAULT '',
   PRIMARY KEY(`username`)
);

CREATE TABLE personaldetails
(
   firstname    varchar(100) NOT NULL DEFAULT '',
   middlename   varchar(100) NOT NULL DEFAULT '',
   lastname     varchar(100) NOT NULL DEFAULT '',
   gender       varchar(100) NOT NULL DEFAULT '',
   PRIMARY KEY(firstname)
);

CREATE TABLE contactdetails
(
   address    varchar(100) NOT NULL DEFAULT '',
   city       varchar(100) NOT NULL DEFAULT '',
   state      varchar(100) NOT NULL DEFAULT '',
   country    varchar(100) NOT NULL DEFAULT '',
   phone      varchar(100) NOT NULL DEFAULT '',
   personid   varchar(100) NOT NULL DEFAULT '',
   PRIMARY KEY(phone)
);

CREATE TABLE bankdetails
(
   bankname        varchar(100) NOT NULL DEFAULT '',
   accountnumber   varchar(100) NOT NULL DEFAULT '',
   ssn             varchar(100) NOT NULL DEFAULT '',
   personid        varchar(100) NOT NULL DEFAULT '',
   PRIMARY KEY(ssn)
);