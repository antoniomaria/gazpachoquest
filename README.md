GazpachoQuest
==============

Set up

-Dspring.profiles.active=standalone,postgres -DGAZPACHO_APP={\"jdbc.url\":\"jdbc:postgresql://localhost:5432/gazpachoquest\",\"jdbc.username\":\"postgres\",\"jdbc.driver.class\":\"org.postgresql.Driver\",\"jdbc.password\":\"admin\"}

-Dspring.profiles.active=container,postgres -DGAZPACHO_APP={\"jndi.name\":\"jdbc/mysql\"}


MySQL Tomcat DBPool

<Resource name="jdbc/gazpachoquest" auth="Container" type="javax.sql.DataSource" driverClassName="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/gazpachoquest"
            username="root" password="admin" maxActive="20" maxIdle="10" maxWait="-1" />