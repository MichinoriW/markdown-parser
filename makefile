# ifeq ($(OS), Windows_NT)
# 	CLASSPATH = ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar"
# else
# 	CLASSPATH = .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar
# endif

ifeq ($(OS), Windows_NT)
	CLASSPATH = ".;lib/*;."
else
	CLASSPATH = .:lib/*:.
endif

# test: MarkdownParseTest.class
# 	java -cp $(CLASSPATH) org.junit.runner.JUnitCore  MarkdownParseTest
# MarkdownParse.class : MarkdownParse.java
# 	javac -cp $(CLASSPATH) MarkdownParse.java
# MarkdownParseTest.class : MarkdownParseTest.java MarkdownParse.class
# 	javac -cp $(CLASSPATH) MarkdownParseTest.java

TryCommonMark.class: TryCommonMark.java
	javac -g -cp $(CLASSPATH) TryCommonMark.java