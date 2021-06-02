package org.ashr.ok.statement.ok.i.app.infra

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.MongoCredential
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces
import javax.inject.Inject

@ApplicationScoped
class MongoDBProducer {

    @Inject @ConfigProperty(name = "statement_mongodb_host")
    var mongoHost: String? = null

    @Inject @ConfigProperty(name = "statement_mongodb_port")
    var mongoPort: Int? = null

    @Inject @ConfigProperty(name = "statement_mongodb_user")
    var mongoUser: String? = null

    @Inject @ConfigProperty(name = "statement_mongodb_password")
    var mongoPassword: String? = null

    @Inject @ConfigProperty(name = "statement_mongodb_database")
    var mongoDatabase: String? = null

    @Produces
    fun mongoClient(): MongoClient {
        val mongoCredential = MongoCredential.createCredential(mongoUser, mongoDatabase, mongoPassword?.toCharArray());
        val connectionString = ConnectionString("mongodb://${mongoHost}:${mongoPort}");
        val settings = MongoClientSettings.builder()
                .credential(mongoCredential)
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(settings);
    }

    @Produces
    fun mongoDB(mongoClient: MongoClient): MongoDatabase {
        return mongoClient.getDatabase(mongoDatabase);
    }

}