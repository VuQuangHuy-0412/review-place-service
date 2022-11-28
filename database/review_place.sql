create table user
(
    id         bigint auto_increment,
    user_name  varchar(100) charset utf8mb4       not null,
    phone      varchar(20) charset ascii          null,
    email      varchar(200) charset utf8mb4       null,
    account_id bigint                             not null,
    created_at datetime default CURRENT_TIMESTAMP not null,
    updated_at datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint user_pk
        primary key (id)
)
    comment 'Danh sách người dùng hệ thống' charset = utf8mb4;

create table account
(
    id         bigint auto_increment,
    account    varchar(100) charset ascii         not null,
    password   varchar(256) charset ascii         not null,
    created_at datetime default CURRENT_TIMESTAMP not null,
    updated_at datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint account_pk
        primary key (id)
)
    comment 'Danh sách tài khoản của user' charset = utf8mb4;

alter table user
    add dob datetime null after email;