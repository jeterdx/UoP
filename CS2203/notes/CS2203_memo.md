- Discussion Forum Unit1
  - Judging from requirements of client, there might not be so many challenges of developing a DBMS to meet what client wants to do in terms of technical difficulty. Although the client requirement says to manage author and loaners information, it is more reasonable to manage book and loaners information since loaners borrow books, not author. So a DBMS needs to have two entity, books and loaners, those of which are in relation set. If books own original id or key, it is easier to introduce the system since we can match these two entity with the key such as Loander ID. On the other hand, it can be challenge about sharpen the requirement of client. While client hopes to manage an author informations such as address or email of them, I do not understand why those information are required. They do not seem to be relevant to realize a library management system. Therefore, the difficult of this project is depending on if the requirement can be modified to focus on developing a relational database to manage the relationship of loaners and books status. Also, there can be many undiscovered variables to make this project easier and more difficult such as the number of files stored in existing systems, the number of books in this library, and the number of loaners of this library, and so on.

- Discussion Forum Unit2
  - Discuss why it is important to review the final model. Consider the cases to make changes in the later stages of database development.
    - The importance of reviewing a database model before starting a development of database comes from its tightly coupled system characteristics. As we have learnt, database systems are heavily related to the business requirement. Also, in many of web system in these days, database is likely to be a bottleneck of entire system since it is connected to many systems such as web server, app server or searching server and so on. Therefore, making changes in the later stages of database development means that making changes in the entire processes of development. This is the reason why careful reviews should be done before starting actual development of database systems.
  - There are several issues to consider when reviewing the final model. One of the issues is M:N relationships. M:N relationships should be removed while reviewing the final model. Discuss the problem/s of M:N relationships and how they should be resolved. Support your discussion with examples.
    - In the phase of final reviewing, we need to pay the biggest attention on M:N relationship since M:N relationship can cause many problems in the actual database system. One of the typical problem of M:N relationship is multi column attribute. Suppose the case of relationship about classes and students in the university. Students can register multiple courses and courses can contain multiple students. In this situation, each table (students and courses) has many keys of each table. When trying to develop a database with this relationship, we need to create courses table with the number of columns of students which can be very big. Also, not all students will take all courses, which forces table to have many empty columns. This is the very inefficient usage of database resources. Therefore, join table needs to be prepared to solve this issue. In the case of students-courses relationship, join table with 3 attributes, that is, id, student_id, and course_id, is appropriate. As you can see, student_id and cource_id are foreign keys of two tables which try to make a relationship of. This is how join table solve the issue of many-to-many relationship.

- Memo of Unit3
  - three anormalies
    - Insertion
    - Delete
    - Update
  - Also, decompositions of tables can cause loss of information. Loss of information occurs when table is decomposed into two tables which loses the original information or generates information which did not exist before decompositions. So the database should be lossless, which means that the all of information should be recoverd when decomposed tables are convined again. In order to make detabase lossless, 3 normal form should be taken, so called, normalizations. More specifically, functional dependency should be maintained.
  - 3 normal form
    - Get rid of repeated data and make one data per one cell
      - List of values
      - Enumerated fields
      - Each data field should be a single datatype
    - Get rid of functional dependencies
      - Remove the groups of columns that depend on each other, rather than the key
    - Get rid of transient dependencies - to remove many to many relationship
      - Remove the field where a field depends more on another column, rather than primary key
  - But it can be a problem to do over-normzaliation since table can be sperated into a tiny peacies in the pahse of 3NF which cause damage of performance of it.
  - Therefore, for both normalization and decomposition, it is important to take a balance between performance of DBMS and efficiency to maintain the Database itself.
  - Also there is a case that 3NF is not enough to optimize the database where the pontial of update anormalies exists. In that case, BCNF,...

