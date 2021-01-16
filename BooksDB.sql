Create database if not exists books;

use books;

drop table if exists book;

create table book (
        bookId int(10) not null auto_increment,
        title varchar(50) not null,     
        primary key(bookId)
        );