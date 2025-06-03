package com.mobilemaker.movienow.views

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.mobilemaker.movienow.R

@Composable
fun YouTubeWebPlayer(
    videoUrl: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(modifier = modifier.background(Color.Black)) {
        AndroidView(
            factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )

                    webChromeClient = object : WebChromeClient() {
                        override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
                            super.onShowCustomView(view, callback)
                        }
                    }

                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true
                    settings.mediaPlaybackRequiresUserGesture = false
                    setLayerType(View.LAYER_TYPE_HARDWARE, null)

                    //uso de IA
                    loadData(
                        """
                        <html>
                          <body style="margin:0; background-color:grey;">
                            <iframe width="100%" height="100%" 
                              src="${videoUrl.replace("watch?v=", "embed/")}?autoplay=1&fs=1"
                              frameborder="0"
                              allowfullscreen
                              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                            ></iframe>
                          </body>
                        </html>
                        """.trimIndent(),
                        "text/html",
                        "utf-8"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
                .background(Color.Gray)
        )
        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                try {
                    val videoId = Uri.parse(videoUrl).getQueryParameter("v")
                        ?: Uri.parse(videoUrl).lastPathSegment ?: ""
                    val intent =
                        Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$videoId")).apply {
                            setPackage("com.google.android.youtube")
                        }
                    context.startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl)))
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp)
        ) {
            Icon(
                Icons.AutoMirrored.Filled.OpenInNew,
                contentDescription = stringResource(R.string.open_youtube)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(stringResource(R.string.open_youtube))
        }
    }
}