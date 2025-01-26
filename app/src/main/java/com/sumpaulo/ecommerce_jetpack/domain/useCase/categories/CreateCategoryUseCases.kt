package com.sumpaulo.ecommerce_jetpack.domain.useCase.categories

import com.sumpaulo.ecommerce_jetpack.domain.model.Category
import com.sumpaulo.ecommerce_jetpack.domain.repository.CategoriesRepository
import java.io.File

class CreateCategoryUseCases(private val repository: CategoriesRepository) {
    suspend operator fun invoke(category: Category, file: File) = repository.create(category, file)
}