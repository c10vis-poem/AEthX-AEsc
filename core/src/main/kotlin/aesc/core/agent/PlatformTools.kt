package aesc.core.agent

import kotlinx.coroutines.flow.Flow

/** Device-specific tools (Android intents, Linux shell). Returns null for tools the platform lacks. */
interface PlatformTools {
    suspend fun execute(tool: AgentTool): ToolResult?

    /** Hook around each inference stream, e.g. Android Game Mode boost. */
    fun wrapInference(stream: Flow<String>): Flow<String> = stream
}
