# RESUME.md — novus-aesc (Æsc)

## Next session (from 2026-10-08, session 34c3e229)
- Branch `pending-fold`: `unresolved.md` folded into PENDING.md; ships at wrap-up.
- 7 old local branches whose PRs merged get deleted (workstream 4).
Full plan, run as parallel subagent workstreams: vault `NovAExorpus/RESUME.md` START HERE.

**Status:** Scaffold. Nothing runs yet. Build order item #2 (see `docs/BUILD-ORDER.md`), blocked on #1 (DroidDesk install) per operator sequencing — do not re-sequence.

## Current state

- Repo layout, docs (`CLAUDE.md`, `README.md`, `STACK-MAP.md`, `docs/BUILD-ORDER.md`, `protocol/README.md`, `salvage/README.md`) already written and operator-declared — not touched here.
- `salvage/` — 5 extraction targets defined (NPU loader, ADB loopback, Chromium integration, terminal render, model router), none pulled from `horizons-ui` yet (all unchecked in `salvage/README.md`).
- `manifest.jsonl` — empty (`entries: []`).
- Known blocker: the Watchdog daemon doesn't survive Android process management (MIUI/One UI/Android 13+ kill it). Fix is a `ForegroundService`, not yet built.

## Prior art not yet reviewed (per `docs/BUILD-ORDER.md`)

`NovAExorpus/unresolved.md` item 10: a bridge daemon (`deploy/phone/bridge/aesopd.py`), a supervised `llamad` daemon with real NPU/Hexagon offload (`deploy/phone/daemons/`), `protocol/bridge-protocol.md`, and a `termux-helper` skill already exist in `aesop-xi` — merged from `origin/claude/wiki-quinn-npu-local-m1crql`, never reviewed. May already cover most of this repo's task. Read before writing new daemon code.

## Document 05 vs. this repo's actual plan — flagged, not reconciled

`05_FEDERATED_FILE_TREE_TOPOLOGY_MASTER.md` sketches this repo's contents generically:
`src/main/java/com/horizons/ui/adb/`, `npu_watchdog/`, `scripts/`, `process-isolation/`,
`lmk-mitigation/`, `wireless-adb/`. This repo's actual operator-declared plan is more
specific and different in shape: `laptop-trick-tunnel/` (ADB loopback), `npu-watchdog/`
(underscore vs. hyphen naming also differs), `protocol/`, `salvage/` with 5 named targets.
Did not force this repo's layout to match Document 05's sketch — the existing plan is more
detailed and explicitly operator-declared ("Do not re-sequence"). Needs the user's call on
whether Document 05's sketch should be updated to match reality, or whether this repo should
be reshaped to match Document 05.

## Second master Drive folder — not found

Per Document 05, this repo's content source is `___Lex-Novi-Æxentis-Copiæ/--•💻_TERMUX_[>_]_main.` and `.../Reverse-Engineering` (both subfolders of a second master Drive folder). That folder has not been shared with this session as of this pass — checked `sharedWithMe = true and mimeType = 'application/vnd.google-apps.folder'`, only `__NovÆxorpus_LIVING_MASTER_CANON`, `22-Hooks`, `Termux ECC`, and `__NovÆxorpus(NÆX)` are shared. Nothing to pull from it yet.

## Next

1. Read the `aesop-xi` prior art above before writing any daemon code.
2. DroidDesk install (build order #1) is the actual blocker, not this repo.
3. `ForegroundService` rewrite for the Watchdog whenever salvage starts.
