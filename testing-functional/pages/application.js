
const I = actor();

module.exports = {

  // insert your locators and methods here
  action: {
    saveChanges: '#save-changes',
    deleteApp: '#delete-app',
    popupDelete: '#popup-delete'
  },

  deleteApp(appName) {
    I.click(appName)
    I.see('Application', 'h1')
    I.click(this.action.deleteApp)
    I.waitForVisible(this.action.popupDelete)
    I.click(this.action.popupDelete)
  }
}
