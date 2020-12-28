# Customer Overview

In our bank we to build a rest api for online customer overview application.
This application needs to getting data from multiple backend systems via rest calls.
Based on customerID it needs to gather details from following systems.

### Customers application
  Will provide details of the customer like (Full name , Date of birth , gender etc).[sample Response Json](./customers)
### Accounts application
 Will provide details list of accounts, current balances , IBAN numbers.[sample Response Json](./accounts)
### Insurances application
 Will provide details about customer owned insurance with our bank such as type, coverage amount.[sample Response Json](./insurances)

# Non functional requirement
* Systems should respond with in 1 second.
* Overview system can take up to 2 seconds max.

## Assigment

1. Design your own rest API specification for overview application.
2. Design and create a application which meets the non-functional requirements for most of the calls.
3. Based on the sample jsons,create a stub application for external calls (Customers,accounts and Insurances applications).
3. Also think about the negative flows and fail fast in case external system take more time.

## Instructions

* Assignment should be submitted as a maven project.
* Junit should be well written.
* Integration test should be implemented.
* Share the project with us as a git bundle.

### How to create a git bundle
* Run `git bundle create <assignment-name>.bundle <branch>` to create a git bundle.
* Run `git clone <assignment-name>.bundle` to un-bundle the repo.
* Please find more info about git bundle here - https://git-scm.com/docs/git-bundle

