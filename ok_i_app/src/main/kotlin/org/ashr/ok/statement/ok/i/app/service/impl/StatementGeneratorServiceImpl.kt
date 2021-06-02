package org.ashr.ok.statement.ok.i.app.service.impl

import org.ashr.ok.statement.ok.i.app.service.StatementGeneratorService
import java.io.InputStream
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class StatementGeneratorServiceImpl: StatementGeneratorService {

    override fun generate(id: UUID, data: Map<String, Any?>): InputStream? {
        return "Hello World!".byteInputStream();
    }

}