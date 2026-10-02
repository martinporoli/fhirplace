# fhirplace-r5-server-spring

Serves the fhirplace FHIR server in Spring Boot. Adding the dependency is all the setup needed:

- every bean annotated with `@FhirResource` is served under `fhirplace.server.path` (`/fhir` by default);
- invalid handlers fail application startup;
- the application's own controllers keep working alongside the FHIR routes.

```java
@Component
@FhirResource(Patient.class)
public class PatientHandler { ... }
```

```properties
fhirplace.server.path=/fhir
```

Define a `FhirServer` bean to build the server yourself; the auto-configuration then serves that one. The servlet
behind it, `FhirServlet`, works in any Jakarta Servlet 6 container. See [examples/spring-boot](../../examples/spring-boot).

**Dependencies:** `fhirplace-r5-server` and Parsson (Spring Boot ships no Jakarta JSON Processing implementation);
Spring Boot and the Servlet API are provided by the application. Tested with Spring Boot 4.1.
