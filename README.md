# COVID19_GS_SpringBoot
- Check "mysql --version" in cmd.<br/>
If not installed, follow this link [here](https://www.javatpoint.com/how-to-install-mysql)
- Clone git repository
```
git clone https://github.com/thuva9872/COVID19_GS_SpringBoot.git
```
- Set up Mysql DB credentials in "src/main/resources/application.properties". Update the following properties.
```
spring.datasource.username= YOUR_MYSQL_USERNAME (eg:root)
spring.datasource.password= YOUR_MYSQL_PASSWORD (eg: 123)
```
```bash
mvnw spring-boot:run
```
