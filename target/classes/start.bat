@ECHO OFF

REM java run application
start javaw com.faintdream.application.ImageWindow

REM redirect console output to a file
timeout /t 0.01 >>&1