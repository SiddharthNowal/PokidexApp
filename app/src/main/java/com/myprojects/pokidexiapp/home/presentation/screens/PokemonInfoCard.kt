package com.myprojects.pokidexiapp.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.myprojects.pokidexiapp.R
import com.myprojects.pokidexiapp.home.domain.model.PokemonCardItemInfo
import com.myprojects.pokidexiapp.utils.theme.ColorGreenLight
import com.myprojects.pokidexiapp.utils.theme.Typography

@Composable
fun PokemonInfoCard(pokemonItemInfo: PokemonCardItemInfo) {
  ElevatedCard(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight(unbounded = true)
      .padding(vertical = 4.dp, horizontal = 8.dp)
      .background(ColorGreenLight, shape = RoundedCornerShape(16.dp))
  ) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
      val tvRegionName = createRef()
      val tvPokemonName = createRef()
      val ivPokemonImage = createRef()
      val boxPokemomType = createRef()

      Text(modifier = Modifier.constrainAs(ref = tvRegionName) {
         start.linkTo(parent.start, margin = 16.dp)
         linkTo(top = parent.top, bottom = tvPokemonName.bottom, bias = 0F, topMargin = 16.dp)
      }, text = pokemonItemInfo.region, style = Typography.labelSmall)
      Text(
        modifier = Modifier.constrainAs(ref = tvPokemonName) {
          start.linkTo(parent.start, margin = 16.dp)
          end.linkTo(ivPokemonImage.start, margin = 16.dp)
          linkTo(top = tvRegionName.bottom, bottom = boxPokemomType.top, bias = 0F)
          width = Dimension.fillToConstraints
          height = Dimension.wrapContent
        },
        text = pokemonItemInfo.name,
        style = Typography.titleLarge,
        fontWeight = FontWeight.Bold
      )
      AsyncImage(
        modifier = Modifier
          .height(80.dp)
          .width(80.dp)
          .constrainAs(ref = ivPokemonImage) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end, margin = 16.dp)
            start.linkTo(tvPokemonName.end)
          },
        contentScale = ContentScale.Inside,
        model = ImageRequest.Builder(LocalContext.current)
          .data(pokemonItemInfo.imageUrl)
          .placeholder(R.drawable.ic_launcher_background).crossfade(true).build(),
        contentDescription = ""
      )
      Box(modifier = Modifier
        .constrainAs(boxPokemomType) {
          top.linkTo(tvPokemonName.bottom, margin = 16.dp)
          linkTo(
            start = parent.start,
            end = tvPokemonName.end,
            startMargin = 16.dp,
            endMargin = 16.dp,
            bias = 0F
          )
          bottom.linkTo(parent.bottom, margin = 16.dp)
        }
        .background(pokemonItemInfo.pokemonTypeColor, shape = RoundedCornerShape(12.dp))) {
        Text(
          modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
          text = pokemonItemInfo.type,
          style = Typography.labelSmall
        )
      }
    }
  }
}

@Preview
@Composable
fun PreviewPokemonInfoCard() {
  PokemonInfoCard(pokemonItemInfo = PokemonCardItemInfo())
}