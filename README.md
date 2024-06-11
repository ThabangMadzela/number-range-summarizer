# Number Range Summarizer

This project implements a number range summarizer that takes a comma-delimited list of numbers and groups consecutive numbers into ranges. For example, given the input "1,3,6,7,8,12,13,14,15,21,22,23,24,31", the output would be "1, 3, 6-8, 12-15, 21-24, 31".

## Assumptions

1. The input list is sorted.
2. Duplicates in the input list are handled correctly.
3. The input list contains integers only.
4. Empty strings or null inputs are considered as empty lists.

## File Structure

- **bin/**: Compiled .class files are stored here.
- **src/**: Source code files are located here.
  - **numberrangesummarizer/**
    - **NumberRangeSummarizer.java**: Provided interface to implement the solution.
    - **RangeSummarizer.java**: Implementation of the interface.
  - **tests/**
    - **RangeSummarizerTest.java**: Unit tests for the implementation.
  - **Main.java**: Main class to demonstrate functionality.
- **Makefile**: Makefile for compiling, running, and cleaning the project.
- **README.md**: This file containing project information.

## Requirements

- Java 8 or higher.
- GitHub account to submit the code.
- JUnit library for running unit tests.

## Building and Running

To compile the project, run `make` in the root directory. This will compile all Java files and place the compiled .class files in the `bin/` directory.

To run the Main class and see the functionality, use `make run`.

To clean up and remove compiled files, run `make clean`.
- **make**: Compiles all .java files in the src/ directory and its subdirectories. The compiled .class files will be placed in the bin/ directory.
- **make run**: Runs the Main class located in the bin/ directory.
- **make test**: Runs the JUnit tests defined in RangeSummarizerTest.java.
- **make clean**: Removes all compiled .class files from the project and clears the bin/ directory.

## Unit Tests

The project includes unit tests written using JUnit. To run the tests, ensure you have JUnit set up in your classpath and run `make test`. The tests cover various scenarios such as basic input, consecutive numbers, duplicates, empty input, etc.


