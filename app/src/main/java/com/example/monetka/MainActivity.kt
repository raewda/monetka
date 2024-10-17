package com.example.monetka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.monetka.ui.theme.Jolly_Lodger
import com.example.monetka.ui.theme.MonetkaTheme
import com.example.monetka.ui.theme.RandomMonetka
import kotlinx.coroutines.delay
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MonetkaTheme {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // I
                    Text(
                        text = "RAEWDA PRODUCTION",
                        modifier = Modifier
                            .padding(start = 20.dp),
                        color = colorResource(R.color.Luminous),
                        fontSize = 36.sp,
                        fontFamily = Jolly_Lodger
                    )
                    // ZAGOLOVOK
                    Text(
                        "MONETKA",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally),
                        color = colorResource(R.color.Luminous),
                        fontSize = 120.sp,
                        fontFamily = Jolly_Lodger
                        )

                    var tap by remember {
                        mutableStateOf(false)
                    }
                    var rand by remember {
                        mutableStateOf(monetka().anim)
                    }

                    Rand(tap, onAnimEnd = {tap = false}, rand)

                    Button(
                        onClick = {tap = true; rand = monetka().anim},
                        modifier = Modifier
                            .size(180.dp, 70.dp)
                            .align(alignment = Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(colorResource(R.color.Luminous))
                    ) {
                        Text(
                            text = "tap",
                            modifier = Modifier,
                            color = Color.White,
                            fontSize = 54.sp,
                            fontFamily = Jolly_Lodger
                            )
                    }
                }

            }
        }
    }
}

@Composable
fun Rand(
    tap : Boolean,
    onAnimEnd:()->Unit,
    animation : Int
) {
    LaunchedEffect(tap) {
        if (tap){
            delay(7000)
            onAnimEnd()
        }
    }
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(animation))
    LottieAnimation(
        composition = composition,
        modifier = Modifier.size(350.dp),
        isPlaying = tap,
        restartOnPlay = true
    )
}
fun monetka(): RandomMonetka{
    return RandomMonetka.getById(Random.nextInt(0, RandomMonetka.Count))
}