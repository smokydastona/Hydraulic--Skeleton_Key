# FULL SYSTEM AUDIT — ABSOLUTE ZERO-TRUST / MISSION-READINESS KILL-SHOT

You are operating in **ABSOLUTE ZERO-TRUST, FULL-WORKSPACE, ADVERSARIAL AUDIT MODE**.

This is a **pre-release kill-shot audit**.

Your purpose is **not** to demonstrate that the repository is healthy.

Your purpose is to determine, with evidence, **exactly what is real, what is incomplete, what is unreachable, what is misleading, what is merely scaffolding, and what will fail under real use**.

Assume that:

* documented features may not actually work
* passing tests may provide false confidence
* code may compile while being functionally incorrect
* architecture diagrams may not match implementation
* reports may claim support that runtime code cannot provide
* interfaces may exist without implementations
* implementations may exist without registrations
* registered implementations may never be selected
* selected implementations may never execute
* execution may occur without authoritative state mutation
* mutation may occur without persistence
* persistence may occur without synchronization
* synchronization may occur without transport
* transport may occur without client observation
* client observation may occur without correct gameplay semantics
* generated artifacts may conceal source defects
* fallback behavior may mask failed primary implementations
* test fixtures may be substantially simpler than real production objects
* mocks may validate contracts that production violates
* caches may return correct-looking stale data
* analyzers may report capabilities that runtime never consumes
* runtime plans may exist but never reach dispatch
* adapters may be registered but unreachable
* behavior-pack files may exist but be impossible to execute remotely
* resource-pack success may be incorrectly classified as gameplay compatibility
* server startup may be incorrectly classified as end-to-end success
* packet creation may be incorrectly classified as client-observed synchronization
* previous audits may themselves contain false conclusions
* commit messages may describe intended work rather than completed work
* documentation may describe future architecture rather than current architecture

**Do not trust names, comments, documentation, tests, reports, commit messages, issue trackers, generated output, architecture plans, or previous audit conclusions without independently verifying them against the live workspace and executable behavior.**

The **workspace, source code, build system, generated artifacts, runtime behavior, tests, and directly observable results are the source of truth.**

---

# 0. PRIMARY MISSION

Before doing anything else, determine the project's **actual mission**.

Extract the intended product-level objective from:

* README files
* architecture plans
* configuration
* public APIs
* entry points
* tests
* generated reports
* implementation
* runtime behavior

Then write a concise:

```text
ACTUAL PRODUCT MISSION:
```

Do not confuse implementation goals with product goals.

For example:

```text
"Generate a Bedrock resource pack"
```

is an implementation capability.

It is not equivalent to:

```text
"Allow a Bedrock player to use a Java mod machine."
```

The audit MUST distinguish:

```text
ENGINEERING HEALTH
```

from:

```text
PRODUCT / MISSION CAPABILITY
```

A repository may be technically clean while still being substantially incomplete relative to its actual mission.

---

# 1. NON-NEGOTIABLE ZERO-TRUST RULES

You MUST:

1. Enumerate the entire workspace before substantive analysis.
2. Establish an explicit audit boundary.
3. Build a complete file inventory.
4. Track every file with an explicit analysis status.
5. Analyze 100% of files inside the defined scope.
6. Perform at least TWO independent analysis passes.
7. Use materially different perspectives for each pass.
8. Cross-reference both passes.
9. Attempt to DISPROVE Pass 1 conclusions during Pass 2.
10. Audit the previous audit, if one exists.
11. Provide evidence for every factual claim.
12. Distinguish observed fact from inference.
13. Investigate uncertainty instead of guessing.
14. Trace implementation paths rather than trusting declarations.
15. Trace important features from entry point to observable result.
16. Search specifically for incomplete implementations.
17. Search specifically for stale architecture.
18. Search specifically for unreachable implementations.
19. Search specifically for fallback masking.
20. Search specifically for disconnected runtime plans.
21. Validate that tests exercise production paths.
22. Validate real runtime wiring.
23. Compare documentation against current implementation.
24. Compare architecture plans against current implementation.
25. Measure actual capability, not merely infrastructure.
26. Create a concrete remediation plan for every confirmed issue.
27. Continue until the defined audit scope is exhausted.

You are NOT allowed to declare the audit complete if:

* any file remains unaccounted for
* any file is marked "not analyzed" without explicit justification
* any critical execution path remains untraced
* any major feature remains untraced
* any major conclusion lacks evidence
* Pass 2 has not challenged Pass 1
* coverage does not reconcile exactly
* a claimed capability has not been traced to production execution
* a major capability has only static/unit evidence but is described as end-to-end verified
* fallback behavior is being counted as full implementation
* visual support is being counted as behavioral support
* server-side execution is being counted as client interoperability
* packet generation is being counted as client observation
* a test fixture is being treated as proof of arbitrary real-world compatibility

Do not stop because the repository is large.

Do not stop because an issue is difficult.

Do not replace investigation with assumptions.

Do not optimize for a positive result.

Do not optimize for finding fewer issues.

---

# 2. EVIDENCE HIERARCHY

Every significant claim MUST be assigned an evidence level.

Use exactly:

```text
E0 — DOCUMENTATION ONLY
E1 — STATIC CODE EVIDENCE
E2 — UNIT TEST VERIFIED
E3 — INTEGRATION TEST VERIFIED
E4 — LIVE JAVA/SERVER RUNTIME VERIFIED
E5 — NETWORK/TRANSPORT VERIFIED
E6 — ACTUAL BEDROCK CLIENT OBSERVED
```

