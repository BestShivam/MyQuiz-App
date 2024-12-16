package com.example.myquizapp

object Constraints {
    val USER_NAME : String = "user_name"
    val CORRECT_ANSWER : String = "correct_answer"
    val TOTAL_QUESTION : String = "total_question"
    fun getQuestion() : ArrayList<Question>{
        val questions = ArrayList<Question>()
        val que1 = Question(
            1,"Who was the first Prime Minister of India?",
            R.drawable.img,"Jawaharlal Nehru","Mahatma Gandhi",
            "Sardar Patel", "Dr. B.R. Ambedkar",
            1
        )

        val que2 = Question(
            2, "Which element has the chemical symbol 'O'?",
            R.drawable.img_1, "Oxygen",
            "Gold", "Osmium", "Zinc",
         1
        )
        val que3 = Question(
            3, "In which year did India gain independence?",
            R.drawable.img_2, "1945",
            "1947", "1950", "1952",
         2
        )
        val que4 = Question(
            4, "What is the chemical symbol for Gold?",
            R.drawable.img_3,
             "Ag", "Fe", "Hg","Au"
            ,4
        )
        val que5 = Question(
            5, "Which river is known as the 'Sorrow of Bihar'?",
            R.drawable.img_4, "Ganga", "Kosi", "Yamuna", "Brahmaputra",
            2
        )
        val que6 = Question(
            6, "Who composed the Indian National Anthem?",
            R.drawable.img_5,  "Bankim Chandra Chatterjee",
            "Subhash Chandra Bose", "Mahatma Gandhi",
            "Rabindranath Tagore",
            4
        )
        val que7 = Question(
            7,  "Which Indian scientist won the Nobel " +
                    "Prize for Physics in 1930?",
            R.drawable.img_7,  "C.V. Raman", "Homi Bhabha",
            "S.N. Bose", "Jagadish Chandra Bose",
            1
        )
        val que8 = Question(
            8, "Which Indian state " +
                    "is known as the 'Spice Garden of India'?",
            R.drawable.img_8,
            "Tamil Nadu","Kerala",
             "Karnataka", "Assam",
            2
        )
        val que9 = Question(
            9, "Who wrote 'Romeo and Juliet'?",
            R.drawable.img_9,  "Mark Twain","William Shakespeare",
            "Charles Dickens", "Jane Austen",
            2
        )
        val que10 = Question(
            10, "Who is known as the 'Missile Man of India'?",
            R.drawable.img_10,
            "Vikram Sarabhai", "Homi Bhabha",
            "C.V. Raman","A.P.J. Abdul Kalam",
            4
        )



        questions.add(que1)
        questions.add(que2)
        questions.add(que3)
        questions.add(que4)
        questions.add(que5)
        questions.add(que6)
        questions.add(que7)
        questions.add(que8)
        questions.add(que9)
        questions.add(que10)

        return questions
    }
}