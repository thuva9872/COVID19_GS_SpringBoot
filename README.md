# COVID19_GS_SpringBoot
- Chek "git --version" command. If not installed install git. Follow this link [here](https://phoenixnap.com/kb/how-to-install-git-windows)

- Check "mysql --version" in cmd.<br/>
If not installed, follow this link [here](https://www.javatpoint.com/how-to-install-mysql).<br/>
Note down the username & password.
- Clone git repository
```
git clone https://github.com/thuva9872/COVID19_GS_SpringBoot.git
```
- Set up Mysql DB credentials in "src/main/resources/application.properties". Update the following properties. (username and password that are used during the mysql installation).
```
spring.datasource.username= YOUR_MYSQL_USERNAME (eg:root)
spring.datasource.password= YOUR_MYSQL_PASSWORD (eg: 123)
```
```bash
mvnw spring-boot:run
```
