# Timex Backend

## Local development

Start PostgreSQL:

```bash
docker compose up -d postgres
```

Run the API:

```bash
mvn spring-boot:run
```

The API is available at `http://localhost:8080/api/public`.

Stop PostgreSQL while preserving its data:

```bash
docker compose down
```

## Database

Local development uses PostgreSQL with these default connection values:

```text
database: timex
username: timex
password: timex
port: 5432
```

Override them without editing source files:

```bash
DB_URL=jdbc:postgresql://localhost:5432/timex \
DB_USERNAME=timex \
DB_PASSWORD=timex \
mvn spring-boot:run
```

Flyway applies schema changes from `src/main/resources/db/migration`.
