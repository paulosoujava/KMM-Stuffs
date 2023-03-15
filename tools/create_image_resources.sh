#!/bin/bash

sourceDir=~/Downloads/Assets/android
#yourCompanyDir=br/com/progdeelite/kmmprogdeelite/ # replace with your own
#resourcePackageDir=com.paulo.kmm # replace with your own
#resourceDir=${yourCompanyDir}resources/
relativeDestinationDir=/Users/paulojorge/AndroidStudioProjects/KMM/shared # on mac / linux
# relativeDestinationDir=./shared/src/commonMain/kotlin/${resourceDir} # on windows
relativeDestinationFile=${relativeDestinationDir}ImageResources.kt

# DE PERMISSAO PARA ExECUTAR chmod +x create_image_resources.sh
# +------------------------------------------- HOW TO USE IT ----------------------------------------------+
#
# 1) run script convert_assets.sh first
# 2) create an initial empty object called ImageResources.kt in relativeDestinationDir
# 3) make sure "~Downloads/Assets/android" exits after running "convert_assets.sh"
# 4) run script from tools folder: ./create_image_resources.sh
# 5) generated object will be create at "$relativeDestinationDir"
#
# +--------------------------------------------------------------------------------------------------------+