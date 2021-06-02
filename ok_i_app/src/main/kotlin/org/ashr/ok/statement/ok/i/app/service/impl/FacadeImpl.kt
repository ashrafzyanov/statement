package org.ashr.ok.statement.ok.i.app.service.impl

import org.ashr.ok.statement.ok.i.app.data.public.StatementDetailDto
import org.ashr.ok.statement.ok.i.app.data.public.StatementDto
import org.ashr.ok.statement.ok.i.app.service.Facade
import org.ashr.ok.statement.ok.i.app.service.StatementGeneratorService
import org.ashr.ok.statement.ok.i.app.service.StatementService
import java.io.InputStream
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class FacadeImpl : Facade {

    open var statementService: StatementService? = null
        @Inject set


    open var generatorService: StatementGeneratorService? = null
        @Inject set

    override fun findAllStatement(): List<StatementDto>? {
        return statementService?.findAllStatement();
    }

    override fun get(id: UUID): StatementDetailDto? {
        return statementService?.get(id);
    }

    override fun generate(id: UUID, data: Map<String, Any?>): InputStream? {
        return generatorService?.generate(id, data);
    }

}