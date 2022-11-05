package com.kiarielinus.myresume.ui.presentation.offer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kiarielinus.myresume.R
import com.kiarielinus.myresume.ui.theme.Orange

@Composable
fun OfferScreen(navController: NavHostController) {

    val offers = stringArrayResource(R.array.what_i_offer)

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Icon(
                imageVector = Icons.Default.ArrowBackIos,
                contentDescription = "nav Back",
                modifier = Modifier
                    .size(48.dp)
                    .weight(1f)
                    .clickable { navController.popBackStack() }
            )
            Text(
                text = stringResource(id = R.string.offer),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(5f)
            )
        }
        LazyColumn {
            itemsIndexed(items = offers) { index, offer ->
                OfferItem(index = index, offer = offer)
                Spacer(Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun OfferItem(
    index: Int,
    offer: String
) {
    Row {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(Orange, CircleShape)
        ) {
            Text(text = "$index", modifier = Modifier.align(Alignment.Center))
        }
        Spacer(Modifier.width(24.dp))

        Text(text = offer)
    }
}

@Preview
@Composable
fun OfferPrev() {
    OfferItem(
        index = 6,
        offer = "Most importantly, I offer a cool head under pressure and great banter"
    )
}