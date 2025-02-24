# <p align="center"> :space_invader: Star Wars API :space_invader:</p>

#### <p align="center">  Project Tooling </p>
<div align="center"> 
    <a href="https://app.snyk.io/org/eddiescj/projects" target"_blank">:wolf: Snyk </a>
    <a href="https://sonarcloud.io/summary/new_code?id=EddieSCJ_starwars-api-java2" target"_blank">:detective: SonarCloud </a>
    <a href="https://app.codecov.io/gh/EddieSCJ/starwars-api-java/" target"_blank">:open_umbrella: CodeCov </a>
</div>

#### <p align="center"> Requirements </p>
<div align="center"> 
    <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html" target"_blank">:coffee: Java 17 </a>
    <a href="https://docs.docker.com/get-docker/" target="_blank"> :whale: Docker </a>
    <a href="https://docs.docker.com/get-docker/" target="_blank"> <img width="13" src="https://raw.githubusercontent.com/davzoku/emoji.ico/master/devicon/mongodb-original.ico"> MongoDB </a>
</div>

#### <p align="center">  Description </p>
This api is a simple wrapper for the [Star Wars API](https://swapi.dev/) where you can get information about the characters,
planets, starships, vehicles, species, films, and more with a few extra features where you can handle this data however you 
need.

The api also is documented with [OpenAPI Swagger](https://swagger.io/specification/), so if you have any doubt, just open in your browser the follow url: `http://domain-you-are-using/api/v0/swagger-ui/index.html`

Please, read the content below to know how to use this api and if is there any doubt, please, contact me.

#### <p align="center"> PR Advices </p>

You'll see that once you open a PR some checks will be made, they are all essential to be passed before you merge your branch, so, make sure they are all passing.

One exception is snyk, which sometimes have some problems that can't be solved now, in this case you can just bypass.

#### <p align="center">  Using Cloud Tools </p>

* Snyk
  * Just click in the link above and search for starwars-api-java, so you will be able to see the security problems.
* SonarCloud
  * Clicking the link above you will be redirected to the quality analysis of this project.
* CodeCov
  * You can click the link above and see the code coverage details by commit or any type of data or just see the summary
    in your PR.

#### <p align="center"> Pre Configurations </p>

Execute the following script in your mongo database

```mongodb-json-query
use starwars
db.createCollection("user")

db.getCollection('user').insert({
  "_id": ObjectId(
  "6281f179344601ef2e98dcd3"
  ),
  "username": "another_application_who_consumes_this_api",
  "password": "$2a$10$W1NqIc3gvpLNwQska2iAFOQ1FOpUDQ1a5FF.ffAF2eUNuaLrr3FKm",
  "authorities": [
    "PLANET_LIST",
    "PLANET_CREATE",
    "PLANET_UPDATE",
    "PLANET_DELETE"
  ]
})
```

#### <p align="center">  Making Requests </p>

Being authenticated:

```bash
curl -o token.json --location --request POST 'http://localhost:8080/api/v0/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username":"another_application_who_consumes_this_api",
    "password": "12"
}'
```

Using Authorization to get planets

```bash
curl -o result.json --location --request GET 'http://localhost:8080/api/v0/planets' \
--header 'Authorization: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbm90aGVyX2FwcGxpY2F0aW9uX3dob19jb25zdW1lc190aGlzX2FwaSJ9.jnSWQTkg6dQ18tAPl8RS2JrdEdmtxBvx40Tq7WqYFighnziLKzUi2BLJ4S__dOlQDuJl0Lw3NYFS5IbGgd-XnQ' \
--header 'Content-Type: application/json' | json_pp
```

#### <p align="center"> Running </p>

You'll see some run configurations below

Enviroment Variables to be set

| NAME                 | VALUE                                                                                                                 | OPTIONAL |
|----------------------|-----------------------------------------------------------------------------------------------------------------------|----------|
| AUTHORIZATION_SECRET | TazvE@QSs7AfWTMfEwXaR#TB7P6&p@JQ5RqCMqZ%cL5MU$2qPZyEDkTZH^#cuUW3nbRrTJy^+Hj5wWdNVg?-QypDRMyfE5pCwR#F%bh%73q#F^m*B?@PS | NO       |
| SQS_ACCESS_KEY       | your_sqs_access_key                                                                                                   | NO       |
| SQS_SECRET_KEY       | your_sqs_secret_key                                                                                                   | NO       |
| SQS_PLANET_DELETE_URL| your_sqs_url                                                                                                          | NO       |
| MONGO_HOST           | localhost                                                                                                             | YES      |
| MONGO_USER           |                                                                                                                       | YES      |
| MONGO_PASSWORD       |                                                                                                                       | YES      |
| MONGO_PORT           | 27017                                                                                                                 | YES      |
| MONGO_DB             | development                                                                                                           | YES      |
| MONGO_CONTAINER_NAME | mongoservice                                                                                                          | YES      |
| SWAPI_URL            | https://swapi.dev/api                                                                                                 | YES      |
| ENV                  | dev                                                                                                                   | YES      |
| API_PORT             | 8080                                                                                                                  | YES      |

![Screenshot from 2022-05-13 22-59-57](https://user-images.githubusercontent.com/47372251/168406781-09afe345-eb57-4f42-8516-8ce0d7a58439.png)

#### <p align="center">  Testing </p>

* Only Testing

Enviroment Variables to be set

| NAME                 | VALUE                                                                                                                 | OPTIONAL |
|----------------------|-----------------------------------------------------------------------------------------------------------------------|----------|
| AUTHORIZATION_SECRET | TazvE@QSs7AfWTMfEwXaR#TB7P6&p@JQ5RqCMqZ%cL5MU$2qPZyEDkTZH^#cuUW3nbRrTJy^+Hj5wWdNVg?-QypDRMyfE5pCwR#F%bh%73q#F^m*B?@PS | NO       |
| SQS_ACCESS_KEY       | your_sqs_access_key                                                                                                   | NO       |
| SQS_SECRET_KEY       | your_sqs_secret_key                                                                                                   | NO       |
| SQS_PLANET_DELETE_URL| your_sqs_url                                                                                                          | NO       |
| MONGO_HOST           | your_host                                                                                                             | NO       |
| MONGO_USER           | your_username                                                                                                         | NO       |
| MONGO_PASSWORD       | your_password                                                                                                         | NO       |
| MONGO_PORT           | your_port                                                                                                             | NO       |
| MONGO_DB             | your_database                                                                                                         | NO       |
| SWAPI_URL            | https://swapi.dev/api                                                                                                 | NO       |
| ENV                  | prod                                                                                                                  | NO       |
| API_PORT             | your_port                                                                                                             | NO       |

![Screenshot from 2022-05-13 23-12-27](https://user-images.githubusercontent.com/47372251/168407052-cfc39577-0234-4c80-9f16-0b3310437593.png)

* Sonar Coverage Analysis

Enviroment Variables to be set

```
AUTHORIZATION_SECRET=TazvE@QSs7AfWTMfEwXaR#TB7P6&p@JQ5RqCMqZ%cL5MU$2qPZyEDkTZH^#cuUW3nbRrTJy^+Hj5wWdNVg?-QypDRMyfE5pCwR#F%bh%73q#F^m*B?@PS
SQS_ACCESS_KEY=your_sqs_access_key;
SQS_SECRET_KEY=your_sqs_secret_key;
SQS_PLANET_DELETE_URL=your_sqs_queue_url
```

![Screenshot from 2022-05-13 23-13-28](https://user-images.githubusercontent.com/47372251/168407069-87d8b8d8-e751-4953-862a-12c09e24f73c.png)
