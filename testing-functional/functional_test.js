
Feature('First Test')

const firstname = 'john'
const lastname = 'doe'
const email = 'john9@doe.com'
const password = '1234567'
const appName = `${email}-app`

Scenario('Register', (I, registerPage) => {
  registerPage.registerUser(firstname, lastname, email, password)
})

Scenario('Applications', (I, loginPage, applicationsPage) => {
  loginPage.loginUser(email, password)
  applicationsPage.create25Apps(appName)
  applicationsPage.browseApps5()
  applicationsPage.browseApps10()
  applicationsPage.browseApps20()
  applicationsPage.browseApps50()
})
