
package com.inkorigin.animationstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF0B0D12)
private val Panel = Color(0xFF171B24)
private val Accent = Color(0xFFB89AFF)
private val Muted = Color(0xFF9299AA)

class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                            setContent {
                                            AnimationStudioApp()
                            }
        }
}

                            }
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimationStudioApp() {
        var selectedTab by remember { mutableStateOf("Home") }

            MaterialTheme(
                        colorScheme = darkColorScheme(
                                        primary = Accent,
                                                    background = Background,
                                                                surface = Panel,
                                                                            onBackground = Color.White,
                                                                                        onSurface = Color.White
                        )
            ) {
                        Scaffold(
                                        containerColor = Background,
                                                    topBar = {
                                                                        TopAppBar(
                                                                                                title = {
                                                                                                                            Column {
                                                                                                                                                            Text(
                                                                                                                                                                                                "ANIMATION STUDIO",
                                                                                                                                                                                                                                fontSize = 17.sp,
                                                                                                                                                                                                                                                                fontWeight = FontWeight.Bold,
                                                                                                                                                                                                                                                                                                letterSpacing = 1.5.sp
                                                                                                                                                            )
                                                                                                                                                                                        Text(
                                                                                                                                                                                                                            "CREATE YOUR STORY",
                                                                                                                                                                                                                                                            fontSize = 9.sp,
                                                                                                                                                                                                                                                                                            color = Muted,
                                                                                                                                                                                                                                                                                                                            letterSpacing = 2.sp
                                                                                                                                                                                        )
                                                                                                                            }
                                                                                                },
                                                                                                                    colors = TopAppBarDefaults.topAppBarColors(
                                                                                                                                                containerColor = Background,
                                                                                                                                                                        titleContentColor = Color.White
                                                                                                                    )
                                                                        )
                                                    },
                                                                bottomBar = {
                                                                                    NavigationBar(containerColor = Panel) {
                                                                                                            listOf("Home", "Scenes", "Export").forEach { tab ->
                                                                                                                                    NavigationBarItem(
                                                                                                                                                                    selected = selectedTab == tab,
                                                                                                                                                                                                onClick = { selectedTab = tab },
                                                                                                                                                                                                                            icon = {
                                                                                                                                                                                                                                                                Text(
                                                                                                                                                                                                                                                                                                        when (tab) {
                                                                                                                                                                                                                                                                                                                                                    "Home" -> "⌂"
                                                                                                                                                                                                                                                                                                                                                                                            "Scenes" -> "▤"
                                                                                                                                                                                                                                                                                                                                                                                                                                    else -> "▶"
                                                                                                                                                                                                                                                                                                        },
                                                                                                                                                                                                                                                                                                                                            fontSize = 20.sp
                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                            },
                                                                                                                                                                                                                                                        label = { Text(tab) },
                                                                                                                                                                                                                                                                                    colors = NavigationBarItemDefaults.colors(
                                                                                                                                                                                                                                                                                                                        selectedIconColor = Accent,
                                                                                                                                                                                                                                                                                                                                                        selectedTextColor = Accent,
                                                                                                                                                                                                                                                                                                                                                                                        indicatorColor = Color(0xFF302642),
                                                                                                                                                                                                                                                                                                                                                                                                                        unselectedTextColor = Muted
                                                                                                                                                                                                                                                                                    )
                                                                                                                                    )
                                                                                                            }
                                                                                    }
                                                                }
                        ) { padding ->
                                    when (selectedTab) {
                                                        "Home" -> HomeScreen(
                                                                                modifier = Modifier.padding(padding),
                                                                                                    onScenesClick = { selectedTab = "Scenes" },
                                                                                                                        onExportClick = { selectedTab = "Export" }
                                                        )
                                                                        "Scenes" -> PlaceholderScreen(
                                                                                                modifier = Modifier.padding(padding),
                                                                                                                    title = "Scene Manager",
                                                                                                                                        description = "Your imported images and scene controls will appear here."
                                                                        )
                                                                                        "Export" -> PlaceholderScreen(
                                                                                                                modifier = Modifier.padding(padding),
                                                                                                                                    title = "Export Studio",
                                                                                                                                                        description = "Video resolution, preview and rendering controls will appear here."
                                                                                        )
                                    }
                        }
            }
}

                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                            }
                                                                                                                            }
                                                                                                }
                                                    }
            }
                        )
            )
}