Never upgrade evidence without actual supporting evidence.

Examples:

```text
A class exists:
E1

A unit test executes it:
E2

A real server executes it:
E4

Geyser transport carries the resulting operation:
E5

A real Bedrock client observes and interacts with the result:
E6
```

A feature supported only at E1–E4 MUST NOT be reported as:

```text
END-TO-END VERIFIED
```

---

# 3. COMPLETION VOCABULARY

Use these classifications exactly:

```text
NOT PRESENT

DOCUMENTED ONLY

SCAFFOLDING ONLY

ANALYSIS ONLY

PLAN ONLY

GENERATED OUTPUT ONLY

PARTIALLY EXECUTABLE

EXECUTABLE

EXECUTABLE BUT UNVERIFIED

SERVER-VERIFIED

TRANSPORT-VERIFIED

CLIENT-OBSERVED

END-TO-END VERIFIED

COMPLETE
```

Never collapse these categories.

In particular:

```text
ANALYSIS ≠ EXECUTION

EXECUTION ≠ MUTATION

MUTATION ≠ SYNCHRONIZATION

SYNCHRONIZATION ≠ TRANSPORT

TRANSPORT ≠ CLIENT OBSERVATION

CLIENT OBSERVATION ≠ CORRECT GAMEPLAY SEMANTICS
```

---

# 4. PHASE 0 — AUDIT BOUNDARY

Before analysis begins, identify:

* workspace root
* source roots
* modules
* subprojects
* build systems
* test roots
* runtime entry points
* configuration roots
* documentation roots
* scripts
* generated sources
* generated outputs
* resources
* assets
* archives
* vendored dependencies
* ignored files
* local runtime directories
* caches
* temporary directories
* worktrees

Classify every path as:

```text
PRODUCTION_CODE
TEST_CODE
BUILD_SCRIPT
CONFIGURATION
RESOURCE
DOCUMENTATION
GENERATED_SOURCE
GENERATED_OUTPUT
DEPENDENCY
BINARY_ASSET
ARCHIVE
RUNTIME_DATA
CACHE
TEMPORARY
UNKNOWN
```

Do not silently exclude anything.

If something is excluded from deep semantic analysis, record:

```text
EXCLUDED FROM DEEP ANALYSIS

Path:
File count:

Reason:
Risk of exclusion:
Alternative validation:
Why exclusion cannot invalidate the audit:
```

Create the audit manifest BEFORE substantive analysis.

---

# 5. PHASE 1 — COMPLETE FILE INVENTORY

Recursively enumerate every file.

Produce:

## 5.1 Directory Tree

Maintain a complete internal directory tree.

The final report may summarize enormous generated/cache directories, but the internal manifest MUST account for every file.

## 5.2 File Classification

Classify all files.

## 5.3 Size Analysis

Identify:

* unusually large files
* giant source files
* monoliths
* accidentally committed generated files
* suspicious binaries
* oversized configuration
* duplicate artifacts

## 5.4 Duplication Analysis

Search for:

* duplicate source
* near-duplicate source
* copied classes
* divergent copies
* duplicate registries
* duplicate configuration
* duplicate resource definitions
* duplicate compatibility logic
* duplicate caches
* obsolete implementations

## 5.5 Suspicious Code Search

Search for:

```text
TODO
FIXME
XXX
HACK
TEMP
TEMPORARY
WORKAROUND
STUB
PLACEHOLDER
MOCK
FAKE
DUMMY
NOT IMPLEMENTED
UNSUPPORTED
return null
return false
return 0
UnsupportedOperationException
```

Also search for:

```text
empty methods
no-op methods
empty catch blocks
catch-and-ignore
swallowed exceptions
always-true branches
always-false branches
constant return values
dead feature flags
unused registrations
fallback-only factories
empty adapters
```

Do not automatically classify them as bugs.

Investigate every occurrence.

---

# 6. PHASE 2 — PASS 1: COMPLETE FILE-BY-FILE ANALYSIS

Analyze every file within scope.

For production/test source:

```text
FILE:
PATH:
CLASSIFICATION:
PRIMARY PURPOSE:
ARCHITECTURAL ROLE:

ENTRY POINTS:
PUBLIC API:
EXPORTS:

IMPORTS:
DEPENDENCIES:
DEPENDENTS:

REGISTRATION:
DISCOVERY:
REFLECTION:
SERVICE LOADING:

STATE OWNED:
MUTATION:
SIDE EFFECTS:

I/O:
NETWORK:
FILESYSTEM:
CACHE:
THREADING:
SCHEDULING:

ERROR HANDLING:
FALLBACK BEHAVIOR:
ASSUMPTIONS:

TEST COVERAGE:
RUNTIME COVERAGE:

PRODUCTION REACHABILITY:
ARCHITECTURAL STATUS:

PASS 1 STATUS:
EVIDENCE:
```

For non-code files:

```text
FILE:
PATH:
CLASSIFICATION:
PURPOSE:
PRODUCER:
CONSUMERS:
VALIDATION:
RUNTIME IMPACT:
STALE RISK:
REACHABILITY:
PASS 1 STATUS:
EVIDENCE:
```

Do not merely summarize file contents.

Trace references when required.

---

# 7. PHASE 3 — IMPLEMENTATION COMPLETENESS AUDIT

For EVERY major feature, construct:

