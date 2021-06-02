package org.ashr.ok.statement.ok.i.app.dao.impl

import com.mongodb.client.MongoDatabase
import org.ashr.ok.statement.ok.i.app.dao.StatementDAO
import org.ashr.ok.statement.ok.i.app.data.public.StatementDetailDto
import org.ashr.ok.statement.ok.i.app.data.public.StatementDto
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class StatementDAOImpl: StatementDAO {

    open var mongoDb: MongoDatabase? = null
        @Inject set

    override fun getAllStatement(): List<StatementDto> {
        return mongoDb?.getCollection("statements")?.find()?.map { e -> StatementDto(UUID.fromString(e.getString("id")), e.getString("name"), e.getString("description")) }?.toList() ?: emptyList();
    }

    override fun getStatement(): StatementDetailDto? {
        TODO("Not yet implemented")
    }

}