
Feature('First Test')

const firstname = 'john'
const lastname = 'doe'
const email = 'john13@doe.com'
const password = '1234567'
const newPassword = '12345678'
const newPassword2 = '123456789'
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
  profilePage.changePassword(newPassword)
  loginPage.loginUser(email, newPassword)
  loginPage.logoutUser()
})

Scenario('Forgot password', (I, loginPage, profilePage) => {
  loginPage.forgotPassword(email, newPassword2)
  loginPage.loginUser(email, newPassword2)
})
