package com.example.a4pics1word.ui.screen

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a4pics1word.R
import com.example.a4pics1word.databinding.FragmentPlaygroundBinding
import com.example.a4pics1word.model.QuestionData
import com.example.a4pics1word.ui.viewmodel.PlaygroundViewModel
import com.example.a4pics1word.util.showToast

class PlaygroundFragment : Fragment(R.layout.fragment_playground) {

    private val binding by viewBinding(FragmentPlaygroundBinding::bind)
    private val viewModel: PlaygroundViewModel by viewModels()
    private val args by navArgs<PlaygroundFragmentArgs>()
    private var counter = 0
    private var counterVar = 0
    private var answerSize = 0
    private var answer = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.questionLiveData.observe(this, questionObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getQuestion(0, "Newbie")

        variantButtons().forEach {
            it.setOnClickListener {

                Log.d("TAGGING", "${(it as Button).text}")
                if (counter < answerSize && it.text.isNotEmpty()) {
                    (binding.answerContainer.getChildAt(counter) as Button).text =
                        it.text
                    it.text = ""
                    counter++
                }
                if (counter == answerSize) {
                    Log.d("TAGGING", "$answer")
                    Log.d("TAGGING", "${getAnswer()}")

                    if (answer == getAnswer()) showToast("Correct")
                    else showToast("Incorrect")
                }
            }
        }

        binding.answerContainer.children.forEach {
            it.setOnClickListener {

                counter--
                (it as Button).apply {
                    if (this.text.isNotEmpty()) {
                        val list = variantButtons().filter {
                            it.text.toString() == "" && it.visibility == VISIBLE
                        }
                        list[0].text = this.text
                        Log.d("TAGGING", "${list.size}")
                        text = ""
                    }
                }
            }
        }
    }


    //-------- Observers --------//

    private val questionObserver = Observer<QuestionData> {
        answerSize = it.answer.length
        answer = it.answer
        binding.apply {
            for (i in 0 until it.answer.length) {

                (answerContainer.getChildAt(i) as Button).apply {
                    visibility = VISIBLE
//                    setOnClickListener {
//                        Log.d("TAGGING", "${(it as Button).text}")
//                        (binding.answerContainer.getChildAt(counter) as Button).text =
//                            (it as Button).text
//                        it.text = ""
//                        counter++
//                    }
//                    setOnClickListener(onClickVariant(this))
                }
            }
        }
        setVariants(it.variants)
    }

    private fun setVariants(variant: String) {
        for (i in variant.indices) {
            variantButtons()[i].apply {
                visibility = VISIBLE
                text = variant[i].toString()
            }
        }
    }

    private fun variantButtons(): ArrayList<Button> {
        val list = ArrayList<Button>()

        binding.variantContainer.children.forEach {
            list.add(it as Button)
        }
        binding.variantContainer2.children.forEach {
            list.add(it as Button)
        }

        return list
    }

    private fun onClickVariant(view: View): View.OnClickListener? {
        Log.d("TAGGING", "${(view as Button).text}")
        (binding.answerContainer.getChildAt(counter) as Button).text =
            view.text
        view.text = ""
        counter++

        return null
    }

    private fun getAnswer(): String {
        var answer = ""
        binding.answerContainer.children.forEach {
            answer += (it as Button).text.toString()
        }
        return answer
    }

}