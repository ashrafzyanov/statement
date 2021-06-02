package org.ashr.ok.statement.ok.i.app.service.impl

import org.ashr.ok.statement.ok.i.app.dao.StatementDAO
import org.ashr.ok.statement.ok.i.app.data.public.StatementDetailDto
import org.ashr.ok.statement.ok.i.app.data.public.StatementDto
import org.ashr.ok.statement.ok.i.app.service.StatementService
import org.ashr.ok.statement.ok.i.app.store.DocumentStore
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class StatementServiceImpl: StatementService {

    open var statementDao: StatementDAO? = null
        @Inject set

    open var documentStore: DocumentStore? = null
        @Inject set

    override fun findAllStatement(): List<StatementDto> {
        return listOf()
    }

    override fun get(id: UUID): StatementDetailDto? {
        return null
    }

}