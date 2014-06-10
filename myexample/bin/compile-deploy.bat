@echo off
echo [INFO] compile source
rem 获取当前批处理文件的路径
cd %~dp0
cd ..
call mvn clean compile -Dmaven.test.skip=true
cd bin
pause