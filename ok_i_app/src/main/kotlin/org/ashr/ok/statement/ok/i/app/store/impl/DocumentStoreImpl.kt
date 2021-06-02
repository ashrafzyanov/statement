package org.ashr.ok.statement.ok.i.app.store.impl

import io.minio.GetObjectArgs
import io.minio.MinioClient
import org.ashr.ok.statement.ok.i.app.store.DocumentStore
import java.io.InputStream
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class DocumentStoreImpl: DocumentStore {

    open var minioClient: MinioClient? = null
        @Inject set

    override fun getDoc(id: String): InputStream {
        return minioClient?.getObject(GetObjectArgs.builder().bucket("statement_backet").`object`(id).build())!!;
    }
}