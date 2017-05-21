package two;

public class ReverseWords {
	public static void main(String[] args) {
		String words = "The input string does not contain leading"; //"Hello World";
		String reverse = "";//"World Hello";
		reverse = reverseWords(words);
		System.out.println(reverse);
	}
	public static String reverseWords(String words) {
		words = words + " ";
		char[] wordsCharArr = words.toCharArray();
		int nextBeginIndex = 0;
		int nextBlankIndex = getNextBlankIndex(wordsCharArr, 0);
		while (nextBlankIndex > 0) {
			reverseChars(wordsCharArr, nextBeginIndex, nextBlankIndex);
			nextBeginIndex = nextBlankIndex + 1;
			nextBlankIndex = getNextBlankIndex(wordsCharArr, nextBeginIndex);
		}
		reverseCharArr(wordsCharArr,0,wordsCharArr.length-2);
		return new String(wordsCharArr, 0, wordsCharArr.length);
	}
	private static int getNextBlankIndex(char[] wordsCharArr, int begin) {
		for(int i=begin ; i<wordsCharArr.length ; i++) {
			if (wordsCharArr[i] == ' ') return i;
		}
		return 0;
	}
	private static void reverseCharArr(char[] wordsCharArr, int begin, int end) {
		if(begin >= end) return;
		swap(wordsCharArr, begin, end);
		reverseCharArr(wordsCharArr, begin+1, end-1);
	}
	private static void swap(char[] wordsCharArr, int begin, int end) {
		char tmp = wordsCharArr[begin];
		wordsCharArr[begin] = wordsCharArr[end];
		wordsCharArr[end] = tmp;
	}
	private static void reverseChars(char[] wordsCharArr, int begin, int blankIndex) {
		reverseCharArr(wordsCharArr, begin, blankIndex-1);
	}
}
