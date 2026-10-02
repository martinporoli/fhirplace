# fhirplace-r5-bom

A bill of materials with the versions of all fhirplace R5 artifacts. Import it and declare dependencies without
versions:

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>se.poroli.fhirplace</groupId>
            <artifactId>fhirplace-r5-bom</artifactId>
            <version>${fhirplace.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
