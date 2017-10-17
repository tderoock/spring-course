create table message(id integer, message varchar(1024), recipient varchar(128));

insert into message values (1, 'Hello Ordina!', 'info@tvh.com');
insert into message values (2, 'Hello again, anybody there?', 'info@tvh.com');
insert into message values (3, 'Never mind...', 'info@tvh.com');

commit;