@Composable
fun HomeScreen(
        modifier: Modifier = Modifier,
            onScenesClick: () -> Unit,
                onExportClick: () -> Unit
) {
        LazyColumn(
                    modifier = modifier
                                .fillMaxSize()
                                            .padding(horizontal = 18.dp),
                                                    verticalArrangement = Arrangement.spacedBy(16.dp),
                                                            contentPadding = PaddingValues(vertical = 20.dp)
        ) {
                    item {
                                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                                        Text(
                                                                                "YOUR CREATIVE SPACE",
                                                                                                    color = Accent,
                                                                                                                        fontSize = 11.sp,
                                                                                                                                            letterSpacing = 2.sp
                                                        )
                                                                        Text(
                                                                                                "Bring your stories to life.",
                                                                                                                    color = Color.White,
                                                                                                                                        fontSize = 27.sp,
                                                                                                                                                            fontWeight = FontWeight.Bold
                                                                        )
                                                                                        Text(
                                                                                                                "Turn images, voice and subtitles into cinematic videos.",
                                                                                                                                    color = Muted,
                                                                                                                                                        fontSize = 13.sp,
                                                                                                                                                                            lineHeight = 20.sp
                                                                                        )
                                    }
                    }

                            item {
                                            Card(
                                                                modifier = Modifier.fillMaxWidth(),
                                                                                shape = RoundedCornerShape(22.dp),
                                                                                                colors = CardDefaults.cardColors(
                                                                                                                        containerColor = Color(0xFF211B30)
                                                                                                )
                                            ) {
                                                                Column(
                                                                                        modifier = Modifier.padding(20.dp),
                                                                                                            verticalArrangement = Arrangement.spacedBy(12.dp)
                                                                ) {
                                                                                        Text(
                                                                                                                    "✦  NEW PROJECT",
                                                                                                                                            color = Accent,
                                                                                                                                                                    fontSize = 11.sp,
                                                                                                                                                                                            fontWeight = FontWeight.Bold,
                                                                                                                                                                                                                    letterSpacing = 1.5.sp
                                                                                        )
                                                                                                            Text(
                                                                                                                                        "Create something\nextraordinary.",
                                                                                                                                                                fontSize = 25.sp,
                                                                                                                                                                                        fontWeight = FontWeight.Bold,
                                                                                                                                                                                                                color = Color.White,
                                                                                                                                                                                                                                        lineHeight = 32.sp
                                                                                                            )
                                                                                                                                Text(
                                                                                                                                                            "Start building your next cinematic story.",
                                                                                                                                                                                    color = Muted,
                                                                                                                                                                                                            fontSize = 13.sp
                                                                                                                                )
                                                                                                                                                    Button(
                                                                                                                                                                                onClick = onScenesClick,
                                                                                                                                                                                                        colors = ButtonDefaults.buttonColors(
                                                                                                                                                                                                                                        containerColor = Accent,
                                                                                                                                                                                                                                                                    contentColor = Background
                                                                                                                                                                                                        ),
                                                                                                                                                                                                                                shape = RoundedCornerShape(12.dp)
                                                                                                                                                    ) {
                                                                                                                                                                                Text(
                                                                                                                                                                                                                "Get Started  →",
                                                                                                                                                                                                                                            fontWeight = FontWeight.Bold
                                                                                                                                                                                )
                                                                                                                                                    }
                                                                }
                                            }
                            }

                                    item {
                                                    Text(
                                                                        "WORKSPACE",
                                                                                        color = Muted,
                                                                                                        fontSize = 11.sp,
                                                                                                                        fontWeight = FontWeight.Bold,
                                                                                                                                        letterSpacing = 2.sp
                                                    )
                                    }

                                            item {
                                                            FeatureCard(
                                                                                symbol = "▧",
                                                                                                title = "Image Library",
                                                                                                                description = "Import and organize your scene images.",
                                                                                                                                status = "COMING NEXT",
                                                                                                                                                onClick = onScenesClick
                                                            )
                                            }

                                                    item {
                                                                    FeatureCard(
                                                                                        symbol = "♫",
                                                                                                        title = "Voice & Audio",
                                                                                                                        description = "Add your narration and background audio.",
                                                                                                                                        status = "COMING NEXT",
                                                                                                                                                        onClick = onScenesClick
                                                                    )
                                                    }

                                                            item {
                                                                            FeatureCard(
                                                                                                symbol = "≡",
                                                                                                                title = "Subtitle Studio",
                                                                                                                                description = "Import SRT and customize subtitles.",
                                                                                                                                                status = "COMING NEXT",
                                                                                                                                                                onClick = onScenesClick
                                                                            )
                                                            }

                                                                    item {
                                                                                    FeatureCard(
                                                                                                        symbol = "✧",
                                                                                                                        title = "Animation Engine",
                                                                                                                                        description = "Create cinematic zoom and camera movements.",
                                                                                                                                                        status = "COMING NEXT",
                                                                                                                                                                        onClick = onScenesClick
                                                                                    )
                                                                    }

                                                                            item {
                                                                                            FeatureCard(
                                                                                                                symbol = "▶",
                                                                                                                                title = "Video Export",
                                                                                                                                                description = "Preview and render your finished video.",
                                                                                                                                                                status = "COMING NEXT",
                                                                                                                                                                                onClick = onExportClick
                                                                                            )
                                                                            }

                                                                                    item {
                                                                                                    Card(
                                                                                                                        modifier = Modifier.fillMaxWidth(),
                                                                                                                                        colors = CardDefaults.cardColors(
                                                                                                                                                                containerColor = Panel
                                                                                                                                        ),
                                                                                                                                                        shape = RoundedCornerShape(16.dp)
                                                                                                    ) {
                                                                                                                        Column(
                                                                                                                                                modifier = Modifier.padding(16.dp),
                                                                                                                                                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                                                                                                        ) {
                                                                                                                                                Text(
                                                                                                                                                                            "BUILT FOR CREATORS",
                                                                                                                                                                                                    color = Accent,
                                                                                                                                                                                                                            fontSize = 10.sp,
                                                                                                                                                                                                                                                    letterSpacing = 1.5.sp,
                                                                                                                                                                                                                                                                            fontWeight = FontWeight.Bold
                                                                                                                                                )
                                                                                                                                                                    Text(
                                                                                                                                                                                                "Your studio. Your workflow. Your stories.",
                                                                                                                                                                                                                        color = Color.White,
                                                                                                                                                                                                                                                fontWeight = FontWeight.Medium,
                                                                                                                                                                                                                                                                        fontSize = 14.sp
                                                                                                                                                                    )
                                                                                                                                                                                        Text(
                                                                                                                                                                                                                    "Offline-first • No paid AI API required",
                                                                                                                                                                                                                                            color = Muted,
                                                                                                                                                                                                                                                                    fontSize = 11.sp
                                                                                                                                                                                        )
                                                                                                                        }
                                                                                                    }
                                                                                    }
        }
}

                                                                                                                                                    }
                                                                }
                                    }
                    }
        }
}
)

