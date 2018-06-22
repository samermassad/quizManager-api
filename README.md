# quizManager-API

Exposes the services of the quizManager-core as a REST API.

## Getting Started

Quiz Manager services can be easily used as following:

### Managing Users

##### Create a new user

GET request: `{server-url}/rest/createLogin?username={username}&password={password}`

##### Login

POST request: `{server-url}/rest/login` with a JSON body: `{"username":"user","password":"pass"}`

