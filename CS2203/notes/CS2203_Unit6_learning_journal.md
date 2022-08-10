##Part1
- Describe what you did (This does not mean that you copy and paste from what you have posted or the assignments you have prepared. You need to describe what you did and how you did it), what you learned, your weekly activities, in what ways are you able to apply the ideas and concepts gained, and finally, describe one important thing that you are thinking about in relation to the activity.
As usual as the other week, I started this unit learning as usual, starting from reading through materials and watched video lectures. This week, there was no programming assignment, so I put a lot time on preparing for graded-quiz. I review all quizzes last 3 units and analyze the part that I do not understand well. I found that my weak point was about ER diagram. Therefore, I reviewed each definition of diagram. Then, I completed the graded quiz. As I am not satisfied with the result yet, I guess I did my best. After that, I moved onto the discussion part, which was the big chance to learn the concept of join operation. Writing down actual SQLs were really great experience to know how the concept of each join is realized. Especially, I was interested in how to reproduce an implementation of full outer join in MySQL. These are my learning this week, and I will finish this.

===========
##Part2

CREATE TABLE Student
      (
        Student_ID varchar(10) not null,
        Student_Name varchar(20) not null,
        Dept_Name varchar(20) not null
      );

CREATE TABLE Student_Courses
      (
        Student_ID varchar(10) not null,
        Course_ID varchar(20) not null,
        Section INT not null,
        Year INT not null,
        Grade varchar(2)
      );

alter table Student modify Student_ID varchar(10);

INSERT INTO Student VALUES ("0000","AAAAA","Computer Science");
INSERT INTO Student VALUES ("1111","BBBBB","Computer Science");
INSERT INTO Student VALUES ("2222","CCCCC","Business Administration");
INSERT INTO Student VALUES ("3333","DDDDD","Education");
INSERT INTO Student VALUES ("4444","EEEEE","Physics");
INSERT INTO Student VALUES ("5555","FFFFF","History");

INSERT INTO Student_Courses VALUES ("0000",	"CS 2203", 2, 2020,	"A");
INSERT INTO Student_Courses VALUES ("0000",	"CS 1101", 1, 2019,	"A");
INSERT INTO Student_Courses VALUES ("1111","CS 1101", 5, 2019, "B");
INSERT INTO Student_Courses VALUES ("1111","CS 1102",	1, 2019, "B");
INSERT INTO Student_Courses VALUES ("1111","CS 2204",	1, 2020, "A");
INSERT INTO Student_Courses VALUES ("1111","CS 2401",	1, 2020, "A");
INSERT INTO Student_Courses VALUES ("2222","BUS 1101", 3,	2019,	"C");
INSERT INTO Student_Courses VALUES ("2222","BUS 2201", 1, 2020,	"B");
INSERT INTO Student_Courses VALUES ("2222","BUS 3302", 1, 2020,	"B");
INSERT INTO Student_Courses VALUES ("3333","EDUC 5010",	1, 2019, "A");
INSERT INTO Student_Courses VALUES ("3333","EDUC 5210", 1, 2020, "B");
INSERT INTO Student_Courses VALUES ("4444","PHY 1101", 4, 2019,	"A");
INSERT INTO Student_Courses VALUES ("4444","PHY 2202", 1, 2020,	"C");
INSERT INTO Student_Courses VALUES ("4444","PHY" "3304", 1, 2020, "A");

