package org.ashr.ok.statement.ok.i.app.data.public

import java.util.*
import kotlin.reflect.KClass

enum class Type(val javaType: KClass<out Any>) {
    NUMBER(Long::class),
    UNUMBER(Long::class),
    STRING(String::class),
    BOOLEAN(Boolean::class),
    DATE(java.util.Date::class),
    DATETIME(Date::class),
    TIME(Date::class)
}