package com.minstone.data.util

import android.util.Log
import com.minstone.domain.exception.BadRequestException
import com.minstone.domain.exception.ConflictException
import com.minstone.domain.exception.ForBiddenException
import com.minstone.domain.exception.NoInternetException
import com.minstone.domain.exception.NotFoundException
import com.minstone.domain.exception.OtherHttpException
import com.minstone.domain.exception.ServerException
import com.minstone.domain.exception.TimeOutException
import com.minstone.domain.exception.UnKnownException
import com.minstone.domain.exception.UnauthorizedException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class RiiidApiHandler<T> {
    private lateinit var httpRequest: suspend () -> T

    fun httpRequest(httpRequest: suspend () -> T) =
        this.apply { this.httpRequest = httpRequest }

    suspend fun sendRequest(): T {
        return try {
            Log.d("ApiHandler", "Success")
            withContext(Dispatchers.IO) {
                httpRequest.invoke()
            }
        } catch (e: HttpException) {
            val message = e.message
            Log.d("ApiHandler", message.toString())
            throw when (e.code()) {
                400 -> BadRequestException(
                    message = message
                )

                401 -> UnauthorizedException(
                    message = message,
                )

                403 -> ForBiddenException(
                    message = message,
                )

                404 -> NotFoundException(
                    message = message,
                )

                409 -> ConflictException(
                    message = message,
                )

                500, 501, 502, 503 -> ServerException(
                    message = message,
                )

                else -> OtherHttpException(
                    message = message,
                    code = e.code()
                )
            }
        } catch (e: SocketTimeoutException) {
            throw TimeOutException(message = e.message)
        } catch (e: UnknownHostException) {
            throw NoInternetException()
        } catch (e: Exception) {
            throw UnKnownException(message = e.message)
        }
    }
}