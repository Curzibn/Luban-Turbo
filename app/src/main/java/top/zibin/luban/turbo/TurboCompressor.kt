package top.zibin.luban.turbo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File
import java.io.InputStream

/**
 * Author: zibin
 * Datetime: 2018/7/18
 */
class TurboCompressor {

    fun compressBitmap(file: InputStream, quality: Int, outfile: String): File {
        val options = BitmapFactory.Options()
        options.inSampleSize = 2

        val tagBitmap = BitmapFactory.decodeStream(file, null, options)

        nativeCompress(tagBitmap, quality, outfile)

        return File(outfile)
    }

    private external fun nativeCompress(bitmap: Bitmap?, quality: Int, outfile: String): Boolean

    companion object {
        init {
            System.loadLibrary("luban")
        }
    }
}