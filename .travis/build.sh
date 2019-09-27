#!/bin/sh

# Discern whether this is a release build.
if [ "$TRAVIS_SECURE_ENV_VARS" = true \
  -a "$TRAVIS_PULL_REQUEST" = false ]
then
  echo '--> Release build detected. Will upload it to the update site.'
  UPLOAD_TO_UPDATE_SITE=true
fi

UPLOAD_TO_UPDATE_SITE=true

# Perform the main build.
#curl -fsLO https://raw.githubusercontent.com/scijava/scijava-scripts/master/travis-build.sh &&
curl -rsLO https://gist.githubusercontent.com/kephale/fe09a1326c02d5e40626675476586cb7/raw/b3cdec5678d4d24b6efa8328620a019b2753a144/travis-build.sh &&
sh travis-build.sh $encrypted_eb7aa63bf7ac_key $encrypted_eb7aa63bf7ac_iv &&

# Upload release version to the ImageJ update site.
if [ "$UPLOAD_TO_UPDATE_SITE" ]
then
  sh Kharrington_deploy.sh
else
  echo '--> Not a release build; skippin upload to update site.'
fi
