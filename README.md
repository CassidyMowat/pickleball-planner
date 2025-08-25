# Pickleball Planner

Your task is to build a minimal backend service for a Pickleball Planner app.
The goal is to let people schedule games and invite others to join.

## Tech Stack
- Postgres database
- Maven (Java build/dependency management)
- Dropwizard Backend (Java)
- Hibernate (ORM)

## TODO: ✅❌
- Database
    - Setup ❌
    - games table ❌
    - players table ❌

- API Endpoints
    - POST /games ❌
    - GET /games/:id ❌
    - GET /games ❌
    - POST /games/:id/players ❌
    - PATCH /games/:id/players/:playerId ❌

- Validation & Errors ❌

- DevOps / Setup ❌

- Bonus Features
    - Additional API endpoints ❌
    - Enhanced data management ❌
    - Security features ❌
    - Monitoring and testing ❌
    - Performance optimizations ❌

## Schema planning

- players
    - id
    - name
    - email

- games
    - id
    - title
    - date
    - location
    - description

The breif seems to imply using the players table to link back to games. Trying to create a linking table to reduce data duplication and store invite status

- players_games
    - id
    - player_id
    - game_id
    - player_status

# Design Notes