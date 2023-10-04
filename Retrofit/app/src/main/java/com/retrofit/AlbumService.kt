package com.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    // write here end points
    @GET("/albums")
    suspend fun getAlbum() : Response<Album>

    @GET("/albums")
    suspend fun getSpecificAlbum(@Query ("userId") userId:Int) : Response<Album>
}