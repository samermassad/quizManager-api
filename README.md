# QuizManager-API
#### Version 1.0

Exposes the services of the quizManager-core as a REST API.

## Getting Started

Quiz Manager services can be easily used as following:

### Managing Users

#### Create a new user

GET request: `{server-url}/rest/createLogin?username={username}&password={password}`

#### Login

POST request: `{server-url}/rest/login` with a JSON body: `{"username":"user","password":"pass"}`


### Managing Exams, questions and MCQ choices

#### Create object

PUT requests:

	`{server-url}/rest/question` with a JSON body: `{"question":"Question Body?","type":"MCQ"}`
	
	`{server-url}/rest/exam` with a JSON body: `{"name":"Exam Name"}`
	
	`{server-url}/rest/mcq` with a JSON body: `{"choice":"Choice Body?","valid":true,"order":1,"question":question}`
	
	`{server-url}/rest/examQuestionRel` with a JSON body: `{"exam":exam,"question":question}`

#### List objects

GET requests:

	`{server-url}/rest/question?question=some keywords&type=MCQ`
	
	`{server-url}/rest/exam?name=exam name`
	
	`{server-url}/rest/mcq?question=questionID`
	
	`{server-url}/rest/examQuestionRel?question=questionID&exam=examID`
	
	
#### Delete objects

DELETE requests:

	`{server-url}/rest/{object type}?id={object id}`
	
#### Update objects

POST requests:

	`{server-url}/rest/question` with a JSON body: `{"question":"Question Body?","type":"MCQ"}`
	
	`{server-url}/rest/exam` with a JSON body: `{"name":"Exam Name"}`
	
	`{server-url}/rest/mcq` with a JSON body: `{"choice":"Choice Body?","valid":true,"order":1,"question":question}`
	
	`{server-url}/rest/examQuestionRel` with a JSON body: `{"exam":exam,"question":question}`
	

## Author

Samer Masaad


