package io.github.amuyu.sample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.amuyu.metamasksdk.MetamaskDisconnectEvent
import io.github.amuyu.sample.ui.theme.MetamasksdkTheme
import io.metamask.androidsdk.ApplicationRepository
import io.metamask.androidsdk.Dapp
import io.metamask.androidsdk.EthereumViewModel
import io.metamask.androidsdk.RequestError

const val TAG = "MAIN"
class MainActivity : ComponentActivity(), MetamaskDisconnectEvent {

    private val ethereumViewModel: EthereumViewModel by lazy {
        val repository = ApplicationRepository(applicationContext)
        EthereumViewModel(repository, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MetamasksdkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Column {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
            Button(
                onClick = {
                    Log.d(TAG,"click!")
                    val dapp = Dapp("iskra wallet", "https://iskra.world")
                    ethereumViewModel.connect(dapp) { result ->
                        if (result is RequestError) {
                            Log.d(TAG, "connect error:" + result.message)
                        } else {
                            Log.d(TAG, "connect success:" + result)
                        }
                    }

                }
            ) {
                Text("Click")
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MetamasksdkTheme {
            Greeting("Android")
        }
    }

    override fun onDisconnect() {
        Log.d(TAG,"onDisconnect!")
    }
}

