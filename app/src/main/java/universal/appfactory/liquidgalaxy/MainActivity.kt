package universal.appfactory.liquidgalaxy

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.gridlayout.widget.GridLayout
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val layout = findViewById<ConstraintLayout>(R.id.mainPage)
        val image = findViewById<ImageView>(R.id.lgLogo)
        val buttonsView = findViewById<GridLayout>(R.id.buttonsView)
        val animator = layout.background as AnimationDrawable

        image.alpha = 0F
        image.scaleX = 0.5F
        image.scaleY = 0.5F
        buttonsView.alpha = 0F

        image.animate().alpha(1F).scaleX(1F).scaleY(1F).setDuration(2000).start()
        image.animate().translationY(-450F).setDuration(2000).start()
        val timer = object: CountDownTimer(5000, 1000) {
            override fun onTick(p0: Long) { }

            override fun onFinish() {
                buttonsView.visibility = View.VISIBLE
                buttonsView.animate().alpha(1F).setDuration(2000).start()
            }
        }
        timer.start()

        animator.setEnterFadeDuration(1000)
        animator.setExitFadeDuration(3000)
        animator.start()

        image.setOnClickListener {
            val intent = Intent("android.intent.action.VIEW", Uri.parse("https://www.liquidgalaxy.eu/"))
            startActivity(intent)
        }

    }

    fun buttonClicked(view: View) {
        Toast.makeText(this, "Button ${view.tag} clicked !", Toast.LENGTH_SHORT).show()
    }
}