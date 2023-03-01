package universal.appfactory.liquidgalaxy

import android.graphics.drawable.AnimationDrawable
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
        buttonsView.alpha = 0F

        val timer = object: CountDownTimer(5000, 1000) {
            override fun onTick(p0: Long) {
                image.animate().alpha(1F).setDuration(4000).translationY(-50F).start()
            }

            override fun onFinish() {
                buttonsView.animate().alpha(1F).setDuration(4000).start()
            }
        }
        timer.start()

        animator.setEnterFadeDuration(1000)
        animator.setExitFadeDuration(3000)
        animator.start()

    }

    fun buttonClicked(view: View) {
        Toast.makeText(this, "Button ${view.tag} clicked !", Toast.LENGTH_SHORT).show()
    }
}