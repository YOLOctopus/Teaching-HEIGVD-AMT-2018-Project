# Testing functional

To exexute functional tests checkout to `gamification-test-functional`:
```
git checkout gamification-test-functional
```

## Description
The test scenario runs as follows:
- Developer creates an account
- Developer logs in
- Developer creates 25 applications
- Developer browses the pages showing the applications
- Developer logs out
- Developer tries to access the list of applications
- Developer is redirected on the login page
- Developer logs in and changes its password
- Developer logs out
- Developer logs in with the new password
- Developer logs out
- Developer forgot his password, he resets it
- Developer logs in with the new password
- Developer logs out

## Executing the tests
To execute the tests, start the paraya server in your favorite IDE. Then:
```sh
# Start db
cd topology-dev/
docker-compose up --build

# Install global dependencies
npm install -g selenium-standalone
selenium-standalone install
selenium-standalone start

# Install local dependencies
cd testing-functional/
npm install

# Open a new terminal
npm run test
```
