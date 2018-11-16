
Feature('First Test')

const firstname = 'john'
const lastname = 'doe'
const email = 'john9@doe.com'
const password = '1234567'
const appName = `${email}-app`

Scenario('Register', (I, registerPage) => {
  registerPage.registerUser(firstname, lastname, email, password)
})

Scenario('Create application and browse pages with specific pages', (I, loginPage, applicationsPage) => {
  loginPage.loginUser(email, password)
  applicationsPage.create25Apps(appName)
  applicationsPage.browseApps5()
  applicationsPage.browseApps10()
  applicationsPage.browseApps20()
  applicationsPage.browseApps50()
})

Scenario('Search app, delete app and search again', (I, loginPage, searchPage, applicationPage) => {
  loginPage.loginUser(email, password)
  searchPage.searchApps(`${appName}-10`, 1)
  applicationPage.deleteApp(`${email}-app-10`)
  searchPage.searchApps(`${appName}-10`, 0)
})

Scenario('Reset account password', (I, loginPage, profilePage) => {
  loginPage.loginUser(email, password)

})

Scenario('Forgot password', (I, loginPage, profilePage) => {
  loginPage.forgotPassword(email, password)
  loginPage.loginUser(email, password)
})
