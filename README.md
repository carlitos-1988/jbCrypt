# jbCrypt

## Lab Class 14

## Feature Tasks 

- Create a database.
  Create a table that models users with a username, id, and hashed password.
  Create a table that models posts with a postId, userId and text content.
  Create a table with a 1-to-many relationship between users and posts.
  Create login/signup page.
  Authenticate the site so only logged-in users can see posts.
  Unauthenticated users accessing protected areas of site should be redirected to login/signup page.
  Use Bcrypt to hash all passwords stored on the site.

### Limitations 
- the app is completed but the blog has not been completed and implemented. Intent is to be able to generate blogs for the blogpost topic. Ultimately there is more to be done 

#### Self Notes 

- Keep track of Routes and understand where redirects can happen
- Two controllers can co-exist within the app seems like good practice for each controller to keep track of the models it is responsible for
- application.properties need to point to the actual running instance of the database application 
- need to tinker or ask why the new database was not able to connect, thinking that two databases where taking up the same port will test more or ask 
- HttpServerletRequest seems to be parent to HttpSession. without HttpServerletRequest HttpSession is not able to get a session.
- Need to readup more on Http Sessions not sure how they look like and what information they have 
- BCrypt was able to generate the hash password and save it and retrieve it from the database 
- I am not sure where the verification from the salted password occurs. The login post map did not verify the password we simply check to see if the person exists in the database  
