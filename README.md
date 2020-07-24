

QA AUTOMATION PROJECT TEMPLATE

By: Jorge Iván Matamoros Duran

Note:This README File as the project are still in development


This project has two purposes:

1 - Be my main project porfolio for  end 2 end autoamtion testing
2 - Be an tempalte project for any another automation project based on Java and testng


Requirements:
--Apache Maven 3.6.3 or higher
--Java 8 or Higher
--At leat one of the following browsers (Chorme,Firefox or EDGE) 


Instructions:
1- Go to logback file located under src/main/resources folder.
2- Open it and modify the following property: FLIE_LOCATION for the desired log's file location.
3- Optionally, these properties: LOG_FILE and FILE_EXT can be modified for the file name and the file extension respectively.
4- Next is to open projectproperties.yaml file and modify the drivers versions accoding with the browsers installed on your machine.
5- Go to testng.xml file located under  src/test/resources folder and open it.
6- Modify the "browser" parameter for the desired browser. 
7- Finnally on an console terminal go to  root folder (the one with the pom.xml file) and execute the following command: mvn test.






