# Pickleball Planner

Your task is to build a minimal backend service for a Pickleball Planner app.
The goal is to let people schedule games and invite others to join.

## Tech Stack
- Postgres database
- Maven (Java build/dependency management)
- Dropwizard Backend (Java)
- Hibernate (ORM)

## TODO:
- Database
    - Setup ✅
    - games table ✅
    - players table ✅

- API Endpoints
    - POST /games ✅
    - GET /games/:id ✅
    - GET /games ✅
    - POST /games/:id/players ✅
    - PATCH /games/:id/players/:playerId ✅

- Validation & Errors ❌

- DevOps / Setup ✅❌

- Bonus Features
    - Additional API endpoints ❌
    - Enhanced data management ❌
    - Security features ❌
    - Monitoring and testing ❌
    - Performance optimizations ❌


# Design Notes

To start the API run `docker-compose up` in the /Database folder where docker-compose.yml can be found

Due to time constraints I didn't get as far as I would have liked, mainly missing any sort of custom validaton or error checking. The build and deployment process could also be improved massively.

### Expanding the system

The first thing I would change to take this project further would be expanding the data model. Currently the game_id being stored in the player table means the same player would have a database row for each game they were associated with. I would split this up and use a mapping table between the players and games to keep track of who was attending what to reduce data duplication. This table could also potentially hold the player status for each game.

To approach repeatable games I would expand that game creation endpoint to be able to accept values for frequecy and an end date, using these to setup multiple games at the creation of the first. Expecting that there would be some sort of edit api endpoint to help manage this in finer detail if needed.

To invite groups of players I would expand the `games/{gameId}/players` endpoint to be able to accept multiple players. This would be a lot easier if the data model change mentioned above was in place. This could also potentially be expanded to some sort of friends system where for example players could only group invite players they had interacted with previously.

To handle email reminders or invites at scale I would potentially want to setup another microservice for handling these sorts of jobs. Connecting to the same database it could have a scheduled job to check for upcoming games and send out the required reminders. Having this as its own service would also prevent any big job processing from affecting the main API.

### Needed Improvements

- Currently the .jar artifact its checked in to allow docker-compose to copy and run it in the container. This needs to be broken out into a proper build and deploy pipeline to tidy things up and maintain consistency when building.
- Some sort of API testing would help to rapidly expand the system while maintaining confidence you weren't breaking anything, even if it was just a basic postman script
- Implementing some sort of codeStyle/linting early on in the project would help to maintain a clean codebase