```text
CLAIM
 ↓
ENTRY POINT
 ↓
REGISTRATION
 ↓
DISCOVERY
 ↓
ANALYSIS
 ↓
INTERMEDIATE REPRESENTATION
 ↓
COMPILATION
 ↓
CACHE
 ↓
RUNTIME SELECTION
 ↓
RUNTIME DISPATCH
 ↓
AUTHORITATIVE MUTATION
 ↓
PERSISTENCE
 ↓
SYNCHRONIZATION
 ↓
TRANSPORT
 ↓
CLIENT OBSERVATION
 ↓
CLIENT ACTION
 ↓
RETURN PATH
 ↓
AUTHORITATIVE JAVA MUTATION
```

Mark every stage:

```text
PRESENT
PARTIAL
MISSING
UNVERIFIED
NOT APPLICABLE
```

A feature MUST NOT be considered complete because:

* a class exists
* an interface exists
* an analyzer recognizes it
* metadata describes it
* a runtime plan contains it
* a factory can construct it
* a bridge exists
* a report mentions it
* JSON is generated
* a unit test passes
* a server starts

The full execution path matters.

---

# 8. PHASE 4 — UNIVERSAL CAPABILITY AUDIT

For every advertised capability, construct a capability matrix.

At minimum inspect:

```text
BLOCK_ENTITY_DATA
MACHINE_INVENTORY
ITEM_TRANSFER
FLUID_RUNTIME
FLUID_TRANSFER
ENERGY_TRANSFER
MENU_CONTAINER
AUTOMATION_ACCESS
MACHINE_PROCESSING
PRESENTATION
NETWORK_SYNC
ENTITY_REGISTRATION
ENTITY_BEHAVIOR
CUSTOM_RENDERING
RECIPE_DISCOVERY
STATE_SYNCHRONIZATION
PLAYER_INTERACTION
```

For each:

```text
CAPABILITY:

DISCOVERY:
SEMANTIC FACT EXTRACTION:
COMPATIBILITY IR:
COMPILED PLAN:
RUNTIME DISPATCH:
JAVA MUTATION:
PERSISTENCE:
SYNC ENCODING:
GEYSER TRANSPORT:
BEDROCK REPRESENTATION:
BEDROCK ACTION:
JAVA RETURN PATH:

EVIDENCE LEVEL:
COMPLETION CLASS:
```

Explicitly distinguish:

```text
VISUAL SUPPORT
INTERACTION SUPPORT
STATE SUPPORT
BEHAVIOR SUPPORT
AUTOMATION SUPPORT
NETWORK SUPPORT
FULL GAMEPLAY SUPPORT
```

Never count visual conversion as gameplay compatibility.

---

# 9. PHASE 5 — SEMANTIC BEHAVIOR AUDIT

Determine whether the system can discover **what a modded object actually does**, rather than merely what resources it has.

Investigate whether the system can extract facts such as:

```text
block entity
inventory
input slots
output slots
item acceptance
item extraction
fluid input
fluid output
energy input
energy output
processing
recipe source
processing time
redstone behavior
automation
sided access
state transitions
entity spawning
particles
sounds
network synchronization
menu topology
server-only logic
client-only logic
custom rendering
```

For each capability ask:

> How does Phlodgate discover this behavior for an arbitrary real mod?

If the answer is:

```text
hardcoded adapter
```

record that.

If the answer is:

```text
metadata manually supplied
```

record that.

If the answer is:

```text
generic semantic discovery
```

trace and prove it.

Identify the boundary between:

```text
RESOURCE KNOWLEDGE
```

and:

```text
BEHAVIOR KNOWLEDGE
```

This is a critical audit area.

---

# 10. PHASE 6 — CROSS-FILE / SYSTEM-WIDE VALIDATION

Construct dependency and interaction graphs.

Verify:

* imports
* registrations
* service loaders
* reflection
* annotations
* generated code
* runtime discovery
* configuration
* resource references
* identifiers
* metadata bindings
* test fixtures
* build dependencies
* event handlers
* packet handlers
* callbacks
* factories
* registries

Detect:

```text
ORPHANED CODE
UNREACHABLE CODE
DEAD IMPLEMENTATION
DUPLICATE REGISTRY
DUPLICATE SOURCE OF TRUTH
BROKEN CONTRACT
STALE INTERFACE
HIDDEN COUPLING
CIRCULAR DEPENDENCY
UNUSED CONFIGURATION
UNCONSUMED ANALYZER OUTPUT
UNCONSUMED RUNTIME PLAN
UNREACHABLE ADAPTER
```

For important paths trace:

```text
INPUT
 ↓
DISCOVERY
 ↓
ANALYSIS
 ↓
TRANSFORMATION
 ↓
COMPILATION
 ↓
CACHE
 ↓
RUNTIME DISPATCH
 ↓
STATE MUTATION
 ↓
SYNC
 ↓
TRANSPORT
 ↓
OBSERVABLE RESULT
```

Identify where:

* information is lost
* assumptions change
* data is reconstructed
* metadata is reparsed
* compatibility reasoning repeats
* expensive work repeats
* fallback behavior begins
* semantic information is discarded

---

# 11. PHASE 7 — FUNCTIONAL INTENT / FALSE-COMPLETION AUDIT

Find code that is:

```text
VALID CODE
+
VALID TYPES
+
PASSING TESTS
+
WRONG PRODUCT BEHAVIOR
```

Search specifically for:

* transformations at wrong stages
* correct data sent to wrong destinations
* correct cache entries with bad invalidation
* compatibility reports disconnected from runtime
* runtime bridges never selected
* generic systems bypassed by special cases
* fallback hiding primary failure
* visual support mislabeled as behavior
* state changes without synchronization
* synchronization without client observation
* recognized actions without authoritative mutation
* metadata accepted but never compiled
* compiled plans never consumed
* adapters registered but never selected
* tests exercising fixtures instead of production discovery
* test doubles that don't model production constraints
* successful startup masking broken gameplay

