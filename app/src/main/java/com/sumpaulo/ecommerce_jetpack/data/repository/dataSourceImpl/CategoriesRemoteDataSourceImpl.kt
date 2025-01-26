package com.sumpaulo.ecommerce_jetpack.data.repository.dataSourceImpl

import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.CategoriesRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.data.repository.dataSource.UserRemoteDataSource
import com.sumpaulo.ecommerce_jetpack.data.service.CategoriesService
import com.sumpaulo.ecommerce_jetpack.data.service.UserService
import com.sumpaulo.ecommerce_jetpack.domain.model.Category
import com.sumpaulo.ecommerce_jetpack.domain.model.User
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File



class CategoriesRemoteDataSourceImpl(private val categoriesService: CategoriesService): CategoriesRemoteDataSource {
    override suspend fun create(category: Category, file: File): Response<Category> {
        val connection = file.toURI().toURL().openConnection()
        val mineType = connection.contentType
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mineType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = category.name.toRequestBody(contentType.toMediaTypeOrNull())
        val description = category.description.toRequestBody(contentType.toMediaTypeOrNull())

        return categoriesService.create(fileFormData, nameData, description)
    }

    override suspend fun getCategories(): Response<List<Category>> {
        TODO("Not yet implemented")
    }

    override suspend fun update(
        id: String,
        category: Category
    ): Response<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Response<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }


}