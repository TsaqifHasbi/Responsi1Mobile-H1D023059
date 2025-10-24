package com.example.responsi1mobileh1d023059.network

import com.example.responsi1mobileh1d023059.model.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballApiService {
    @GET("teams/{teamId}")
    suspend fun getTeam(
        @Path("teamId") teamId: Int,
        @Header("X-Auth-Token") authToken: String
    ): TeamResponse
}
