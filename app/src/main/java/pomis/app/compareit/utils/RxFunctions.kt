package pomis.app.compareit.utils

import android.content.Context
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by roman on 3/29/18.
 */
fun <T> Observable<List<T>>.schedule(): Observable<T> {
    return this.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMapIterable { it }
}

fun <T> Observable<T>.scheduleFlat(): Observable<T> {
    return this.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.schedule(): Single<T> {
    return this.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.handle(context: Context, callback : ((T) -> Unit)): Disposable {
    return this.subscribe ({ callback.invoke(it) } , { ErrorHandler.handle(it, context) })
}

fun <T> Single<T>.handle(context: Context, callback : ((T) -> Unit)): Disposable {
    return this.subscribe ({ callback.invoke(it) } , { ErrorHandler.handle(it, context) })
}