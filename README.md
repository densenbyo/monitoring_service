# monitoring_service
monitoring_service

### Send POST request with json body
POST http://localhost:8080/api/v1/user
Content-Type: application/json

{
  "username": "mukan",
  "email": "atazhanov@mail.com",
  "accessToken": ""
}

### GET request with parameter
GET http://localhost:8080/api/v1/health-check
Accept: application/json

### GET request with parameter
GET http://localhost:8080/api/v1/user/4b538d5d-98c1-4d57-bfa1-f8eb41657bfb
Accept: application/json
Authorization: Bearer 4b538d5d-98c1-4d57-bfa1-f8eb41657bfb
