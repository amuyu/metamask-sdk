package io.github.amuyu.metamasksdk

import android.content.Context
import io.metamask.androidsdk.ApplicationRepository
import io.metamask.androidsdk.EthereumViewModel
import io.metamask.androidsdk.Logger

class MetamaskWrapper(context: Context): MetamaskDisconnectEvent {
    val ethereumViewModel: EthereumViewModel

    init {
        val repository = ApplicationRepository(context)
        ethereumViewModel = EthereumViewModel(repository, this)
    }

    override fun onDisconnect() {
        Logger.log("Metamask disconnected")
    }
}