For every major feature ask:

```text
If this code were deleted, would the advertised feature actually stop working?
```

If NO:

```text
DEAD / REDUNDANT / STALE / BYPASSED / INCORRECTLY TESTED
```

investigate further.

---

# 12. PHASE 8 — RUNTIME REACHABILITY AUDIT

For every major class, factory, adapter, analyzer, bridge, registry, and runtime plan:

Determine:

```text
DEFINED?
REGISTERED?
DISCOVERED?
SELECTED?
INSTANTIATED?
EXECUTED?
RESULT USED?
```

A component that is:

```text
DEFINED = YES
REGISTERED = YES
SELECTED = NO
```

is NOT operational.

A component that is:

```text
EXECUTED = YES
RESULT USED = NO
```

is NOT functional.

A component that is:

```text
RESULT USED = YES
CLIENT OBSERVATION = NO
```

is NOT end-to-end verified.

---

# 13. PHASE 9 — FALLBACK / DEGRADATION AUDIT

Explicitly map every fallback.

For each:

```text
PRIMARY IMPLEMENTATION:
FALLBACK:
TRIGGER:
IS FAILURE EXPLICIT:
IS FAILURE LOGGED:
IS FAILURE REPORTED:
IS FALLBACK SEMANTICALLY EQUIVALENT:
DOES FALLBACK HIDE FAILURE:
DOES FALLBACK REDUCE CAPABILITY:
```

Search for cases where:

```text
unsupported behavior
        ↓
fallback
        ↓
success-looking result
```

A successful fallback MUST NOT be counted as full feature support unless it preserves the intended semantics.

Classify:

```text
SEMANTICALLY EQUIVALENT
APPROXIMATION
VISUAL-ONLY
DEGRADED
UNSUPPORTED
MISLEADING
```

---

# 14. PHASE 10 — RUNTIME FAILURE / ADVERSARIAL ANALYSIS

Analyze realistic failures grounded in actual code.

Inspect:

* null handling
* invalid identifiers
* missing resources
* malformed metadata
* incompatible versions
* cache corruption
* stale caches
* dependency changes
* duplicate registration
* startup ordering
* concurrent access
* shutdown races
* resource leaks
* unbounded memory
* repeated scans
* repeated parsing
* partial transactions
* exception swallowing
* fallback masking
* synchronization failures
* client disconnects
* server restart
* world reload
* mod reload
* pack regeneration

For each scenario:

```text
TRIGGER:
CODE PATH:
EXPECTED BEHAVIOR:
ACTUAL BEHAVIOR:
FAILURE VISIBILITY:
DATA LOSS RISK:
STATE CORRUPTION RISK:
CLIENT IMPACT:
RECOVERY:
TEST COVERAGE:
```

Do not invent failure scenarios disconnected from implementation.

---

# 15. PHASE 11 — TRANSACTION / STATE CONSISTENCY AUDIT

For systems involving:

* item transfer
* fluid transfer
* energy transfer
* machine processing
* inventory mutation
* automation
* menus
* block entities

verify transactional correctness.

Ask:

```text
What is authoritative?

Can insertion partially succeed?

Can extraction partially succeed?

Can source mutate without destination mutation?

Can destination mutate without source mutation?

Can processing consume input but fail to produce output?

Can synchronization fail after mutation?

Can the client display stale state?

Can the client perform an action against stale state?

Does rollback exist?

Does restart preserve state?

Does cache state match runtime state?
```

Look specifically for:

```text
TOCTOU
PARTIAL COMMIT
DUPLICATION
ITEM LOSS
FLUID LOSS
ENERGY LOSS
DESYNC
DUPLICATE ACTION
REPLAY
STALE STATE
```

---

# 16. PHASE 12 — PERFORMANCE / RESOURCE AUDIT

Identify:

* repeated filesystem traversal
* archive traversal
* full-tree hashing
* eager parsing
* duplicate parsing
* unbounded caches
* excessive object retention
* repeated serialization
* repeated deserialization
* repeated compatibility analysis
* hot-path reflection
* hot-path metadata parsing
* unnecessary extraction
* quadratic algorithms
* synchronization storms

For each:

```text
OPERATION:
CALL PATH:
FREQUENCY:
INPUT SCALE:
TIME COMPLEXITY:
MEMORY COMPLEXITY:
CACHE:
MEASUREMENT:
EVIDENCE:
```

Classify:

```text
MEASURED BOTTLENECK
HIGH-CONFIDENCE SCALING RISK
POSSIBLE OPTIMIZATION
NOT MEANINGFUL
```

Never claim a bottleneck solely from intuition.

---

# 17. PHASE 13 — CONFIGURATION / ENVIRONMENT AUDIT

Trace every configuration value:

```text
DEFINITION
 ↓
LOAD
 ↓
PARSE
 ↓
VALIDATION
 ↓
TRANSFORMATION
 ↓
CONSUMPTION
```

Find:

* unused settings
* undocumented settings
* invalid defaults
* conflicting configuration
* dead feature flags
* environment-sensitive behavior
* OS-specific behavior
* Java version mismatches
* toolchain mismatches
* runtime launch differences
* test-only configuration
* configuration that claims unsupported functionality

Verify:

```text
Java version
Gradle version
mod-loader version
Minecraft version
Geyser version
Bedrock assumptions
Node/npm version
TypeScript version
build environment
runtime environment
```

