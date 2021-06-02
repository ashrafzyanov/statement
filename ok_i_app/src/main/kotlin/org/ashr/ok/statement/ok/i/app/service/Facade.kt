package org.ashr.ok.statement.ok.i.app.service

import org.ashr.ok.statement.ok.i.app.data.public.StatementDetailDto
import org.ashr.ok.statement.ok.i.app.data.public.StatementDto
import java.io.InputStream
import java.util.*

interface Facade {

    fun findAllStatement(): List<StatementDto>?;

    fun get(id: UUID): StatementDetailDto?;

    fun generate(id: UUID, data: Map<String, Any?>): InputStream?;

}