package main;

public class Test {
	public static void main(String[] args) {
		WordDictionary dictionary = new WordDictionary();
		dictionary.addWord("hello");
		dictionary.addWord("world");
		System.out.print(dictionary.search("..llo"));
	}
}
