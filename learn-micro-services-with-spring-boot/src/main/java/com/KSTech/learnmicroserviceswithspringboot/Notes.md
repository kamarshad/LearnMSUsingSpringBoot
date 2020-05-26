### Table Structure 
#### User Table
 create table user (
 user_id bigint not null,
 date_of_birth timestamp,
 user_name varchar(255),
 primary key (user_id)
)

#### Post Table
 create table post (id bigint not null, description varchar(255), user_user_id bigint, primary key (id))