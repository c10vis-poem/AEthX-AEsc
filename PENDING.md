# PENDING.md — novus-aesc (Æsc)

Durable cross-session backlog. Not rewritten each session — items persist until resolved or explicitly dropped.

- **Blocked on DroidDesk install** (build order #1 in `docs/BUILD-ORDER.md`) — this repo is build order #2, do not re-sequence.
- **Watchdog daemon doesn't survive Android process management** (MIUI/One UI/Android 13+ kill it). Fix is a `ForegroundService`, not yet built.
- **5 salvage targets not yet pulled from `horizons-ui`** — NPU loader, ADB loopback, Chromium integration, terminal render, model router. All unchecked in `salvage/README.md`.
- **Prior art in `aesop-xi` never reviewed** — a bridge daemon (`deploy/phone/bridge/aesopd.py`), a supervised `llamad` daemon, `protocol/bridge-protocol.md`, and a `termux-helper` skill already exist there and may cover most of this repo's task.

## Carried over from unresolved.md (2026-10-08)


1. **Document 05 vs. actual repo layout.** `05_FEDERATED_FILE_TREE_TOPOLOGY_MASTER.md`'s
   generic sketch of this repo (`npu_watchdog/`, `scripts/`, `process-isolation/`,
   `lmk-mitigation/`, `wireless-adb/`, `src/main/java/com/horizons/ui/adb/`) doesn't match
   the existing, more specific operator-declared plan (`laptop-trick-tunnel/`,
   `npu-watchdog/`, `protocol/`, `salvage/` with 5 named extraction targets). Not reconciled.
   Needs the user's call on which is authoritative.

2. **Unreviewed prior art in `aesop-xi`.** Bridge daemon (`deploy/phone/bridge/aesopd.py`),
   `llamad` daemon with NPU/Hexagon offload (`deploy/phone/daemons/`),
   `protocol/bridge-protocol.md`, `termux-helper` skill — merged from a remote branch,
   never reviewed, may already cover most of this repo's build target. See
   `novae-xorpus/unresolved.md` item 10.

3. **WebSocket auth** — not decided whether the Horizons-Ui-facing WebSocket surface
   authenticates, or how. Tracked here per `protocol/README.md`.

4. **Backpressure policy** — not decided for when the UI is slower than the daemon.
   Tracked here per `protocol/README.md`.

5. **Second master Drive folder not accessible.** `___Lex-Novi-Æxentis-Copiæ` (source for
   this repo's Document-05-mapped content, per the 14-subfolder table) hasn't been shared
   with this session. Nothing pulled from it.

6. **Watchdog ForegroundService rewrite** — not started. Current Watchdog doesn't survive
   Android process management on MIUI/One UI/Android 13+.
