#!/bin/sh

token="1a8d6ca6-d51c-4f33-a224-2dbac47c7ed3"
curl -d '{"username": "edevries", "application": "triptop"}' \
    https://triptop-identity.wiremockapi.cloud/checkAppAccess?token=$token
