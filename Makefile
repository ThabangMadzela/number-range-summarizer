# Directories
SRC_DIR = src
TEST_DIR = $(SRC_DIR)/tests
BIN_DIR = bin
LIB_DIR = lib

# Java compiler and flags
JC = javac
JFLAGS = -d $(BIN_DIR) -cp $(BIN_DIR):$(LIB_DIR)/junit-4.13.2.jar:$(LIB_DIR)/hamcrest-core-1.3.jar

# Classpath for running tests and the main class
RUN_CP = $(BIN_DIR)
TEST_CP = $(RUN_CP):$(LIB_DIR)/junit-4.13.2.jar:$(LIB_DIR)/hamcrest-core-1.3.jar

# Source files
MAIN_SRC = $(SRC_DIR)/Main.java
SUMMARIZER_SRC = $(SRC_DIR)/numberrangesummarizer/NumberRangeSummarizer.java $(SRC_DIR)/numberrangesummarizer/RangeSummarizer.java
TEST_SRC = $(TEST_DIR)/RangeSummarizerTest.java

# Main target to compile all sources
all:  $(BIN_DIR)/numberrangesummarizer/NumberRangeSummarizer.class $(BIN_DIR)/numberrangesummarizer/RangeSummarizer.class $(BIN_DIR)/tests/RangeSummarizerTest.class $(BIN_DIR)/Main.class

# Compiling Main class
$(BIN_DIR)/Main.class: $(MAIN_SRC)
	$(JC) $(JFLAGS) $<

# Compiling NumberRangeSummarizer and RangeSummarizer classes
$(BIN_DIR)/numberrangesummarizer/NumberRangeSummarizer.class: $(SRC_DIR)/numberrangesummarizer/NumberRangeSummarizer.java
	$(JC) $(JFLAGS) $<

$(BIN_DIR)/numberrangesummarizer/RangeSummarizer.class: $(SRC_DIR)/numberrangesummarizer/RangeSummarizer.java $(BIN_DIR)/numberrangesummarizer/NumberRangeSummarizer.class
	$(JC) $(JFLAGS) $<

# Compiling RangeSummarizerTest class
$(BIN_DIR)/tests/RangeSummarizerTest.class: $(TEST_SRC) $(BIN_DIR)/numberrangesummarizer/RangeSummarizer.class
	$(JC) $(JFLAGS) $<

# Running the tests
test: $(BIN_DIR)/tests/RangeSummarizerTest.class
	java -cp $(TEST_CP) org.junit.runner.JUnitCore tests.RangeSummarizerTest

# Running the main class
run: $(BIN_DIR)/Main.class
	java -cp $(RUN_CP) Main

# Cleaning up
clean:
	rm -rf $(BIN_DIR)/*.class $(BIN_DIR)/numberrangesummarizer/*.class $(BIN_DIR)/tests/*.class
