package uz.ravshanbaxranov.a4pics1word.repository

import uz.ravshanbaxranov.a4pics1word.R
import uz.ravshanbaxranov.a4pics1word.model.QuestionData

object QuestionRepository {

    fun loadNewbieQuestions(): List<QuestionData> =
        listOf(
            QuestionData("KITOB", "BFTOKI", R.raw.book1, R.raw.book2, R.raw.book3, R.raw.book4),
            QuestionData("QALAM", "LMAQAR", R.raw.pencil1, R.raw.pencil2, R.raw.pencil3, R.raw.pencil4),
            QuestionData("IT", "BGTOMI", R.raw.dog1, R.raw.dog2, R.raw.dog3, R.raw.dog4),
            QuestionData("SUV", "TVBSIU", R.raw.suv1, R.raw.suv2, R.raw.suv3, R.raw.suv4),
            QuestionData("OSMON", "NQOSOM", R.raw.osmon1, R.raw.osmon2, R.raw.osmon3, R.raw.osmon4),
            QuestionData("GLOBUS", "OBGLUS", R.raw.globus1, R.raw.globus2, R.raw.globus3, R.raw.globus4),
            QuestionData("KIYIM", "SIYMKI", R.raw.dress1, R.raw.dress2, R.raw.dress3, R.raw.dress4),
            QuestionData("RAQAM", "QMRADA", R.raw.digit1, R.raw.digit2, R.raw.digit3, R.raw.digit4),
            QuestionData("UZUK", "KSUMZU", R.raw.ring1, R.raw.ring2, R.raw.ring3, R.raw.ring4),
            QuestionData("RANG", "SRGUAN", R.raw.color1, R.raw.color2, R.raw.color3, R.raw.color4),
            QuestionData("MUSIQA", "SIMUQA", R.raw.music1, R.raw.music2, R.raw.music3, R.raw.music4),
            QuestionData("QOR", "SNOQRA", R.raw.snow1, R.raw.snow2, R.raw.snow3, R.raw.snow4)
        )

    fun loadMediumQuestions(): List<QuestionData> =
        listOf(
            QuestionData("BOLA", "SALSROBA", R.raw.baby1, R.raw.baby2, R.raw.baby3, R.raw.baby4),
            QuestionData("ORQA", "SARQOTAL", R.raw.back1, R.raw.back2, R.raw.back3, R.raw.back4),
            QuestionData("QUM", "TMSQUPRO", R.raw.sand1, R.raw.sand2, R.raw.sand3, R.raw.sand4),
            QuestionData("QUSH", "NASOQAHU", R.raw.bird1, R.raw.bird2, R.raw.bird3, R.raw.bird4),
            QuestionData("UYQU", "SYMBUQLU", R.raw.sleep1, R.raw.sleep2, R.raw.sleep3, R.raw.sleep4),
            QuestionData("FIRMA", "OSMAFRIT", R.raw.firm1, R.raw.firm2, R.raw.firm3, R.raw.firm4),
            QuestionData("BOKS", "SORBSOPK", R.raw.box1, R.raw.box2, R.raw.box3, R.raw.box4),
            QuestionData("FASL", "HAFLMVSO", R.raw.season1, R.raw.season2, R.raw.season3, R.raw.season4),
            QuestionData("TO'LA", "AL'OTMSA", R.raw.full1, R.raw.full2, R.raw.full3, R.raw.full4),
            QuestionData("TAYOQ", "QAYSOMTB", R.raw.stick1, R.raw.stick2, R.raw.stick3, R.raw.stick4),
            QuestionData("CHOY", "IYHACOSH", R.raw.tea1, R.raw.tea2, R.raw.tea3, R.raw.tea4),
            QuestionData("KALIT", "EKHATSLI", R.raw.key1, R.raw.key2, R.raw.key3, R.raw.key4)
        )


    fun loadExpertQuestions(): List<QuestionData> =
        listOf(
            QuestionData("TISH", "APTREHIAHSEP", R.raw.tooth1, R.raw.tooth2, R.raw.tooth3, R.raw.tooth4),
            QuestionData("UZUN", "UBZNGLAUNERT", R.raw.long1, R.raw.long2, R.raw.long3, R.raw.long4),
            QuestionData("AYLANA", "YLANDOTRAIRA", R.raw.circle1, R.raw.circle2, R.raw.circle3, R.raw.circle4),
            QuestionData("BELGI", "LNBSYTGSEVIA", R.raw.symbol1, R.raw.symbol2, R.raw.symbol3, R.raw.symbol4),
            QuestionData("ILDIZ", "ZASMIRBINOLD", R.raw.root1, R.raw.root2, R.raw.root3, R.raw.root4),
            QuestionData("ARXIV", "VRKLAAIZMXOK", R.raw.archive1, R.raw.archive2, R.raw.archive3, R.raw.archive4),
            QuestionData("TINCH", "ICTKANILAUHB", R.raw.peace1, R.raw.peace2, R.raw.peace3, R.raw.peace4),
            QuestionData("BENZIN", "NIAINZBGEQ'A", R.raw.banzin1, R.raw.banzin2, R.raw.benzin3, R.raw.banzin4),
            QuestionData("SAVAT", "TARAMSCHAVOP", R.raw.basket1, R.raw.basket2, R.raw.basket3, R.raw.basket4),
            QuestionData("TIL", "LAYEMKHATSLI", R.raw.lang1, R.raw.lang2, R.raw.lang3, R.raw.lang4),
            QuestionData("ISSIQ", "QKSHITSLIBLA", R.raw.hot1, R.raw.hot2, R.raw.hot3, R.raw.hot4),
            QuestionData("QULOQ", "LVOQRUAEDQAS", R.raw.ear1, R.raw.ear2, R.raw.ear3, R.raw.ear4)
        )

}