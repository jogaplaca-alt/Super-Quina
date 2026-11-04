# Performance and capacity requirements

The platform runs frequent draws. Performance is a correctness and availability requirement, not a cosmetic enhancement.

## Rules for application code

- Keep recurring workers memory-bounded. Read and process one small database batch at a time; never load the full pending queue into an array.
- Use deterministic cursor pagination on indexed keys. A failed item remains eligible on the next scheduler execution, while the current execution continues to later items.
- Keep each transaction limited to one purchase and the minimum rows needed to allocate it. Do not keep a transaction open while calling Mercado Pago or another network service.
- Select only required columns. Avoid loading full histories, large JSON payloads, or related collections when the screen needs only a summary.
- All user-facing history and result lists must have a strict server-side limit and pagination. Never return an unbounded purchase, participation, audit, or result collection.
- Recurring scheduler queries must be selective and backed by indexes matching their filters and ordering. Keep retries idempotent and bounded per execution; do not run an unbounded retry loop inside a single HTTP request.
- Do not add polling, background timers, large client-side state stores, or expensive calculations without a demonstrated need.
- Prefer server components and static rendering for pages that do not need request-time data. Keep client components limited to genuinely interactive parts.
- Use responsive image delivery, modern formats, caching, and lazy loading for non-critical images. Only above-the-fold assets should be prioritized.
- Do not introduce dependencies solely for small utility tasks.

## Current optimizations recorded

- Allocation retries now read at most 50 purchase IDs per batch and process that batch before fetching the next one. The worker no longer accumulates every pending purchase ID in memory.
- Added PostgreSQL indexes for the CASH/WALLET allocation queue and the pending Mercado Pago reconciliation queue.
- The public landing page no longer forces request-time rendering.
- The header and landing infographic use Next.js image delivery with AVIF/WebP negotiation, responsive sizing, and long-lived optimization caching.

## Known asset work

The current source PNGs are large: header 1,507,890 bytes, icon 1,743,132 bytes, and landing infographic 2,067,204 bytes. The header and landing image are now delivered through the image optimizer, but the source files still need a proper lossless/visual review and optimized replacement. The icon is still referenced directly in metadata and should be replaced with a properly sized lightweight favicon/apple-touch asset after validating the brand appearance.

## Validation requirements

- Run typecheck, lint, unit tests, PostgreSQL integration tests, and production build after performance changes.
- Inspect generated image responses and browser network transfer sizes; do not claim an optimization is effective based only on source code.
- Exercise scheduler behavior with a large pending queue and verify bounded memory, continued pagination after a failed item, and retry on the next execution.
- Measure representative public, player, cashier, and admin routes on mobile and desktop. Track LCP, INP, CLS, server response time, database query count, and memory under load.
- Do not merge or deploy performance changes until CI passes and the target hosting environment has been measured.
