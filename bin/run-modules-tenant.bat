@echo off
echo.
echo [��Ϣ] ʹ��Jar��������Modules-System���̡�
echo.

cd %~dp0
cd ../cool-modules/cool-tenant/target

set JAVA_OPTS=-Xms512m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

java -Dfile.encoding=utf-8 %JAVA_OPTS% -jar cool-modules-tenant.jar

cd bin
pause