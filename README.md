# Assignment 3’s README

Navigate to the folder of this README file:

Perform Below commands to compile/run/clean the program:


## To clean:
ant -build file airportSecurityState/src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile airportSecurityState/src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
ant -buildfile airportSecurityState/src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=DebugLevelInt

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.

[Date: 10/19/2017] 

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

- Implemented State Pattern Using AirportSecurity (Context Class), AirportStateI (State Inteface), LowRisk, HighRisk, ModerateRisk classes as different states classes inherited from AirportStateI Interface. 

- Implemented SecurityFactors class as the Controller of State Pattern. This class parse the input file and calculate Average Traffic and Prohibited Items and then send message to context class for State checking.

- Context class calls the tightenOrlosen method on current Sate object and gets the new state.

- Depending on the State, printing a String that shows the list of operations performed on particular state.

- No Special Data Structure is used in this assignment.


-----------------------------------------------------------------------
