
const I = actor();

module.exports = {

  // setting locators
  fields: {
    firstname: '#firstname',
    lastname: '#lastname',
    email: '#email',
    password: '#password',
  },
  submitButton: {
    css: '#register',
  },
  divs: {
    registerConfirmation: '#confirmation-text',
  },

  // introducing methods
  sendForm(firstname, lastname, email, password) {
    I.amOnPage('http://localhost:8080/gamification/pages/home')
    I.see('Welcome to the gamification API')
    I.click('Register')
    I.see('Register', 'h2')
    I.fillField(this.fields.firstname, firstname)
    I.fillField(this.fields.lastname, lastname)
    I.fillField(this.fields.email, email)
    I.fillField(this.fields.password, password)
    I.click(this.submitButton)
    I.waitForElement(this.divs.registerConfirmation)
    I.see('Thank you for registering. Please activate your account by clicking the link in the mail sent to the mail address you provided.')
    I.amOnPage(`http://localhost:8080/gamification/pages/usertoken?email=${email}`)
    I.click('Redirect')
    I.see('You have successfully activated your account. You can now log in.')
  }
}
