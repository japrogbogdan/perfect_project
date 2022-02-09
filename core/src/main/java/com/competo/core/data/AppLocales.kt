package com.competo.core.data

import com.competo.core.domain.SerializedEnum
import com.competo.core.data.LocaleRepository.Companion.EN_LOCALE_CODE
import com.competo.core.data.LocaleRepository.Companion.RU_LOCALE_CODE

enum class AppLocales(override val serializeName: String) :
    SerializedEnum {

    NONE("none"),
    ENGLISH(EN_LOCALE_CODE),
    RUSSIAN(RU_LOCALE_CODE)
}