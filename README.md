# Employee Management
This microservice is used to  add and get employees of a given instructor. Eg: 

Add Api:
http://localhost:8085/addEmployee/Instructor4/mandeep 

input:
{Instructor4} act as parent  
{mandeep} act as empName which needs to be added under this parent

Get Api: 
http://localhost:8085/getEmployees/Instructor4 
input : {Instructor4}  

output:   {
"empName": "mandeep",
"parent": "Instructor4"
}



### Structure

The template contains the following major components: inbound, outbound, service and configuration.
Communication to and from the service belongs in the inbound and outbound packages. The core business logic of the service belongs in the service folder. Interfaces describeing the behaviour of the service and outbound communication is located in the service.ports package. 
The service.model package contains the main model of the service, the inbound and outbound functions maps to and from this main model. 
Lastly the config package contains all the configurations used by springboot.

## Application
To run the application locally use the run.sh file in shell command. E.g : "source run.sh"
