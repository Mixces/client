cd game
./gradlew setupCIWorkspace || exit 1
./gradlew build || exit  1
cd ..
electron-packager . sol-client-launcher --platform linux --arch x64 --out dist/ || exit 1
electron-installer-debian --src dist/sol-client-launcher-x64/ --dest dist/installers/ --arch amd64 || exit 1
