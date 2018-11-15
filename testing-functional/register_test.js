
Feature('First Test')

Scenario('Login', (I) => {
  I.amOnPage('http://localhost:8080/gamification/pages/home')
  I.see('Welcome to the gamification API')
  I.click('Login')
  I.see('Login', 'h2')
  I.fillField('email', 'sam@gmail.com')
  I.fillField('pwd', '1234')
  I.click('Login')
});

Scenario('Register', (I, registerPage) => {
  registerPage.sendForm('jane','doe','jane@doe.com','1234567');
});

Scenario('Login', (I, loginPage) => {
  registerPage.sendForm('jane@doe.com','1234567');
});
