CREATE TABLE Sale
      (
        SaleID INT AUTO_INCREMENT not null PRIMARY KEY,
        SaleDate date not null,
        Tax INT not null,
        Total INT not null,
        index(SaleID)
      );

CREATE TABLE Item
      (
        ItemID INT AUTO_INCREMENT not null PRIMARY KEY,
        Name varchar(100) not null,
        Cost INT not null,
        Price INT not null,
        index(ItemID)
      );

CREATE TABLE SaleItem
      (
        SaleID INT not null,
        ItemID INT not null,
        FOREIGN KEY(SaleID) REFERENCES Sale(SaleID),
        FOREIGN KEY(ItemID) REFERENCES Item(ItemID)
      );


mysql> show tables;
+----------------+
| Tables_in_shop |
+----------------+
| item           |
| sale           |
| saleitem       |
+----------------+
3 rows in set (0.00 sec)

mysql> show columns from item;
+--------+--------------+------+-----+---------+----------------+
| Field  | Type         | Null | Key | Default | Extra          |
+--------+--------------+------+-----+---------+----------------+
| ItemID | int          | NO   | PRI | NULL    | auto_increment |
| Name   | varchar(100) | NO   |     | NULL    |                |
| Cost   | int          | NO   |     | NULL    |                |
| Price  | int          | NO   |     | NULL    |                |
+--------+--------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

mysql> show columns from sale;
+----------+------+------+-----+---------+----------------+
| Field    | Type | Null | Key | Default | Extra          |
+----------+------+------+-----+---------+----------------+
| SaleID   | int  | NO   | PRI | NULL    | auto_increment |
| SaleDate | date | NO   |     | NULL    |                |
| Tax      | int  | NO   |     | NULL    |                |
| Total    | int  | NO   |     | NULL    |                |
+----------+------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

mysql> show columns from saleitem;
+--------+------+------+-----+---------+-------+
| Field  | Type | Null | Key | Default | Extra |
+--------+------+------+-----+---------+-------+
| SaleID | int  | NO   | MUL | NULL    |       |
| ItemID | int  | NO   | MUL | NULL    |       |
+--------+------+------+-----+---------+-------+
2 rows in set (0.00 sec)

INSERT INTO sale VALUES (0, '2022-01-01', 10, 110);
INSERT INTO sale VALUES (0, '2022-02-01', 20, 220);
INSERT INTO sale VALUES (0, '2022-03-01', 30, 330);
INSERT INTO sale VALUES (0, '2022-04-01', 40, 440);
INSERT INTO sale VALUES (0, '2022-05-01', 50, 550);
INSERT INTO sale VALUES (0, '2022-06-01', 60, 660);
INSERT INTO sale VALUES (0, '2022-06-01', 70, 770);


INSERT INTO item VALUES (0, 'Driver', 300, 700);
INSERT INTO item VALUES (0, '7Iron', 360, 600);
INSERT INTO item VALUES (0, 'PW', 220, 400);
INSERT INTO item VALUES (0, 'SW', 180, 300);
INSERT INTO item VALUES (0, 'AW', 130, 200);
INSERT INTO item VALUES (0, '5Iron', 30, 100);
INSERT INTO item VALUES (0, 'Putter', 450, 800);
INSERT INTO item VALUES (0, '2Iron', 300, 500);

INSERT INTO saleitem VALUES (6, 2);
INSERT INTO saleitem VALUES (7, 3);
INSERT INTO saleitem VALUES (7, 4);
INSERT INTO saleitem VALUES (5, 5);
INSERT INTO saleitem VALUES (5, 5);
INSERT INTO saleitem VALUES (5, 6);
INSERT INTO saleitem VALUES (1, 6);
INSERT INTO saleitem VALUES (3, 4);


mysql> select * from sale;
+--------+------------+-----+-------+
| SaleID | SaleDate   | Tax | Total |
+--------+------------+-----+-------+
|      1 | 2022-01-01 |  10 |   110 |
|      2 | 2022-02-01 |  20 |   220 |
|      3 | 2022-03-01 |  30 |   330 |
|      4 | 2022-04-01 |  40 |   440 |
|      5 | 2022-05-01 |  50 |   550 |
|      6 | 2022-06-01 |  60 |   660 |
|      7 | 2022-06-01 |  70 |   770 |
+--------+------------+-----+-------+
7 rows in set (0.00 sec)

mysql> select * from item;
+--------+--------+------+-------+
| ItemID | Name   | Cost | Price |
+--------+--------+------+-------+
|      1 | Driver |  300 |   700 |
|      2 | 7Iron  |  360 |   600 |
|      3 | PW     |  220 |   400 |
|      4 | SW     |  180 |   300 |
|      5 | AW     |  130 |   200 |
|      6 | 5Iron  |   30 |   100 |
|      7 | Putter |  450 |   800 |
|      8 | 2Iron  |  300 |   500 |
+--------+--------+------+-------+
8 rows in set (0.00 sec)

mysql> select * from saleitem;
+--------+--------+
| SaleID | ItemID |
+--------+--------+
|      6 |      2 |
|      7 |      3 |
|      7 |      4 |
|      5 |      5 |
|      5 |      5 |
|      5 |      6 |
|      1 |      6 |
|      3 |      4 |
+--------+--------+
8 rows in set (0.00 sec)

mysql> Update item SET Price=180 where ItemID=5;
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from item;
+--------+--------+------+-------+
| ItemID | Name   | Cost | Price |
+--------+--------+------+-------+
|      1 | Driver |  300 |   700 |
|      2 | 7Iron  |  360 |   600 |
|      3 | PW     |  220 |   400 |
|      4 | SW     |  180 |   300 |
|      5 | AW     |  130 |   180 |
|      6 | 5Iron  |   30 |   100 |
|      7 | Putter |  450 |   800 |
|      8 | 2Iron  |  300 |   500 |
+--------+--------+------+-------+
8 rows in set (0.00 sec)


