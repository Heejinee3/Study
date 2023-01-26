# application.properties

### JPA

```
spring.jpa.hibernate.ddl-auto=none
spring.jpa.generate-ddl=false
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MariaDB103Dialect
```

### Log

```
logging.level.org.hibernate=info
```

### MariaDB

```
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=1234
```

# build.gradle

```
dependencies {
    runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
}
```
