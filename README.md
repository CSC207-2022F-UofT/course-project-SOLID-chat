# SOLID Chat

## Our Progress (Last Updated on Dec 10)

### Test Coverage

A summary of the test coverage is below. To view a full report, please open the file full-test-coverage-report.html.

### Chat UI
- By Nasim, James, and Amy
- The UI is rendered by ChatView
- This view will appear when a user creates a new chat or visits an existing chat

![image](https://user-images.githubusercontent.com/18428059/202935072-ba09587d-c67d-4599-9986-9c652480356f.png)

- Update on inner layers of the conversation history feature:
  - The ConvHistInteractor, responsible for displaying a conversation history, was tested (see [here](https://github.com/CSC207-2022F-UofT/course-project-SOLID-chat/pull/32)). To focus testing on the interactor, a mock data access class was used. While the test does not currently pass, the structure of the test is there.

### Profile display
- By Parmis
- Implemented by UserSearchUI, which allows a user to type in a user's username to view their features (user and username so far).
- User information is captured using UserPresenter interface, which uses UserDatabse's interface UserRetriever to retrieve the user of interest, then UserReader reads features of the reader that are eventually presented:
- ![img.png](images/img.png)
- Here, Alex123 is not a user of the chat system:
- ![img_1.png](images/img_1.png)
- parmis is a user of the chat system though:
- ![img_2.png](images/img_2.png)

### Profile feature modification
- By Parmis
- Implemented by UserMdoificationUI, which allows a user to verify their authority to access their account by confirming their username and password, and then choosing the feature they wish to modify, and enter the new value for it. 
- User information is captured using ChangeController interface, which uses UserDatabse's interface UserRetriever to retrieve the user of interest. Then, UserAuthenticationI confirms user's authority to make the change, then we use Changeable interface (use case) to make the changes to the User entity, and finally use UserModificationGateway to relay the changed info to UserDatabase:
- ![img_3.png](images/img_3.png)
- Here: Parmis's password is actually 123, so she doesn't get the chance to change her email:
- ![img_4.png](images/img_4.png)
- as you can see, her email is unchanged.
- now she enters the right password and tries again:
- ![img_5.png](images/img_5.png)
- This time, change was successful. She could use this tool to similarly change her username or password too:
- ![img_6.png](images/img_6.png)


### App Screen UI
- By Amy
- The AppScreen UI is the screen that acts as a proxy between the user's login screen and their individual chats.
- Upon logging in, a user will will be rendered with a view of AppScreen.
- App screen provides a dashboard of buttons containing a user's existing chats, and the order that these chats appear will update whenever a new message or chat is recieved/created.

<img width="218" alt="Screenshot 2022-12-07 113506" src="https://user-images.githubusercontent.com/71410005/206237009-b5dc955f-110c-48fc-9d00-fce72c8d4c94.png">


- Each chat button will also display a date indicating the date of the last message in a chat's conversation history, or no date if a chat has no messages 
- ChatView (the window referenced above) will open upon clicking an existing chat to display the chat to the user.
- With respect to ChatView, clicking on the +Private Chat button will also open an instance of ChatView for a user to create a new chat.

<img width="541" alt="Screenshot_20221206_014045" src="https://user-images.githubusercontent.com/71410005/206237398-8cc0e023-fdcb-41ec-9d7f-52de459fd407.png">

- Along with that, at the bottom of AppScreen are two buttons for a user to search for other users and edit their profile (see #Profile display and #Profile feature modification above). As well as a logout button on the top left which allows a user to logout.





### User Registration and Login
- By Madhav
- The User will be prompted to include the credentials to create a new account. Then he will be asked to choose a method to deliver the verification code: 
![image](https://user-images.githubusercontent.com/59711147/203239946-ba8e5650-5403-4dd5-9864-636599b68d60.png)
![image](https://user-images.githubusercontent.com/59711147/203240033-fddf931f-cf13-4405-99c7-d770541adb10.png)
If there is an account with the same username or password, an error message will show up(closing this message will allow the user to go back):
![image](https://user-images.githubusercontent.com/59711147/203240205-2e33094e-5578-4782-b3dc-b8dcd524c349.png)
![image](https://user-images.githubusercontent.com/59711147/203240317-d75bd4de-e8de-4720-bcb9-4016d3a27267.png)
Now(after clicking enter and choosing to verify via email), an email with the verification code will show up, and user will be prompted to enter the verification code:
![image](https://user-images.githubusercontent.com/59711147/203240493-5ef4c8c9-03e7-43c5-89fe-9dbda7b260fb.png)
![image](https://user-images.githubusercontent.com/59711147/203240620-eef94fe0-47b8-43ba-9612-9ed711c365b1.png)
If the incorrect verification code is entered, the following message shows up. Upon closing the message, the user can re-enter the correct verification code, upon which the login UI - asking for the username and password will show up:
![image](https://user-images.githubusercontent.com/59711147/203241081-fc541b31-fb2b-4df5-a2e5-7c481cd980c5.png)
![image](https://user-images.githubusercontent.com/59711147/203241122-7fade0d0-d354-4f6d-96ce-c55fafd2cf61.png)
If the user enters the credentials of an account that does not exist, the following message shows up. A similar message shows up if the user enters an incorrect password for the username
![image](https://user-images.githubusercontent.com/59711147/203241552-b442cc1a-36f0-4bd7-ba69-81f91b2db927.png)
Finally, if the user enters the correct login credentials, his chats will show up(see # App Screen UI above):
![image](https://user-images.githubusercontent.com/59711147/203241762-b549a6ca-1d90-4d3b-abde-6889f1219490.png)





## Template Readme
This is a template repository for CSC 207 projects. 
This repository contains starter code for a gradle project.
It also contains workflow documents that give instructions on how to manage your Github repository and how to use Github Projects for efficient collaboration.

### Checklist For Your Project
- [ ] Verify the correct settings for your project repository
- [ ] Set up Github Projects
- [ ] Create the implementation plan using issues and Github Projects
- [ ] Create deveopment branches for your features
- [ ] Use pull requests to merge finished features into main branch
- [ ] Conduct code reviews

**If your team has trouble with any of these steps, please ask on Piazza. For example, with how GitHub Classroom works, your team *may* not have permissions to do some of the first few steps, in which case we'll post alternative instructions as needed.**

### Workflow Documents

* Github Workflow: Please refer to the workflow that was introduced in the first lab. You should follow this when working on your code. The following document provides additional details too.

* [Project Planning and Development Guide](project_plan_dev.md): This document helps you to understand how to create and maintain a project plan for your class project. **This document helps you to complete the Implementation Plan Milestone.**

### Gradle Project
Import this project into your Intellij editor. It should automatically recognise this as a gradle repository.
The starter code was built using SDK version 11.0.1. Ensure that you are using this version for this project. (You can, of course, change the SDK version as per your requirement if your team has all agreed to use a different version)

You have been provided with two starter files for demonstration: HelloWorld and HelloWorldTest.

You will find HelloWorld in `src/main/java/tutorial` directory. Right click on the HelloWorld file and click on `Run HelloWorld.main()`.
This should run the program and print on your console.

You will find HelloWorldTest in `src/test/java/tutorial` directory. Right click on the HelloWorldTest file and click on `Run HelloWorldTest`.
All tests should pass. Your team can remove this sample of how testing works once you start adding your project code to the repo.

Moving forward, we expect you to maintain this project structure. You *should* use Gradle as the build environment, but it is fine if your team prefers to use something else -- just remove the gradle files and push your preferred project setup. Assuming you stick with Gradle, your source code should go into `src/main/java` (you can keep creating more subdirectories as per your project requirement). Every source class can auto-generate a test file for you. For example, open HelloWorld.java file and click on the `HelloWorld` variable as shown in the image below. You should see an option `Generate` and on clicking this your should see an option `Test`. Clicking on this will generate a JUnit test file for `HelloWorld` class. This was used to generate the `HelloWorldTest`.

![image](https://user-images.githubusercontent.com/5333020/196066655-d3c97bf4-fdbd-46b0-b6ae-aeb8dbcf351d.png)

You can create another simple class and try generating a test for this class.
