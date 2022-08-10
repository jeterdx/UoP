1. Get all the orders placed by a specific customer. CustomerID for this customer is MAGAA
SELECT * from tblOrders where tblOrders.CustomerID = "MAGAA";

2. Show customers whose ContactTitle is not Sales Associate. Display CustomerID, CompanyName, Contact Name, and ContactTitle
SELECT CustomerID, CompanyName, ContactName, ContactTitle from tblCustomers where tblCustomers.ContactTitle != "Sales Associate";

3. Show customers who bought products where the EnglishName includes the string “chocolate”. Display CustomerID, CompanyName, ProductID, ProductName, and EnglishName
SELECTc.CustomerID, c.CompanyName, p.ProductID, p.ProductName, p.EnglishName FROM tblCustomers c JOIN tblOrders o
ON c.CustomerID = o.CustomerID
JOIN tblOrderDetails od
ON o.OrderID = od.OrderID
JOIN tblProducts p
ON od.ProductID = p.ProductID
WHERE p.EnglishName LIKE '%chocolate%';

4. Show products which were bought by customers from Italy or USA. ”. Display CustomerID, CompanyName, ShipCountry, ProductID, ProductName, and EnglishName
SELECT c.CustomerID, c.CompanyName, p.ProductID, p.ProductName, p.EnglishName, o.ShipCountry FROM tblCustomers c JOIN tblOrders o
ON c.CustomerID = o.CustomerID
JOIN tblOrderDetails od
ON o.OrderID = od.OrderID
JOIN tblProducts p
ON od.ProductID = p.ProductID
WHERE c.Country = "Itarly" OR c.Country = "USA";

5. Show total price of each product in each order. Note that there is not a column named as total price. You should calculate it and create a column named as TotalPrice. Display OrderID, ProductID, ProductName, UnitPrice, Quantity, Discount, and TotalPrice
CREATE view totalSummary as select od.OrderID, od.ProductID, p.ProductName, od.UnitPrice, od.Quantity, od.Discount, sum(od.UnitPrice * od.Quantity * (1-od.Discount)) as TotalPrice from tblOrderDetails od join tblProducts p on od.ProductID = p.ProductID;

6. Show how many products there are in each category and show the results in ascending order by the total number of products. Display CategoryName, and TotalProducts
CREATE view totalProducts as SELECT CategoryID, COUNT(CategoryID) as TotalProducts from tblProducts
GROUP BY CategoryID HAVING count(CategoryID) > 1 ORDER BY TotalProducts ASC;

7. Show the total number of customers in each City. Display Country, City, TotalCustomers
CREATE view customerGeo as SELECT Country, City, COUNT(City) as TotalCustomers from tblCustomers
GROUP BY City HAVING count(City) > 1;

8. Show the orders which were shipped late than the actual required date. Display OrderID, OrderDate, RequiredDate, and ShippedDate
SELECT OrderID, OrderDate, RequiredDate, and ShippedDate from tblOrders where RequiredDate < ShippedDate;