mysql> CREATE view grade_info_view AS SELECT Student.Student_ID, Student.Dept_Name, Student_Courses.Course_ID, Student_Courses.Grade FROM Student INNER JOIN Student_Courses ON  Student.Student_ID =  Student_Courses.Student_ID;
mysql> select * from grade_info_view;
+------------+------------------+-----------+-------+
| Student_ID | Dept_Name        | Course_ID | Grade |
+------------+------------------+-----------+-------+
| 0000       | Computer Science | CS 2203   | A     |
| 0000       | Computer Science | CS 1101   | A     |
| 1111       | Computer Science | CS 1101   | B     |
| 1111       | Computer Science | CS 1102   | B     |
| 1111       | Computer Science | CS 2204   | A     |
| 1111       | Computer Science | CS 2401   | A     |
| 3333       | Education        | EDUC 5010 | A     |
| 3333       | Education        | EDUC 5210 | B     |
| 4444       | Physics          | PHY 1101  | A     |
| 4444       | Physics          | PHY 2202  | C     |
| 4444       | Physics          | PHY3304   | A     |
+------------+------------------+-----------+-------+
11 rows in set (0.00 sec)

mysql> CREATE view dept_course_relation_view AS SELECT Student.Dept_Name, Student_Courses.Course_ID FROM Student INNER JOIN Student_Courses ON Student.Student_ID =  Student_Courses.Student_ID;
mysql> select * from dept_course_relation_view;
+------------------+-----------+
| Dept_Name        | Course_ID |
+------------------+-----------+
| Computer Science | CS 2203   |
| Computer Science | CS 1101   |
| Computer Science | CS 1101   |
| Computer Science | CS 1102   |
| Computer Science | CS 2204   |
| Computer Science | CS 2401   |
| Education        | EDUC 5010 |
| Education        | EDUC 5210 |
| Physics          | PHY 1101  |
| Physics          | PHY 2202  |
| Physics          | PHY3304   |
+------------------+-----------+
11 rows in set (0.00 sec)

mysql> alter view grade_info_view as SELECT Student.Student_Name, Student.Dept_Name, Student_Courses.Course_ID, Student_Courses.Grade FROM Student INNER JOIN Student_Courses ON  Student.Student_ID =  Student_Courses.Student_ID;
mysql> select * from grade_info_view;
+--------------+------------------+-----------+-------+
| Student_Name | Dept_Name        | Course_ID | Grade |
+--------------+------------------+-----------+-------+
| AAAAA        | Computer Science | CS 2203   | A     |
| AAAAA        | Computer Science | CS 1101   | A     |
| BBBBB        | Computer Science | CS 1101   | B     |
| BBBBB        | Computer Science | CS 1102   | B     |
| BBBBB        | Computer Science | CS 2204   | A     |
| BBBBB        | Computer Science | CS 2401   | A     |
| DDDDD        | Education        | EDUC 5010 | A     |
| DDDDD        | Education        | EDUC 5210 | B     |
| EEEEE        | Physics          | PHY 1101  | A     |
| EEEEE        | Physics          | PHY 2202  | C     |
| EEEEE        | Physics          | PHY3304   | A     |
+--------------+------------------+-----------+-------+
11 rows in set (0.00 sec)

mysql> drop view grade_info_view;
mysql> select * from grade_info_view;
ERROR 1146 (42S02): Table 'temp.grade_info_view' doesn't exist
mysql> select * from Student;
+------------+--------------+------------------+
| Student_ID | Student_Name | Dept_Name        |
+------------+--------------+------------------+
| 0000       | AAAAA        | Computer Science |
| 1111       | BBBBB        | Computer Science |
| 3333       | DDDDD        | Education        |
| 4444       | EEEEE        | Physics          |
| 5555       | FFFFF        | History          |
+------------+--------------+------------------+
5 rows in set (0.00 sec)

I created two views, "grade_info_view" and "dept_course_relation_view". As this output shows, views are useful to create temporary database with limited accesses to the data. For example, in the case of grade_info_view, database admin can meet the demand such that some department of school wants to check a difficulty of courses is appropriate or not based on grade data. But for security reason, it is not good to provide data of grade with individual name since it can specify each student's grade. So, based on the assumption that ID is secret key for database admin, not data opened for students or other organizations, creating grade_info_view can meet the demand. As seeing an operation of alter, drop, and select statement, alter and drop do not affect the original database. This means that if database admin gives an appropriate access and limit to the data, users can also operate it without a risk of damaging an original database. This is another reason why view is powerful.