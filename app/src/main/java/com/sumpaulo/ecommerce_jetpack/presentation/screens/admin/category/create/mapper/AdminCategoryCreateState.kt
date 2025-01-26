package com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.create.mapper

import com.sumpaulo.ecommerce_jetpack.domain.model.Category
import com.sumpaulo.ecommerce_jetpack.presentation.screens.admin.category.create.AdminCategoryCreateState

fun AdminCategoryCreateState.toCategory():Category {
    return Category(
        name = name,
        description = description
    )
}