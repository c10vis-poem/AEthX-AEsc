package aesc.core.state

/** Key/value lookup for API keys and settings. Android backs it with app storage; Linux with a file or env. */
fun interface SecretStore {
    fun get(key: String): String?

    companion object {
        const val KEY_HF_TOKEN       = "hf.token"
        const val KEY_API_SAMBANOVA  = "api.sambanova"
        const val KEY_API_OPENROUTER = "api.openrouter"
    }
}
