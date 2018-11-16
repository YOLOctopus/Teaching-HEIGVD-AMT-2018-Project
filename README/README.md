### Gamification - WP 1

#### Launching  
To launch the application, the `docker-compose up --build` command has to be executed from the topology-project directory. The application will be run at `localhost:8080/gamification`. The database can be found at `localhost:8888` (_username:_ root, _password:_ root) in the phpMyAdmin interface. Payara server administration console can be found at `localhost:4848` (_username:_ admin, _password:_ admin).

#### Overview  
Once connected, the user will be redirected to the gamification home page. He/she then can register or login to his/her account.  

![](img/homepage.png)  

* __Registration__  
To create a new account, the user has to enter his/her first and last names, the email address and the password. Once the Register button clicked and the fields verifications performed, an account activation email is sent to the user. The user can activate the account by clicking the link received in the email.
![](img/registration.png)  

* __UI__  
* __Administration console__   
* __Reset password__    


#### Implementation  
The project contains several packages:   
* __business__ package represents the Business Tier  and is responsible of the business logic of the application. Typically, classes of this package verify the data entered by the user and send emails.  
* __dao__ package contain Data Access classes which are responsible of retrieving data from the database. All the classes of this package extend the _GenericDAO_ class that implement the basic CRUD functionalities.  
* __model__ package contain the Model entities of the application, such as _Application_, _User_ and _UserToken_.
* __presentation__ package represents the Presentation Tier and contains the servlets which manage the http requests and forward the results to the .jsp pages.  

__Notes:__  
* The .jsp files generating the web pages can be found in the `webapp/WEB-INF/pages` directory.  
* We used the SQL database to store the data and JDBC API to access it.


#### Tests  
Functional tests, as long as non functional pagination transactions tests have been performed on our project. The non functional test reports can be found in [TESTING_NON_FUNCTIONAL_TRANSACTION](https://github.com/YOLOctopus/Teaching-HEIGVD-AMT-2018-Project/tree/master/TESTING_NON_FUNCTIONAL_TRANSACTIONS) and [TESTING_NON_FUNCTIONAL_PAGINATION](https://github.com/YOLOctopus/Teaching-HEIGVD-AMT-2018-Project/tree/master/TESTING_NON_FUNCTIONAL_PAGINATION). The non functional tests implementation can be found in the `gamification-test-transaction` and `testing-non-functional-pagination` branches of the project.
