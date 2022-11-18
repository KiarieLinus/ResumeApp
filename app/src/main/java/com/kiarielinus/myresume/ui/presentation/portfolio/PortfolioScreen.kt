package com.kiarielinus.myresume.ui.presentation.portfolio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kiarielinus.myresume.R

@Composable
fun PortfolioScreen(navController: NavHostController) {
    Column (modifier = Modifier.padding(8.dp)){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ArrowBackIos,
                contentDescription = "nav Back",
                modifier = Modifier
                    .size(48.dp)
                    .weight(1f)
                    .clickable { navController.popBackStack() }
            )
            Text(
                text = stringResource(id = R.string.portfolio),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(5f)
            )
        }

        LazyColumn {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = stringResource(R.string.education),
                        fontSize = 36.sp,
                        textAlign = TextAlign.Center
                    )
                    PortfolioItem(
                        title = stringResource(R.string.title_education),
                        details = stringResource(
                            R.string.detail_education
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.projects),
                        fontSize = 36.sp,
                        textAlign = TextAlign.Center
                    )
                    PortfolioItem(
                        title = stringResource(R.string.title_spice),
                        details = stringResource(R.string.detail_spice)
                    )
                    PortfolioItem(
                        title = stringResource(R.string.title_todo),
                        details = stringResource(R.string.detail_todo)
                    )
                }
            }
        }
    }
}

        //Some test changes


@Composable
fun PortfolioItem(
    title: String,
    details: String
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 8.dp)
        )
        Spacer(Modifier.width(24.dp))
        Text(
            text = details,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewPItem() {
    PortfolioItem(title = "Spice", details = stringResource(id = R.string.about_me))
}