# RESUME.md — novus-aesc (Æsc)

**Last updated: 2026-10-23** (phone, Claude Code, wrap-up of session 7cb1c8c0). Vault-wide plan: `NovAExorpus/RESUME.md` START HERE.

## Next session
1. **NPU proof:** results in `docs/npu-proof/2026-10-23.md`. Both Qwen3.5 2B and 4B (Q4_0, GenieX v0.9.3, `llama_cpp` + GGML Hexagon) ran fully on HTP0: 2B decode 21.2 tps on npu, 4B 7.6 tps. The 4B cpu run never finished. Continue vault `handoff/2026-10-23/npu-install-plan.md` §6 from step 8, one model at a time with the operator; the operator runs freshly downloaded binaries as `!` commands.
2. Rerun the cpu baseline on charge (the 2026-10-23 run was at 14% battery with capped clocks).

**Status:** Scaffold. No daemon code runs yet. Build order item #2 (see `docs/BUILD-ORDER.md`), blocked on #1 (DroidDesk install) per operator sequencing; do not re-sequence.

## Current state
- Repo layout and docs (`README.md`, `STACK-MAP.md`, `docs/BUILD-ORDER.md`, `protocol/README.md`, `salvage/README.md`) are operator-declared.
- `docs/npu-proof/`: the 2026-10-23 NPU proof results and full log.
- `salvage/`: 5 extraction targets defined (NPU loader, ADB loopback, Chromium integration, terminal render, model router), none pulled from `horizons-ui` yet.
- `manifest.jsonl`: empty.
- Known blocker: the Watchdog daemon doesn't survive Android process management (MIUI/One UI/Android 13+). Fix is a `ForegroundService`, not built.
- The 2026-10-08 `pending-fold` branch merged (PR #12); old local branches are gone (only `main` locally).

## Open items
In `PENDING.md`: DroidDesk blocker, Watchdog ForegroundService, salvage targets, unreviewed `aesop-xi` prior art, Document 05 vs layout, WebSocket auth, backpressure, second Drive folder, NPU follow-ups.

## Sources
Read for this update: this repo's AGENTS.md, RESUME.md, MEMORY.md, PENDING.md; the proof log `~/.claude/session-work/2026-10-23/npu-proof-1255.log` (phone only). Not read: `docs/BUILD-ORDER.md`, `salvage/README.md`, `protocol/README.md`, the rest of the repo; the install plan itself.
