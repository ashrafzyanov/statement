package org.ashr.ok.statement.ok.i.app.dao

import org.ashr.ok.statement.ok.i.app.data.public.StatementDetailDto
import org.ashr.ok.statement.ok.i.app.data.public.StatementDto

interface StatementDAO {

    fun getAllStatement(): List<StatementDto>

    fun getStatement(): StatementDetailDto?
}