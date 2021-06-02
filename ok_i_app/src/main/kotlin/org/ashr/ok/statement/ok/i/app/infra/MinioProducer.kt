package org.ashr.ok.statement.ok.i.app.infra

import io.minio.MinioClient
import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces
import javax.inject.Inject

@ApplicationScoped
class MinioProducer {

    @Inject @ConfigProperty(name = "statement_minio_host")
    var minioHost: String? = null

    @Inject @ConfigProperty(name = "statement_minio_port")
    var minioPort: Int? = null

    @Inject @ConfigProperty(name = "statement_minio_accessKey")
    var accessKey: String? = null

    @Inject @ConfigProperty(name = "statement_minio_secretKey")
    var secretKey: String? = null

    @Produces
    fun minioClient(): MinioClient {
        return MinioClient.builder().credentials(accessKey, secretKey)
                .endpoint(minioHost, minioPort!!, true)
                .build()
    }

}