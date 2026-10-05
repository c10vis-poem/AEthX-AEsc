# agent.md — novus-aesc (Æsc)

Procedural directives for an agent working in this repo. See `AGENTS.md`/`README.md` for
architecture, `STACK-MAP.md` for position in the federation.

## Before writing daemon code

1. Read `novae-xorpus/unresolved.md` item 10 and the `aesop-xi` bridge-daemon/`llamad`
   material it points to — it may already cover most of this repo's build target. Do not
   duplicate it.
2. Confirm build-order sequencing in `docs/BUILD-ORDER.md` — operator-declared, do not
   re-sequence. Item #1 (DroidDesk install) blocks this repo's item #2.

## Salvage discipline (`salvage/README.md`)

- Only the 5 named targets survive from `horizons-ui`: NPU loader, ADB loopback, Chromium
  integration, terminal render, model router. Everything else is junkyard — do not keep
  something just because it works.
- Record provenance (source repo, path, commit SHA, date) on every extraction.
- Don't fix while extracting — pull, note what's wrong, promote, then fix as a separate step.
- Nothing gets promoted un-read.

## Watchdog

Any Watchdog work must use `ForegroundService` with an ongoing notification — not `Service`,
not `WorkManager`. That's the only mechanism Android reliably declines to kill.

## IPC

Implement, don't redesign — protocol specs are authored in `aesop-xi`, this repo implements
them. See `protocol/README.md` for the transport table (AF_UNIX/SCM_RIGHTS, WebSocket,
ASharedMemory, ADB loopback).

## Known conflict — flag, don't silently resolve

Document 05's generic sketch of this repo's file layout doesn't match what's actually here.
If asked to "match Document 05," don't restructure this repo silently — surface the conflict
(see `unresolved.md` #1) and get a decision first.
