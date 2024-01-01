
#RESO TECH BACKEND API'S



## Database Configurations
1) install MYSQL Workbench
2) Create new schema
3) create new database with name resotech
assuming username and password are root and root respectively
## Procedure
Unzip the project :
1) Extract the all files from project structure
2) Run in intelliji IDE or anyother editor
 with commands below.
 mvn clean install to avoid dependencies version conflict then run the project.
 


## Run Locally

Clone the project

```bash
  git clone https://github.com/Bompalli458/resotech.git
```

Go to the project directory

```bash
  cd TaskManager
```

Install dependencies

```bash
 mvn build 
```

Start the server

```bash
  mvn spring-boot:run
```


## Deployment


1) GetAllTasks :
HTTP METHOD: GET 
http://localhost:8080/api/tasks/getAllTasks

2) Get Task by ID:

HTTP METHOD: GET
 http://localhost:8080/api/tasks/2/getTaskById

3) Create Task:
HTTP METHOD: POST:
 http://localhost:8080/api/tasks/createTask
Body:
  { 
  "taskName": "Fix backend changes ",
  "description": "Handle backend null values   and handle graceful exceptions "
}

4) Update Task by ID:
HTTP METHOD: PUT 
http://localhost:8080/api/tasks/2/updateTask

Body:
{
  "taskName": "fix api integrations",
  "description": "white label the reso tech api's"
}

5) Delete Task by ID:
HTTP METHOD: DELETE
 http://localhost:8080/api/tasks/1/deleteTask

## During Progress
 Faced issues while Handling all exceptions with graceful terminations.
 Used Global exceptions for all controllers exception.
 Loved the Assignment, special thanks to RESO TECH.
 
