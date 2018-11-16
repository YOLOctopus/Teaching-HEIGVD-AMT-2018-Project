
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
    email: '#email',
    password: '#pwd',
    newPassword: '#newPassword',
    passwordRepeat: '#passwordRepeat',
  },
  action: {
    login: '#login-btn',
    forgotPassword: '#forgot-password-link',
    sendMail: '#send-mail',
    redirect: '#redirect',
    submit: '#submit-btn',
  },

  // introducing methods
  loginUser(email, password) {
    I.amOnPage('http://localhost:8080/gamification/pages/home')
    I.see('Welcome to the gamification API', 'h1')
    I.click(this.header.login)
    I.see('Login', 'h1')
    I.fillField(this.fields.email, email)
    I.fillField(this.fields.password, password)
    I.click(this.action.login)
    I.seeElement(this.header.profile)
    I.seeElement(this.header.logout)
    I.seeElement(this.header.apps)
  },
  loginAdmin(email, password) {
    this.loginUser(email, password)
    I.seeElement(this.header.users)
  },
  logoutUser() {
    I.click(this.header.logout)
  },
  redirectAccessApps() {
    I.click(this.header.apps)
    I.see('Welcome to the gamification API', 'h1')
  },
  forgotPassword(email, newPassword) {
    I.see('Welcome to the gamification API', 'h1')
    I.click(this.header.login)
    I.see('Login', 'h1')
    I.click(this.action.forgotPassword)
    I.fillField(this.fields.email, email)
    I.click(this.action.sendMail)
    I.see('An email has been sent to')
    I.amOnPage(`http://localhost:8080/gamification/pages/testforgot?email=${email}`)
    I.click(this.action.redirect)
    I.see('Reset Password', 'h1')
    I.fillField(this.fields.newPassword, newPassword)
    I.fillField(this.fields.passwordRepeat, newPassword)
    I.click(this.action.submit)
    I.see('Password successfully reseted.')
  },
}
