package com.competo.core.domain

/**
 * Интерфейс для сериализации enum.
 * Позволяет проставлять для каждого элемента enum значение строковое и через него безопасно
 * сериализовать/десериализовать enum
 */
interface SerializedEnum {
    val serializeName: String
}