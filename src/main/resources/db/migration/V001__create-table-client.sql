create table client (
    id bigint NOT NULL auto_increment,
    name varchar(50) NOT NULL,
    email varchar(200) NOT NULL,
    phone varchar(20) NOT NULL,

    PRIMARY KEY (id)
);