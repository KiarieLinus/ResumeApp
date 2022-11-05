package com.kiarielinus.myresume.ui.presentation.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kiarielinus.myresume.R
import com.kiarielinus.myresume.ui.theme.Orange200
import com.kiarielinus.myresume.utils.Screen

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel(),
    navController: NavHostController
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Profile()

        ContactsPane(
            slackId = stringResource(R.string.slackId)
        ) { contactType ->
            viewModel.onContactClicked(contactType)
        }

        NavigationButton(strRes = R.string.offer) {
            navController.navigate(Screen.Offer.route)
        }
        NavigationButton(strRes = R.string.portfolio) {
            navController.navigate(Screen.Portfolio.route)
        }
    }
}


@Composable
fun Profile() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.profile_no_bg),
            contentDescription = "Profile Image",
            modifier = Modifier
                .background(Orange200, CircleShape)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(R.string.title),
            fontSize = 36.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(R.string.about_me),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactsPane(
    slackId: String,
    contactClicked: (ContactType) -> Unit
) {
    val contactTypes = listOf("E-mail", "Twitter", "Phone")
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ContactItem(
                onContactItemClick = { contactClicked(ContactType.EMAIL) },
                imageRes = R.drawable.ic_mail,
                title = contactTypes[0]
            )
            ContactItem(
                onContactItemClick = { contactClicked(ContactType.TWITTER) },
                imageRes = R.drawable.ic_twitter_icon,
                title = contactTypes[1]
            )
            ContactItem(
                onContactItemClick = { contactClicked(ContactType.PHONE) },
                imageRes = R.drawable.ic_phone,
                title = contactTypes[2]
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            val context = LocalContext.current
            Text(text = "Slack id: $slackId")
            IconButton(onClick = {
                contactClicked(ContactType.SLACK)
                Toast.makeText(context,"Copied to Clipboard",Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Default.ContentCopy,
                    contentDescription = "Copy slack ID icon",
                    tint = Orange200
                )
            }
        }
    }
}

@Composable
fun ContactItem(
    onContactItemClick: () -> Unit,
    imageRes: Int,
    title: String
) {
    Column {
        IconButton(onClick = { onContactItemClick() }) {
            Icon(
                painter = painterResource(id = imageRes),
                contentDescription = "Contact Icon",
                tint = Orange200
            )
        }
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
    }
}

@Composable
fun NavigationButton(
    strRes: Int,
    navigationBtnClicked: () -> Unit
) {
    OutlinedButton(
        onClick = { navigationBtnClicked() },
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(strRes),
            fontSize = 20.sp
        )
    }
}

@Preview
@Composable
fun ProfilePreview() {
    Profile()
}

@Preview
@Composable
fun ContactsPreview() {
    ContactsPane(slackId = "@SlackId") {}
}

@Preview
@Composable
fun NavBtnPrev() {
    NavigationButton(R.string.offer) {}
}