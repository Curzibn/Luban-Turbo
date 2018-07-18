package top.zibin.luban.turbo

import android.graphics.Bitmap

/**
 * Author: zibin
 * Datetime: 2018/7/18
 */
class TurboCompressor {

    private external fun nativeCompress(bitmap: Bitmap, outfile: String, quality: Int, optimize: Boolean): Boolean

    companion object {
        init {
            System.loadLibrary("luban-turbo")
        }
    }
}