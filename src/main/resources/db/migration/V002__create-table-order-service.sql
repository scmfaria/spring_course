create table order_service (
    id bigint NOT NULL auto_increment,
    client_id bigint NOT NULL,
    description text NOT NULL,
    price decimal(10,2) NOT NULL,
    status varchar(20) NOT NULL,
    date_open datetime NOT NULL,
    date_finish datetime,

    PRIMARY KEY (id)
);

alter table order_service add CONSTRAINT fk_order_service_client
FOREIGN KEY (client_id) REFERENCES client (id);
