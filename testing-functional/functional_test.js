
Feature('First Test')

const firstname = 'john'
const lastname = 'doe'
const email = 'john@doe.com'
const password = '1234567'

Scenario('Register', (I, registerPage) => {
  registerPage.sendForm(firstname, lastname, email, password)
})

Scenario('Login', (I, loginPage) => {
  loginPage.sendForm(email, password)
})
