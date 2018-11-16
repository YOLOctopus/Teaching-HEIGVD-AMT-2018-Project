
const I = actor();

module.exports = {

  // insert your locators and methods here
  header: {
    login: '#nav-login',
    logout: '#nav-logout',
    register: '#nav-register',
    users: '#nav-users',
    apps: '#nav-apps',
    profile: '#nav-apps',
  },
  fields: {
    search: '#search',
    appName: '#appname',
    appDesc: '#appdesc',
    apiKey: '#apikey',
    apiSecret: '#apisecret',
  },
  action: {
  },
  elements: {
    appRow: '.list-group-item',
  },

  searchApps(appName, number) {
    I.click(this.header.apps)
    I.see('Applications', 'h1')
    I.seeElement(this.fields.search)
    I.fillField(this.fields.search, appName)
    I.pressKey('Enter')
    I.seeNumberOfElements(this.elements.appRow, number)
  },
  searchUsers(userName) {
    I.click(this.header.users)
    I.see('Users', 'h1')
    I.seeElement(this.fields.search)
    I.fillField(this.fields.search, userName)
    I.pressKey('Enter')
    I.seeNumberOfElements(this.elements.appRow, number)
  }
}
