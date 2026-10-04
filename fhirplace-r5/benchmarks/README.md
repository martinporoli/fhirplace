# fhirplace-r5-benchmarks

JMH benchmarks; never packaged or published. The module is not part of the normal build: the `benchmarks` profile adds
it, and running its `verify` phase builds the modules it measures from the current sources and runs JMH from
`target/classes`. No jar is built and nothing is installed.

```
./mvnw -Pbenchmarks -pl fhirplace-r5/benchmarks -am verify -DskipTests
```

Pass JMH options with `-Djmh.args`, such as a benchmark regex or a shorter run while iterating:

```
./mvnw -Pbenchmarks -pl fhirplace-r5/benchmarks -am verify -DskipTests -Djmh.args="CoreSerialization.readJson -f 1"
```

JMH 1.37 uses `sun.misc.Unsafe`, which JDK 24 and later warn about; on JDK 23 and later the build runs JMH with
`--sun-misc-unsafe-memory-access=allow`, which the forked JVMs inherit. To add JVM options to the forks, use JMH's
`-jvmArgsAppend`; `-jvmArgs` replaces the inherited options.

Results are printed and saved to `target/jmh-result.json`. Compare runs on the same machine and JDK, and change one
thing at a time.

| Benchmark | Measures |
|---|---|
| `CoreSerializationBenchmark` | `FhirJson` and `FhirXml` reading and writing a small Observation, with `value[x]` as a primitive (`String`) or a complex datatype (`Quantity`) |

Benchmarks go through the public API, like the tests. **Dependencies:** the modules measured, Parsson, and JMH.
