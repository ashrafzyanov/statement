package org.ashr.ok.statement.ok.i.web.api.impl

import org.ashr.ok.statement.ok.i.web.api.binding.DocumentData
import org.ashr.ok.statement.ok.i.app.service.Facade
import java.io.InputStream
import java.util.*
import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/statement")
@RequestScoped
open class StatementAPI {

    open var facade: Facade? = null
        @Inject set

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    open fun findAll(): Response {
        return Response.ok(facade?.findAllStatement()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    open fun get(@PathParam("id") id: UUID): Response {
        return Response.ok(facade?.get(id)).build();
    }

    @POST
    @Path("/generate/{id}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    open fun generate(@PathParam("id") id: UUID, data: List<DocumentData>): Response {
        var mapData = convertToMap(data);
        var data: InputStream? = facade?.generate(id, mapData) ?: return Response.noContent().build();
        return Response.ok(data).header("Content-Disposition", "attachment; filename=\"statement_$id\"").build();
    }

    private fun convertToMap(datas: List<DocumentData>): Map<String, Any?> {
        var result = mutableMapOf<String, Any?>()
        for(data in datas) {
            result[data.name] = data.value;
        }
        return result
    }

}