-- Database: valorecia


CREATE DATABASE zobi
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'French_France.1252'
       LC_CTYPE = 'French_France.1252'
       CONNECTION LIMIT = -1;
       
DROP DATABASE IF EXISTS valorecia;

CREATE DATABASE valorecia
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'French_France.1252'
       LC_CTYPE = 'French_France.1252'
       CONNECTION LIMIT = -1;

COMMENT ON DATABASE valorecia
  IS 'valorecia db';

  
DROP TABLE IF EXISTS ContactOrigine;

CREATE TABLE ContactOrigine (
    contactoriginelabelId     SERIAL PRIMARY KEY,
    contactoriginelabel      varchar(255) NOT NULL
);


DROP TABLE IF EXISTS Contact;
	
Create Table Contact(
	ContactId SERIAL PRIMARY KEY ,
	name varchar(255) NOT NULL CHECK (name <> ''),
	surname varchar(255) NOT NULL CHECK (surname <> ''),
	mail varchar(255) NOT NULL CHECK (mail <> ''),
	telephone varchar(255),
	message varchar(8000) NOT NULL CHECK (message <> ''),
	copymessage boolean Not NULL,
	dateMessage timestamp DEFAULT current_timestamp, 
	contactorigineId  integer references ContactOrigine
);

--jeu test
--insert Contact Origine
Insert INTO ContactOrigine (contactoriginelabel) values ('Vous nous connaissiez déjà avant.');
Insert INTO ContactOrigine (contactoriginelabel) values ('Une de vos connaissances vous as eguillé vers nous.');
Insert INTO ContactOrigine (contactoriginelabel) values ('Vous avez fait une recherche internet');

--insert Contact
Insert INTO Contact (	name ,	surname ,mail ,telephone ,message ,copymessage ,dateMessage ,contactorigineId ) 
values ('FAGEGALTIER','Richard','richardfagegaltier@free.fr','0777793001','Bonjour, je souhaite communiquer avec vous !',true,now(),1);

--test select
select * from Contact;
select * from ContactOrigine;

