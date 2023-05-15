package com.example.finalproject.data.local

class CardDB {

    var firstFact = FactsDataClass(
        "Random Fact 1",
        "Maybe inside is a fact about men",
        "Check if the fact is not about men by any chance: ",
        "https://images.liverpoolmuseums.org.uk/styles/dynamic/public/2021-12/Peaky%20Blinders.jpg"
    )

    var secondFact = FactsDataClass(
        "Random Fact 2",
        "Maybe inside is a fact about women",
        "Check if the fact is not about women by any chance: ",
        "data:image/jpeg;base64,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"
    )

    var thirdFact = FactsDataClass(
        "Random Fact 3",
        "Maybe inside is a fact about dogs",
        "Check if the fact is not about dogs by any chance: ",
        "data:image/jpeg;base64,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"
    )

    var fourthFact = FactsDataClass(
        "Random Fact 4",
        "Maybe inside is a fact about cats",
        "Check if the fact is not about cats by any chance: ",
        "https://s2.afisha.ru/mediastorage/39/15/4d6179bcd85c4ea5a7c564111539.jpg"
    )
}