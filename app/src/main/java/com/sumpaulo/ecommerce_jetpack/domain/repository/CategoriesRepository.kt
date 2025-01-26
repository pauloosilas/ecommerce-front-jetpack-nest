package com.sumpaulo.ecommerce_jetpack.domain.repository

import com.sumpaulo.ecommerce_jetpack.domain.model.Category
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface CategoriesRepository {
    suspend fun create(category: Category, file: File): Resource<Category>
    fun getCategories(): Flow<Resource<List<Category>>>
    suspend fun update(id: String, category: Category): Resource<Category>
    suspend fun updateWidthImage(id: String, category: Category, file: File): Resource<Category>
    suspend fun delete(id:String): Resource<Unit>
}

