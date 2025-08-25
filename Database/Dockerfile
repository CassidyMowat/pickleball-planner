FROM postgres

ENV POSTGRES_USER pickleballPlanner
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB pickleballPlanner

WORKDIR /database

COPY *.sql /docker-entrypoint-initdb.d/