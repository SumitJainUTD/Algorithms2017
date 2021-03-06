package MacLaptop.ThirdLot.TextJustification;

import java.util.List;

/**
 * Created by sjain on 9/9/17.
 */

//Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
//
//        You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
//
//        Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//        For the last line of text, it should be left justified and no extra space is inserted between words.
//
//        For example,
//        words: ["This", "is", "an", "example", "of", "text", "justification."]
//        L: 16.
public class TextJustification {

    public List<String> print(String [] words, int maxWidth){

        return null;
    }

    public String find(String [] words, int maxWidth, int index){
        if(index<words.length){
            String result = "";
            int currentLen = 0;
            int remainLength = maxWidth;
            while(result.length()<maxWidth && index<words.length){
                if(remainLength>=words[index].length()+1){ //remainingLength+1 for space
                    if(!result.equals("")){
                        result += "@" + words[index];
                        currentLen = words[index].length()+1;
                    }else{
                        result += words[index];
                        currentLen = words[index].length();
                    }
                    remainLength -= currentLen;
                    index++;
                }else if(remainLength>0){
                    if(result.contains("@")==false){
                        for (int i = 0; i < remainLength; i++) {
                            result = result + " ";
                        }
                    }else {
                        //go in only if there at least 2 words
                        String[] arr = result.split("@");
                        int mod = remainLength % (arr.length - 1);
                        int splitedSpace = remainLength / (arr.length - 1);
                        String spaces = " ";
                        for (int i = 0; i < splitedSpace; i++) {
                            spaces = spaces + " ";
                        }
                        String leftmost = spaces;
                        for (int i = 0; i < mod; i++) {
                            leftmost = leftmost + " ";
                        }
                        result = result.replaceFirst("@", leftmost);
                        result = result.replaceAll("@", spaces);
                    }
                }
            }
            result = result.replaceAll("@", " ");
            return result + "\n" + find(words,maxWidth,index);
        }else{
            return "";
        }
    }


    public static void main(String[] args) {
        TextJustification t = new TextJustification();
        String [] words = {"This", "is", "an", "example", "of", "text", "justification", "at","Sumit","Jain","is", "a", "good", "boy","This", "is", "an", "example", "of", "text", "justification", "at","Sumit","Jain","is", "a", "good", "boy"
        ,"This", "is", "an", "example", "of", "text", "justification", "at","Sumit","Jain","is", "a", "good", "boy","This", "is", "an", "example", "of", "text", "justification", "at","Sumit","Jain","is", "a", "good", "boy"};
        int maxWidth = 30;
//        List<String> result = t.print(words,maxWidth);
        System.out.println(t.find(words,maxWidth,0));
    }
}
