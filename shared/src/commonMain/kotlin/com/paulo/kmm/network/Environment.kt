package com.paulo.kmm.network

/**
 * Environment variable used while creating different http clients
 * @param host the host name of the desired environment
 * @param certificatePinningHashes hashes to be pinned if any (Only prepared for later)
 */
enum class Environment(
    val host: String,
    val certificatePinningHashes: List<String> = emptyList(),
    val hostTest: String = ""
) {

    // +--------------------------+
    // | AVAILABLE ENVIRONMENTS   |
    // +--------------------------+
    PROD(
        host = "https://api.yourcompany.com",
        certificatePinningHashes = listOf(
            "sha256/rE/SEU_HASH_DE_PINNING",
            "sha256/rE/SEU_HASH_DE_PINNING",
            "sha256/rE/SEU_HASH_DE_PINNING",
        )
    ),

    INT(
        host = "https://api.integration.yourcompany.com",
        certificatePinningHashes = listOf(
            "sha256/rE/SEU_HASH_DE_PINNING",
            "sha256/rE/SEU_HASH_DE_PINNING",
            "sha256/rE/SEU_HASH_DE_PINNING",
        ),
        hostTest = "https://api.publicapis.org"
    ),

    DEV(
        host = "https://api.development.yourcompany.com",
        certificatePinningHashes = listOf(
            "sha256/rE/SEU_HASH_DE_PINNING",
            "sha256/rE/SEU_HASH_DE_PINNING",
            "sha256/rE/SEU_HASH_DE_PINNING",
        ),
        hostTest = "https://api.publicapis.org" // DEFINICÃO DA API DE TESTE PÚBLICA
    );

    companion object{
        fun getEnvironmentByBuildFlavor(buildFlavor: String): Environment {
            return when(buildFlavor){
                "production" -> PROD
                "development" -> DEV
                "integration" -> INT
                else -> PROD
            }
        }
    }
}