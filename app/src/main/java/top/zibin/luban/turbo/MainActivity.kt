package top.zibin.luban.turbo

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testJpeg()
    }

    private fun testJpeg() {
        val dir = externalCacheDir
        if (!dir.exists()) {
            dir.mkdirs()
        }

        val quality = 50
        val file = resources.assets.open("test.jpg")

        val outfile = File(dir, "output.jpg")

        TurboCompressor().compressBitmap(file, quality, outfile.absolutePath)

        println(outfile.absoluteFile)

        image_view.setImageBitmap(BitmapFactory.decodeFile(outfile.absolutePath))
    }
}
