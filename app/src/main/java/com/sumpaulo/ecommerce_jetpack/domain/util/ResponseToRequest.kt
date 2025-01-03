package com.sumpaulo.ecommerce_jetpack.domain.util

import com.sumpaulo.ecommerce_jetpack.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {
    fun<T> send(result: Response<T>): Resource<T> {
        return try {
           if(result.isSuccessful){
                Resource.Success(result.body()!!)
            }else{
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconhecido")
            }
        }catch (e: HttpException){
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error na requisição...")
        }
        catch (e: IOException){
            e.printStackTrace()
            Resource.Failure(e.message ?: "Verifique sua conexão com a internet...")
        }
        catch (e: Exception){
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconhecido...")
        }
    }
  }
