<h1 align="center">Students Control</h1>
<p align="center">

____
### I. Description

==================

Welcome to the Students Control app. <br/> <br/>
Before starting the application, you have access to several main
properties that characterize the initial
random list of students up to 8 people:<br/>
1) app.event-create-list.enabled: true or false - initialization or not random 
list of students and save it to Map. (a random number of students is generated from 1 to 8)<br/>
2) students-settings.names - list of student names where the random value comes from.<br/>
3) students-settings.surnames -  list of student surnames where the random value comes from.<br/>

The application is implemented using Spring Shell and a boot module. 
And also during the work, EventListener was involved

The student database is implemented on the basis of a local repository within the application. The base 
is implemented through the Repository interface and the RepositoryImpl class, which is bean.

The repository works with possible incoming commands from the user in the console, which are described below.
The actual data storage is implemented in the repository using a Map in which the student is stored under
an individual ID, and which, depending on the above application 
parameters, when launched, the application will already have a certain number of students or will be empty.
When auto-filling of the list is enabled, the implementation of automatic completion by students is organized 
in the class using an EventListener, ApplicationEvent, ApplicationStartedEvent listener.

The student entity, in addition to ID, also consists of such properties as first name, last name and age.

The main work is done in the StudentController class, which, of course, is also a shell component.<br/>

The application starts with the method _start)_.
Using the EventListener annotation and the ApplicationStartedEvent listener,
the application understands that before starting work it needs to show a list of available commands
The user is provided with 4 functions that interact with the repository:
1) show - Show the user in the console which students are currently in the database.
2) add - Adding a student to internal storage with params name, sername and age. ID students generate auto. 
(Works through method _addStudentToList()_)
3) del - Removing a student by his id. (Works through method _deleteStudentFromList()_)
4) clr - Clear students list.(Works through method _clearStudentsList()_)

** _all automatic generation values of the application occurs in the GeneratedSettingsStudent class_


==================

### II. How to start
There are two options available to launch the application:
1) Move the repository to your development environment and use the Run function of your environment under the Main class in the application architecture.
   The system will build and launch the application.
2) The second way is to use Docker. At the root of the application, a
Dockerfile is generated that contains parameters such as FROM, WORKDIR, COPY, CMD, which together 
allow you to build the application into a container and run it from there.
   To run an application from Docker, you need to enter the following commands in the console:
   - docker build -t [name image] .;
   - docker run -it [name image].
   
----


