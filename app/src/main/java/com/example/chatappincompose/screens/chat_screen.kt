package com.example.chatappincompose.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatappincompose.R
import com.example.chatappincompose.components.IconComponentDrawable
import com.example.chatappincompose.components.IconComponentImageVector
import com.example.chatappincompose.components.SpaceWidth
import com.example.chatappincompose.models.Chat
import com.example.chatappincompose.models.Person
import com.example.chatappincompose.models.chatList
import com.google.gson.Gson

@Composable
fun ChatScreen(personData: String) {
    var message by remember { mutableStateOf("") }
    val personData = Gson().fromJson(personData, Person::class.java)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            UserNameHeader(
                person = personData,
                modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 10.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .padding(top = 10.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 75.dp)
                ) {
                    items(chatList, key = { it.id }) {
                        ChatRow(chat = it)
                    }
                }

                TextFieldComponent(
                    text = message,
                    modifier = Modifier
                        .padding(20.dp)
                        .align(
                            Alignment.BottomCenter
                        )
                ) {
                    message = it
                }
            }
        }
    }
}

@Composable
fun UserNameHeader(
    modifier: Modifier = Modifier,
    person: Person
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Box(
                modifier = Modifier
                    .background(color = Color.Yellow, shape = CircleShape)
                    .size(50.dp),
                contentAlignment = Alignment.Center
            ) {
                IconComponentDrawable(
                    icon = person.icon, size = 50.dp, modifier = Modifier.clip(
                        CircleShape
                    )
                )
            }
            SpaceWidth()
            Column {
                Text(
                    text = person.name, style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = "Online", style = TextStyle(
                        color = Color.White,
                        fontSize = 14.sp
                    )
                )
            }
        }

        IconComponentImageVector(icon = Icons.Default.MoreVert, size = 24.dp, tint = Color.White)
    }
}

@Composable
fun ChatRow(
    chat: Chat
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (chat.isSender) Alignment.End else Alignment.Start
    ) {
        Box(
            modifier = Modifier.background(
                if (chat.isSender) Color.LightGray else Color.Cyan,
                shape = RoundedCornerShape(100.dp)
            ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = chat.message, style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Black
                ),
                textAlign = TextAlign.End,
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 8.dp)
            )
        }
        Text(
            text = chat.time, style = TextStyle(
                fontSize = 12.sp,
                color = Color.Gray
            ),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 8.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit
) {

    TextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(160.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Gray,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ), placeholder = {
            Text(
                text = stringResource(R.string.type_message), style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black
                )
            )
        },
        leadingIcon = {
            IconButtonComponentImageVector(icon = Icons.Default.Add)
        },
        trailingIcon = {
            IconButtonComponentDrawable(icon = R.drawable.ic_voice)
        }
    )

}

@Composable
fun IconButtonComponentImageVector(
    icon: ImageVector
) {
    Box(
        modifier = Modifier
            .background(color = Color.Yellow, shape = CircleShape)
            .size(40.dp),
        contentAlignment = Alignment.Center
    ) {
        IconComponentImageVector(icon = icon, size = 15.dp, tint = Color.Black)
    }
}

@Composable
fun IconButtonComponentDrawable(
    @DrawableRes icon: Int
) {
    Box(
        modifier = Modifier
            .background(color = Color.Yellow, shape = CircleShape)
            .size(40.dp),
        contentAlignment = Alignment.Center
    ) {
        IconComponentDrawable(icon = icon, size = 15.dp, tint = Color.Black)
    }
}