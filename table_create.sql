create user "ace"@"localhost" identified by "Ace20!ace";
create role "admin";

create database main;
use main;

grant all on main.* to "admin";
grant "admin" to "ace"@"localhost";
set default role all to "ace"@"localhost";

create table if not exists address(addressId int auto_increment, houseNo varchar(40), 
city varchar(40), district varchar(40), state varchar(40),
primary key(addressId));
									
create table if not exists Patient(patientId int auto_increment, name varchar(40), phoneNo varchar(15),
healthSummary varchar(400), timeDuration int,gender varchar(30), dob date, 
email varchar(40), address int, doctor int, ward int, isIn int, primary key(patientId),
foreign key(address) references address(addressId), foreign key(doctor) references Doctor(doctorId), 
foreign key(ward) references ward(wardId));
									
create table if not exists user(username varchar(20) not null, passwd varchar(20) not null,primary key(username));

create table if not exists Doctor(doctorId int not null auto_increment,name varchar(40),
phoneNo varchar(13), designation varchar(40), workHour varchar(10), charge double ,
primary key(doctorId));
									
create table if not exists Staff(staffId int auto_increment, name varchar(40), phoneNo varchar(13), 
designation varchar(40), salary int , address int, primary key(staffId),
foreign key(address) references address(addressId));
									
create table if not exists ward (wardId int auto_increment, type varchar(20), status varchar(20),
price int, staff int, primary key(wardId), foreign key(staff) references Staff(staffId));
									
create table if not exists facility(serviceId int auto_increment, service_name varchar(30), price int, primary key(serviceId));

create table if not exists Trans(transId int auto_increment, patient int, type varchar(40), charge int,
transTime date,primary key(transId), foreign key(patient) references Patient(patientId));
									
create table if not exists report ( reportId int auto_increment, patient int, doctor int, facility int,
summary varchar(400), primary key(reportId), foreign key(patient) references Patient(patientId),
foreign key(doctor) references Doctor(doctorId), foreign key(facility) references facility(serviceId));
									
create table if not exists medicine (mediId int auto_increment, name varchar(40) unique, price double, primary key(mediId));

create table if not exists inventory(inventId int auto_increment, medicine int unique, count int,
primary key(inventId), foreign key(medicine) references medicine(mediId));
									
create table if not exists purchase ( purchaseId int auto_increment, patient int, medicine int, count int, 
primary key(purchaseId), foreign key(patient) references Patient(patientId), 
foreign key(medicine) references medicine(mediId));

create table retailer(retailerId int auto_increment, name varchar(40), phoneNo varchar(20), address int,
basePrice int, primary key(retailerId), foreign key(address) references address(addressId));

create table orders ( orderId int auto_increment, medicine int, retailer int, quantity int, primary key(orderId),
foreign key(medicine) references medicine(mediId), foreign key(retailer) references retailer(retailerId));



