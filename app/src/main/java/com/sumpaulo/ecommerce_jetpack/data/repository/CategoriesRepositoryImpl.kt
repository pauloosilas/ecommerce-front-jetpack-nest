package com.sumpaulo.ecommerce_jetpack.data.repository

import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.CategoriesRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.domain.model.Category
import com.sumpaulo.ecommerce_jetpack.domain.repository.CategoriesRepository
import com.sumpaulo.ecommerce_jetpack.domain.util.Resource
import com.sumpaulo.ecommerce_jetpack.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import java.io.File

class CategoriesRepositoryImpl(
    private val categoriesRemoteDataSource: CategoriesRemoteDataSource)
    : CategoriesRepository {
    override suspend fun create(category: Category, file: File): Resource<Category> =
        ResponseToRequest.send(
            categoriesRemoteDataSource.create(category, file)
        )

    override fun getCategories(): Flow<Resource<List<Category>>> {
        TODO("Not yet implemented")
    }

    override suspend fun update(
        id: String,
        category: Category
    ): Resource<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun updateWidthImage(
        id: String,
        category: Category,
        file: File
    ): Resource<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Resource<Unit> {
        TODO("Not yet implemented")
    }
}