---

# 18. PHASE 14 — BEDROCK / GEYSER INTEROPERABILITY AUDIT

This phase is mandatory for any system claiming Bedrock compatibility.

Separate:

```text
JAVA SERVER SUPPORT
GEYSER SUPPORT
PACK DELIVERY
BEDROCK REGISTRATION
BEDROCK RENDERING
BEDROCK INTERACTION
JAVA MUTATION
STATE SYNCHRONIZATION
CLIENT OBSERVATION
```

Do NOT treat them as one capability.

Investigate:

### Resource delivery

```text
Java server
→ Geyser
→ Bedrock resource pack
→ Bedrock client
```

### Behavior delivery

Determine exactly what can and cannot be executed remotely.

Explicitly distinguish:

```text
resource pack
behavior pack
Script API
server-side JavaScript
client-side JavaScript
Geyser extension
Java server execution
Bedrock client execution
```

### Interaction

Trace:

```text
Bedrock input
→ Geyser translation
→ Java event
→ authoritative mutation
→ state update
→ synchronization
→ Bedrock observation
```

If physical Bedrock testing is unavailable, mark the final stage:

```text
UNVERIFIED — CLIENT OBSERVATION UNAVAILABLE
```

Do not substitute server tests.

---

# 19. PHASE 15 — TEST AUDIT

For every important test:

Identify:

```text
TEST:
PRODUCTION CODE EXERCISED:
MOCKS:
STUBS:
Fakes:
Fixtures:
REAL REGISTRIES:
REAL RESOURCES:
REAL RUNTIME:
REAL NETWORK:
CLIENT:
```

Determine whether the test can pass while the production feature is broken.

Search for:

* tests testing only getters
* tests testing only object construction
* tests testing only reports
* tests testing test fixtures
* mocks replacing critical production systems
* fake registries
* fake resource loaders
* fake network transport
* fake Bedrock state
* assertions that verify only "no exception"
* tests that don't assert authoritative mutation
* tests that don't assert synchronization
* tests that don't assert output state

Also require negative tests for:

* missing resources
* invalid metadata
* invalid identifiers
* unsupported capability
* stale cache
* cache invalidation
* partial failure
* duplicate registration
* failed synchronization
* incompatible versions

---

# 20. PHASE 16 — SECOND INDEPENDENT ADVERSARIAL PASS

Repeat the audit independently.

Do NOT simply reread Pass 1.

Pass 2 must actively attempt to disprove Pass 1.

Assume Pass 1 missed:

* false-positive tests
* unreachable code
* hidden fallback
* stale architecture
* duplicate systems
* broken registration
* broken synchronization
* cache invalidation defects
* documentation drift
* fake runtime paths
* test fixtures too simple to represent production
* capabilities that work only for specially constructed fixtures

For every major Pass 1 conclusion:

```text
PASS 1 CLAIM:

PASS 1 EVIDENCE:

PASS 2 ATTACK:

COUNTER-EVIDENCE:

RESULT:
CONFIRMED
REVISED
REJECTED
UNRESOLVED
```

Pass 2 MUST search specifically for contradictions between:

```text
documentation ↔ implementation
tests ↔ implementation
tests ↔ runtime
metadata ↔ compiled plan
compiled plan ↔ dispatch
dispatch ↔ mutation
mutation ↔ persistence
persistence ↔ synchronization
synchronization ↔ transport
transport ↔ client observation
```

---

# 21. PHASE 17 — AUDIT-THE-AUDITOR

If a previous audit/report exists, independently verify its conclusions.

For every major previous claim:

```text
PREVIOUS CLAIM:

SOURCE:

CURRENT CODE:

CURRENT TEST:

CURRENT RUNTIME EVIDENCE:

CONFIRMED:
REVISED:
REJECTED:
UNVERIFIABLE:
```

Specifically challenge:

* file counts
* coverage claims
* issue counts
* health scores
* "all tests pass"
* "fully implemented"
* "end-to-end"
* "runtime verified"
* "supported"
* "automatic"
* "universal"
* "production ready"

A previous audit is **evidence to investigate**, not authority.

---

# 22. PHASE 18 — DOCUMENTATION VS REALITY

For every major documented claim:

```text
DOCUMENTED CLAIM:
SOURCE:
IMPLEMENTATION:
RUNTIME EVIDENCE:
CLIENT EVIDENCE:
STATUS:
```

Use:

```text
VERIFIED
PARTIALLY VERIFIED
OUTDATED
MISLEADING
FALSE
UNVERIFIABLE
```

Treat these words as requiring especially strong evidence:

```text
supports
automatic
universal
complete
runtime
executable
compatible
optimized
validated
end-to-end
production-ready
```

Mandatory rules:

```text
Build success ≠ feature success

Test success ≠ runtime success

Server startup ≠ gameplay success

Resource conversion ≠ gameplay compatibility

Generated JSON ≠ working Bedrock behavior

Packet creation ≠ client observation

Scoreboard registration ≠ complete bridge behavior

Analyzer detection ≠ runtime support

Runtime plan ≠ runtime execution

Runtime execution ≠ correct mutation

Correct mutation ≠ synchronization

Synchronization ≠ client observation
```

---

# 23. PHASE 19 — STALE ARCHITECTURE AUDIT

Identify:

* old architecture still active
* old abstractions
* duplicate discovery
* duplicate parsing
* duplicate caches
* duplicate compatibility reasoning
* transitional code
* partially completed migrations
* dead registries
* old factories
* legacy metadata
* compatibility logic in hot paths
* mod-specific logic that should be generic
* generic logic bypassed by special cases

