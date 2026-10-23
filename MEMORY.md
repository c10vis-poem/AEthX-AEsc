# MEMORY.md — novus-aesc
Durable facts about this repo. Dated; newest first. Updated at session wrap-up.

## 2026-10-05
- Created at wrap-up. AGENTS.md is the only instruction file (the old CLAUDE.md content moved there; Claude Code reads AGENTS.md natively).
- `.github/workflows/notify-vault.yml` pings `c10vis-poem/NovAExorpus` when AGENTS.md or RESUME.md change on main, so the vault rebuilds MASTER-AGENTS.md / MASTER-RESUME.md (secret `VAULT_DISPATCH_TOKEN`).
- Runtime memory stack is canonical in aesop-xi (`AGENTS.md` §Runtime memory stack); this repo references it.

## 2026-10-08
- `unresolved.md` retired into `PENDING.md` (section "Carried over from unresolved.md").

## 2026-10-23
- NPU test results for this repo live in `docs/npu-proof/` (operator: these tests are run for Æsc). First run: GenieX v0.9.3, Qwen3.5 2B and 4B Q4_0 fully on HTP0 (2B 25/25 layers, 4B 33/33); decode 21.2 and 7.6 tps on npu.
- The Hexagon backend sees HTP0 and HTP1; GenieX used HTP0 only.
- Stack dropped by the operator 2026-10-23: OmniRoute, mem0, Terrestrial Brain, OpenWiki, Qwen3-VL. AGENTS.md §Memory still points to OmniRoute (flagged, not edited).
