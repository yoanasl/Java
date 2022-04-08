package com.company;

public class GoodWords {


    public static void main(String[] args) throws Exception {

        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        int n = countCharacters(words,chars);
        System.out.println(n);
    }

    public static int countCharacters(String[] words, String chars) throws Exception {

        if((words.length<1 || words.length>1000)||( chars.length()<1 || chars.length()>1000))
        {
            throw new Exception("Invalid length");
        }

        boolean validChar = chars.matches("[a-z]+");

        if(!validChar)
        {
            throw new Exception("Invalid char");
        }
        for (String word:words) {

            boolean validWord = word.matches("[a-z]+");
            if(!validWord)
            {
                throw new Exception("Invalid char in the word");
            }
        }

        int counter = 0;
        boolean isGood = false;

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];

            if (currentWord.length()<1 )
            {
                throw new Exception("Invalid input");
            }

            for (int j = 0; j < currentWord.length(); j++) {

                char wordChar = currentWord.charAt(j);
                if (chars.contains(String.valueOf(words[i].charAt(j)))) {
                    isGood = true;
                } else {
                    isGood = false;
                    break;
                }


            }
            if (isGood) {
                counter += currentWord.length();
            }


        }
        return counter;

    }
}
