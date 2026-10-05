# Æsc — terminal daemon

Canon name: **Æsc**. Repo name: `novus-aesc`. See `NovAExorpus/NAMING-CANON.md`.

## What this is

The terminal daemon layer of the Æsop-Xi stack. Provides OS-level shell
access, accessibility services, and Termux-free command execution on Android.
Part of the 3-APK architecture alongside Horizons-Ui and Æyre.

## Stack position

```
Æsop-Xi → NovÆxenti → NovÆxopia → Æsc (this repo)
                                 → Æyre (voice/vision)
```

Æsc runs independently. Horizons-Ui does NOT require Æsc to function — any
document claiming otherwise is superseded by the naming canon.

## Conventions

- `laptop-trick-tunnel/` — ADB-to-WebSocket local Unix host bridge logic.
- `npu-watchdog/` — real-time Genie SDK thermal and OOM monitoring loop.
- Protocol specs in `protocol/` — daemon lifecycle, IPC contract, permissions.
- Reference docs in `docs/` — Android accessibility API notes, shell execution
  patterns.
- Salvaged material in `salvage/` — content from earlier "Æsh" / "daemon.aexenti"
  designs, preserved for reference.

## Operator Rule 1 — no action without an explicit prompt

A skipped or unanswered question is NOT consent. No action — reading,
searching, or anything else — without an explicit prompt or permitted
request. State-changing or not, it doesn't matter.

## Operator Rule 2 — read this file and RESUME.md first

Before doing anything else in this repo, read this AGENTS.md and RESUME.md.
Standing convention across the operator's repos for months — step one,
every session, no exceptions.

## Git workflow

PR required. No direct pushes to main. CI runs gitleaks + structure check.
Before every push, scan the diff for secrets/keys and refuse to push if any
are found. On green CI, auto-merge into `main` immediately — do not wait for
a manual merge step. Leave the branch in place after merge; do not delete it.

The point of this workflow is that everything reaches `main` — a branch
that never gets a PR opened, or a PR that never gets merged, is a failure
of this rule, not a valid alternative to it. Don't let work sit stranded.

## Memory — runtime infrastructure (references aesop-xi)

The whole stack's runtime memory infrastructure (mem0, terrestrial-brain,
OmniRoute, reasoning-bank, continual-harness) lives canonically in
**aesop-xi** — see `~/repos/aesop-xi/AGENTS.md` §Runtime memory stack.
Not duplicated here.

Every agent in this repo — regardless of harness (Claude Code, Codex, dsh,
Prime Agent, Hermes) — reaches memory via one MCP endpoint:
`http://localhost:20128/mcp` (OmniRoute). Never call mem0 or
terrestrial-brain directly; that bypasses OmniRoute's async memory tap
and the observation layer.

**Bootstrap this repo**: `bash tools/bootstrap.sh` — thin wrapper that
calls aesop-xi's canonical bootstrap first.
