# quizManager-API

Exposes the services of the quizManager-core as a REST API.

## Getting Started

Quiz Manager services can be easily used as following:

### Managing Users

##### Create a new user

GET request: `{server-url}/rest/createLogin?username={username}&password={password}`

##### Login

POST request: `{server-url}/rest/login` with a JSON body: `{"username":"user","password":"pass"}`


### Managing Exams, questions and MCQ choices

##### Create object

PUT requests:
	`{server-url}/rest/question` with a JSON body: `{"question":"Question Body?","type":"MCQ"}`
	
	`{server-url}/rest/exam` with a JSON body: `{"name":"Exam Name"}`
	
	`{server-url}/rest/mcq` with a JSON body: `{"choice":"Choice Body?","valid":true,"order":1,"question":question}`

##### Login

POST request: `{server-url}/rest/login` with a JSON body: `{"username":"user","password":"pass"}`

