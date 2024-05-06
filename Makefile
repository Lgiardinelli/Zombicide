# Variables
JAVAC = javac
JAVA = java
JAR = jar
JAVADOC = javadoc

SRC_DIR = src
TEST_DIR = test
DOCS_DIR = docs
JAR_DIR = jar

MAIN_PACKAGE = zombicide
MAIN_CLASS = $(MAIN_PACKAGE).Zombicide

# take all java files in src and src/zombicide
JAVA_SOURCES := $(shell find $(SRC_DIR) -name "*.java")
TEST_SOURCES := $(shell find $(TEST_DIR) -name "*.java")
CLASSES_DIR = classes

JAR_NAME = zombicide.jar

TESTS_JAR = junit-console.jar

# Targets
.PHONY: all compile run tests run-tests javadoc clean

# Default target
all: compile tests javadoc

# Compile Java source files
compile: $(JAVA_SOURCES)
	$(JAVAC) -sourcepath $(SRC_DIR) -d $(CLASSES_DIR) $^

# Run the livrable2 Java application with arguments (longueur, largeur, nbSurvivants)
run: compile
	$(JAVA) -cp $(CLASSES_DIR) $(MAIN_CLASS) $(ARGS)

# Compile tests
tests: compile
	$(JAVAC) -cp $(TESTS_JAR):$(CLASSES_DIR) $(TEST_SOURCES)

# Run tests
run-tests: tests
	$(JAVA) -jar $(TESTS_JAR) -cp $(TEST_DIR):$(CLASSES_DIR) -scan-classpath

# Generate Java documentation
javadoc:
	$(JAVADOC) -sourcepath $(SRC_DIR) -d $(DOCS_DIR) -subpackages $(MAIN_PACKAGE)

# Create a JAR file in jar directory
%.jar: compile
	$(JAR) cfe $(JAR_DIR)/$@ $(MAIN_CLASS) -C $(CLASSES_DIR) $(MAIN_PACKAGE)

# Clean up generated files and tests classes in test directory
clean:
	rm -rf $(CLASSES_DIR) $(DOCS_DIR) $(shell find $(TEST_DIR) -name "*.class")

# Dependency rules
$(CLASSES_DIR)/%.class: $(SRC_DIR)/%.java
	$(JAVAC) -d $(CLASSES_DIR) $<