@Composable
fun FeatureCard(
            symbol: String,
                title: String,
                    description: String,
                        status: String,
                            onClick: () -> Unit
) {
            Card(
                        modifier = Modifier
                                    .fillMaxWidth()
                                                .clickable { onClick() },
                                                        shape = RoundedCornerShape(16.dp),
                                                                colors = CardDefaults.cardColors(
                                                                                    containerColor = Panel
                                                                )
            ) {
                        Row(
                                            modifier = Modifier.padding(16.dp),
                                                        verticalAlignment = Alignment.CenterVertically
                        ) {
                                            Box(
                                                                modifier = Modifier
                                                                                    .size(48.dp)
                                                                                                        .background(
                                                                                                                                        Color(0xFF302642),
                                                                                                                                                                RoundedCornerShape(14.dp)
                                                                                                        ),
                                                                                                                        contentAlignment = Alignment.Center
                                            ) {
                                                                Text(
                                                                                            symbol,
                                                                                                                color = Accent,
                                                                                                                                    fontSize = 23.sp
                                                                )
                                            }

                                                        Spacer(modifier = Modifier.width(14.dp))

                                                                    Column(
                                                                                        modifier = Modifier.weight(1f),
                                                                                                        verticalArrangement = Arrangement.spacedBy(4.dp)
                                                                    ) {
                                                                                        Text(
                                                                                                                    title,
                                                                                                                                        color = Color.White,
                                                                                                                                                            fontWeight = FontWeight.Bold,
                                                                                                                                                                                fontSize = 15.sp
                                                                                        )
                                                                                                        Text(
                                                                                                                                    description,
                                                                                                                                                        color = Muted,
                                                                                                                                                                            fontSize = 11.sp,
                                                                                                                                                                                                lineHeight = 16.sp
                                                                                                        )
                                                                                                                        Text(
                                                                                                                                                    status,
                                                                                                                                                                        color = Accent,
                                                                                                                                                                                            fontSize = 9.sp,
                                                                                                                                                                                                                fontWeight = FontWeight.Bold,
                                                                                                                                                                                                                                    letterSpacing = 1.sp
                                                                                                                        )
                                                                    }

                                                                                Text(
                                                                                                        "›",
                                                                                                                        color = Muted,
                                                                                                                                        fontSize = 25.sp
                                                                                )
                        }
            }
}

@Composable
fun PlaceholderScreen(
            modifier: Modifier = Modifier,
                title: String,
                    description: String
) {
            Column(
                        modifier = modifier
                                    .fillMaxSize()
                                                .padding(24.dp),
                                                        verticalArrangement = Arrangement.Center,
                                                                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                        Text(
                                            title,
                                                        color = Color.White,
                                                                    fontSize = 25.sp,
                                                                                fontWeight = FontWeight.Bold
                        )
                                Spacer(modifier = Modifier.height(12.dp))
                                        Text(
                                                            description,
                                                                        color = Muted,
                                                                                    fontSize = 14.sp,
                                                                                                lineHeight = 22.sp
                                        )
                                                Spacer(modifier = Modifier.height(16.dp))
                                                        Text(
                                                                            "Feature development in progress",
                                                                                        color = Accent,
                                                                                                    fontSize = 12.sp
                                                        )
            }
}

                                            }
                        }
            }
}
)