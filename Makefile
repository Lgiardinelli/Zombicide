JAVAC = javac
JAVA = java
JAR = jar
JAVADOC = javadoc

SRC = src
TEST = test
CLASSES = classes
DOCS = docs
JAR2_NAME = livrable2.jar
MAIN_CLASSE = zombicide.main

SOURCES = $(wildcard $(SRC)/*.java $(SRC)/zombicide/*.java)
CLASSES_DIR = $(CLASSES)

all : compile run test javadoc jar

compile:
	$(JAVAC) -sourcepath $(SRC) -d $(CLASSES_DIR) $(SOURCES)

run:
	$(JAVA) -classpath $(CLASSES_DIR) $(MAIN_CLASS) 10 10

test:
	$(JAVAC) -classpath junit-console.jar:$(CLASSES_DIR) $(TEST)/zombicide/*.java
    $(JAVA) -jar junit-console.jar -classpath $(TEST):$(CLASSES_DIR) -scan-classpath

javadoc:
	$(JAVADOC) -sourcepath $(SRC) -d $(DOCS) -subpackages zombicide

jar:
	$(JAR) cvfe $(JAR2_NAME) $(MAIN_CLASS) -C $(CLASSES_DIR) .

clean:
	rm -rf $(CLASSES_DIR) $(DOCS) $(JAR2_NAME)

.PHONY: all compile run test javadoc jar clean

