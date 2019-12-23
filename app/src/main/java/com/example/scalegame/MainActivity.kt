package com.example.scalegame

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import android.view.WindowManager
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                adjX(imageViewA,p1)
                adjY(imageViewB,p1)
                adjY(imageViewC,p1)
                adjX(imageViewD,p1)
                adjScale(imageView3,p1)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }
    fun adjX(imageView: ImageView,rate:Int){
        val layoutParams = imageView.getLayoutParams()
        layoutParams.width = convertDpToPixel(150-(rate/100F*150))
        layoutParams.height = convertDpToPixel(150+(rate/100F*150))
        imageView.setLayoutParams(layoutParams)
    }
    fun adjY(imageView: ImageView,rate:Int){
        val layoutParams = imageView.getLayoutParams()
        layoutParams.width = convertDpToPixel(150+(rate/100F*150))
        layoutParams.height = convertDpToPixel(150-(rate/100F*150))
        imageView.setLayoutParams(layoutParams)
    }
    fun adjScale(imageView: ImageView,rate:Int){
        val layoutParams = imageView.getLayoutParams()
        layoutParams.width = convertDpToPixel(rate/100F*300)
        layoutParams.height = convertDpToPixel(rate/100F*300)
        imageView.setLayoutParams(layoutParams)
    }
    fun convertDpToPixel(dp: Float): Int {
        val metrics = DisplayMetrics()
        val windowManager =
            this!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)

        var  DEVICE_DENSITY_DPI = metrics.densityDpi
        return (dp * (DEVICE_DENSITY_DPI / 160f)).toInt()
    }
}
