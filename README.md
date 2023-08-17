# spring-boot-flyway

Simple demo to reproduce a baseline migration for Spring-Boot:3.x and Flyway:9.x.

## Setup
* [ ] Clone git repository
* [ ] Docker Engine is required
* [ ] Run `docker-compose up`
* [ ] Run test with maven `./mvnw test`
* [ ] Run test class `ch.subsidia.flywaydemo.FlywayDemoApplicationTests` within your development environment

## Tests
There are 3 states in 3 commits
- Initial State: flyway v1.0.0
- Migration State: flyway v1.0.1
- Baseline State: flyway 2.0.0

Switch back and forth between the individual commits with:
```bash
git log 
git checkout [commit-id]
```

Reset the state of the database with.
```bash
docker-compose down
docker-compose up -d
```

Run the tests with 
```bash
./mvnw clean test
```
