/*
@author

This is an sql file to put your queries for SQL coursework. 
You can write your comment in sqlite with -- or /* * /

To read the sql and execute it in the sqlite, simply
type .read sqlcwk.sql on the terminal after sqlite3 chinook.db.
*/

/* =====================================================
   WARNNIG: DO NOT REMOVE THE DROP VIEW
   Dropping existing views if exists
   =====================================================
*/
DROP VIEW IF EXISTS vCustomerPerEmployee;
DROP VIEW IF EXISTS v10WorstSellingGenres ;
DROP VIEW IF EXISTS vBestSellingGenreAlbum ;
DROP VIEW IF EXISTS v10BestSellingArtists;
DROP VIEW IF EXISTS vTopCustomerEachGenre;

.mode columns
.headers on
/*
============================================================================
Question 1: Complete the query for vCustomerPerEmployee.
WARNNIG: DO NOT REMOVE THE STATEMENT "CREATE VIEW vCustomerPerEmployee AS"
============================================================================
*/
CREATE VIEW vCustomerPerEmployee  AS
--Remove this line and complete your query for question 1 here
SELECT employees.LastName, employees.FirstName, employees.EmployeeID, count(customers.CustomerID) TotalCustomer
FROM employees, customers
WHERE customers.SupportRepID = employees.EmployeeID
GROUP BY EmployeeID;


/*
SELECT employees.LastName, employees.FirstName, EmployeeID, count(CustomerID) TotalCustomer
FROM employees, customers
GROUP BY EmployeeId;
*/


/*
============================================================================
Question 2: Complete the query for v10WorstSellingGenres.
WARNNIG: DO NOT REMOVE THE STATEMENT "CREATE VIEW v10WorstSellingGenres AS"
============================================================================
*/
CREATE VIEW v10WorstSellingGenres  AS
SELECT g.name Genre, sum(quantitySold) Sales
FROM
(SELECT trackid, sum(quantity) quantitySold
FROM invoice_items
GROUP BY trackid)
NATURAL JOIN tracks t
LEFT OUTER JOIN genres g ON g.genreid = t.genreid
GROUP BY t.genreid
ORDER BY sum(quantitySold) ASC
LIMIT 10;


/*
============================================================================
Question 3:
Complete the query for vBestSellingGenreAlbum
WARNNIG: DO NOT REMOVE THE STATEMENT "CREATE VIEW vBestSellingGenreAlbum AS"
============================================================================
*/
CREATE VIEW vBestSellingGenreAlbum  AS
--Remove this line and complete your query for question 3 here
SELECT genres.Name Genre, albums.Title Album, artists.Name Artist, count(invoiceID) Sales
FROM albums, artists, invoice_items, genres;






/*
============================================================================
Question 4:
Complete the query for v10BestSellingArtists
WARNNIG: DO NOT REMOVE THE STATEMENT "CREATE VIEW v10BestSellingArtists AS"
============================================================================
*/

CREATE VIEW v10BestSellingArtists AS
SELECT artists.Name Artist, albums.Title Album, invoice_items.Quantity TotalTrackSales

--link to total track sales 
WHERE artists.artistID = albums.artistID
--ORDER BY TotalTrackSales DESC
LIMIT 10;





/*
============================================================================
Question 5:
Complete the query for vTopCustomerEachGenre
WARNNIG: DO NOT REMOVE THE STATEMENT "CREATE VIEW vTopCustomerEachGenre AS" 
============================================================================
*/
CREATE VIEW vTopCustomerEachGenre AS
--Remove this line and complete your query for question 5 here
SELECT genres.Name Genre, FullName TopSpender, max(genreSpent) TotalSpending
FROM 
(
   SELECT FirstName || ' ' || LastName AS FullName, (UnitPrice * Quantity) GenreSpent
   FROM customers, invoices, invoice_items
   WHERE customers.customerID = invoices.customerID
   GROUP BY FullName
), genres
ORDER BY Genre DESC;

/*
To view the created views, use SELECT * FROM views;
You can uncomment the following to look at invididual views created
*/
--SELECT * FROM vCustomerPerEmployee;
--SELECT * FROM v10WorstSellingGenres ;
--SELECT * FROM vBestSellingGenreAlbum ;
SELECT * FROM v10BestSellingArtists;
--SELECT * FROM vTopCustomerEachGenre;
