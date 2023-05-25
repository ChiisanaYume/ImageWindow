set log=%USERPROFILE%\Desktop\gitlog%date%.log
echo ---------- >> %log%
git pull origin master >> %log% 2>&1
echo [%date% %time%] >> %log%
