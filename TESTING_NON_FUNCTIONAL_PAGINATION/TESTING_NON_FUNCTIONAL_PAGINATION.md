#### Non Functional Pagination Test    
One of the approaches for the retrieval of the fixed number (N) of the user's applications would be to retrieve all of the user's applications first, and then display only N of them. This solution would obviously be suboptimal.  
Another approach would be to take advantage of using the SQL functionalities and only retrieve N applications from the database in this case.   
To point out the difference between these two solutions in terms of the performance, we have set up a JMeter test. The test plan contains a Loop Controller, which sends 10 GET requests to the applications page, and a Summary Report that displays the minimum, maximum and the average times needed to execute the operations of the Loop Controller.  
The Summary Report results are displayed below.

Summary Report results for the slow pagination
![](img/slow-report.png)

Summary Report results for the fast pagination (using SQL functionalities)
![](img/fast-report.png)   


The default number of pages to display is set to 5.  
