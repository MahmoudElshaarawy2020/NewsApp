
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun NewsCard(url : String, title : String, date : String, onClick : () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(255.dp)
            .clickable { onClick() }
            .background(Color.Gray, RoundedCornerShape(16.dp))
    ) {
        // Background Image
        AsyncImage(
            model = url, // Replace with the URL or resource
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        // Overlay Text
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(Alignment.BottomStart)
                .background(
                    color = Color.White.copy(alpha = 0.8f),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp) // Rounded corners for the top edges
                )
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = date,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

