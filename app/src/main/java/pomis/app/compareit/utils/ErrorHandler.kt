package pomis.app.compareit.utils

import android.app.inject
import android.content.Context
import android.util.Log
import android.widget.Toast
import es.dmoral.toasty.Toasty
import pomis.app.compareit.model.Basket
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.util.*


class ErrorHandler {

    companion object {
        fun handle(throwable: Throwable, context: Context) {
            Log.d("kek handler", Arrays.toString(throwable.stackTrace))
            Log.d("kek handler", throwable.toString())

            if (throwable is HttpException) {
                when (throwable.code()) {
                    502 -> Toasty.error(context, "Server not available").show()
                    404 -> Toasty.error(context, "Wrong data!").show()
                    500 -> Toasty.error(context, "Server internal error.").show()
                    else -> Toasty.error(context, "Connection error.").show()
                }
            } else if (throwable is ConnectException) {
                Toasty.error(context, "No connection!", Toast.LENGTH_LONG).show()
            } else if (throwable is IllegalArgumentException) {
                Toasty.error(context, "Wrong data!", Toast.LENGTH_LONG).show()
            } else if (throwable is SocketTimeoutException) {
                Toasty.normal(context, "Timeout.", Toast.LENGTH_LONG).show()
            }
        }
    }

}