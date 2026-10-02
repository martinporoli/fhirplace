package se.poroli.fhirplace.r5.server.internal;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Comparator;
import se.poroli.fhirplace.r5.capabilitystatement.CapabilityStatement;
import se.poroli.fhirplace.r5.capabilitystatement.CapabilityStatement.Rest;
import se.poroli.fhirplace.r5.capabilitystatement.CapabilityStatement.Rest.RestResource;
import se.poroli.fhirplace.r5.capabilitystatement.ResourceVersionPolicy;
import se.poroli.fhirplace.r5.capabilitystatement.RestfulCapabilityMode;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.server.DateParam;
import se.poroli.fhirplace.r5.server.ReferenceParam;
import se.poroli.fhirplace.r5.server.StringParam;
import se.poroli.fhirplace.r5.valuesets.CapabilityStatementKind;
import se.poroli.fhirplace.r5.valuesets.FHIRVersion;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.ResourceType;
import se.poroli.fhirplace.r5.valuesets.SearchParamType;

/** Builds the server's CapabilityStatement from its handlers. */
final class Capabilities {

    private Capabilities() {
    }

    static CapabilityStatement of(Collection<Handler> handlers) {
        Rest.Builder rest = Rest.builder().mode(RestfulCapabilityMode.SERVER);
        handlers.stream().sorted(Comparator.comparing(Handler::typeName)).forEach(handler -> {
            RestResource.Builder resource = RestResource.builder()
                    .type(ResourceType.fromCode(handler.typeName()))
                    .versioning(handler.method(Interaction.VREAD).isPresent()
                            ? ResourceVersionPolicy.VERSIONED : ResourceVersionPolicy.NO_VERSION);
            for (Interaction interaction : Interaction.values()) {
                if (handler.method(interaction).isPresent()) {
                    resource.addInteraction(RestResource.ResourceInteraction.builder()
                            .code(interaction.code())
                            .build());
                }
            }
            handler.method(Interaction.SEARCH).ifPresent(search -> search.bindings().stream()
                    .filter(binding -> binding instanceof Binding.Search)
                    .map(binding -> (Binding.Search) binding)
                    .sorted(Comparator.comparing(Binding.Search::name))
                    .forEach(parameter -> resource.addSearchParam(RestResource.SearchParam.builder()
                            .name(FhirString.of(parameter.name()))
                            .type(searchType(parameter.type()))
                            .build())));
            rest.addResource(resource.build());
        });
        return CapabilityStatement.builder()
                .status(PublicationStatus.ACTIVE)
                .date(OffsetDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS))
                .kind(CapabilityStatementKind.INSTANCE)
                .fhirVersion(FHIRVersion.CODE_5_0_0)
                .addFormat("json")
                .addFormat("xml")
                .addRest(rest.build())
                .build();
    }

    private static SearchParamType searchType(Class<?> type) {
        if (type == StringParam.class) {
            return SearchParamType.STRING;
        }
        if (type == DateParam.class) {
            return SearchParamType.DATE;
        }
        if (type == ReferenceParam.class) {
            return SearchParamType.REFERENCE;
        }
        return SearchParamType.TOKEN;
    }
}
