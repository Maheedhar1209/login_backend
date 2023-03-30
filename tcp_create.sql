drop database tcp;

create database tcp;
use tcp;

CREATE TABLE admin (
	admin_id INT NOT NULL AUTO_INCREMENT,
	admin_name VARCHAR(255) NOT NULL,
	admin_gender VARCHAR(255) NOT NULL,
	admin_dob DATE NOT NULL,
    admin_phone_number VARCHAr(255) NOT NULL,
	PRIMARY KEY (admin_id)
);

CREATE TABLE patient_details (
	patient_id INT NOT NULL AUTO_INCREMENT,
	patient_name VARCHAR(255) NOT NULL,
	patient_email_id VARCHAR(255) NOT NULL,
	patient_dob DATE NOT NULL,
	gender VARCHAR(255) NOT NULL,
	patient_phone_number VARCHAR(255) NOT NULL,
	patient_location VARCHAR(255) NOT NULL,
	PRIMARY KEY (patient_id)
);

CREATE TABLE doctor_details (
	doctor_id INT NOT NULL AUTO_INCREMENT,
	doctor_name VARCHAR(255) NOT NULL,
	doctor_dob DATE NOT NULL,
    doctor_gender VARCHAR(255) NOT NULL,
	department_name VARCHAR(255) NOT NULL,
	doctor_qualification VARCHAR(255) NOT NULL,
	doctor_clinic_address VARCHAR(255) NOT NULL,
	doctor_phone_number VARCHAR(255) NOT NULL,
    doctor_availability BOOLEAN NOT NULL,
    doctor_start_date DATE NOT NULL,
	PRIMARY KEY (doctor_id)
);

CREATE TABLE appointments (
	appointment_id INT NOT NULL AUTO_INCREMENT,
	doctor_id INT NOT NULL,
	patient_id INT NOT NULL,
	appointment_date DATE NOT NULL,
	prescription_id INT NOT NULL,
	follow_up BOOLEAN NOT NULL,
	follow_up_date DATE,
	PRIMARY KEY (appointment_id)
);

CREATE TABLE prescriptions (
	prescription_id INT NOT NULL AUTO_INCREMENT,
	medicine_name VARCHAR(255) NOT NULL,
	medicine_power VARCHAR(255) NOT NULL,
	medicine_dosage VARCHAR(255) NOT NULL,
	duration INT NOT NULL,
	additional_instructions VARCHAR(255),
	patient_record_id INT NOT NULL,
	PRIMARY KEY (prescription_id, medicine_name)
);

CREATE TABLE patient_record (
	patient_record_id INT NOT NULL AUTO_INCREMENT,
	patient_id INT NOT NULL UNIQUE,
	patient_weight INT,
	patient_temperature INT,
	patient_bp VARCHAR(255),
	PRIMARY KEY (patient_record_id)
);

CREATE TABLE admin_login (
	admin_email_id VARCHAR(255) NOT NULL,
	admin_password VARCHAR(255) NOT NULL,
	admin_id INT NOT NULL UNIQUE ,
    is_admin_active BOOLEAN NOT NULL,
	PRIMARY KEY (admin_email_id)
);

CREATE TABLE doctor_login (
	doctor_email_id VARCHAR(255) NOT NULL,
	doctor_password VARCHAR(255) NOT NULL,
	doctor_id INT NOT NULL UNIQUE ,
    is_doctor_active BOOLEAN NOT NULL,
	PRIMARY KEY (doctor_email_id)
);

ALTER TABLE appointments ADD CONSTRAINT Appointments_fk0 FOREIGN KEY (doctor_id) REFERENCES doctor_details(doctor_id);

ALTER TABLE appointments ADD CONSTRAINT Appointments_fk1 FOREIGN KEY (patient_id) REFERENCES patient_details(patient_id);

ALTER TABLE appointments ADD CONSTRAINT Appointments_fk2 FOREIGN KEY (prescription_id) REFERENCES prescriptions(prescription_id);

ALTER TABLE prescriptions ADD CONSTRAINT Prescriptions_fk0 FOREIGN KEY (patient_record_id) REFERENCES patient_record(patient_record_id);

ALTER TABLE admin_login ADD CONSTRAINT Admin_Login_fk0 FOREIGN KEY (admin_id) REFERENCES admin(admin_id);

ALTER TABLE doctor_login ADD CONSTRAINT Doctor_Login_fk0 FOREIGN KEY (doctor_id) REFERENCES doctor_details(doctor_id);

insert into admin(admin_name,admin_gender,admin_dob, admin_phone_number) values ("admin1@gmail.com","Male","1985-08-11","1234567890");

insert into doctor_details(doctor_name ,doctor_dob, doctor_gender ,department_name ,doctor_qualification ,doctor_clinic_address ,doctor_phone_number,doctor_availability, doctor_start_date) values ( "Venkaiah Naidu", "1985-09-14", "Male", "Gynecology", "M.B.D.S","26/C,Hosur Road, Electronic City phase 1,Bangalore,560100","123456789",false, "2004-01-12");

insert into doctor_login(doctor_email_id,doctor_password,doctor_id, is_doctor_active) values("doctor1@gmail.com","doctor1@123",1,true);

insert into admin_login(admin_email_id,admin_password,admin_id, is_admin_active) values("admin1@gmail.com","admin1@123",1,true);
