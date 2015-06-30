-- Database: valorecia


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
    contactOrigineId    integer PRIMARY KEY,
    contactOrigine      varchar(255) NOT NULL
);


DROP TABLE IF EXISTS Contact;
	
Create Table Contact(
	ContactId integer PRIMARY KEY ,
	name varchar(255) NOT NULL CHECK (name <> ''),
	surname varchar(255) NOT NULL CHECK (surname <> ''),
	mail varchar(255) NOT NULL CHECK (mail <> ''),
	telephone varchar(255),
	message varchar(8000) NOT NULL CHECK (message <> ''),
	sendMessage int Not NULL,
	dateMessage timestamp DEFAULT current_timestamp, 
	contactOrigineId  integer references ContactOrigine
);

