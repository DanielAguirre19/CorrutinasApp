package mx.unam.fi.corrutinasapp.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.unam.fi.corrutinasapp.R
import mx.unam.fi.corrutinasapp.ui.theme.CorrutinasAppTheme
import mx.unam.fi.corrutinasapp.viewmodel.MainViewModel

@Composable
fun CoroutinesApp(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = MainViewModel()

    ){
    var changeColor by remember{
        mutableStateOf(false)
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Button(
            onClick = {changeColor = !changeColor},
            colors = ButtonDefaults.buttonColors(
                if (changeColor) Color.Blue else Color.Red
            )
        ) {
            Text(text = stringResource(R.string.cambio_de_color))
        }
        Spacer(modifier = modifier.height(30.dp))

        //Text(text = viewModel.resultState)
        Spacer(modifier = modifier.height(30.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Contador 1", fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Spacer(modifier = modifier.height(10.dp))
            if (viewModel.resultState){
                Text(text = "${viewModel.countTime} [s]", fontSize = 22.sp, color = Color.Red)
            }else{
                Text(text = "${viewModel.countTime} [s]", fontSize = 22.sp)
            }


            Spacer(modifier = modifier.height(30.dp))

            Text(text = "Contador 2", fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Spacer(modifier = modifier.height(10.dp))
            if (viewModel.resultState2){
                Text(text = "${viewModel.countTime2} [s]", fontSize = 22.sp, color = Color.Red)
            }else{
                Text(text = "${viewModel.countTime2} [s]", fontSize = 22.sp)
            }
        }

        Spacer(modifier = modifier.height(30.dp))
        Button(onClick = {viewModel.fetchData()}) {
            Text(text = stringResource(R.string.realizar_consulta))
        }
        Spacer(modifier = modifier.height(10.dp))
        Button(onClick = {viewModel.reset()}) {
            Text(text = stringResource(R.string.detener_contadores))
        }
    }
}

@Preview
@Composable
fun CoroutinesAppPreview(){
    CorrutinasAppTheme {
        CoroutinesApp()
    }
}