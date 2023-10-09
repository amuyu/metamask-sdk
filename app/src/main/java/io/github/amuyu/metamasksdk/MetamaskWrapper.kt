package io.github.amuyu.metamasksdk

import android.content.Context
import io.metamask.androidsdk.ApplicationRepository
import io.metamask.androidsdk.EthereumViewModel

class MetamaskWrapper(context: Context) {
    val ethereumViewModel: EthereumViewModel

    init {
        val repository = ApplicationRepository(context)
        ethereumViewModel = EthereumViewModel(repository)
    }
}