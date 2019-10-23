# spring-data-envers
Database Auditing using spring data envers

# Maven Dependency
```
<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-envers</artifactId>
		</dependency>
```
# *Enable Repository*

``` @EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class) ```

# *Enable H2-Console*
``` spring.h2.console.enabled=true ```