- Discussion Forum Unit3
  - Normalization is one of the important processes while designing databases. Normalization is actually a technique for reviewing the database design and it includes a set of mathematical rules. Answer the following questions using specific examples:
    - Does normalization always lead to a good design? Why or why not? What kind of issues, problems are possible in the normalization process?
      - Yes, normalization is powerful technique to enhance the maintainability of database system and realize an efficient usage of resources. There are three normal forms achieved by normalization; the first normal form is the state of whose repeated data is removed, the second normal form is the state of whose groups of columns that depend on each other except for key are removed, and third normal form is the state of whose transient dependencies is removed (Sharma, 2010). These processes can reduce the redundancy of data in database and mitigate the risk of many operational anomalies. Thinking of anomalies, decomposition is also the good way to improve the database(Watt and Eng, 2014). But decompositions of tables can cause loss of information. Loss of information occurs when table is decomposed into two tables which loses the original information or generates information which did not exist before decompositions. So, the database should be lossless, which means that all of information should be recovered when decomposed tables are combined again. In order to make database lossless, 3 normal forms should be taken, that is, normalizations. On the other hand, the risk of normalization should be mentioned, an over-normalization. When over-normalization occurs, table can be separated into tiny pieces in the phase of 3NF which cause damage of performance of database system itself since it has too many tables and go back and forth to refer each table many times, which result in the waste of memory or CPU resources. Therefore, for both normalization and decomposition, it is important to take a balance between performance of DBMS and efficiency to maintain the database itself.

Usefull link to understand the concept of Unit3 in Japanese.
https://www.altus5.co.jp/blog/algorithm/2017/05/30/db-ukey-detect2/


Memo of Unit4
- DDL
 - Data Definition Language : Manipulates the database schema.
   - Create, alter and drop table, index, and view
- DML
  - Data Manipulation Languge : Manipulate data within database objects.
  - SELECT, INSERT, UPDATE, DELETE
- Fun fact
  - Stored the elapsed seconds past since the specific EPOC (some point in 1970s).
- Difference between UNIQUE and PRIMARY KEY
  - UNIQUE allows null as a value but PRIMARY KEY does not.
- CHECK can make original constraints on values stored.
- View creates virtual tables

Discussion forum of Unit4
- Different data types could be used for the same attribute. For example, both char and varchar could be used to store “names” in a database. Examine the attributes for the Characters and Numbers data types. Using specific examples, compare data types for each category. For example, why you should choose char rather than varchar or opposite.
  - Characters
    - Data type "char" is defined as "fixed-length UTF-16 string type" in SQL standard (Simpson, 2019). This means the size of char is fixed to the size given in SQL statement. The size of memory prepared is also always fixed. For instance, when char data with size 10 is prepared, the program reserves 10 bytes memory, even if actual data is 1 byte. On the other hand, "varchar" is defined as "variable-length UTF-16 string type" in SQL standard (Simpson, 2019). This means the size of varchar is not fixed. For instance, when the program calls varchar with size 10, and the actual data input was 1 byte, the program adjusts the size of memory prepared to the actual size of data, that is, from 10 bytes to 1 byte. Based on the definition of both char and varchar, the advantage of char is that char type can reserve a desgnated space in memory with fixed sizes, which means high speed access to memory is achieved. Also, user cannot input over-size data, so sofware can controll an illegal data input. On the other hand, as it reserves the fixed size memory, it is not an efficient usage of memory space. As for varchar, it can reduce the memory space depending on actual data size, so an efficient usage of memory space can be achieved. On the contrary, user can input various size of data, so the software is vulnerable to malicious users. Also, an access speed to the memory can be slower compared with fixed-size memory access. These are the comparison between char and varchar type.
  - Numbers
    - Data type integer is defined as binary number type with 32 bit precision in SQL standard (Simpson, 2019). This is the very basic numeric type. There are many usages such as ID or post code which must not include any data type other than integral numbers. 32 bit in binary means it can take more than 2 billion patterns so if the maximum numbers of data is always less than that, it is reasonable to use a data type such as TINYINT or so. Data type decimal is defined as "identical types for fixed precision number (*)" while float is defined as "64 bit precision floating point number" in SQL standard (Simpson, 2019). The big differences between these two is whether it has an optional precision number, and the data type is expressed a decimal or binary. Decimal can choose an optional precision when defining a data, so data can be rounded when the data with more precisions is input. On the other hand, float is literally floating and maximum precision is 64 bit. When thinking of expressing 0.05 in float, it can be an infinite floating number since it's binary, which means that it requires rounding numbers more than 65 precision. As a result, a calculation will not be precise. So, in my opinion, it is reasonable to use decimal to express these types of numbers.


