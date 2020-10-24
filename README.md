# Office API

API created for Approval flow to purchase requests of office supplies built on the basis of Java, Spring and MySql. It provides data to the office-web project!

## Getting Started and Installing it

To install this project, just need to clone it and run in your IDE of preference (I personally used Intellij IDEA). In it have a file called 'scripts.txt' that have the scripts to create the tables from the database. When you open the project in your IDE, it probably will ask you for download the Maven Dependencies, just click in Accept Button and wait for the end of it, when it ends, you can just run the application to use the API.

Obs: Don't forget to make sure that you have JDK 1.8 and MySql installeds in your machine.

## Database configuration

```
name: office_db

port: 3306

username: administrator

password: password!@#

Obs: If you want to change it, go to application.properties file and just put another parameters.
```

## Built With (Main technologies)

* Java
* Spring
* MySql

## Author

* **Marino Gonçalves Neto** - [Github](https://github.com/MarinoNetoo)

## Notes

The system is not yet completely finalized, we already have a little system to register users and get the users, but this unfortunately is not implemented in office-web yet, so we have an 'simulation' of user system in there to simulate the process that is not finished yet. However, it is already in progress and will become real soon! Hope you like it!

