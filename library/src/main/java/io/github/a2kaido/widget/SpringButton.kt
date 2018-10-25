package io.github.a2kaido.widget

import android.content.Context
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet

class SpringButton @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatButton(context, attributeSet, defStyleAttr) {

    private val animX: SpringAnimation by lazy {
        SpringAnimation(this, DynamicAnimation.SCALE_X).apply {
            spring = SpringForce(1f).apply {
                dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
                stiffness = SpringForce.STIFFNESS_LOW
            }
            setMinValue(0f)
            setMaxValue(1.5f)
        }
    }

    private val animY: SpringAnimation by lazy {
        SpringAnimation(this, DynamicAnimation.SCALE_Y).apply {
            spring = SpringForce(1f).apply {
                dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
                stiffness = SpringForce.STIFFNESS_LOW
            }
            setMinValue(0f)
            setMaxValue(1.5f)
        }
    }

    override fun performClick(): Boolean {
        this.scaleX = 0.7f
        this.scaleY = 0.7f
        animX.start()
        animY.start()
        return super.performClick()
    }
}