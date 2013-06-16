
JC = umake-java
TARGET = UHttp.jar

CLASSES = \
        UHttp.java 

default: $(CLASSES)
	$(JC) -q ./ -o $(TARGET) 

clean:
	rm -R classes-$(TARGET)
	rm $(TARGET)
