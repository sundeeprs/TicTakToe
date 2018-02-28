package `in`.sunsoft.com.tictactoy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var activePayer:Int=1
    var player1= ArrayList<Int>()
    var player2= ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    protected fun onButtonClick(view: View) {
        var butSelected = view as Button
        print("Selected button is ::" + butSelected)
        var cellId = 0

        when(butSelected.id) {
            R.id.button1-> cellId=1
            R.id.button2-> cellId=2
            R.id.button3-> cellId=3
            R.id.button4-> cellId=4
            R.id.button5-> cellId=5
            R.id.button6-> cellId=6
            R.id.button7-> cellId=7
            R.id.button8-> cellId=8
            R.id.button9-> cellId=9
        }

        Toast.makeText(this, "Cell id: " + cellId, Toast.LENGTH_LONG).show()
        playGame(cellId, butSelected)
    }

    fun playGame(cellId:Int, buttonSelected:Button) {
        if(activePayer==1) {
            buttonSelected.text="X"
            buttonSelected.textSize=20.0f
            buttonSelected.setBackgroundColor(Color.BLUE)
            player1.add(cellId)
            activePayer=2
        } else {
            buttonSelected.text="0"
            buttonSelected.textSize=20.0f
            buttonSelected.setBackgroundColor(Color.MAGENTA)
            player2.add(cellId)
            activePayer=1
        }
        buttonSelected.isEnabled=false
        winner()
    }

    fun winner() {
        var winner=-1

        //row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
         winner=1
        }

        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }

        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }

        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }

        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }

        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }

        //col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }

        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }

        //col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }

        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }

        //col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }

        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }

        //diagonal 1
       /* if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
        }

        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }

        //diagonal 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
        }

        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
        }*/

        if(winner != -1) {
            if(winner==1){
                //Toast.makeText(this, "Winner is Player 1", Toast.LENGTH_LONG).show()
                textView.text ="Player 1 Win!"
                textView.visibility = View.VISIBLE

            } else {
                //Toast.makeText(this, "Winner is Player 2", Toast.LENGTH_LONG).show()
                textView.text ="Player 2 Win!"
                textView.visibility = View.VISIBLE
            }
        }
    }

    fun onStartPressed(view: View) {

    }

    fun onRestartPressed(view: View) {
    }
}
