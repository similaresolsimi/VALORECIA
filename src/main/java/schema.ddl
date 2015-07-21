
    create table UserEntity (
        id int4 not null,
        nom varchar(255),
        prenom varchar(255),
        pseudo varchar(255),
        pswd varchar(255),
        primary key (id)
    );

    create table public.Contact (
        contactid int4 not null,
        copymessage boolean,
        datemessage date,
        mail varchar(255),
        message varchar(255),
        nom varchar(255),
        prenom varchar(255),
        telephone varchar(255),
        contactorigineid int4,
        primary key (contactid)
    );

    create table public.Contactorigine (
        contactorigineid int4 not null,
        contactoriginelabel varchar(255),
        primary key (contactorigineid)
    );

    alter table public.Contact 
        add constraint FK_4q8s3ivt8o27bomxicse1oewy 
        foreign key (contactorigineid) 
        references public.Contactorigine;

    create sequence hibernate_sequence;
