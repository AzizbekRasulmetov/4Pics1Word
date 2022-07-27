package com.example.a4pics1word.ui.screen

import android.animation.ValueAnimator
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a4pics1word.R
import com.example.a4pics1word.databinding.FragmentPlaygroundBinding
import com.example.a4pics1word.model.QuestionData
import com.example.a4pics1word.ui.viewmodel.PlaygroundViewModel
import com.example.a4pics1word.util.showSnackBar
import com.example.a4pics1word.util.showToast
import kotlinx.coroutines.delay

class PlaygroundFragment : Fragment(R.layout.fragment_playground) {

    private val binding by viewBinding(FragmentPlaygroundBinding::bind)
    private val viewModel: PlaygroundViewModel by viewModels()
    private val args by navArgs<PlaygroundFragmentArgs>()
    private var counter = 0
    private var counterQuestion = 0
    private var answerSize = 0
    private var questionsSize = 0
    private var answer = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.questionLiveData.observe(this, questionObserver)
        viewModel.backLiveData.observe(this, backObserver)
        viewModel.variantClickLiveData.observe(this, variantClickObserver)
        viewModel.answerClickLiveData.observe(this, answerClickObserver)
        viewModel.correctAnswerLiveData.observe(this, correctObserver)
        viewModel.inCorrectAnswerLiveData.observe(this, inCorrectObserver)
        viewModel.finishLiveData.observe(this, finishLevelObserver)
        viewModel.listSizeLiveData.observe(this) {
            questionsSize = it
        }
        viewModel.prefLiveData.observe(this) {
            counterQuestion = it

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getQuestion(args.playground)

        variantButtons().forEach {
            it.setOnClickListener { button ->
                viewModel.variantClick(button as Button)
            }
        }

        binding.answerContainer.children.forEach {
            it.setOnClickListener { button ->
                viewModel.answerClick(button as Button)
            }
        }

        when (args.playground) {
            "Beginner" -> binding.titleTv.text = "Oson"
            "Medium" -> binding.titleTv.text = "O'rta"
            "Expert" -> binding.titleTv.text = "Qiyin"
        }

        binding.backBtn.setOnClickListener {
            viewModel.back()
        }
    }


    //-------- Observers --------//

    private val questionObserver = Observer<QuestionData> {
        answerSize = it.answer.length
        answer = it.answer
        binding.apply {
            answerContainer.children.forEach {
                it.visibility = GONE
            }
            for (i in 0 until it.answer.length) {
                (answerContainer.getChildAt(i) as Button).apply {
                    visibility = VISIBLE
                    text = ""
                }
            }
        }
        if (counterQuestion == 0) {
            binding.constraintLayout4.getChildAt(0).setBackgroundResource(it.image1)
            binding.constraintLayout4.getChildAt(1).setBackgroundResource(it.image2)
            binding.constraintLayout4.getChildAt(2).setBackgroundResource(it.image3)
            binding.constraintLayout4.getChildAt(3).setBackgroundResource(it.image4)
        } else {
            setPictures(it.image1, it.image2, it.image3, it.image4)

        }


        setVariants(it.variants)
    }

    private val backObserver = Observer<Unit> {
        requireActivity().onBackPressed()
    }

    private val finishLevelObserver = Observer<Unit> {
        lifecycleScope.launchWhenCreated {

            showToast("Ushbu bosqichini tamomladingiz")
            showDialog()

        }

    }

    private val correctObserver = Observer<Unit> {
        lifecycleScope.launchWhenCreated {
            binding.correctLottie.playAnimation()
            binding.counterTv.text = counterQuestion.toString()
        }
    }

