##Here is SQLs that I used to create tables
mysql> create DATABASE hospital;
mysql> use hospital
mysql> CREATE TABLE Doctor
      (
        DoctorID INT not null PRIMARY KEY,
        Name varchar(40) not null,
        Phone varchar(14) not null,
        SpecialtyNumber INT not null,
        Supervisor INT not null
      );
mysql> CREATE TABLE Specialty
      (
        Specialty_ID INT not null PRIMARY KEY,
        Specialty varchar(40) not null
      );

mysql> CREATE TABLE Patient
      (
        PatientID INT not null PRIMARY KEY,
        Name varchar(40) not null,
        Phone varchar(14) not null,
        Email varchar(40),
        Address varchar(100) not null,
        AddedDate date not null,
        DoctorID INT not null,
        FOREIGN KEY(DoctorID) REFERENCES Doctor(DoctorID)
      );

mysql> CREATE TABLE Allergy
      (
        AllergyID INT not null PRIMARY KEY,
        AllergyName varchar(40) not null
      );

mysql> CREATE TABLE PatientAllergy
      (
        AllergyID INT not null PRIMARY KEY,
        PatientID INT not null,
        FOREIGN KEY(AllergyID) REFERENCES Allergy(AllergyID),
        FOREIGN KEY(PatientID) REFERENCES Patient(PatientID)
      );

mysql> CREATE TABLE Appointment
      (
        AppointmentID INT not null PRIMARY KEY,
        DoctorID INT not null,
        PatientID INT not null,
        AppointmentDate date not null,
        BloodPressure INT not null,
        Weight INT not null,
        TreatmentNotes varchar(300) not null,
        FOREIGN KEY(DoctorID) REFERENCES Doctor(DoctorID),
        FOREIGN KEY(PatientID) REFERENCES Patient(PatientID)
      );

mysql> CREATE TABLE Medicine
      (
        MedicineID INT not null PRIMARY KEY,
        MedicineName varchar(100) not null
      );

mysql> CREATE TABLE PatientMedicine
      (
        AppointmentID INT not null PRIMARY KEY,
        MedicineID INT not null,
        FOREIGN KEY(AppointmentID) REFERENCES Appointment(AppointmentID),
        FOREIGN KEY(MedicineID) REFERENCES Medicine(MedicineID)
      );
mysql> ALTER TABLE Specialty RENAME COLUMN Specialty_ID TO SpecialtyNumber;
mysql> ALTER TABLE Doctor ADD FOREIGN KEY SpecialtyNumber(SpecialtyNumber) REFERENCES Specialty(SpecialtyNumber);

##Here is the outputs of tables created with SQLs above.
mysql> show tables;
+--------------------+
| Tables_in_hospital |
+--------------------+
| allergy            |
| appointment        |
| doctor             |
| medicine           |
| patient            |
| patientallergy     |
| patientmedicine    |
| specialty          |
+--------------------+
8 rows in set (0.00 sec)

mysql> show columns from allergy;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| AllergyID   | int         | NO   | PRI | NULL    |       |
| AllergyName | varchar(40) | NO   |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql> show columns from appointment;
+-----------------+--------------+------+-----+---------+-------+
| Field           | Type         | Null | Key | Default | Extra |
+-----------------+--------------+------+-----+---------+-------+
| AppointmentID   | int          | NO   | PRI | NULL    |       |
| DoctorID        | int          | NO   | MUL | NULL    |       |
| PatientID       | int          | NO   | MUL | NULL    |       |
| AppointmentDate | date         | NO   |     | NULL    |       |
| BloodPressure   | int          | NO   |     | NULL    |       |
| Weight          | int          | NO   |     | NULL    |       |
| TreatmentNotes  | varchar(300) | NO   |     | NULL    |       |
+-----------------+--------------+------+-----+---------+-------+
7 rows in set (0.00 sec)

mysql> show columns from doctor;
+-----------------+-------------+------+-----+---------+-------+
| Field           | Type        | Null | Key | Default | Extra |
+-----------------+-------------+------+-----+---------+-------+
| DoctorID        | int         | NO   | PRI | NULL    |       |
| Name            | varchar(40) | NO   |     | NULL    |       |
| Phone           | varchar(14) | NO   |     | NULL    |       |
| SpecialtyNumber | int         | NO   | MUL | NULL    |       |
| Supervisor      | int         | NO   |     | NULL    |       |
+-----------------+-------------+------+-----+---------+-------+
5 rows in set (0.00 sec)

mysql> show columns from medicine;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| MedicineID   | int          | NO   | PRI | NULL    |       |
| MedicineName | varchar(100) | NO   |     | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql> show columns from patient;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| PatientID | int          | NO   | PRI | NULL    |       |
| Name      | varchar(40)  | NO   |     | NULL    |       |
| Phone     | varchar(14)  | NO   |     | NULL    |       |
| Email     | varchar(40)  | YES  |     | NULL    |       |
| Address   | varchar(100) | NO   |     | NULL    |       |
| AddedDate | date         | NO   |     | NULL    |       |
| DoctorID  | int          | NO   | MUL | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
7 rows in set (0.00 sec)

mysql> show columns from patientallergy;
+-----------+------+------+-----+---------+-------+
| Field     | Type | Null | Key | Default | Extra |
+-----------+------+------+-----+---------+-------+
| AllergyID | int  | NO   | PRI | NULL    |       |
| PatientID | int  | NO   | MUL | NULL    |       |
+-----------+------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql> show columns from patientmedicine;
+---------------+------+------+-----+---------+-------+
| Field         | Type | Null | Key | Default | Extra |
+---------------+------+------+-----+---------+-------+
| AppointmentID | int  | NO   | PRI | NULL    |       |
| MedicineID    | int  | NO   | MUL | NULL    |       |
+---------------+------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql> show columns from specialty;
+-----------------+-------------+------+-----+---------+-------+
| Field           | Type        | Null | Key | Default | Extra |
+-----------------+-------------+------+-----+---------+-------+
| SpecialtyNumber | int         | NO   | PRI | NULL    |       |
| Specialty       | varchar(40) | NO   |     | NULL    |       |
+-----------------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)