# Quorumify(Forum-API) Server :  

## Database Structure



<table border="0">

 <tr>
    <td>
> Question: ID, Content, Date, User{UserId-foreign Key}, List of Answer{List of AnswerId's - List of foreign Key}. <br>
&emsp; Many to One Table (QuestionID, AnswerID)

> Answer: ID, Content, Date, User{UserId-foreign Key}, List of Reply{List of ReplyID's - List of foreign Key}. <br>
&emsp; Many to One Table (AnswerID, ReplyID)

> Replies: ID, Content, Date, User{UserId-foreign Key}. <br>

> User: FirstName, LastName, Email, Password, Role, Bio. <br>
    </td>
    <td> 
<img src="Screenshots/Screenshot%202024-01-31%20174326.png" alt="-" /></td>
 </tr>
</table>

## Role Based Accses Level 
> &emsp; Public:- api/auth  - /, /signin, /signup <br>

> &emsp; Admin:- api/ADMIN - /DeleteQuestion, /updateUserToModerator, /updateModeratorToUser, /GetAllUser <br>

> &emsp; User:- api/USER - /postQuestion, /postAnswer, /postReply, /deleteQuestionByUser, /deleteAnswerByUser, /deleteReplyByUser, /UpdateBio<br>

> &emsp; Moderator:- api/MODERATOR - /UpdateQuestion <be>

# Getting Started with Server 
> Download the Zip file of [Quarumify-Server](https://github.com/Ronak083/Forum-API)
> Clean and Install Maven before running the Application.
> Run src/main/java/com/example/forumapi/ForumApiApplication.java as Application.
> Run on Default port [localhost:8080](), So that it will run without any problem because React app is configured with localhost:8080 only.
For any Query Contact me at ronakgupta083@gmail.com

## ScreenShots

<p float="left">
Here are some Screenshots from Postman During Api testing

 > GET: api/auth/ - Get all the Questions from Database
  <img src="Screenshots/Screenshot%202024-01-19%20133844.png" alt="-" width="90%"/>

> POST: api/auth/signin/ (email, password) - Provide JWT Token for Secure transaction 
  <img src="Screenshots/Screenshot%202024-01-19%20135029.png" alt="-" width="90%"/>

> GET: api/auth/loggedinUserinfo - Gives Current User Info from Request Header
  <img src="Screenshots/Screenshot%202024-01-19%20135610.png" alt="-" width="90%"/>

> POST: api/user/postQuestion (content) - Upload Question in database and Create a Blank List of Answers, & taking 
> User, Date, Id by it's own
  <img src="Screenshots/Screenshot%202024-01-19%20135858.png" alt="FoodRunner Splash Screen" width="90%"/>

> POST: api/user/postAnswer/{Q_ID} (content) - Upload Answer in database and Create a Blank List of Reply, set 
> Question_ID = Q_ID & taking User, Date, Id by it's own
  <img src="Screenshots/Screenshot%202024-01-19%20140857.png" alt="FoodRunner Splash Screen" width="90%"/>
  
> PUT: api/user/updateBio (bio)  Update User Bio
  <img src="Screenshots/Screenshot%202024-01-19%20141946.png" alt="FoodRunner Splash Screen" width="90%"/>

> DELETE: api/user/delete/QuestionByUser - Each user has Access to Delete Question Posted by him.
  <img src="Screenshots/Screenshot%202024-01-19%20142401.png" alt="FoodRunner Splash Screen" width="90%"/>
</p>
