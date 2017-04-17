create table if not exists employee(
id int primary key auto_increment,
name varchar(45),
surname varchar(45),
lastname varchar(45),
personel_number int);

create table if not exists route(
id int primary key auto_increment,
number_of_route int);

create table if not exists num_of_order(
id int primary key auto_increment,
num int);

create table if not exists turn(
id int primary key auto_increment,
num_of_turn int);

create table if not exists vehicle(
id  int primary key auto_increment,
bort_number int);

create table if not exists absent(
id int primary key auto_increment,
day_of_week date,
reason varchar(45),
id_employee int,
constraint  foreign key (id_employee) references employee (id));

create table if not exists daily_order(
id  int primary key auto_increment,
id_route int,
id_num_of_order int,
id_turn int,
start_time datetime,
constraint foreign key (id_route) references route (id),
constraint foreign key (id_num_of_order) references num_of_order (id),
constraint foreign key (id_turn) references turn (id));

create table if not exists time_table(
id  int primary key auto_increment,
day_of_month date,
id_employee int,
id_vehicle int,
id_daily_order int,
constraint foreign key (id_employee) references employee (id),
constraint foreign key (id_vehicle) references vehicle (id),
constraint foreign key (id_daily_order) references daily_order (id));
