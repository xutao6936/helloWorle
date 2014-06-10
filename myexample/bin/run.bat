@echo off
echo [INFO] run project
rem 获取当前批处理文件的路径
cd %~dp0
cd ..
call mvn jetty:run -Djetty.port=9999 -Dmaven.test.skip=true
cd bin
pause