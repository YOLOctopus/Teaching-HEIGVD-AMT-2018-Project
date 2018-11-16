
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
  fields: {
    newPassword: '#newPassword',
    passwordRepeat: '#passwordRepeat',
  },
  action: {
    resetPwd: '#resetpwd-btn',
    submit: '#submit-btn',
  },
  changePassword(newPassword) {
    I.click(this.header.profile)
    I.seeElement(this.action.resetPwd)
    I.click(this.action.resetPwd)
    I.see('Reset Password', 'h1')
    I.fillField(this.fields.newPassword, newPassword)
    I.fillField(this.fields.passwordRepeat, newPassword)
    I.click(this.action.submit)
    I.see('Password successfully reseted.')
    I.click(this.header.logout)
  }
}
