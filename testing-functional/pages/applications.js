
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
    appName: '#appname',
    appDesc: '#appdesc',
    apiKey: '#apikey',
    apiSecret: '#apisecret'
  },
  action: {
    newApp: '#newapp-btn',
    save: '#save-btn',
    previous: '#previous',
    next: '#next',
    dropdown: '#dropdownMenuButton',
    ps5: '#pagesize-5',
    ps10: '#pagesize-10',
    ps20: '#pagesize-20',
    ps50: '#pagesize-50',
  },
  elements: {
    appRow: '.list-group-item',
  },

  create25Apps(appName) {
    for(let i = 0; i < 25; i++) {
      I.click(this.header.apps)
      I.see('Applications', 'h1')
      I.click(this.action.newApp)
      I.see('Application name')
      I.see('Description')
      I.fillField(this.fields.appName, `${appName}-${i}`)
      I.fillField(this.fields.appDesc, `This is test app ${appName} ${i}`)
      I.click(this.action.save)
      I.waitForElement(this.fields.apiKey)
      I.waitForElement(this.fields.apiKey)
      I.click(this.header.apps)
    }
  },
  browseApps5() {
    I.see('Applications', 'h1')
    I.click(this.action.dropdown)
    I.waitForElement(this.action.ps5)
    I.click(this.action.ps5)
    for(let i = 0; i < 5; i++) {
      I.seeNumberOfElements(this.elements.appRow, 5)
      I.click(this.action.next)
    }
    for(let i = 0; i < 5; i++) {
      I.click(this.action.previous)
      I.seeNumberOfElements(this.elements.appRow, 5)
    }
  },
  browseApps10() {
    I.click(this.header.apps)
    I.see('Applications', 'h1')
    I.click(this.action.dropdown)
    I.waitForElement(this.action.ps10)
    I.click(this.action.ps10)
    I.seeNumberOfElements(this.elements.appRow, 10)
    I.click(this.action.next)
    I.seeNumberOfElements(this.elements.appRow, 10)
    I.click(this.action.next)
    I.seeNumberOfElements(this.elements.appRow, 5)
    I.click(this.action.previous)
    I.seeNumberOfElements(this.elements.appRow, 10)
    I.click(this.action.previous)
    I.seeNumberOfElements(this.elements.appRow, 10)
  },
  browseApps20() {
    I.click(this.header.apps)
    I.see('Applications', 'h1')
    I.click(this.action.dropdown)
    I.waitForElement(this.action.ps20)
    I.click(this.action.ps20)
    I.seeNumberOfElements(this.elements.appRow, 20)
    I.click(this.action.next)
    I.seeNumberOfElements(this.elements.appRow, 5)
    I.click(this.action.previous)
    I.seeNumberOfElements(this.elements.appRow, 20)
  },
  browseApps50() {
    I.click(this.header.apps)
    I.see('Applications', 'h1')
    I.click(this.action.dropdown)
    I.waitForElement(this.action.ps50)
    I.click(this.action.ps20)
    I.seeNumberOfElements(this.elements.appRow, 25)
  }
}
