# Quorumify(Forum-API):  

## Database Structure

Question: ID, Content, Date, User{UserId-foreign Key}, List of Answer{List of AnswerId's}. 
     > Many to One Table (QuestionID, AnswerID)
     > One to One (QuestionID, UserID)

Answer: ID, Content, Date, User{UserId-foreign Key}, List of Reply{List of ReplyID's}.
     > Many to One Table (AnswerID, ReplyID)
     > One to One (AnswerID, UserID)

Replies: ID, Content, Date, User{UserId-foreign Key}.
     > One to One (ReplyID, UserID)

User: FirstName, LastName, Email, Password, Role.

## ScreenShots

<p float="left">

 GET: api/auth/ - Get all the Questions from Database
  <img src="Screenshots/Screenshot%202024-01-19%20133844.png" alt="-" width="90%"/>


  <img src="Screenshots/Screenshot%202024-01-19%20135029.png" alt="-" width="90%"/>
  <img src="Screenshots/Screenshot%202024-01-19%20135610.png" alt="FoodRunner Splash Screen" width="90%"/>
  <img src="Screenshots/Screenshot%202024-01-19%20135858.png" alt="FoodRunner Splash Screen" width="90%"/>
  <img src="Screenshots/Screenshot%202024-01-19%20140857.png" alt="FoodRunner Splash Screen" width="90%"/>
  <img src="Screenshots/Screenshot%202024-01-19%20141152.png" alt="FoodRunner Splash Screen" width="90%"/>
  <img src="Screenshots/Screenshot%202024-01-19%20141523.png" alt="FoodRunner Splash Screen" width="90%"/>
  <img src="Screenshots/Screenshot%202024-01-19%20141946.png" alt="FoodRunner Splash Screen" width="90%"/>
  <img src="Screenshots/Screenshot%202024-01-19%20142401.png" alt="FoodRunner Splash Screen" width="90%"/>
</p>
