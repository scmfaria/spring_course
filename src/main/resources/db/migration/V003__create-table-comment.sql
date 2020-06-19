create table coment (
    id bigint NOT NULL auto_increment,
    order_service_id bigint NOT NULL,
    description text NOT NULL,
    date_send datetime NOT NULL,

    PRIMARY KEY (id)
);

alter TABLE comment add CONSTRAINT fk_comment_order_service
FOREIGN KEY (order_service_id) REFERENCES order_service (id);