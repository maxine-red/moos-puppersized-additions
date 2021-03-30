#!/bin/bash

getVersion() {
  readarray -d = -t mc_release<<< "$(grep minecraft_release gradle.properties)"
  readarray -d = -t major<<< "$(grep version_major gradle.properties)"
  readarray -d = -t minor<<< "$(grep version_minor gradle.properties)"
  readarray -d = -t patch<<< "$(grep version_patch gradle.properties)"
  full_version="v$(echo ${major[1]}).$(echo ${minor[1]}).$(echo ${patch[1]})"
}

getVersion
git checkout development && git pull && \
  git checkout main && git merge development && git push && \
  git tag "$full_version"  -F CHANGELOG.md && \
  echo "Created tag $full_version" && \
  git push origin "$full_version" && git checkout development && \
  echo "Pushed new tag $full_version" && \
  ./gradlew build &&
  echo "Built release jar" && \
  gh release create "$full_version" -F CHANGELOG.md && \
  gh release upload "$full_version" build/libsStrawberryTwirlCompanion-"$full_version".jar
