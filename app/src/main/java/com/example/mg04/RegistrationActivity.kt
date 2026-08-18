package com.example.mg04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mg04.ui.theme.MGTheme

class RegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MGTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegistrationScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RegistrationScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    // Unique Gradient Background
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFE3F2FD), Color(0xFFBBDEFB), Color(0xFF90CAF9))
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(gradient)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .verticalScroll(rememberScrollState()),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = null,
                    tint = Color(0xFF1976D2),
                    modifier = Modifier.size(64.dp)
                )

                Text(
                    text = "College Registration",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF0D47A1),
                    textAlign = TextAlign.Center
                )

                HorizontalDivider(color = Color(0xFFBBDEFB), thickness = 1.dp)

                // Custom Color Bordering for TextFields
                val textFieldColors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF1976D2),
                    unfocusedBorderColor = Color(0xFF64B5F6),
                    focusedLabelColor = Color(0xFF0D47A1),
                    cursorColor = Color(0xFF1976D2),
                    focusedLeadingIconColor = Color(0xFF1976D2)
                )

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Full Name") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = textFieldColors
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email Address") },
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = textFieldColors
                )

                OutlinedTextField(
                    value = course,
                    onValueChange = { course = it },
                    label = { Text("Course Name") },
                    leadingIcon = { Icon(Icons.Default.Book, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = textFieldColors
                )

                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Phone Number") },
                    leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = textFieldColors
                )

                Button(
                    onClick = {
                        if (name.isNotEmpty() && email.isNotEmpty() && course.isNotEmpty() && phone.isNotEmpty()) {
                            result = "Success! Welcome aboard, $name"
                        } else {
                            result = "Please complete all fields"
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2))
                ) {
                    Text("Submit Registration", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }

                if (result.isNotEmpty()) {
                    Surface(
                        color = if (result.startsWith("Success")) Color(0xFFE8F5E9) else Color(0xFFFFEBEE),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = result,
                            color = if (result.startsWith("Success")) Color(0xFF2E7D32) else Color(0xFFC62828),
                            modifier = Modifier.padding(12.dp),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

        // Floating Action Button at Bottom Left
        FloatingActionButton(
            onClick = { /* Handle menu click */ },
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp),
            containerColor = Color.White,
            shape = RoundedCornerShape(50)
        ) {
            Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    MGTheme {
        RegistrationScreen()
    }
}