For each:

```text
CURRENT PATH:

INTENDED PATH:

WHY THEY DIVERGE:

ACTIVE REFERENCES:

MIGRATION REQUIRED:

FILES:

REGRESSION RISK:
```

---

# 24. PHASE 20 — COMPLETENESS / STALE-CODE SWEEP

Perform a final repository-wide search for:

```text
TODO
FIXME
XXX
HACK
TEMP
STUB
PLACEHOLDER
MOCK
FAKE
DUMMY
UNSUPPORTED
NOT IMPLEMENTED
return null
return false
return 0
UnsupportedOperationException
```

Also search for:

* empty implementations
* no-op implementations
* factories always choosing fallback
* registries with unused entries
* analyzers whose findings are never consumed
* runtime plans never dispatched
* adapters never selected
* configuration never read
* reports disconnected from runtime
* tests disconnected from production
* generated output disconnected from source

Every occurrence:

```text
INTENTIONAL
SAFE
SUSPICIOUS
CONFIRMED ISSUE
```

Nothing may be silently ignored.

---

# 25. PHASE 21 — ARCHITECTURAL COMPLETION ASSESSMENT

Evaluate each major architectural layer.

Use:

```text
LAYER:

INTENDED RESPONSIBILITY:

IMPLEMENTATION:

REACHABILITY:

CONTRACT:

FAILURE HANDLING:

TESTING:

RUNTIME EVIDENCE:

CLIENT EVIDENCE:

STATUS:
NOT STARTED
SCAFFOLDING
PARTIAL
FUNCTIONAL
SERVER-VERIFIED
TRANSPORT-VERIFIED
CLIENT-OBSERVED
COMPLETE

MISSING CAPABILITIES:

BLOCKERS:

FALSE-COMPLETION RISKS:
```

A subsystem is COMPLETE only if:

1. intended responsibility exists
2. production path is reachable
3. contracts are satisfied
4. failure behavior is defined
5. tests exercise meaningful behavior
6. no critical gap is hidden by fallback
7. runtime evidence supports the claim
8. required synchronization works
9. required client behavior is verified when applicable
10. documentation accurately describes its limitations

---

# 26. PHASE 22 — MISSION CAPABILITY SCORE

This is mandatory.

Do NOT use a single health percentage to represent the whole project.

Produce at least:

```text
ENGINEERING HEALTH SCORE:
ARCHITECTURAL COMPLETENESS:
IMPLEMENTATION COMPLETENESS:
RUNTIME COMPLETENESS:
END-TO-END VERIFICATION:
MISSION CAPABILITY:
RELEASE READINESS:
```

The **MISSION CAPABILITY SCORE** must be based on actual product functionality.

For a compatibility project, heavily weight:

```text
real behavior support
real interaction
authoritative mutation
synchronization
transport
client observation
automatic discovery
generic compatibility
failure correctness
```

Do NOT inflate the mission score because:

* many classes exist
* many tests pass
* many reports exist
* many adapters exist
* code coverage is high
* resource conversion works
* the server starts successfully

A system with excellent infrastructure but incomplete gameplay capability MUST receive a correspondingly lower mission score.

---

# 27. REQUIRED CAPABILITY MATRIX

Produce a final matrix similar to:

| Capability         | Discovery | IR | Compile | Dispatch | Mutation | Persistence | Sync | Transport | Client | Overall |   |
| ------------------ | --------- | -- | ------- | -------- | -------- | ----------- | ---- | --------- | ------ | ------- | - |
| Item inventory     |           |    |         |          |          |             |      |           |        |         |   |
| Item insertion     |           |    |         |          |          |             |      |           |        |         |   |
| Item extraction    |           |    |         |          |          |             |      |           |        |         |   |
| Fluid storage      |           |    |         |          |          |             |      |           |        |         |   |
| Fluid insertion    |           |    |         |          |          |             |      |           |        |         |   |
| Fluid extraction   |           |    |         |          |          |             |      |           |        |         |   |
| Energy             |           |    |         |          |          |             |      |           |        |         |   |
| Machine processing |           |    |         |          |          |             |      |           |        |         |   |
| Automation         |           |    |         |          |          |             |      |           |        |         |   |
| Block entities     |           |    |         |          |          |             |      |           |        |         |   |
| Menus              |           |    |         |          |          |             |      |           |        |         |   |
| Entity interaction |           |    |         |          |          |             |      |           |        |         |   |
| Entity behavior    |           |    |         |          |          |             |      |           |        |         |   |
| Networking         |           |    |         |          |          |             |      |           |        |         |   |
| Rendering          |           |    |         |          |          |             |      |           |        |         |   |
| Recipes            |           |    |         |          |          |             |      |           |        |         |   |

Every cell requires evidence.

---

# 28. "LOOKS COMPLETE BUT ISN'T"

Explicitly identify systems where:

* analysis exists but execution doesn't
* execution exists but selection doesn't
* selection exists but dispatch doesn't
* dispatch exists but mutation doesn't
* mutation exists but persistence doesn't
* persistence exists but synchronization doesn't
* synchronization exists but transport doesn't
* transport exists but client observation is missing
* metadata exists but behavior doesn't
* tests exist but production wiring isn't exercised
* fixtures exist but arbitrary real mod behavior isn't handled
* fallback produces success-looking output
* reports claim more than runtime proves

For each:

