/*
 * Copyright (C) 2021, Alashov Berkeli
 * All rights reserved.
 */
package tm.alashow.datmusic.ui.audios

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch
import tm.alashow.base.util.toast
import tm.alashow.datmusic.ui.downloader.LocalDownloader

@Composable
internal fun AudioActionHandler(): AudioActionHandler {
    val downloader = LocalDownloader.current
    val context = LocalContext.current
    val coroutine = rememberCoroutineScope()

    return { action ->
        when (action) {
            is AudioItemAction.Download -> {
                coroutine.launch {
                    val uri = downloader.verifyAndGetDownloadsLocationUri()
                    if (uri != null)
                        context.toast("Uri: $uri")
                }
            }
            is AudioItemAction.CopyLink -> {
                context.toast("Not implemented: Copy link")
            }
            is AudioItemAction.Share -> {
                context.toast("Not implemented: Share")
            }
        }
    }
}