    private val inCorrectObserver = Observer<Unit> {
        lifecycleScope.launchWhenCreated {

            showSnackBar("Xato javob")
            binding.inCorrectLottie.apply {
                visibility = VISIBLE
                playAnimation()
                delay(1500L)
                visibility = GONE
            }
        }
    }
    private val variantClickObserver = Observer<Button> {

        if (it.text.isNotEmpty() && answer.length > getAnswer().length) {
            getFirstEmptyAnswerButton().text = it.text
            it.text = ""
            counter++
        }

        if (counter == answerSize) {

            if (answer == getAnswer()) {
                viewModel.correctAnswer(args.playground)
                // there should be list size
                if (counterQuestion == questionsSize) {
                    viewModel.finishLevel(args.playground)
                } else {

                    viewModel.getQuestion(args.playground)
                    counter = 0
                    counterQuestion++
                }
            } else viewModel.inCorrect()
        }

    }

    private val answerClickObserver = Observer<Button> {
        it.apply {
            counter--
            if (this.text.isNotEmpty()) {
                val list = variantButtons().filter {
                    it.text.toString() == "" && it.visibility == VISIBLE
                }
                list[0].text = this.text
                text = ""
            }
        }
    }

    //-------- Functions --------//

    private fun setVariants(variant: String) = lifecycleScope.launchWhenCreated {

        for (i in variant.indices) {
            variantButtons()[i].apply {
                visibility = VISIBLE
                text = ""

            }
        }

        for (i in variant.indices) {
            variantButtons()[i].apply {
                this.isClickable = false
                delay(100L)
                variantAnimation(this, variant[i])
                this.isClickable = true
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

    private fun getAnswer(): String {
        var answer = ""
        binding.answerContainer.children.filter {
            it.visibility == VISIBLE
        }.forEach {
            answer += (it as Button).text.toString()
        }
        return answer
    }

    private fun getFirstEmptyAnswerButton(): Button {
        val list = ArrayList<Button>()
        binding.answerContainer.children.filter {
            (it as Button).text.isEmpty() && it.visibility == VISIBLE
        }.forEach {
            list.add(it as Button)
        }
        return list[0]
    }

    private fun setPictures(image1: Int, image2: Int, image3: Int, image4: Int) =
        lifecycleScope.launchWhenCreated {
            picturesAnimation(binding.constraintLayout4.getChildAt(0) as ImageView, image1)
            delay(200L)
            picturesAnimation(binding.constraintLayout4.getChildAt(1) as ImageView, image2)
            delay(200L)
            picturesAnimation(binding.constraintLayout4.getChildAt(2) as ImageView, image3)
            delay(200L)
            picturesAnimation(binding.constraintLayout4.getChildAt(3) as ImageView, image4)
        }

    //-------- Animation --------//

    private fun variantAnimation(button: Button, text: Char) = lifecycleScope.launchWhenCreated {
        button.isEnabled = false
        ValueAnimator.ofFloat('A'.code.toFloat(), text.code.toFloat()).apply {
            addUpdateListener {
                button.text = Char((it.animatedValue as Float).toInt()).toString()

            }
            duration = 1000L
            start()
        }
        delay(1000L)
        button.isEnabled = true
    }

    private fun picturesAnimation(
        imageView: ImageView,
        @DrawableRes
        drawableRes: Int
    ) {
        ValueAnimator.ofFloat(0f, 90f).apply {
            addUpdateListener {
                imageView.rotationX = it.animatedValue as Float
                imageView.rotationY = it.animatedValue as Float
            }
            duration = 1000L
            start()
        }
        imageView.setBackgroundResource(drawableRes)

        ValueAnimator.ofFloat(270f, 360f).apply {
            addUpdateListener {
                imageView.rotationX = it.animatedValue as Float
                imageView.rotationY = it.animatedValue as Float
            }
            duration = 1000L
            start()
        }
    }

    //-------- Show dialog --------//

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_level_up)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);

        dialog.findViewById<TextView>(R.id.main_menu_btn).setOnClickListener {
            dialog.dismiss()
            requireActivity().onBackPressed()
        }
        dialog.show()
    }
}