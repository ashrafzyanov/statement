package org.ashr.ok.statement.ok.i.app.service

import org.ashr.ok.statement.ok.i.app.data.public.StatementDetailDto
import org.ashr.ok.statement.ok.i.app.data.public.StatementDto
import java.util.*

interface StatementService : BaseService {

    fun findAllStatement(): List<StatementDto>?

    fun get(id: UUID): StatementDetailDto?

}