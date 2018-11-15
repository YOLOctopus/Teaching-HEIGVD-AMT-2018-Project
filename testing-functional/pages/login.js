
const I = actor();

module.exports = {

  // setting locators
  fields: {
    email: '#email',
    password: '#password',
  },
  submitButton: {
    css: '#login',
  },

  // introducing methods
  sendForm(email, password) {
    I.amOnPage('http://localhost:8080/gamification/pages/home')
    I.see('Welcome to the gamification API')
    I.click('Login')
    I.see('Login', 'h2')
    I.fillField(this.fields.email, email)
    I.fillField(this.fields.password, password)
    I.click('Login')
  }
}
