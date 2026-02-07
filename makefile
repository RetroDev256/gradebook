# Java compiler
JAVAC := javac
# Java Virtual Machine
JAVA := java
# Jar packager
JAR := jar
# Disable debug info, enable all warnings, treat warnings as errors
JFLAGS := -g:none -Xlint:all -Werror
# Create jar and set entry point
JARFLAGS := cfe

# Output directory
BINDIR := bin
# Output jar name
TARGET := main.jar
# Source directory
SRCDIR := src
# All Java source files
SRC  := $(shell fd '\.java$$' $(SRCDIR))

# Build target depends on sources
$(TARGET): $(SRC)
# 	# Auto-format before building
# 	@make -s format
	# Create output directory
	@mkdir -p $(BINDIR)
	# Compile sources into bin
	@$(JAVAC) $(JFLAGS) -d $(BINDIR) $^
	# Package into runnable jar
	@$(JAR) $(JARFLAGS) $(BINDIR)/$@ Main -C $(BINDIR) .

# Run target depends on build
run: $(TARGET)
	# Execute jar
	@$(JAVA) -jar $(BINDIR)/$(TARGET)

# format:
# 	# Format all source files
# 	clang-format -i $(SRC)

watch:
	# Watch for file changes and rebuild
	@while inotifywait -qq -re CLOSE_WRITE $(SRCDIR); do \
		clear; \
		make -s run; \
	done

clean:
	# Format before cleaning
#	@make -s format
	# Remove build output
	rm -rf $(BINDIR)