Memo of Unit5
- The distinction between DDL and DML is not just about the concept, but also about the actual SQL execution. ANSI/ISO does not require DBMS to accept DDL after database structure is created with DDL. But this is not the case with the commercial SQL which allows to execute the both maniplulation joinly. This ANSI/ISO standard is not common in

SQL used in Unit5

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


Memo of Unit5
- When using Self-join, aliases for tables are used to indentify each table.
- Restrict should be written in SQLs when using foreign keys that refer parenets keys.
  - SQL statement below is used. The second line restricts the deletion of parenet keys but allows updates which pass through to childs as well.
    - FOREIGN KEY(---) REFERENCES DEPARTMENTS
    - DELETE OF table_name RESTRICTED
    - UPDATE OF table_name CASCADE
- Trigger is useful when specific SQLs wanted to be executed with specific condional changes on databases
- The main point of view is not about an enablement of seeing, but about disablement of seeing what you do not want see.
  - Views have various powers when using database; security, data integrity, prevention from changes, easier querying.
  - When using views, be careful about what kind of queries is used to create the view, since queries used to retrieve data from the view can crash with the ones used to create the view.
  - Generally, view is not updatable but it is when it meets several requirements to make it sure that the rows and coluns in the view is traceable to the base table.


Discussion Forum of Unit6

- Union
  - Union is used to integrate more than two results of SQLs that must creat the same number of output. In this case, if users want to get a result of student_ID who registered a course of CS1101 or who are in the department of Computer Science, Union is useful. An actual SQL is below.

SELECT Student_ID from Student WHERE Dept_Name = "Computer Science"
UNION
SELECT Student_ID from Student WHERE Cousre_ID = "Student_Courses";

- Inner Join
  - Inner join is used to join two tables together and get data where designated columns have the same value. In this case, if users want to know a name of student who has the specific grade or has taken specific courses, inner join is useful. An actual SQL is below.

SELECT
  Student.Name
FROM Student
  INNER JOIN Student_Courses
ON
  Student.Student_ID = Student_Courses.Student_ID
WHERE
  Student_Courses.Course_ID = "CS1101"
AND
  Student_Courses.Grade = "A";

- Left and Right Outer Join
  - Left and Right outer join is used to get all tuples of left side table and tuples from right table where a join condition of two tables are met. Ther reason why I left and right at the same time here is both statements are essentially the same thing. It's just about how to decide the prioritized table. So in this case, if users want a list of names with course_ID. Left outer join is useful. On the other hand, if users want a list of course_ID with student_name, right outer join is useful. Actual SQLs are below.

<Left Outer Join>
SELECT
  Student.Student_Name
  Student_Courses.Course_ID
FROM Student
  LEFT JOIN  Student_Couses
ON
  Student.Student_ID = Student_Courses.Student_ID;

<Right Outer Join>
SELECT
  Student.Student_Name
  Student_Courses.Course_ID
FROM Student
  RIGHT JOIN  Student_Courses
ON
  Student.Student_ID = Student_Courses.Student_ID;

