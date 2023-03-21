package com.example.calulatorshahi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.Toast
import com.example.calulatorshahi.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onNumberClicked()
        onOperatorClicked()




    }

    private fun onOperatorClicked() {

        binding.btnJam.setOnClickListener {

            if (binding.txtExpression.text.isNotEmpty()) {


                val myChar = binding.txtExpression.text.last()

                if (myChar == '+' || myChar == '-' || myChar == '*' || myChar == '/') {


                } else {

                    appendTxt("+")

                }


            }
        }
        binding.btnMenha.setOnClickListener {

            if (binding.txtExpression.text.isNotEmpty()) {


                val myChar = binding.txtExpression.text.last()

                if (myChar == '+' || myChar == '-' || myChar == '*' || myChar == '/') {


                } else {

                    appendTxt("-")

                }


            }




        }


        binding.btnPakidan.setOnClickListener {

            val oldText = binding.txtExpression.text.toString()

            if ( oldText.isNotEmpty() ) {

                binding.txtExpression.text = oldText.substring(0 , oldText.length-1)

            }


        }

        binding.btnZarb.setOnClickListener {
            if (binding.txtExpression.text.isNotEmpty()) {


                val myChar = binding.txtExpression.text.last()

                if (myChar == '+' || myChar == '-' || myChar == '*' || myChar == '/') {


                } else {

                    appendTxt("*")

                }


            }

        }


        binding.btnTaghsim.setOnClickListener {
            if (binding.txtExpression.text.isNotEmpty()) {


                val myChar = binding.txtExpression.text.last()

                if (myChar == '+' || myChar == '-' || myChar == '*' || myChar == '/') {


                } else {

                    appendTxt("/")

                }


            }

        }

        binding.btnParantezBaz.setOnClickListener {

            appendTxt("(")


        }

        binding.btnParantezBaste.setOnClickListener {

            appendTxt(")")
        }

        binding.btnMosavi.setOnClickListener {
            try {


                val experssion = ExpressionBuilder(binding.txtExpression.text.toString()).build()
                val result = experssion.evaluate()
                val result1 = result.toLong()
                if (result == result1.toDouble()) {
                    binding.txtJavab.text = result1.toString()
                } else {
                    binding.txtJavab.text = result.toString()
                }
            }catch(e : Exception){

                binding.txtExpression.text = ""
                binding.txtJavab.text = ""

                Toast.makeText(this, "داری اشتباه میزنی !", Toast.LENGTH_LONG).show()

            }
        }
        binding.btnAC.setOnClickListener {

            binding.txtExpression.text = ""
            binding.txtJavab.text = ""
        }


    }

    private fun onNumberClicked() {

        binding.btn0.setOnClickListener {

            if (binding.txtExpression.text.isNotEmpty()) {

                val myChar = binding.txtExpression.text.last()
                val mychar2 = binding.txtExpression.text.length

                if (myChar == '0' && mychar2 == 1) {

                }else{
                    appendTxt("0")
                }
            }
            if (binding.txtExpression.text.isEmpty()){
                appendTxt("0")
            }

        }

        binding.btn1.setOnClickListener {
            appendTxt("1")

        }

        binding.btn2.setOnClickListener {

            appendTxt("2")
        }

        binding.btn3.setOnClickListener {

            appendTxt("3")
        }

        binding.btn4.setOnClickListener {

            appendTxt("4")

        }

        binding.btn5.setOnClickListener {
            appendTxt("5")
        }

        binding.btn6.setOnClickListener {
            appendTxt("6")
        }

        binding.btn7.setOnClickListener {
            appendTxt("7")
        }

        binding.btn8.setOnClickListener {
            appendTxt("8")
        }

        binding.btn9.setOnClickListener {
            appendTxt("9")
        }

        binding.btnDot.setOnClickListener {
            val myChar = binding.txtExpression.text.last()
            if (myChar == '.') {

            } else if (binding.txtJavab.text.isNotEmpty()) {
                appendTxt(".")
            } else if (binding.txtExpression.text.isEmpty()) {
                appendTxt("0.")
            } else {
                appendTxt(".")
            }
        }
        }

    private fun appendTxt( newText:String ) {

        // binding.txtExpression.text = newText


        if (binding.txtJavab.text.isNotEmpty()) {


            binding.txtExpression.text = binding.txtJavab.text

        }
        binding.txtExpression.append(newText)
        binding.txtJavab.text = ""








        val viewTree: ViewTreeObserver = binding.horizontalScrollViewTxtExpression.viewTreeObserver
        viewTree.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.horizontalScrollViewTxtExpression.viewTreeObserver.removeOnGlobalLayoutListener(
                    this
                )
                binding.horizontalScrollViewTxtExpression.scrollTo(binding.txtExpression.width, 0)
            }
        })

    }


}
