@echo off
echo Building...
echo;
call ng build
echo; 
echo Copying files...
echo; 
copy dist\front\browser\*.* ..\src\main\resources\public
echo; 
echo Done!!!