```text
SYSTEM:
WHAT LOOKS COMPLETE:
WHAT IS ACTUALLY COMPLETE:
WHAT IS MISSING:
EVIDENCE:
REQUIRED WORK:
```

---

# 29. REQUIRED ISSUE FORMAT

For every confirmed issue:

## ISSUE <ID> — <SHORT TITLE>

**Severity:** CRITICAL / HIGH / MEDIUM / LOW

**Type:** Syntax / Functional / Architectural / Runtime / Performance / Config / Docs / Test / Completeness / Security

**Confidence:** VERIFIED / HIGH / MEDIUM

**Pass Found:** PASS 1 / PASS 2 / BOTH

**Evidence Level:** E0–E6

**Files:**

```text
path
path
```

**Code Evidence:**

```text
File:
Symbol:
Line:
Exact relevant code:
```

**Execution Path:**

```text
entry
→ registration
→ discovery
→ analysis
→ compilation
→ dispatch
→ mutation
→ persistence
→ synchronization
→ transport
→ observable result
```

**What Is Actually Happening:**

Only state what evidence supports.

**Why This Is Wrong:**

Identify the violated contract or intended behavior.

**System-Wide Impact:**

Identify affected systems.

**Failure Scenario:**

Ground it in the real implementation.

**Why Existing Tests Do Not Prevent It:**

This field is mandatory for functional/runtime issues.

**Exact Fix:**

Include:

* affected abstractions
* files
* contract changes
* migration
* implementation steps
* regression tests
* runtime validation

**Verification Required:**

State exactly what must be proven before closure.

---

# 30. REQUIRED COVERAGE REPORT

Final report MUST contain:

```text
TOTAL FILES DETECTED:
TOTAL FILES IN SCOPE:
TOTAL FILES ANALYZED — PASS 1:
TOTAL FILES ANALYZED — PASS 2:

FILES EXCLUDED FROM DEEP SEMANTIC ANALYSIS:
COUNT:

EXCLUSION JUSTIFICATIONS:

FILES WITH PARTIAL ANALYSIS:
COUNT:

UNRESOLVED FILES:
COUNT:

MISSED FILES:
COUNT:

COVERAGE:
```

Required:

```text
MISSED FILES = 0
```

unless a concrete technical limitation prevents it.

Reconcile:

```text
DETECTED = ANALYZED + EXCLUDED
```

If this does not reconcile exactly, the audit is incomplete.

---

# 31. REQUIRED FINAL REPORT

## 1. Executive Summary

State:

```text
ACTUAL PRODUCT MISSION:

CURRENT REALITY:

BIGGEST STRENGTH:

BIGGEST WEAKNESS:

MOST DANGEROUS FALSE-COMPLETION RISK:

MOST IMPORTANT NEXT MILESTONE:
```

---

## 2. Separate Health Scores

Provide:

```text
ENGINEERING HEALTH:
ARCHITECTURAL COMPLETENESS:
IMPLEMENTATION COMPLETENESS:
RUNTIME COMPLETENESS:
END-TO-END VERIFICATION:
MISSION CAPABILITY:
RELEASE READINESS:
```

Explain scoring.

Do not fabricate mathematical precision.

---

## 3. Top 10 Risks

Rank using:

```text
Severity
×
Blast Radius
×
Likelihood
×
Detection Difficulty
×
Mission Impact
```

---

## 4. Most Fragile Subsystems

For each:

```text
Subsystem:
Why fragile:
Evidence:
Failure trigger:
Blast radius:
Recommended stabilization:
```

---

## 5. Looks Complete but Isn't

Provide the complete list.

---

## 6. Stale Architecture

Provide:

```text
OLD PATH:
CURRENT PATH:
CONFLICT:
MIGRATION:
```

---

## 7. Highest Technical Debt

For each:

```text
Debt:
Why it exists:
Files:
Cost of leaving:
Cost of fixing:
Recommended timing:
```

---

## 8. Capability Matrix

Include the complete capability matrix from Phase 27.

---

## 9. Documentation vs Reality

Provide the major claims and their actual status.

---

## 10. Test Confidence

Explain what passing tests genuinely prove and what they do NOT prove.

---

## 11. Runtime Confidence

Explain exactly what has been proven at:

```text
E1
E2
E3
E4
E5
E6
```

---

## 12. Audit Integrity

Report:

```text
Previous audit claims verified:
Previous audit claims revised:
Previous audit claims rejected:
Unverifiable previous claims:

Pass 1 findings:
Pass 2 findings:
Cross-pass confirmed:
Cross-pass rejected:
Cross-pass unresolved:
```

---

# 32. REQUIRED REMEDIATION PLAN

Every confirmed issue MUST map to one:

```text
FIX IMMEDIATELY
FIX BEFORE RELEASE
ARCHITECTURAL MIGRATION
PERFORMANCE HARDENING
DOCUMENTATION CORRECTION
ACCEPTED LIMITATION
```

Order work by **dependency and architectural leverage**, not simply severity.

Use:

```text
PHASE <N>

OBJECTIVE:

WHY THIS PHASE COMES NOW:

ISSUES RESOLVED:

CAPABILITIES ENABLED:

FILES / SUBSYSTEMS:

IMPLEMENTATION STEPS:

ARCHITECTURAL CONTRACT:

DATA FLOW:

RUNTIME PATH:

TESTS REQUIRED:

NEGATIVE TESTS:

RUNTIME VALIDATION:

CLIENT VALIDATION:

MIGRATION / COMPATIBILITY:

EXIT CRITERIA:

PROOF REQUIRED BEFORE CLOSURE:
```

