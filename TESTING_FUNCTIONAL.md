# Testing functional

## Description
The test scenario runs as follows:   
- Developer creates an account
- Developer logs in
- Developer creates 25 applications
- Developer browses the pages showing the applications
- Developer logs out
- Developer tries to access the list of applications
- Developer is redirected on the login page

## Executing the tests
To execute the tests, checkout on the test branch () run the following commands:
```sh
cd TESTING_FUNCTIONAL
npm install
npm run selenium
# Open a new terminal
npm run test
```

## Introducing a bug
