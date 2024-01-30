# Quorumify(Forum-API):  

## Database Structure

Question: ID, Content, Date, User{UserId-foreign Key}, List of Answer{List of AnswerId's}. 
Many to One Table (QuestionID, AnswerID)
One to One (QuestionID, UserID)

Answer: ID, Content, Date, User{UserId-foreign Key}, List of Reply{List of ReplyID's}.
Many to One Table (AnswerID, ReplyID)
One to One (AnswerID, UserID)

Replies: ID, Content, Date, User{UserId-foreign Key}.
One to One (ReplyID, UserID)

User: FirstName, LastName, Email, Password, Role, Bio.

## Acsses Level 
api/auth/ - Pubic
api/ADMIN/ - Admin
api/USER/ - User
api/MODERATOR/ - Moderator

## ScreenShots

<p float="left">

 GET: api/auth/ - Get all the Questions from Database
  <img src="Screenshots/Screenshot%202024-01-19%20133844.png" alt="-" width="90%"/>

POST: api/auth/signin/ (email, password) - Provide JWT Token for Secure transaction 
  <img src="Screenshots/Screenshot%202024-01-19%20135029.png" alt="-" width="90%"/>

GET: api/auth/loggedinUserinfo - Gives Current User Info from Request Header
  <img src="Screenshots/Screenshot%202024-01-19%20135610.png" alt="-" width="90%"/>

POST: api/user/postQuestion (content) - Upload Question in database and Create a Blank List of Answers, & taking User, Date, Id by it's own
  <img src="Screenshots/Screenshot%202024-01-19%20135858.png" alt="FoodRunner Splash Screen" width="90%"/>

POST: api/user/postAnswer/{Q_ID} (content) - Upload Answer in database and Create a Blank List of Reply, set Question_ID = Q_ID & taking User, Date, Id by it's own
  <img src="Screenshots/Screenshot%202024-01-19%20140857.png" alt="FoodRunner Splash Screen" width="90%"/>
  
PUT: api/user/updateBio (bio)  Update User Bio
  <img src="Screenshots/Screenshot%202024-01-19%20141946.png" alt="FoodRunner Splash Screen" width="90%"/>

DELETE: api/user/delete/QuestionByUser - Each user has Access to Delete Question Posted by him.
  <img src="Screenshots/Screenshot%202024-01-19%20142401.png" alt="FoodRunner Splash Screen" width="90%"/>
</p>
