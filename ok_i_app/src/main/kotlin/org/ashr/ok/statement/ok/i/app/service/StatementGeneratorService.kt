package org.ashr.ok.statement.ok.i.app.service

import java.io.InputStream
import java.util.*

interface StatementGeneratorService {

    fun generate(id: UUID, data: Map<String, Any?>): InputStream?;

}