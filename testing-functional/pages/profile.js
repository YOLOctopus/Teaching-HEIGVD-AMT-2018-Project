
const I = actor();

module.exports = {

  // insert your locators and methods here
  header: {
    login: '#nav-login',
    logout: '#nav-logout',
    register: '#nav-register',
    users: '#nav-users',
    apps: '#nav-apps',
    profile: '#nav-profile',
  },
  action: {
    deleteAccount: '#resetpwd-btn',
    redirect: '#redirect',
  },
  resetPassword() {
    I.click(this.header.profile)
    I.see(this.action.deleteAccount)
    I.click(this.action.deleteAccount)
    I.see('An email has been sent to')
    I.amOnPage(`http://localhost:8080/gamification/pages/testreset?email=${email}`)
    I.click(this.action.redirect)
    I.see('You have successfully activated your account. You can now log in.')
  }
}
