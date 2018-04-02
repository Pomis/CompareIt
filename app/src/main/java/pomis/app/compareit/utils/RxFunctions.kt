package pomis.app.compareit.utils

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by roman on 3/29/18.
 */
fun <T> Observable<T>.schedule(): Observable<T> {
    return this
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
}
