@echo off
echo [INFO] recreate data from schame

rem 获得当前批处理文件的路径
cd %~dp0
cd ..
call mvn antrun:run -Prefresh-db

cd bin
pause