# Contributing to fhirplace

Thanks for your interest in fhirplace! Bug reports, questions, and pull requests are all welcome.

fhirplace is young and has not reached 1.0. The API still changes, so for anything larger than a bug fix, please open an
issue to discuss it before writing code. That way neither of us wastes effort on a change that doesn't fit.

## Reporting bugs and asking questions

Open a [GitHub issue](https://github.com/martinporoli/fhirplace/issues). For a bug, include the fhirplace version, the
Java version, and the smallest code or FHIR resource that shows the problem. Do not report security vulnerabilities in
public issues; see [SECURITY.md](SECURITY.md).

## Building

```
./mvnw verify
```

This needs Java 21 or later. It compiles every module, runs all tests, and tests the examples. CI runs the same command
on every pull request.

## Pull requests

1. Fork the repository and create a branch from `main`.
2. Keep each pull request to one logical change, with tests and documentation.
3. Make sure `./mvnw verify` passes.
4. Open the pull request against `main` and describe what it changes and why.

Pull requests are squash-merged, so the title of the pull request becomes the commit message on `main`. Write it in the
imperative mood, for example "Add a request timeout to the client".

## Guidelines

fhirplace aims to be small, explicit, and faithful to FHIR. Changes are judged against these goals:

- **Small footprint.** Keep code, artifact size, and especially transitive dependencies small. A new dependency needs a
  strong reason. Do not use HAPI FHIR.
- **Small, intentional public API.** Prefer interfaces, sealed interfaces, and records over abstract classes, and
  composition over inheritance. Keep implementation details out of the public API.
- **Standard APIs.** Prefer Jakarta and MicroProfile APIs over proprietary alternatives.
- **Immutable and explicit.** Prefer immutable designs and plain code over frameworks, abstraction, and clever tricks.
- **FHIR semantics.** Improve the developer experience without changing what FHIR means.
- **Module boundaries.** Add a Maven module only when it gives users a meaningful capability or dependency boundary.

### Tests

- Test behavior, not implementation, through the public API where practical.
- Prefer real implementations and in-memory infrastructure over mocks.
- Add a regression test for every bug fix.

### Documentation

- Every public class and method needs a short Javadoc that describes behavior and important constraints.
- Every module has a `README.md`. Update it in the same pull request as the behavior it describes, and make sure its
  code examples compile.

## License

fhirplace is licensed under the [Apache License 2.0](LICENSE). By submitting a contribution, you agree that it is
licensed under the same license.
