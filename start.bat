md bin
javac -sourcepath src src/mainPackage/Main.java -d bin/
xcopy /E /I /Y res bin
cd bin
cls
java mainPackage/Main