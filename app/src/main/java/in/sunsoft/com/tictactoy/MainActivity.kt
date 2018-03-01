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
    lateinit var butSelected: Button
    var winner=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    protected fun onButtonClick(view: View) {
        butSelected = view as Button
        print("Selected button is ::" + butSelected)
        var cellId = 0
        enableAllButton()
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

        //Toast.makeText(this, "Cell id: " + cellId, Toast.LENGTH_LONG).show()
        playGame(cellId, butSelected)
    }

    private fun enableAllButton() {
        button1.isEnabled=true
        button2.isEnabled=true
        button3.isEnabled=true
        button4.isEnabled=true
        button5.isEnabled=true
        button6.isEnabled=true
        button7.isEnabled=true
        button8.isEnabled=true
        button9.isEnabled=true
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
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
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
        }

        if(winner != -1) {
            if(winner==1){
                //Toast.makeText(this, "Winner is Player 1", Toast.LENGTH_LONG).show()
                textView.text ="Player 1 Win!"
                textView.visibility = View.VISIBLE
                disableAllButton()
                player1.clear()
                player1.removeAll(player1)
            } else {
                //Toast.makeText(this, "Winner is Player 2", Toast.LENGTH_LONG).show()
                textView.text ="Player 2 Win!"
                textView.visibility = View.VISIBLE
                disableAllButton()
                player2.clear()
                player2.removeAll(player2)
            }

        }
    }

    private fun disableAllButton() {
        button1.isEnabled = false
        button2.isEnabled =false
        button3.isEnabled =false
        button4.isEnabled =false
        button5.isEnabled =false
        button6.isEnabled =false
        button7.isEnabled =false
        button8.isEnabled =false
        button9.isEnabled =false
    }

    fun onRestartPressed(view: View) {


        button1.setBackgroundColor(Color.GRAY)
        button1.text = ""
        button1.isEnabled=true

        button2.setBackgroundColor(Color.GRAY)
        button2.text = ""
        button2.isEnabled=true

        button3.setBackgroundColor(Color.GRAY)
        button3.text = ""
        button3.isEnabled=true

        button4.setBackgroundColor(Color.GRAY)
        button4.text = ""
        button4.isEnabled=true

        button5.setBackgroundColor(Color.GRAY)
        button5.text = ""
        button5.isEnabled=true

        button6.setBackgroundColor(Color.GRAY)
        button6.text = ""
        button6.isEnabled=true

        button7.setBackgroundColor(Color.GRAY)
        button7.text = ""
        button7.isEnabled=true

        button8.setBackgroundColor(Color.GRAY)
        button8.text = ""
        button8.isEnabled=true

        button9.setBackgroundColor(Color.GRAY)
        button9.text = ""
        button9.isEnabled=true

        textView.visibility = View.INVISIBLE

        winner=-1

    }
}
