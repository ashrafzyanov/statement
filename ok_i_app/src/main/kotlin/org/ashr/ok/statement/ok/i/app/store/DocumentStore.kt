package org.ashr.ok.statement.ok.i.app.store

import java.io.InputStream

interface DocumentStore {

    fun getDoc(id: String): InputStream;

}