Never use vague tasks such as:

```text
improve architecture
improve caching
improve performance
add better tests
support more mods
fix compatibility
```

Every task must identify the actual implementation change required.

---

# 33. REQUIRED PHASE-GATE RULES

A phase cannot be marked complete merely because code was written.

Each phase requires:

```text
SOURCE IMPLEMENTATION
+
REACHABLE PRODUCTION PATH
+
TEST COVERAGE
+
NEGATIVE TESTING
+
RUNTIME EVIDENCE
+
DOCUMENTATION ACCURACY
```

For client-facing functionality additionally require:

```text
TRANSPORT EVIDENCE
+
CLIENT OBSERVATION
```

when such testing is technically possible.

---

# 34. PROHIBITED AUDIT BEHAVIOR

You MUST NOT:

* stop after compilation
* stop after tests pass
* trust reports
* trust previous audits
* trust README claims
* trust architecture diagrams
* count classes as capabilities
* count interfaces as capabilities
* count analyzers as capabilities
* count metadata as capabilities
* count runtime plans as capabilities
* count generated JSON as functionality
* count server startup as gameplay success
* count packet creation as synchronization success
* count transport as client observation
* count visual conversion as behavioral support
* count fallback as full implementation
* ignore unreachable code
* ignore generated code without classification
* skip large files
* skip test code
* skip scripts
* skip configuration
* skip resources
* skip archives without justification
* use generic refactoring recommendations
* hide uncertainty
* invent evidence
* infer client behavior from server behavior
* infer arbitrary mod support from one fixture
* infer universal behavior from one mod adapter
* declare completion while critical gaps remain

---

# 35. FINAL OPERATING PRINCIPLE

The purpose of this audit is to **actively attempt to prove that the system is broken**.

For every major capability ask:

```text
What evidence proves this works?

What evidence could prove it does not work?

Is the implementation actually reachable?

Is the production implementation being exercised?

Does the system discover the real behavior?

Does the compatibility compiler understand the behavior?

Does the runtime select the implementation?

Does dispatch actually execute?

Does execution cause authoritative mutation?

Does mutation persist?

Does synchronization occur?

Does transport occur?

Does the intended client observe the result?

Can the client perform the intended action?

Does that action produce authoritative Java mutation?

Could tests still pass if the real feature were broken?

Could fallback behavior make a broken feature look successful?

Does this work for arbitrary real inputs or only a specially constructed fixture?

Is the feature generic or dependent on a special-case adapter?

Is the documentation accurately describing the limitation?
```

Continue investigating until every question has:

```text
EVIDENCE
```

or:

```text
UNVERIFIED

Evidence currently insufficient.

Further investigation required:

<exact investigation>
```

---

# 36. AUDIT COMPLETION GATE

The audit is complete ONLY when all of the following are satisfied:

```text
100% FILE INVENTORY
+
100% REQUIRED FILE COVERAGE
+
2 INDEPENDENT ANALYSIS PASSES
+
CROSS-PASS RECONCILIATION
+
AUDIT-THE-AUDITOR
+
SYSTEM-WIDE DEPENDENCY VALIDATION
+
FUNCTIONAL INTENT VERIFICATION
+
IMPLEMENTATION COMPLETENESS
+
RUNTIME REACHABILITY
+
FALLBACK ANALYSIS
+
STATE / TRANSACTION ANALYSIS
+
PERFORMANCE ANALYSIS
+
CONFIGURATION ANALYSIS
+
BEDROCK / GEYSER ANALYSIS
+
TEST VALIDITY ANALYSIS
+
STALE-CODE SWEEP
+
STALE-ARCHITECTURE AUDIT
+
DOCUMENTATION-TO-REALITY AUDIT
+
CAPABILITY MATRIX
+
MISSION CAPABILITY SCORE
+
CONCRETE REMEDIATION PLAN
```

The final report MUST clearly distinguish:

```text
WHAT EXISTS
WHAT EXECUTES
WHAT WORKS
WHAT IS VERIFIED
WHAT IS CLIENT-OBSERVED
WHAT IS APPROXIMATED
WHAT IS FALLBACK
WHAT IS UNSUPPORTED
WHAT IS UNKNOWN
WHAT MUST BE BUILT NEXT
```

**Do not optimize for finding fewer issues.**

**Do not optimize for a high score.**

**Do not optimize for a positive conclusion.**

**Do not declare victory because the architecture looks good.**

**Do not declare victory because the tests pass.**

**Do not declare victory because the server starts.**

**Do not declare victory because Bedrock receives a pack.**

**Do not declare victory because a bridge exists.**

The audit succeeds only when it establishes, with evidence, the precise boundary between:

```text
IMPLEMENTED
```

```text
FUNCTIONAL
```

```text
RUNTIME-VERIFIED
```

```text
CLIENT-OBSERVED
```

and:

```text
NOT YET REAL
```

If the repository contains a weakness, contradiction, incomplete implementation, dead architecture, false completion claim, broken execution path, misleading fallback, stale subsystem, synchronization failure, unsupported behavior, or functionally incorrect implementation:

**FIND IT.**

**PROVE IT.**

**TRACE IT.**

**EXPLAIN ITS BLAST RADIUS.**

**IDENTIFY THE EXACT CODE PATH.**

**DEFINE THE REQUIRED FIX.**

**DEFINE THE TEST THAT PROVES THE FIX.**

**DEFINE THE RUNTIME EVIDENCE REQUIRED TO CLOSE IT.**

Then continue auditing until the entire defined scope has been exhausted.
