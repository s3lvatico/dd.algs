@echo off
setlocal

set PROJECT_HOME=%~dp0
echo PROJECT_HOME=%PROJECT_HOME%

set PROJECT_LIB=%PROJECT_HOME%lib
echo PROJECT_LIB=%PROJECT_LIB%

pushd %PROJECT_HOME%target\classes

set EXECUTABLE=java -cp .;%PROJECT_LIB%\algs4.jar %*

echo eseguo : %EXECUTABLE%
%EXECUTABLE%

popd

echo -- finito

endlocal