# A JavaFX App which Authenthicate and Registers A student

_This App Accepts Users email and Password inputs to logging them to there account and if they don't have account it enables them to sign up._

## Tools used

- mysql
- Scene Builder
- Jdbc Connector
- JavaFX libraries

## IDE used

- VsCode

---

# Let's look each interfaces

> **1. The Login Page**

![Login](/screenshots/LoginPage.png)

- **if Button Login clicked, then the app compares the given password and email in the database**.

---

- _if they are correct it **display** The Welcome page which is shown below_
  ![Login](/screenshots/Dashbord.png)
  **Button logout** _if it is cliked it will switched back to the login page_

---

- _if they are not correct it will **display** an Error alert which is shown below_
  ![Login](/screenshots/LoginError.png)

---

- **Button Sign Up if it is cliked**
  **It display the sign up page**
  > **2. The Sign up Page**

![Login](/screenshots/SignUp.png)
**Button Register** _if it s cliked it checks all the fields are not null and both password is matched it register the user and switch back to the login page else_

- if password doesn't match it displays an error alert shown below
  ![Login](/screenshots/passworedDoesn'tMatchError.png)

* if one of the fields is null it displays the following
  ![Login](/screenshots/EnterAllEntryError.png)

* **If Button Back clicked** _it switched back to the login page_

---

---

> **3. Here is the database Table**

![Login](/screenshots/DataBase.png)

---