- Full Outer Join
  - Full outer join is used to get all joined table nonetheless if there is the same attributes or not. In MySQL, full outer join is not supported but it is possible to write SQL with the same function. Based on the definition of full outer join, it is the same as the union all of LEFT and RIGHT outer join to each table. An actual SQL is below.

SELECT * FROM Student
  RIGHT JOIN Student_Courses ON Student.Student_ID = Student_Courses.Student_ID
UNION ALL
SELECT * FROM Student
  LEFT JOIN Student_Courses ON Student.Student_ID = Student_Courses.Student_ID;


Discussion Forum of Unit7
- Transaction is an action or series of actions the execution of which should lead to a consistent database state from another consistent database state. Discuss which properties that transactions should have for their correct executions. Provide two examples to support your answer.
  - First of all, transactions can be defined as "a set of database operations all of which should be executed successfully in order to call the transaction successful"(Sharma, 2010). As an example of transactions of money transferring from one bank account to another bank account, transactions should have a strong integrity on whole sets themselves. In general, there are four important properties in database transactions, Atomicity, Consistency, Isolation, and Durability, which is known as ACID, in order to maintain accuracy, completeness, and data integrity. I am going to refer to two of these properties: Consistency and Isolation. Consistency is "integrity constraints must be maintained so that the database is consistent before and after the transaction"(ACID Properties in DBMS, 2022). For example, when thinking of the case of transferring money between two people again, if the total amount of money in the bank account of A is 1000$ while the one of B is 500$ before transactions, the total amount of money of these two people must always stay as 1500$ after any transactions such as sending 500$ from A to B or 300$ from B to A. This is a consistency of database. In addition to this, isolation is a property that ensures that multiple transactions can occur concurrently without leading to the inconsistency of the database state (ACID Properties in DBMS, 2022). As picture below, data inconsistency can happen if multiple transactions occur concurrently without ensuring an integrity of data changes until one transaction will commit the change to memory. There are the two of four peroperties that should be maintained in database.


Discussion Forum of Unit8
- Assume that you are testing the Orders database introduced in Watt (2014) - Appendix C. Discuss the problems and possible consequences of using the Orders database. Provide examples of how you would address any problems that you identified.
  - According to a textbook, testing is defined as to "compare the implemented system against the design documents and requirements specification and produces an acceptance report" (Sharma, 2010). In this unit lab, the designed documents are ER diagram listed on page 135 of the textbook. There is no more specification on business logic or requirements for the database system with clear statements. So, what I can check with this information is whether the SQL statements written covers enough requirements of ER diagram. There is no information about data type in ER diagram, no constraints or null option. What we can test is about primary key. In SQL Server, a phrase of "ON [PRIMARY]" is used to assign the database to a specific file group to which database is going to be stored. In other words, real entity of database is stored in this file group in SQL server. Therefore, this phrase is not used to define primary keys on each table. With these SQL statements, the risk of data duplication or the latency of data searching spreads since there is no primary keys in this database. An approach to solve this issue is simple; adding a primary key statement in CREATE table statements. This is my testing process in this lab.



References:
Sharma, N., Perniu, L., Chong, R. F., Iyer, A., Nandan, C., Mitea, A. C., Nonvinkere, M. & Danubianu, M. (2010). Database fundamentals. IBM Canada.
GeeksforGeeks. (2022, April 26). ACID Properties in DBMS. https://www.geeksforgeeks.org/acid-properties-in-dbms/


References:
Sharma, N., Perniu, L., Chong, R. F., Iyer, A., Nandan, C., Mitea, A. C., Nonvinkere, M. & Danubianu, M. (2010). Database fundamentals. IBM Canada.
Watt, A., & Eng, N. (2014). Database design,  2nd ed. BCcampus, BC Open Textbook Project.
Din, A. I. (2006).  Structured Query Language (SQL): A practical introduction. NCC Blackwell.
Simpson, B., Toussi, F, & The HSQL Development Group. (2019, June 2). HyperSQL user guide. Chapter 2.

