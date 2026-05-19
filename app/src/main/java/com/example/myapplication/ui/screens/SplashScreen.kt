package com.example.myapplication.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigation: (isLoggedIn: Boolean) -> Unit) {
    val context = LocalContext.current
    
    LaunchedEffect(Unit) {
        val sharedPrefs = context.getSharedPreferences("user_prefs", android.content.Context.MODE_PRIVATE)
        val isLoggedIn = sharedPrefs.getBoolean("is_logged_in", false)

        delay(3000) // 3 second delay
        onNavigation(isLoggedIn)
    }

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        val screenHeight = maxHeight
        
        val infiniteTransition = rememberInfiniteTransition(label = "BouncingIcon")
        
        // Vertical bouncing animation from top to bottom
        val offsetY by infiniteTransition.animateValue(
            initialValue = 0.dp,
            targetValue = screenHeight - 200.dp, // Subtracting approximate height of Column content
            typeConverter = Dp.VectorConverter,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "VerticalPosition"
        )

        Column(
            modifier = Modifier.offset(y = offsetY),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                contentDescription = "App Icon",
                modifier = Modifier.size(120.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "My Application",
                fontSize = 32.sp
            )
        }
    }
}
