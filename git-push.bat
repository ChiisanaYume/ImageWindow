set log=%USERPROFILE%\Desktop\gitlog%date%.log
echo ---------- >> %log%
git add . >> %log% 2>&1
echo [%date% %time%] >> %log%
git commit -m "Commit git" >> %log% 2>&1
echo [%date% %time%] >> %log%
git push -u origin master >> %log% 2>&1
echo [%date% %time%] >> %log%
