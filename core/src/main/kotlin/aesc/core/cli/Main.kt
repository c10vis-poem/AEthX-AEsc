package aesc.core.cli

import aesc.core.agent.AgentLoop
import aesc.core.agent.AgentTool
import aesc.core.agent.PlatformTools
import aesc.core.agent.ToolResult
import aesc.core.llm.CloudLlmRuntime
import aesc.core.state.SecretStore
import kotlinx.coroutines.runBlocking

/**
 * Linux entry point (Jetson and other hosts): `aesc "prompt"`.
 * Settings come from env: key `local.endpoint` -> `AESC_LOCAL_ENDPOINT`, `api.openrouter` -> `AESC_API_OPENROUTER`.
 */
fun main(args: Array<String>) {
    val prompt = args.joinToString(" ").ifBlank { generateSequence(::readLine).joinToString("\n") }
    val secrets = SecretStore { key -> System.getenv("AESC_" + key.uppercase().replace('.', '_')) }
    val llm = CloudLlmRuntime(secrets) { msg, e -> System.err.println("$msg: ${e?.message}") }
    val noDeviceTools = object : PlatformTools {
        override suspend fun execute(tool: AgentTool): ToolResult? = null
    }
    runBlocking {
        AgentLoop({ llm }, noDeviceTools, secrets) { System.err.println(it) }
            .run(prompt)
            .collect { print(it); System.out.flush() }
    }
    println()
}
