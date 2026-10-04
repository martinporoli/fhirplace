package se.poroli.fhirplace.r5.benchmarks;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.observation.Observation;
import se.poroli.fhirplace.r5.valuesets.ObservationStatus;
import se.poroli.fhirplace.r5.xml.FhirXml;

/**
 * Reads and writes a small Observation as FHIR JSON and XML through core's public API. The {@code value} parameter
 * picks the type of {@code Observation.value[x]}: a primitive ({@code String}) or a complex datatype
 * ({@code Quantity}), since choice elements are resolved by their type suffix.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(2)
public class CoreSerializationBenchmark {

    @Param({"String", "Quantity"})
    public String value;

    private Observation observation;
    private String json;
    private String xml;

    @Setup
    public void setUp() {
        DataType observed = switch (value) {
            case "String" -> FhirString.of("72 kg");
            case "Quantity" -> Quantity.builder().value(new BigDecimal("72")).unit("kg")
                    .system("http://unitsofmeasure.org").code("kg").build();
            default -> throw new IllegalArgumentException("Unknown value type: " + value);
        };
        observation = Observation.builder()
                .id("weight")
                .status(ObservationStatus.FINAL)
                .code(CodeableConcept.builder()
                        .addCoding(Coding.builder().system("http://loinc.org").code("29463-7")
                                .display("Body weight").build())
                        .build())
                .subject(Reference.builder().reference("Patient/123").build())
                .effective(FhirDateTime.of(OffsetDateTime.of(2026, 10, 4, 9, 30, 0, 0, ZoneOffset.UTC)))
                .value(observed)
                .build();
        json = FhirJson.write(observation);
        xml = FhirXml.write(observation);
    }

    @Benchmark
    public Observation readJson() {
        return FhirJson.read(json, Observation.class);
    }

    @Benchmark
    public String writeJson() {
        return FhirJson.write(observation);
    }

    @Benchmark
    public Observation readXml() {
        return FhirXml.read(xml, Observation.class);
    }

    @Benchmark
    public String writeXml() {
        return FhirXml.write(observation);
    }
}
