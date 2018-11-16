
const I = actor();

module.exports = {

  // setting locators
  header: {
    login: '#nav-login',
    logout: '#nav-logout',
    register: '#nav-register',
    users: '#nav-users',
    apps: '#nav-apps',
    profile: '#nav-apps',
  },
  fields: {
    firstname: '#firstname',
    lastname: '#lastname',
    email: '#email',
    password: '#pwd',
  },
  action: {
    register: '#register-btn',
    redirect: '#redirect',
  },
  divs: {
    registerConfirmation: '#confirmation-text',
  },

  // introducing methods
  registerUser(firstname, lastname, email, password) {
    I.amOnPage('http://localhost:8080/gamification/pages/home')
    I.see('Welcome', 'h1')
    I.click(this.header.register)
    I.see('Register', 'h1')
    I.fillField(this.fields.firstname, firstname)
    I.fillField(this.fields.lastname, lastname)
    I.fillField(this.fields.email, email)
    I.fillField(this.fields.password, password)
    I.click(this.action.register)
    I.waitForElement(this.divs.registerConfirmation)
    I.see('Thank you for registering. Please activate your account by clicking the link in the mail sent to the mail address you provided.')
    I.amOnPage(`http://localhost:8080/gamification/pages/testactivation?email=${email}`)
    I.click(this.action.redirect)
    I.see('You have successfully activated your account. You can now log in.')
  }
}
